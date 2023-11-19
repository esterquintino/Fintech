package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Categoria;
import br.com.fiap.fintech.bean.T_GASTO;
import br.com.fiap.fintech.dao.CategoriaDao;
import br.com.fiap.fintech.dao.T_GastoDao;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.store.singleton.Conexao;

@WebServlet("/p_gasto")
public class T_GASTO_SERVLETS extends HttpServlet {
    private static final long serialVersionUID = 1L;


    private T_GastoDao dao;
    private CategoriaDao categoriaDao;
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	dao = DAOFactory.getGastoDao();
    	categoriaDao = DAOFactory.getCategoriaDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
    	String acao = request.getParameter("acao");
    	
    	switch (acao) {
    	case "listar": 
    		listar(request, response);
    		break;
    	case "abrir-form-edicao" :
    		int cod_gasto = Integer.parseInt(
    				request.getParameter("cod_gasto"));
    		T_GASTO gasto = dao.buscar(cod_gasto);
    		request.setAttribute("gasto", gasto);
    		request.getRequestDispatcher("edicao-gasto.jsp").forward(request, response);
    	case "abrir-form-cadastro" :
    		abrirFormCadastro(request, response);
    		break;
    	}
    }
    	
    private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categoria> lista = null;
        
        try {
            lista = categoriaDao.listar();
        } catch (Exception e) {
            System.err.println("Erro ao obter categorias: " + e.getMessage());
            e.printStackTrace();
        }

        request.setAttribute("categorias", lista);

        // Em vez de redirecionar diretamente, vamos armazenar uma flag no request
        request.setAttribute("redirect", true);
        
        // Vamos encaminhar para a JSP
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }







 
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<T_GASTO> lista = dao.listar();
		request.setAttribute("gastos", lista);
		request.getRequestDispatcher("gastos-feitos.jsp").forward(request, response);
	}


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String acao = request.getParameter("acao");
    	
    	switch (acao) {
    	case "cadastrar" :
    		cadastrar(request, response);
    		break;
    	case "editar" :
    		editar(request, response);
    		break;
    	case "excluir" :
    		excluir(request, response);
    		break;
    	}
    }
    
    
	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dGasto = request.getParameter("des_gasto");
        Calendar datGasto = Calendar.getInstance();

        String codGastoString = request.getParameter("cod_gasto");
        String codUsuarioString = request.getParameter("cod_usuario");
        //String codCategoriaString = request.getParameter("cod_categoria");
        String valGastoString = request.getParameter("val_gasto");
        String dataString = request.getParameter("dat_gasto");
        Date dataFormatada = null;

        // Verifica se os valores não são nulos antes de convertê-los
        if (codGastoString != null && codUsuarioString != null && valGastoString != null
                && dataString != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            try {
                int cGasto = Integer.parseInt(codGastoString);
                int cUsuario = Integer.parseInt(codUsuarioString);
                //int cCategoria = Integer.parseInt(codCategoriaString);
                double vGasto = Double.parseDouble(valGastoString);
                LocalDate localDate = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                // Configurar datGasto diretamente com a data
                datGasto = new GregorianCalendar(
                        localDate.getYear(),
                        localDate.getMonthValue() - 1,  // Mês é baseado em zero
                        localDate.getDayOfMonth());
                
                int cod_categoria = Integer.parseInt(request.getParameter("categoria"));
                
                Categoria categoria = new Categoria();
                categoria.setCod_categoria(cod_categoria);

                T_GASTO p_gasto = new T_GASTO(cGasto, cUsuario, dGasto, vGasto, datGasto);
                p_gasto.setCategoria(categoria);
                dao.cadastrar(p_gasto);
               
                request.setAttribute("msg", "Gasto Adicionado!");

            } catch (NumberFormatException e) {
                // Lide com as exceções de conversão para número e de parse
                e.printStackTrace();
                request.setAttribute("msg", "Erro ao adicionar gasto. Verifique os dados informados.");
            } catch (DBException e) {
            	e.printStackTrace();
            	request.setAttribute("erro", "Erro ao cadastrar!");
            }


        } else {
            // Lide com o caso em que um dos parâmetros é nulo
            System.out.println("Um dos parâmetros é nulo");
            request.setAttribute("msg", "Erro ao adicionar gasto. Verifique os dados informados.");
        }

       // request.getRequestDispatcher("home.jsp").forward(request, response);
        abrirFormCadastro(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 try {
             int cGasto = Integer.parseInt(request.getParameter("cod_gasto"));
             int cUsuario = Integer.parseInt(request.getParameter("cod_usuario"));
             String dGasto = request.getParameter("des_gasto");
             double vGasto = Double.parseDouble(request.getParameter("val_gasto"));
             SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
             Calendar dat_gasto = Calendar.getInstance();
             dat_gasto.setTime(format.parse(request.getParameter("dat_gasto")));

             T_GASTO p_gasto = new T_GASTO(cGasto, cUsuario, dGasto, vGasto, dat_gasto);      
             dao.atualizar(p_gasto);
            
             request.setAttribute("msg", "Gasto Atualizado!");
         } catch (Exception e) {
             // Lide com as exceções de conversão para número e de parse
             e.printStackTrace();
             request.setAttribute("msg", "Erro ao atualizar gasto. Verifique os dados informados.");
         }
		listar(request, response);
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cod_gasto = Integer.parseInt(request.getParameter("cod_gasto"));
		try {
			dao.remover(cod_gasto);
			request.setAttribute("msg", "Gasto Removido");
		} catch(DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}
		listar(request, response);
	}

}
