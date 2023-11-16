package br.com.fiap.store.teste;

import java.util.List;

import br.com.fiap.fintech.bean.Categoria;
import br.com.fiap.fintech.dao.CategoriaDao;
import br.com.fiap.fintech.factory.DAOFactory;

public class TesteCategoriaDAO {

	public static void main(String[] args) {
		CategoriaDao dao = DAOFactory.getCategoriaDao();
		
		List<Categoria> lista = dao.listar();
		for (Categoria cat : lista) {
			System.out.println(cat.getCod_categoria() + " " + cat.getNom_categoria() + " " + cat.getDes_categoria());
		}
	}

}
