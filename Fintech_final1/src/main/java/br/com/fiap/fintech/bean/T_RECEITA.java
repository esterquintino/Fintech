package br.com.fiap.fintech.bean;

import java.io.Serializable;

public class T_RECEITA implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int cod_receita;
	private int cod_usuario;
	private int cod_categoria;
	private String des_receita;
	private double val_receita;
	
	public int getCod_receita() {
		return cod_receita;
	}
	public void setCod_receita(int cod_receita) {
		this.cod_receita = cod_receita;
	}
	public int getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(int cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	
	public int getCod_categoria() {
		return cod_categoria;
	}
	public void setCod_categoria(int cod_categoria) {
		this.cod_categoria = cod_categoria;
	}
	
	public String getDes_receita() {
		return des_receita;
	}
	public void setDes_receita(String des_receita) {
		this.des_receita = des_receita;
	}
	
	public double getVal_receita() {
		return val_receita;
	}
	public void setVal_receita(double val_receita) {
		this.val_receita = val_receita;
	}
	
	@Override
	public String toString() {
		return "T_RECEITA [cod_receita=" + cod_receita +", cod_usuario=" + cod_usuario + ", cod_categoria=" + cod_categoria + ", des_receita=" + des_receita
				+ ", val_receita=" + val_receita + "]";
	}
	
}
