package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.bean.T_CATEGORIA;
import br.com.fiap.fintech.bean.T_GASTO;
import br.com.fiap.fintech.dao.T_GastoDao;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.store.singleton.Conexao;

public class OracleT_GastoDao implements T_GastoDao {

    private Connection conexao;

    public OracleT_GastoDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void cadastrar(T_GASTO gasto) throws DBException {
    	try (PreparedStatement ps = this.conexao.prepareStatement(
    	        "INSERT INTO TGF_GASTO (cod_gasto, cod_usuario, des_gasto, val_gasto, dt_saida, cod_categoria,) VALUES (sq_gasto.nextval, ?, ?, ?, ?, ?)")) {

            ps.setInt(1, gasto.getCod_usuario());
            ps.setString(2, gasto.getDes_gasto());
            ps.setDouble(3, gasto.getVal_gasto());
            java.sql.Date data = new java.sql.Date(gasto.getDat_gasto().getTimeInMillis());
            ps.setDate(4, data);
            ps.setInt(5, gasto.getCod_categoria());

            System.out.println("Gasto cadastrado corretamente!");
            ps.execute();
        } catch (Exception e) {
            System.out.println("Erro no cadastro do gasto");
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar o gasto", e);
        }
    }



    @Override
    public void atualizar(T_GASTO gasto) throws DBException {
        String sql = "UPDATE T_GASTO SET des_gasto = ?, val_gasto = ?, dt_datagasto = ?, cod_categoria = ? WHERE cod_gasto = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, gasto.getDes_gasto());
            ps.setDouble(2, gasto.getVal_gasto());
            java.sql.Date data = new java.sql.Date(gasto.getDat_gasto().getTimeInMillis());
            ps.setDate(3, data);

            // Adicionando verificação de categoria nula
            T_CATEGORIA categoria = gasto.getCategoria();
            if (categoria != null) {
                ps.setInt(4, categoria.getCod_categoria());
            } else {
                ps.setNull(4, Types.INTEGER);
            }

            ps.setInt(5, gasto.getCod_gasto());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Erro ao atualizar o gasto", e);
        } 
    }


    @Override
    public void remover(int cod_gasto) throws DBException {
        String sql = "DELETE FROM T_GASTO WHERE cod_gasto = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, cod_gasto);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Erro ao remover o gasto", e);
        } 
    }

    @Override
    public T_GASTO buscar(int cod_gasto) {
        T_GASTO gasto = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = conexao.prepareStatement("SELECT * FROM TGF_GASTO INNER JOIN TGF_CATEGORIA ON TGF_GASTO.COD_CATEGORIA = TGF_CATEGORIA.COD_CATEGORIA WHERE T_GASTO.COD_GASTO = ?");
            ps.setInt(1, cod_gasto);
            rs = ps.executeQuery();

            if (rs.next()) {
                int cod_gasto1 = rs.getInt("cod_gasto");
                int cod_usuario = rs.getInt("cod_usuario");
                String des_gasto = rs.getString("des_gasto");
                double val_gasto = rs.getDouble("Val_gasto");
                java.sql.Date data = rs.getDate("dt_datagasto");
                Calendar dat_gasto = Calendar.getInstance();
                dat_gasto.setTimeInMillis(data.getTime());

                int cod_categoria = rs.getInt("COD_CATEGORIA");
                String nom_categoria = rs.getString("NOM_CATEGORIA");
                String des_categoria = rs.getString("DES_CATEGORIA");

                gasto = new T_GASTO(cod_gasto1, cod_usuario, des_gasto, val_gasto, dat_gasto, cod_categoria);
                T_CATEGORIA categoria = new T_CATEGORIA(cod_categoria, nom_categoria, des_categoria);
                gasto.setCategoria(cod_categoria);
            }
        } catch (SQLException u) {
            u.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return gasto;
    }


    @Override
    public List<T_GASTO> listar() {
        String sql = "SELECT * FROM TGF_GASTO INNER JOIN TGF_CATEGORIA ON TGF_GASTO.COD_CATEGORIA = TGF_CATEGORIA.COD_CATEGORIA ORDER BY COD_GASTO";
        List<T_GASTO> gastos = new ArrayList<>();

        try {
            // Obtém a conexão
            Connection conexao = Conexao.obterConexao();

            // Agora, tenta executar a consulta
            try (PreparedStatement ps = conexao.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    int cod_gasto1 = rs.getInt("cod_gasto");
                    int cod_usuario = rs.getInt("cod_usuario");
                    String des_gasto = rs.getString("des_gasto");
                    double val_gasto = rs.getDouble("val_gasto");
                    java.sql.Date data = rs.getDate("dt_datagasto");
                    Calendar dat_gasto = Calendar.getInstance();
                    dat_gasto.setTimeInMillis(data.getTime());

                    int cod_categoria = rs.getInt("cod_categoria");
                    String nom_categoria = rs.getString("NOM_CATEGORIA");
                    String des_categoria = rs.getString("DES_CATEGORIA");

                    T_GASTO gasto = new T_GASTO(cod_gasto1, cod_usuario, des_gasto, val_gasto, dat_gasto, cod_categoria);
                    T_CATEGORIA categoria = new T_CATEGORIA(cod_categoria, nom_categoria, des_categoria);
                    gasto.setCod_categoria(cod_categoria);
                    gastos.add(gasto);
                }
            }
        } catch (SQLException e) {
            // Se ocorrer um erro, logue-o e/ou imprima-o
            System.out.println("Erro na exibição de todos os gastos");
            e.printStackTrace();
        } catch (DBException e) {
        	e.printStackTrace();
        }

        return gastos;
    }



}
