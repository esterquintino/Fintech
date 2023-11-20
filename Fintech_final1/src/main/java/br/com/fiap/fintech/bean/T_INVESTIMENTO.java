package br.com.fiap.fintech.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class T_INVESTIMENTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int cod_investimento;
	private int cod_usuario;
	private String des_investimento;
	private double val_investimento;
	private String nom_instituicao;
	private String nom_tipo;
    private LocalDate dt_inicio;
    private LocalDate dt_conclusao;
    
    //Construtores
    
    public T_INVESTIMENTO(int cod_investimento, int cod_usuario, String des_investimento, double val_investimento, String nom_instituicao, String nom_tipo, LocalDate dt_inicio, LocalDate dt_conclusao) {
		super();
		this.cod_investimento = cod_investimento;
		this.cod_usuario = cod_usuario;
		this.des_investimento = des_investimento;
		this.val_investimento = val_investimento;
		this.nom_instituicao = nom_instituicao;
		this.nom_tipo = nom_tipo;
		this.dt_inicio = dt_inicio;
		this.dt_conclusao = dt_conclusao;
	}
	public T_INVESTIMENTO() {
		super();
	}
    
    //Getters e Setters
    
	public int getCod_investimento() {
		return cod_investimento;
	}
	public void setCod_investimento(int cod_investimento) {
		this.cod_investimento = cod_investimento;
	}
	public int getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(int cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public String getDes_investimento() {
		return des_investimento;
	}
	public void setDes_investimento(String des_investimento) {
		this.des_investimento = des_investimento;
	}
	public double getVal_investimento() {
		return val_investimento;
	}
	public void setVal_investimento(double val_investimento) {
		this.val_investimento = val_investimento;
	}
	public String getNom_instituicao() {
		return nom_instituicao;
	}
	public void setNom_instituicao(String nom_instituicao) {
		this.nom_instituicao = nom_instituicao;
	}
	public String getNom_tipo() {
		return nom_tipo;
	}
	public void setNom_tipo(String nom_tipo) {
		this.nom_tipo = nom_tipo;
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
		return "T_INVESTIMENTO [cod_investimento=" + cod_investimento + ", cod_usuario=" + cod_usuario + ", des_investimento=" + des_investimento
				+ ", val_investimento=" + val_investimento + ", nom_instituição=" + nom_instituicao + ", nom_tipo=" + nom_tipo
				+ ", dt_inicio=" + dt_inicio + ", dt_conclusao="+ dt_conclusao + "]";
	}

}
