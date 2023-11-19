<%@ page import="java.util.*" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>

<%
    // Verifica se a flag de redirecionamento está presente
    Boolean redirect = (Boolean) request.getAttribute("redirect");
    
    if (redirect != null && redirect) {
        // Limpa a flag
        request.setAttribute("redirect", false);
        
        // Realiza o redirecionamento
        response.sendRedirect("home.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Gasto</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="Gasto.jsp"%>
	<div class="container">
		<h1>Tabela de Gastos</h1>
		
		<c:if test="${not empty msg}">
			<div class="alert alert-success">
				${msg}
			</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>

		<form method="POST" action="p_gasto">
		<input type="hidden" value="cadastrar" name="acao">
			<div class="form-group">
				<label for="id-cod-gasto">Codigo Gasto</label> <input type="number"
					name="cod_gasto" id="id-cod-gasto" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-cod-usuaro">Codigo Usuário</label> <input type="number"
					name="cod_usuario" id="id-cod-usuario" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-des-gasto">Descrição Gasto</label> <input type="text"
					name="des_gasto" id="id-des-gasto" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-vl-gasto">Valor Gasto</label> <input type="number"
					name="val_gasto" id="id-vl-gasto" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-dt-gasto">Data Gasto</label> <input type="date"
					name="dat_gasto" id="id-dt-gasto" class="form-control">
			</div>
			<div class="form-group">
				<label for="id-cod_categoria">Categoria</label>
				<select name="categoria" id="cod_categoria" class="form-control">
					<option value="0">Selecione</option>
					<c:forEach items="${categorias}" var="c">
						<option value="${c.cod_categoria}" >${c.nom_categoria}</option>
					</c:forEach>
				</select>
			</div>
			<input type="submit" value="Enviar" class="btn btn-primary">
		</form>
	</div>
	


	<%@ include file="footer.jsp"%>
</body>
</html>