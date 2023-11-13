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
  <%@ include file="Gasto.jsp" %>
    <div class="container">
      <h1>Gastos</h1>
      <table class="table table-striped">
        <tr>
          <th>Codigo Gasto</th>
          <th>Codigo Usuário</th>
          <th>Codigo Categoria</th>
          <th>Descrição Gasto</th>
          <th>Valor Gasto</th>				
          <th>Data Gasto</th>				
        </tr>
        <c:forEach items="${gastos}" var="g">
          <tr>
            <td>${g.cod_gasto}</td>
            <td>${g.cod_usuario}</td>
            <td>${g.cod_categoria}</td>
            <td>${g.des_gasto}</td>
            <td>${g.val_gasto}</td>
            <td>
                <fmt:formatDate value="${g.dat_gasto.time}" pattern="dd/MM/yyyy" />
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
  <%@ include file="footer.jsp" %>
  </body>
  </html>