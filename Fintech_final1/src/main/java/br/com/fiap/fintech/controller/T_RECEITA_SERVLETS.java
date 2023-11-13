package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

import br.com.fiap.fintech.bean.T_RECEITA;

/**
 * Servlet implementation class T_RECEITA_SERVLETS
 */
@WebServlet("/p_receita")
public class T_RECEITA_SERVLETS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static List<T_RECEITA> listaReceita = new ArrayList<T_RECEITA>();
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("receitas", listaReceita);
        request.getRequestDispatcher("receitas-feitas.jsp").forward(request, response);
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dReceita = request.getParameter("des_receita");
        Calendar datReceita = Calendar.getInstance();

        String codReceitaString = request.getParameter("cod_receita");
        String codUsuarioString = request.getParameter("cod_usuario");
        String codCategoriaString = request.getParameter("cod_categoria");
        String valReceitaString = request.getParameter("val_receita");
        String dataString = request.getParameter("dat_receita");
        Date dataFormatada = null;

        // Verifica se os valores não são nulos antes de convertê-los
        if (codReceitaString != null && codUsuarioString != null && codCategoriaString != null && valReceitaString != null
                && dataString != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            try {
                int cReceita = Integer.parseInt(codReceitaString);
                int cUsuario = Integer.parseInt(codUsuarioString);
                int cCategoria = Integer.parseInt(codCategoriaString);
                double vReceita = Double.parseDouble(valReceitaString);
                LocalDate localDate = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                // Configurar datGasto diretamente com a data
                datReceita = new GregorianCalendar(
                        localDate.getYear(),
                        localDate.getMonthValue() - 1,  // Mês é baseado em zero
                        localDate.getDayOfMonth()
                );

                T_RECEITA p_receita = new T_RECEITA(cReceita, cUsuario, cCategoria, dReceita, vReceita, datReceita);

                listaReceita.add(p_receita);

                request.setAttribute("msg", "Receita Adicionada!");

            } catch (NumberFormatException e) {
                // Lide com as exceções de conversão para número e de parse
                e.printStackTrace();
                request.setAttribute("msg", "Erro ao adicionar receita. Verifique os dados informados.");
            }


        } else {
            // Lide com o caso em que um dos parâmetros é nulo
            System.out.println("Um dos parâmetros é nulo");
            request.setAttribute("msg", "Erro ao adicionar receita. Verifique os dados informados.");
        }

        request.getRequestDispatcher("homeReceita.jsp").forward(request, response);
	}

}
