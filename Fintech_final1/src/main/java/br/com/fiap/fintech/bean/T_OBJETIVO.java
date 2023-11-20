package br.com.fiap.fintech.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class T_OBJETIVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int cod_objetivo;
	private int cod_usuario;
	private String des_objetivo;
	private double val_objetivo;
	private LocalDate dt_inicio;
	private LocalDate dt_conclusao;
	
	//Construtores
	
	public T_OBJETIVO(int cod_objetivo, int cod_usuario, String des_objetivo, double val_objetivo, LocalDate dt_inicio, LocalDate dt_conclusao) {
		super();
		this.cod_objetivo = cod_objetivo;
		this.cod_usuario = cod_usuario;
		this.des_objetivo = des_objetivo;
		this.val_objetivo = val_objetivo;
		this.dt_inicio = dt_inicio;
		this.dt_conclusao = dt_conclusao;
	}
	public T_OBJETIVO() {
		super();
	}
	
	//Getters e Setters
	
	public int getCod_objetivo() {
		return cod_objetivo;
	}
	public void setCod_objetivo(int cod_objetivo) {
		this.cod_objetivo = cod_objetivo;
	}
	public int getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(int cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public String getDes_objetivo() {
		return des_objetivo;
	}
	public void setDes_objetivo(String des_objetivo) {
		this.des_objetivo = des_objetivo;
	}
	public double getVal_objetivo() {
		return val_objetivo;
	}
	public void setVal_objetivo(double val_objetivo) {
		this.val_objetivo = val_objetivo;
	}
	public LocalDate getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(LocalDate dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	public LocalDate getDt_conclusao() {
		return dt_conclusao;
	}
	public void setDt_conclusao(LocalDate dt_conclusao) {
		this.dt_conclusao = dt_conclusao;
	}
	
	@Override
	public String toString() {
		return "T_OBJETIVO [cod_objetivo=" + cod_objetivo + ", cod_usuario=" + cod_usuario + ", des_objetivo=" + des_objetivo
				+ ", val_objetivo=" + val_objetivo + ", dt_inicio=" + dt_inicio + ", dt_conclusao="+ dt_conclusao + "]";
	}

}
