package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.bean.Categoria;
import br.com.fiap.fintech.bean.T_GASTO;
import br.com.fiap.fintech.dao.T_GastoDao;
import br.com.fiap.fintech.exception.DBException;

public class OracleT_GastoDao implements T_GastoDao {

    private Connection conexao;

    public OracleT_GastoDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void cadastrar(T_GASTO gasto) throws DBException {
        try (PreparedStatement ps = conexao.prepareStatement(
                "INSERT INTO T_GASTO (cod_gasto, cod_usuario, cod_categoria, des_gasto, val_gasto, dt_datagasto) VALUES (sq_gasto.nextval, ?, ?, ?, ?, ?)")) {

            // Verifica se a categoria existe antes de cadastrar
//            if (!categoriaExiste(gasto.getCod_categoria())) {
//                throw new DBException("Categoria não encontrada para o código: " + gasto.getCod_categoria());
//            }

            ps.setInt(1, gasto.getCod_usuario());
            ps.setInt(2, gasto.getCategoria().getCod_categoria());
            ps.setString(3, gasto.getDes_gasto());
            ps.setDouble(4, gasto.getVal_gasto());
            java.sql.Date data = new java.sql.Date(gasto.getDat_gasto().getTimeInMillis());
            ps.setDate(5, data);

            System.out.println("Gasto cadastrado corretamente!");
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro no cadastro do gasto");
            e.printStackTrace();
            throw new DBException("Erro ao cadastrar o gasto", e);
        }
    }

    // Método para verificar se a categoria existe
//    private boolean categoriaExiste(int codCategoria) throws SQLException {
//        String sql = "SELECT 1 FROM T_CATEGORIA WHERE COD_CATEGORIA = ?";
//        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
//            ps.setInt(1, codCategoria);
//            try (ResultSet rs = ps.executeQuery()) {
//                return rs.next();
//            }
//        }
//    }



    @Override
    public void atualizar(T_GASTO gasto) throws DBException {
        String sql = "UPDATE T_GASTO SET des_gasto = ?, val_gasto = ?, dt_datagasto = ?, cod_categoria = ? WHERE cod_gasto = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, gasto.getDes_gasto());
            ps.setDouble(2, gasto.getVal_gasto());
            java.sql.Date data = new java.sql.Date(gasto.getDat_gasto().getTimeInMillis());
            ps.setDate(3, data);
            ps.setInt(4, gasto.getCategoria().getCod_categoria());
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
            ps = conexao.prepareStatement("SELECT * FROM T_GASTO INNER JOIN T_CATEGORIA ON T_GASTO.COD_CATEGORIA = T_CATEGORIA.COD_CATEGORIA WHERE T_GASTO.COD_GASTO = ?");
            ps.setInt(1, cod_gasto);
            rs = ps.executeQuery();

            if (rs.next()) {
                int cod_gasto1 = rs.getInt("cod_gasto");
                int cod_usuario = rs.getInt("cod_usuario");
                String des_gasto = rs.getString("Des_gasto");
                double val_gasto = rs.getDouble("Val_gasto");
                java.sql.Date data = rs.getDate("dt_datagasto");
                Calendar dat_gasto = Calendar.getInstance();
                dat_gasto.setTimeInMillis(data.getTime());
                
                int cod_categoria = rs.getInt("cod_categoria");
                String nom_categoria = rs.getString("NOM_CATEGORIA");
                String des_categoria = rs.getString("DES_CATEGORIA");

                gasto = new T_GASTO(cod_gasto1, cod_usuario, des_gasto, val_gasto, dat_gasto);
                Categoria categoria = new Categoria(cod_categoria, nom_categoria, des_categoria);
                gasto.setCategoria(categoria);
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
                // Não feche a conexão aqui!
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return gasto;
    }

    @Override
    public List<T_GASTO> listar() {
        String sql = "SELECT * FROM T_GASTO INNER JOIN T_CATEGORIA ON T_GASTO.COD_CATEGORIA = T_CATEGORIA.COD_CATEGORIA ORDER BY COD_GASTO";
        List<T_GASTO> gastos = new ArrayList<>();
        
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

                T_GASTO gasto = new T_GASTO(cod_gasto1, cod_usuario, des_gasto, val_gasto, dat_gasto);
                Categoria categoria = new Categoria(cod_categoria, nom_categoria, des_categoria);
                gasto.setCategoria(categoria);
                gastos.add(gasto);
            }
        } catch (SQLException u) {
            System.out.println("Erro na exibição de todos os gastos");
            u.printStackTrace();
        }

        return gastos;
    }
}
