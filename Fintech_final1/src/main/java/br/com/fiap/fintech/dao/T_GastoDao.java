package br.com.fiap.fintech.dao;

import java.util.List;
import br.com.fiap.fintech.bean.T_GASTO;
import br.com.fiap.fintech.exception.DBException;

public interface T_GastoDao {

		void cadastrar(T_GASTO gasto) throws DBException;
		void atualizar(T_GASTO gasto) throws DBException;
		void remover(int codigo) throws DBException;
		T_GASTO buscar(int cod);
		List<T_GASTO> listar();

}
