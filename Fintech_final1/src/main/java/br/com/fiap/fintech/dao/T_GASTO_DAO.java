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
	
	private Connection conexao;
	
	public T_GASTO_DAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	
	
	public T_GASTO_DAO() {
		super();
	}




	public void gravar(T_GASTO gasto) {
		
		String sql = "INSERT INTO T_GASTO (cod_gasto, cod_usuario, cod_categoria, des_gasto, val_gasto, dt_datagasto)"
				+ "VALUES (sq_gasto.nextval, ?, ?, ?, ?,?)";
		
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1,gasto.getCod_usuario() );
			//ps.setInt(2,gasto.getCod_categoria() );
			ps.setString(3,gasto.getDes_gasto() );
			ps.setDouble(4,gasto.getVal_gasto() );
			java.sql.Date data= new java.sql.Date(gasto.getDat_gasto().getTimeInMillis());
			ps.setDate(5, data);
							
			System.out.println("Gasto 1 cadastrado corretamente!");
			ps.execute();		
			ps.close();		
			
		} catch (SQLException e) {
			System.out.println("Erro no cadastro do gasto 1");
			e.printStackTrace();
		} 

	}
	
	public void excluir(T_GASTO gasto) {
		
//		@Override
//		public void remover(int codigo) throws DBException {
//				PreparedStatement stmt = null;

				try {
					String sql = "DELETE FROM T_GASTO WHERE cod_gasto = ?";
					PreparedStatement ps = conexao.prepareStatement(sql);
					ps = conexao.prepareStatement(sql);
					ps.setInt(1, gasto.getCod_gasto());
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
	}


	public void atualizar(T_GASTO gasto) {
		
//		@Override
//		public void atualizar(Produto produto) throws DBException {
//			PreparedStatement stmt = null;

			try {
				String sql = "UPDATE T_GASTOSET des_gasto = ?, val_gasto = ?, dt_datagasto = ? WHERE cod_gasto = ?";
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, gasto.getDes_gasto());
				ps.setDouble(2, gasto.getVal_gasto());
				java.sql.Date data= new java.sql.Date(gasto.getDat_gasto().getTimeInMillis());
				ps.setDate(3, data);
				ps.setInt(4, gasto.getCod_gasto());

				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			}

	}
	
	public List<T_GASTO> listarTodos() {
		
		String sql ="SELECT * FROM T_GASTO ORDER BY COD_GASTO";
		List<T_GASTO> gastos = null;
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			
			gastos = new ArrayList();
			
			while (rs.next()) {
				T_GASTO u = new T_GASTO();
				u.setCod_usuario(rs.getInt("cod_usuario"));
				//u.setCod_categoria(rs.getInt("cod_categoria"));
				u.setDes_gasto(rs.getString("des_gasto"));
				u.setVal_gasto(rs.getDouble("val_gasto"));
				gastos.add(u);
			}			
	
			ps.close();
			conexao.close();
		
		} catch (SQLException u) {
			System.out.println("Erro no na exibição de todos os gastos");
			u.printStackTrace();
		} 
		
		return gastos;

	}
	
	public void buscarGastoPorCod(int cod_gasto, int cod_usuario) {
		
		String sql = "select * from t_gasto where cod_gasto = ? and cod_usuario = ?";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, cod_gasto);
			
			ResultSet rs = ps.executeQuery();
			T_GASTO u = new T_GASTO();
			
			if (rs.next()) {
				u.setCod_gasto(rs.getInt("cod_gasto"));
				u.setCod_usuario(rs.getInt("cod_usuario"));
				//u.setCod_categoria(rs.getInt("cod_categoria"));
				u.setDes_gasto(rs.getString("Des_gasto"));
				u.setVal_gasto(rs.getDouble("Val_gasto"));
			}
			
			System.out.println(u);
					
			ps.close();
			conexao.close();
		
		} catch (SQLException u) {
			System.out.println("Erro no na exibição do usuario");
			u.printStackTrace();
		} 

	}
	
	
}
