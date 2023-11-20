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
		
		String sql = "INSERT INTO TGF_GASTO (cod_gasto, cod_usuario, des_gasto, val_gasto, dt_saida, cod_categoria)"
				+ "VALUES (SEQ_GASTO.NEXTVAL, ?, ?, ?, ?,?)";
		
		
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
			ps.setInt(1,gasto.getCod_usuario() );
			ps.setString(2,gasto.getDes_gasto() );
			ps.setDouble(3,gasto.getVal_gasto() );
			java.sql.Date data= new java.sql.Date(gasto.getDat_gasto().getTimeInMillis());
			ps.setDate(4, data);
			ps.setInt(5,gasto.getCategoria().getCod_categoria() );
							
			System.out.println("Gasto 1 cadastrado corretamente!");
			ps.executeUpdate();		
			ps.close();		
			
		} catch (SQLException e) {
			System.out.println("Erro no cadastro do gasto 1");
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void excluir(T_GASTO gasto) {
		String sql = "DELETE FROM TGF_GASTO WHERE cod_gasto = ?";

		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
					ps.setInt(1, gasto.getCod_gasto());
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally { 
					try {
						conexao.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
	}


	public void atualizar(T_GASTO gasto) {
		String sql = "UPDATE TGF_GASTO SET des_gasto = ?, val_gasto = ?, dt_saida = ?, cod_categoria = ? WHERE cod_gasto = ?";
		
		try (PreparedStatement ps = conexao.prepareStatement(sql)) {
				ps.setString(1, gasto.getDes_gasto());
				ps.setDouble(2, gasto.getVal_gasto());
				java.sql.Date data= new java.sql.Date(gasto.getDat_gasto().getTimeInMillis());
				ps.setDate(3, data);
				ps.setInt(4, gasto.getCategoria().getCod_categoria());
				ps.setInt(5, gasto.getCod_gasto());

				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { 
				try {
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

	}
	
	public List<T_GASTO> listar() {
		
		String sql ="SELECT * FROM TGF_GASTO ORDER BY COD_GASTO";
		List<T_GASTO> gastos = null;
		
		try (PreparedStatement ps = conexao.prepareStatement(sql);
		         ResultSet rs = ps.executeQuery()) {		
			
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
		
		} catch (SQLException u) {
			System.out.println("Erro no na exibição de todos os gastos");
			u.printStackTrace();
		} finally { 
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return gastos;

	}
	
	public void buscar(int cod_gasto, int cod_usuario) {
		
		String sql = "SELECT * FROM TGF_GASTO INNER JOIN TGF_CATEGORIA ON TGF_GASTO.COD_CATEGORIA = TGF_CATEGORIA.COD_CATEGORIA WHERE TGF_GASTO.COD_GASTO = ?";
		ResultSet rs = null;
		try (PreparedStatement ps = conexao.prepareStatement(sql))
				 {
						
			ps.setInt(1, cod_gasto);
			rs = ps.executeQuery();
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
		
		} catch (SQLException u) {
			System.out.println("Erro no na exibição do usuario");
			u.printStackTrace();
		} finally { 
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	
}
