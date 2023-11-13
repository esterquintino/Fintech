<%@ page import="java.util.*" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Gastos Realizados</title>
  <%@ include file="header.jsp" %>
  </head>
  <body>
  <%@ include file="Receita.jsp" %>
    <div class="container">
      <h1>Receitas</h1>
      <table class="table table-striped">
        <tr>
          <th>Código Receita</th>
          <th>Código Usuário</th>
          <th>Código Categoria</th>
          <th>Descrição Receita</th>
          <th>Valor Receita</th>				
          <th>Data Receita</th>				
        </tr>
        <c:forEach items="${receitas}" var="r">
          <tr>
            <td>${r.cod_receita}</td>
            <td>${r.cod_usuario}</td>
            <td>${r.cod_categoria}</td>
            <td>${r.des_receita}</td>
            <td>${r.val_receita}</td>
            <td>
                <fmt:formatDate value="${r.dat_receita.time}" pattern="dd/MM/yyyy" />
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
  <%@ include file="footer.jsp" %>
  </body>
  </html>