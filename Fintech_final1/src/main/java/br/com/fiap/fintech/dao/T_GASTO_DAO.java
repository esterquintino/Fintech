package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.fintech.bean.T_GASTO;
 
public class T_GASTO_DAO {
	
//	private Connection conexao;
//	
//	public T_GASTO_DAO(Connection conexao) {
//		this.conexao = conexao;
//	}
//	
//	public void gravar(T_GASTO gasto) {
//		
//		String sql = "INSERT INTO T_GASTO (cod_gasto, cod_usuario, cod_categoria, des_gasto, val_gasto)"
//				+ "VALUES (sq_gasto.nextval, ?, ?, ?, ?)";
//		
//		
//		try {
//			PreparedStatement ps = conexao.prepareStatement(sql);
//			ps.setInt(1,gasto.getCod_usuario() );
//			ps.setInt(2,gasto.getCod_categoria() );
//			ps.setString(3,gasto.getDes_gasto() );
//			ps.setDouble(4,gasto.getVal_gasto() );
//							
//			System.out.println("Gasto 1 cadastrado corretamente!");
//			ps.execute();		
//			ps.close();		
//			
//		} catch (SQLException e) {
//			System.out.println("Erro no cadastro do gasto 1");
//			e.printStackTrace();
//		} 
//
//	}
//	
//	public void excluir(T_GASTO gasto) {
//
//	}
//
//	public void atualizar(T_GASTO gasto) {
//
//	}
//	
//	public List<T_GASTO> listarTodos() {
//		
//		String sql ="SELECT * FROM T_GASTO ORDER BY COD_GASTO";
//		List<T_GASTO> gastos = null;
//		
//		try {
//			PreparedStatement ps = conexao.prepareStatement(sql);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			
//			gastos = new ArrayList();
//			
//			while (rs.next()) {
//				T_GASTO u = new T_GASTO();
//				u.setCod_usuario(rs.getInt("cod_usuario"));
//				u.setCod_categoria(rs.getInt("cod_categoria"));
//				u.setDes_gasto(rs.getString("des_gasto"));
//				u.setVal_gasto(rs.getDouble("val_gasto"));
//				gastos.add(u);
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
//		return gastos;
//
//	}
//	
//	public void buscarGastoPorCod(int cod_gasto, int cod_usuario) {
//		
//		String sql = "select * from t_gasto where cod_gasto = ? and cod_usuario = ?";
//		
//		try {
//			PreparedStatement ps = conexao.prepareStatement(sql);
//			
//			ps.setInt(1, cod_gasto);
//			
//			ResultSet rs = ps.executeQuery();
//			T_GASTO u = new T_GASTO();
//			
//			if (rs.next()) {
//				u.setCod_gasto(rs.getInt("cod_gasto"));
//				u.setCod_usuario(rs.getInt("cod_usuario"));
//				u.setCod_categoria(rs.getInt("cod_categoria"));
//				u.setDes_gasto(rs.getString("Des_gasto"));
//				u.setVal_gasto(rs.getDouble("Val_gasto"));
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
	
	//Exemplo de array lista para simular o banco de dados
	
//	private ArrayList<T_GASTO> gasto = new ArrayList<T_GASTO>();
//
//		public T_GASTO_DAO() {
//			this.gasto.add(
//				new T_GASTO(1, 1, 10,
//									"Computador",
//									3500.00f,
//									Calendar.getInstance()
//						));
//			
//			this.gasto.add(
//					new T_GASTO(2, 2, 15,
//										"Celular",
//										5500.f,
//										Calendar.getInstance()
//							));
//			}
//		
//	
//		public ArrayList<T_GASTO> listar(){
//			return this.gasto;
//		}
	
}