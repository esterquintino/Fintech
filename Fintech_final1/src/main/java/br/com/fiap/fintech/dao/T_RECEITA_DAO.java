package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.T_RECEITA;

public class T_RECEITA_DAO {

//	private Connection conexao;
//	
//	public T_RECEITA_DAO(Connection conexao) {
//		this.conexao = conexao;
//	}
//public void gravar(T_RECEITA receita) {
//		
//		String sql = "INSERT INTO T_RECEITA (cod_receita, cod_usuario, cod_categoria, des_receita, val_receita)"
//				+ "VALUES (sq_receita.nextval, ?, ?, ?, ?)";
//		
//		
//		try {
//			PreparedStatement ps = conexao.prepareStatement(sql);
//			ps.setInt(1,receita.getCod_usuario() );
//			ps.setInt(2,receita.getCod_categoria() );
//			ps.setString(3,receita.getDes_receita() );
//			ps.setDouble(4,receita.getVal_receita() );
//							
//			System.out.println("Receita 1 cadastrado corretamente!");
//			ps.execute();		
//			ps.close();		
//			
//		} catch (SQLException e) {
//			System.out.println("Erro no cadastro da receita 1");
//			e.printStackTrace();
//		} 
//
//	}
//	
//	public void excluir(T_RECEITA receita) {
//
//	}
//
//	public void atualizar(T_RECEITA receita) {
//
//	}
//	
//	public List<T_RECEITA> listarTodos() {
//		
//		String sql ="SELECT * FROM T_RECEITA ORDER BY COD_RECEITA";
//		List<T_RECEITA> receitas = null;
//		
//		try {
//			PreparedStatement ps = conexao.prepareStatement(sql);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			
//			receitas = new ArrayList();
//			
//			while (rs.next()) {
//				T_RECEITA u = new T_RECEITA();
//				u.setCod_usuario(rs.getInt("cod_usuario"));
//				u.setCod_categoria(rs.getInt("cod_categoria"));
//				u.setDes_receita(rs.getString("des_receita"));
//				u.setVal_receita(rs.getDouble("val_receita"));
//				receitas.add(u);
//			}			
//	
//			ps.close();
//			conexao.close();
//		
//		} catch (SQLException u) {
//			System.out.println("Erro no na exibição de todos os gastos");
//			u.printStackTrace();
//		} 
//		
//		return receitas;
//
//	}
//	
//	public void buscarReceitaPorCod(int cod_receita, int cod_usuario) {
//		
//		String sql = "select * from t_receita where cod_receita = ? and cod_usuario = ?";
//		
//		try {
//			PreparedStatement ps = conexao.prepareStatement(sql);
//			
//			ps.setInt(1, cod_receita);
//			
//			ResultSet rs = ps.executeQuery();
//			T_RECEITA u = new T_RECEITA();
//			
//			if (rs.next()) {
//				u.setCod_receita(rs.getInt("cod_receita"));
//				u.setCod_usuario(rs.getInt("cod_usuario"));
//				u.setCod_categoria(rs.getInt("cod_categoria"));
//				u.setDes_receita(rs.getString("Des_receita"));
//				u.setVal_receita(rs.getDouble("Val_receita"));
//			}
//			
//			System.out.println(u);
//					
//			ps.close();
//			conexao.close();
//		
//		} catch (SQLException u) {
//			System.out.println("Erro no na exibição do usuario");
//			u.printStackTrace();
//		} 
//
//	}
}
