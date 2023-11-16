<%@ page import="java.util.*" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Atualização de Gasto</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="Gasto.jsp"%>
	<div class="container">
		<h1>Edição de Gastos</h1>
		
		<c:if test="${not empty msg}">
			<div class="alert alert-sucess">
				${msg}
			</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>

		<form method="POST" action="p_gasto">
		
			<input type="hidden" value="editar" name="acao">
			<input type="hidden" value="${gasto.cod_gasto}" name="cod_gasto">
			<div class="form-group">
				<label for="id-cod-gasto">Codigo Gasto</label> <input type="number"
					name="cod_gasto" id="id-cod-gasto" class="form-control" value="${gasto.cod_gasto}">
			</div>
			<div class="form-group">
				<label for="id-cod-usuaro">Codigo Usuário</label> <input type="number"
					name="cod_usuario" id="id-cod-usuario" class="form-control" value="${gasto.cod_usuario}">
			</div>
			<div class="form-group">
				<label for="id-cod-categoria">Codigo Categoria</label> <input type="number"
					name="cod_categoria" id="id-cod-categoria" class="form-control" value="${gasto.cod_categoria}">
			</div>
			<div class="form-group">
				<label for="id-des-gasto">Descrição Gasto</label> <input type="text"
					name="des_gasto" id="id-des-gasto" class="form-control" value="${gasto.des_gasto}">
			</div>
			<div class="form-group">
				<label for="id-vl-gasto">Valor Gasto</label> <input type="number"
					name="val_gasto" id="id-vl-gasto" class="form-control" value="${gasto.val_gasto}">
			</div>
			<div class="form-group">
				<label for="id-dt-gasto">Data Gasto</label> <input type="date"
					name="dat_gasto" id="id-dt-gasto" class="form-control" value= '<fmt:formatDate value="${gasto.dat_gasto.time}" pattern="dd/MM/yyyy"/>'>
			</div>
			<input type="submit" value="Salvar" class="btn btn-primary">
			<a href="p_gasto?acao=listar" class="btn btn-danger">Cancelar</a>
		</form>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>