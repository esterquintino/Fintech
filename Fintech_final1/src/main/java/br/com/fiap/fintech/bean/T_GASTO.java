package br.com.fiap.fintech.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

public class T_GASTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int cod_gasto;
	private int cod_usuario;
	//private int cod_categoria;
	private String des_gasto;
	private double val_gasto;
	private Calendar dat_gasto;
	private Categoria categoria;
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public T_GASTO(int cod_gasto, int cod_usuario, String des_gasto, double val_gasto, Calendar dat_gasto) {
		super();
		this.cod_gasto = cod_gasto;
		this.cod_usuario = cod_usuario;
		//this.cod_categoria = cod_categoria;
		this.des_gasto = des_gasto;
		this.val_gasto = val_gasto;
		this.dat_gasto = dat_gasto;
	}
	public T_GASTO() {
		super();
		
	}
	public int getCod_gasto() {
		return cod_gasto;
	}
	public void setCod_gasto(int cod_gasto) {
		this.cod_gasto = cod_gasto;
	}
	public int getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(int cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
//	public int getCod_categoria() {
//		return cod_categoria;
//	}
//	public void setCod_categoria(int cod_categoria) {
//		this.cod_categoria = cod_categoria;
//	}
	public String getDes_gasto() {
		return des_gasto;
	}
	public void setDes_gasto(String des_gasto) {
		this.des_gasto = des_gasto;
	}
	public double getVal_gasto() {
		return val_gasto;
	}
	public void setVal_gasto(double val_gasto) {
		this.val_gasto = val_gasto;
	}
	public Calendar getDat_gasto() {
		return dat_gasto;
	}
	public void setDat_gasto(Calendar dat_gasto) {
		this.dat_gasto = dat_gasto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
//	@Override
//	public String toString() {
//		return "T_GASTO [cod_gasto=" + cod_gasto +", cod_usuario=" + cod_usuario + ", cod_categoria=" + cod_categoria + ", des_gasto=" + des_gasto
//				+ ", val_gasto=" + val_gasto + "]";
//	}
}
