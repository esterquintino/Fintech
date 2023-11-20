package br.com.fiap.fintech.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class T_USUARIO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int cod_usuario;
	private String usu_nome;
	private String usu_sobrenome;
	private String usu_email;
	private String usu_senha;
	private String usu_pais;
	private LocalDate dt_nascimento;
	
	//Construtores
	
	public T_USUARIO(int cod_usuario, String usu_nome, String usu_sobrenome, String usu_email, String usu_senha, String usu_pais, LocalDate dt_nascimento) {
		super();
		this.cod_usuario = cod_usuario;
		this.usu_nome = usu_nome;
		this.usu_sobrenome = usu_sobrenome;
		this.usu_email = usu_email;
		this.usu_senha = usu_senha;
		this.usu_pais = usu_pais;
		this.dt_nascimento = dt_nascimento;
	}
		
	public T_USUARIO() {
		super();
	}
	
	//Getters e Setters

	public int getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(int cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public String getUsu_nome() {
		return usu_nome;
	}
	public void setUsu_nome(String usu_nome) {
		this.usu_nome = usu_nome;
	}
	public String getUsu_sobrenome() {
		return usu_sobrenome;
	}
	public void setUsu_sobrenome(String usu_sobrenome) {
		this.usu_sobrenome = usu_sobrenome;
	}
	public String getUsu_email() {
		return usu_email;
	}
	public void setUsu_email(String usu_email) {
		this.usu_email = usu_email;
	}
	public String getUsu_senha() {
		return usu_senha;
	}
	public void setUsu_senha(String usu_senha) {
		this.usu_senha = usu_senha;
	}
	public String getUsu_pais() {
		return usu_pais;
	}
	public void setUsu_pais(String usu_pais) {
		this.usu_pais = usu_pais;
	}
	public LocalDate getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(LocalDate dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	@Override
	public String toString() {
		return "T_USUARIO [cod_usuario=" + cod_usuario + ", usu_nome=" + usu_nome + ", usu_sobrenome=" + usu_sobrenome
				+ ", usu_email=" + usu_email + ", usu_senha=" + usu_senha + ", usu_pais=" + usu_pais
				+ ", dt_nascimento=" + dt_nascimento + "]";
	}
	
	
}
