<%@ page import="java.util.*" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Receita</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="Receita.jsp"%>
	<div class="container">
		<h1>Tabela de Receitas</h1>
		
		<c:if test="${not empty msg}">
			<div class="alert alert-sucess">
				${msg}
			</div>
		</c:if>

		<form method="POST" action="p_receita">
		
			<div class="form-group">
				<label for="id-cod-receita">Codigo Receita</label> <input type="number"
					name="cod_receita" id="id-cod-receita" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-cod-usuaro">Codigo Usuário</label> <input type="number"
					name="cod_usuario" id="id-cod-usuario" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-cod-categoria">Codigo Categoria</label> <input type="number"
					name="cod_categoria" id="id-cod-categoria" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-des-receita">Descrição Receita</label> <input type="text"
					name="des_receita" id="id-des-receita" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-vl-receita">Valor Receita</label> <input type="number"
					name="val_receita" id="id-vl-receita" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-dt-receita">Data Receita</label> <input type="date"
					name="dat_receita" id="id-dt-receita" class="form-control">
			</div>
			<input type="submit" value="Enviar" class="btn btn-primary">
		</form>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>