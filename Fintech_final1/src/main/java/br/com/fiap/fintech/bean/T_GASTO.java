package br.com.fiap.fintech.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

public class T_GASTO extends T_CATEGORIA implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int cod_gasto;
	private int cod_usuario;
	private String des_gasto;
	private double val_gasto;
	private Calendar dat_gasto;
	private T_CATEGORIA cod_categoria;
	
	//Contrutores
	
	public T_GASTO(int cod_gasto, int cod_usuario, String des_gasto, double val_gasto, Calendar dat_gasto, T_CATEGORIA cod_categoria) {
		super();
		this.cod_gasto = cod_gasto;
		this.cod_usuario = cod_usuario;
		this.des_gasto = des_gasto;
		this.val_gasto = val_gasto;
		this.dat_gasto = dat_gasto;
		this.cod_categoria = cod_categoria;
	}
	public T_GASTO() {
		super();
	}
	
	//Getter e Setters
	
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
	public T_CATEGORIA getCategoria() {
		return cod_categoria;
	}
	public void setT_CATEGORIA(T_CATEGORIA cod_categoria) {
		this.cod_categoria = cod_categoria;
	}
	
	
	@Override
	public String toString() {
		return "T_GASTO [cod_gasto=" + cod_gasto +", cod_usuario=" + cod_usuario + ", cod_categoria=" 
				+ cod_categoria + ", des_gasto=" + des_gasto + ", val_gasto=" + val_gasto + "]";
	}
}
