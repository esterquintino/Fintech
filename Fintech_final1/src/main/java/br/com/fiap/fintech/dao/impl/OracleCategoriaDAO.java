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
	    String sql = "SELECT * FROM T_CATEGORIA ORDER BY COD_CATEGORIA"; // Correção na consulta SQL
	    List<Categoria> lista = new ArrayList<>();

	    try (PreparedStatement ps = conexao.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            int cod_categoria = rs.getInt("cod_categoria");
	            String nom_categoria = rs.getString("nom_categoria");
	            String des_categoria = rs.getString("des_categoria");

	            Categoria cat = new Categoria(cod_categoria, nom_categoria, des_categoria);
	            lista.add(cat);
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao obter categorias");
	        e.printStackTrace();
	    }

	    return lista;
	}



}
