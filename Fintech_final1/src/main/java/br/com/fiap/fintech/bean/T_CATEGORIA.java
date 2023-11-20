package br.com.fiap.fintech.bean;

import java.io.Serializable;

public class T_CATEGORIA implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int cod_categoria;
	private String nom_categoria;
	private String des_categoria;
	
	//Construtores
	
	public T_CATEGORIA() {
		super();
	}
	public T_CATEGORIA(int cod_categoria, String nom_categoria, String des_categoria) {
		super();
		this.cod_categoria = cod_categoria;
		this.nom_categoria = nom_categoria;
		this.des_categoria = des_categoria;
	}

	//Getters e Setters
	
	public int getCod_categoria() {
		return cod_categoria;
	}
	public void setCod_categoria(int cod_categoria) {
		this.cod_categoria = cod_categoria;
	}
	public String getNom_categoria() {
		return nom_categoria;
	}
	public void setNom_categoria(String nom_categoria) {
		this.nom_categoria = nom_categoria;
	}
	public String getDes_categoria() {
		return des_categoria;
	}
	public void setDes_categoria(String des_categoria) {
		this.des_categoria = des_categoria;
	}
	
	@Override
	public String toString() {
		return "T_CATEGORIA [cod_categoria=" + cod_categoria +", nom_categoria=" + nom_categoria + ", des_categoria=" 
				+ des_categoria + "]";
	}
}
