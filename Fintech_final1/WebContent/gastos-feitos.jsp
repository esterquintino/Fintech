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
      <c:if test="${not empty msg}">
      	<div class="alert alert-sucess">${msg}</div>
      </c:if>
      <c:if test="${not empty erro}">
      	<div class="alert alert-danger">${erro}</div>
      </c:if>
      
      <table class="table table-striped">
        <tr>
          <th>Codigo Gasto</th>
          <th>Codigo Usuário</th>
          <th>Descrição Gasto</th>
          <th>Valor Gasto</th>				
          <th>Data Gasto</th>
          <th></th>			
        </tr>
        <c:forEach items="${gastos}" var="g">
          <tr>
            <td>${g.cod_gasto}</td>
            <td>${g.cod_usuario}</td>
            <td>${g.des_gasto}</td>
            <td>${g.val_gasto}</td>
            <td>
                <fmt:formatDate value="${g.dat_gasto.time}" pattern="dd/MM/yyyy" />
            </td>
            <td>
            	<c:url value="p_gasto" var="link">
            		<c:param name="acao" value="abrir-form-edicao"/>
            		<c:param name="cod_gasto" value="${g.cod_gasto}"/>
            	</c:url>
            	<a href="${link}">Editar</a>
            	<button type="button" class="btn btn-danger btn-xs" data-toggle="modal" 
            	data-target="#excluirModal" onClick="cod_gastoExcluir.value= ${g.cod_gasto}">
            	Excluir</button>
            </td>
          </tr>
        </c:forEach>
      </table>
    </div>
  <%@ include file="footer.jsp" %>
  
  <!-- Modal -->
<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        		Deseja realmente excluir o gasto?
      </div>
      <div class="modal-footer">
      	<form action="p_gasto" method="post">
      		<input type="hidden" name="acao" value="excluir">
      		<input type="hidden" name="cod_gasto" id="cod_gastoExcluir">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	        <button type="submit" class="btn btn-danger">Excluir</button>
        </form>
      </div>
    </div>
  </div>
</div>
  
  </body>
  </html>