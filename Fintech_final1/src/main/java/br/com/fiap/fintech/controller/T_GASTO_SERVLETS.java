package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.T_GASTO;

@WebServlet("/p_gasto")
public class T_GASTO_SERVLETS extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static List<T_GASTO> lista = new ArrayList<T_GASTO>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setAttribute("gastos", lista);
        request.getRequestDispatcher("gastos-feitos.jsp").forward(request, response);
    	
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dGasto = request.getParameter("des_gasto");
        Calendar datGasto = Calendar.getInstance();

        String codGastoString = request.getParameter("cod_gasto");
        String codUsuarioString = request.getParameter("cod_usuario");
        String codCategoriaString = request.getParameter("cod_categoria");
        String valGastoString = request.getParameter("val_gasto");
        String dataString = request.getParameter("dat_gasto");
        Date dataFormatada = null;

        // Verifica se os valores não são nulos antes de convertê-los
        if (codGastoString != null && codUsuarioString != null && codCategoriaString != null && valGastoString != null
                && dataString != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            try {
                int cGasto = Integer.parseInt(codGastoString);
                int cUsuario = Integer.parseInt(codUsuarioString);
                int cCategoria = Integer.parseInt(codCategoriaString);
                double vGasto = Double.parseDouble(valGastoString);
                dataFormatada = new Date(format.parse(dataString).getTime());

                T_GASTO p_gasto = new T_GASTO(cGasto, cUsuario, cCategoria, dGasto, vGasto, datGasto);

                lista.add(p_gasto);

                // Mova a configuração do datGasto para dentro do try
                datGasto.setTime(dataFormatada);

                request.setAttribute("msg", "Gasto Adicionado!");

            } catch (NumberFormatException | ParseException e) {
                // Lide com as exceções de conversão para número e de parse
                e.printStackTrace();
                request.setAttribute("msg", "Erro ao adicionar gasto. Verifique os dados informados.");
            }

        } else {
            // Lide com o caso em que um dos parâmetros é nulo
            System.out.println("Um dos parâmetros é nulo");
            request.setAttribute("msg", "Erro ao adicionar gasto. Verifique os dados informados.");
        }

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

}