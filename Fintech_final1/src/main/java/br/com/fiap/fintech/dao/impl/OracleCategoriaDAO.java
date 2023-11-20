package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.bean.T_CATEGORIA;
import br.com.fiap.fintech.bean.T_GASTO;
import br.com.fiap.fintech.dao.CategoriaDao;

public class OracleCategoriaDAO implements CategoriaDao {
	
	private Connection conexao;
	
	public OracleCategoriaDAO(Connection conexao) {
        this.conexao = conexao;
    }

	@Override
	public List<T_CATEGORIA> listar() {
	    String sql = "SELECT * FROM TGF_CATEGORIA ORDER BY COD_CATEGORIA";
	    List<T_CATEGORIA> lista = new ArrayList<>();

	    try (PreparedStatement ps = conexao.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            int cod_categoria = rs.getInt("cod_categoria");
	            String nom_categoria = rs.getString("nom_categoria");
	            String des_categoria = rs.getString("des_categoria");

	            T_CATEGORIA categoria = new T_CATEGORIA(cod_categoria, nom_categoria, des_categoria);
	            lista.add(categoria);
	        }
	        
	        ps.close();
	        rs.close();
	    } catch (SQLException e) {
	        System.out.println("Erro ao obter categorias");
	        e.printStackTrace();
	    } finally {
	    	try {	    		
	    		conexao.close();
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    return lista;
	}



}
