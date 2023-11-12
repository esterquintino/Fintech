package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.bean.T_USUARIO;

public class T_USUARIO_DAO {
	
	private Connection conexao;
	
	public T_USUARIO_DAO(Connection conexao) {
		this.conexao = conexao;
	}

// SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO 	
	
	
	
	
	public void gravar(T_USUARIO usuario) {
		
		String sql = "INSERT INTO T_USUARIO (cod_usuario, usu_nome, usu_sobrenome, usu_email, usu_senha, usu_pais, dt_nascimento)"
				+ "VALUES (sq_usuario.nextval, ?, ?, ?, ?, ?, ?)";
		
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1,usuario.getUsu_nome() );
			ps.setString(2,usuario.getUsu_sobrenome() );
			ps.setString(3,usuario.getUsu_email() );
			ps.setString(4,usuario.getUsu_senha() );
			ps.setString(5,usuario.getUsu_pais() );
			Date data = Date.valueOf(usuario.getDt_nascimento());
			ps.setDate(6, data);
					
			
			System.out.println("Usuario 1 cadastrado corretamente!");
			ps.execute();		
			ps.close();		
			
		} catch (SQLException e) {
			System.out.println("Erro no cadastro do ususario 1");
			e.printStackTrace();
		} 

	}
	
	
	public void gravar2(T_USUARIO usuario2) {
		
		String sql = "INSERT INTO T_USUARIO (cod_usuario, usu_nome, usu_sobrenome, usu_email, usu_senha, usu_pais, dt_nascimento)"
				+ "VALUES (sq_usuario.nextval, ?, ?, ?, ?, ?, ?)";
		
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1,usuario2.getUsu_nome() );
			ps.setString(2,usuario2.getUsu_sobrenome() );
			ps.setString(3,usuario2.getUsu_email() );
			ps.setString(4,usuario2.getUsu_senha() );
			ps.setString(5,usuario2.getUsu_pais() );
			Date data = Date.valueOf(usuario2.getDt_nascimento());
			ps.setDate(6, data);
					
			ps.execute();
			ps.close();
			
			System.out.println("Usuario 2 cadastrado corretamente!");
					
					
			
		} catch (SQLException e) {
			System.out.println("Erro no cadastro do ususario 2");
			e.printStackTrace();
		} 

	}
	
	
	public void gravar3(T_USUARIO usuario3) {
		
		String sql = "INSERT INTO T_USUARIO (cod_usuario, usu_nome, usu_sobrenome, usu_email, usu_senha, usu_pais, dt_nascimento)"
				+ "VALUES (sq_usuario.nextval, ?, ?, ?, ?, ?, ?)";
		
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1,usuario3.getUsu_nome() );
			ps.setString(2,usuario3.getUsu_sobrenome() );
			ps.setString(3,usuario3.getUsu_email() );
			ps.setString(4,usuario3.getUsu_senha() );
			ps.setString(5,usuario3.getUsu_pais() );
			Date data = Date.valueOf(usuario3.getDt_nascimento());
			ps.setDate(6, data);
					
			ps.execute();
			ps.close();
			
			System.out.println("Usuario 3 cadastrado corretamente!");
					
					
			
		} catch (SQLException e) {
			System.out.println("Erro no cadastro do ususario 3");
			e.printStackTrace();
		} 

	}
	
	public void gravar4(T_USUARIO usuario4) {
		
		String sql = "INSERT INTO T_USUARIO (cod_usuario, usu_nome, usu_sobrenome, usu_email, usu_senha, usu_pais, dt_nascimento)"
				+ "VALUES (sq_usuario.nextval, ?, ?, ?, ?, ?, ?)";
		
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1,usuario4.getUsu_nome() );
			ps.setString(2,usuario4.getUsu_sobrenome() );
			ps.setString(3,usuario4.getUsu_email() );
			ps.setString(4,usuario4.getUsu_senha() );
			ps.setString(5,usuario4.getUsu_pais() );
			Date data = Date.valueOf(usuario4.getDt_nascimento());
			ps.setDate(6, data);
					
			ps.execute();
			ps.close();
			
			System.out.println("Usuario 4 cadastrado corretamente!");
					
					
			
		} catch (SQLException e) {
			System.out.println("Erro no cadastro do ususario 4");
			e.printStackTrace();
		} 

	}
	
	
	public void gravar5(T_USUARIO usuario5) {
		
		String sql = "INSERT INTO T_USUARIO (cod_usuario, usu_nome, usu_sobrenome, usu_email, usu_senha, usu_pais, dt_nascimento)"
				+ "VALUES (sq_usuario.nextval, ?, ?, ?, ?, ?, ?)";
		
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1,usuario5.getUsu_nome() );
			ps.setString(2,usuario5.getUsu_sobrenome() );
			ps.setString(3,usuario5.getUsu_email() );
			ps.setString(4,usuario5.getUsu_senha() );
			ps.setString(5,usuario5.getUsu_pais() );
			Date data = Date.valueOf(usuario5.getDt_nascimento());
			ps.setDate(6, data);
					
			ps.execute();
			ps.close();
			
			
			System.out.println("Usuario 5 cadastrado corretamente!");
					
					
			
		} catch (SQLException e) {
			System.out.println("Erro no cadastro do ususario 5");
			e.printStackTrace();
		} 

	}


//	SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO SEPARANDO
	
	
	public void excluir(T_USUARIO usuario) {

	}

	public void atualizar(T_USUARIO usuario) {

	}

	public List<T_USUARIO> listarTodos() {
		
		String sql ="SELECT * FROM T_USUARIO ORDER BY COD_USUARIO";
		List<T_USUARIO> usuarios = null;
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			
			usuarios = new ArrayList();
			
			while (rs.next()) {
				T_USUARIO u = new T_USUARIO();
				u.setCod_usuario(rs.getInt("cod_usuario"));
				u.setUsu_nome(rs.getString("usu_nome"));
				u.setUsu_email(rs.getString("usu_email"));
				u.setUsu_senha(rs.getString("usu_senha"));
				u.setUsu_pais(rs.getString("usu_pais"));
				//u.setDt_nascimento(rs.findColumn(sql) ("dt_nascimento");
				usuarios.add(u);
				
			}
			
			
			//Date data = Date.valueOf(usuario5.getDt_nascimento());
			//ps.setDate(6, data);
				
			//System.out.println(u);
			
	
			ps.close();
			conexao.close();
		
		} catch (SQLException u) {
			System.out.println("Erro no na exibição de todos usuarios");
			u.printStackTrace();
		} 
		
		return usuarios;

	}

	public void buscarUsuarioPorCod(int cod_usuario) {
		
		String sql = "select * from t_usuario where cod_usuario = ?";
		
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, cod_usuario);
			
			ResultSet rs = ps.executeQuery();
			T_USUARIO u = new T_USUARIO();
			
			if (rs.next()) {
				u.setCod_usuario(rs.getInt("cod_usuario"));
				u.setUsu_nome(rs.getString("usu_nome"));
				u.setUsu_email(rs.getString("usu_email"));
				u.setUsu_senha(rs.getString("usu_senha"));
				u.setUsu_pais(rs.getString("usu_pais"));
				//u.setdt_nascimnento(rs.getLoca("dt_nascimento"));
				
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


