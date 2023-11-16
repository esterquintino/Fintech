package br.com.fiap.fintech.factory;

import java.sql.Connection;

import br.com.fiap.fintech.dao.CategoriaDao;
import br.com.fiap.fintech.dao.T_GastoDao;
import br.com.fiap.fintech.dao.impl.OracleCategoriaDAO;
import br.com.fiap.fintech.dao.impl.OracleT_GastoDao;
import br.com.fiap.store.singleton.Conexao;

public class DAOFactory {
    
	public static T_GastoDao getGastoDao() {
	    Connection conexao = null;
	    T_GastoDao gastoDao = null;

	    try {
	        conexao = Conexao.obterConexao();
	        gastoDao = new OracleT_GastoDao(conexao);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return gastoDao;
	}
	
	public static CategoriaDao getCategoriaDao() {
	    Connection conexao = null;
	    CategoriaDao categoriaDao = null;

	    try {
	        conexao = Conexao.obterConexao();
	        categoriaDao = new OracleCategoriaDAO(conexao);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return categoriaDao;
	}

}
