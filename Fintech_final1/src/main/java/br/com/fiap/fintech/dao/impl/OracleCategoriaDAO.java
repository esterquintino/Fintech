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
import br.com.fiap.fintech.dao.CategoriaDao;

public class OracleCategoriaDAO implements CategoriaDao {
	
	private Connection conexao;
	
	public OracleCategoriaDAO(Connection conexao) {
        this.conexao = conexao;
    }
	
	@Override
	public List<Categoria> listar() {
	    String sql = "SELECT * FROM T_GASTO ORDER BY COD_GASTO";
	    List<Categoria> lista = new ArrayList<Categoria>();

	    try (PreparedStatement ps = conexao.prepareStatement("SELECT * FROM T_CATEGORIA");
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            int cod_categoria = rs.getInt("cod_categoria");
	            String nom_categoria = rs.getString("nom_categoria");
	            String des_categoria = rs.getString("des_categoria");

	            Categoria cat = new Categoria(cod_categoria, nom_categoria, des_categoria);
	            lista.add(cat);
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro na adição da categoria");
	        e.printStackTrace();
	    } finally {
	        // Certifique-se de fechar a conexão fora do loop while
	        try {
	            if (conexao != null) conexao.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return lista;
	}

}
