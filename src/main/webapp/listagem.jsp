<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored ="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>"/> 
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h3>Listagem</h3>
		</div>
		<div>
			<table class="table">
				<thead>
					<tr>
						<td class="col-sm-1">Código</td>
						<td class="col-sm-10">Nome</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pessoas.pessoas}" var="pessoa">
						<tr>
							<td class="col-sm-1">${pessoa.codigo}</td>
							<td class="col-sm-10">${pessoa.nome}</td>
							<td><a href="/ServletBasico-VI/Editar/${pessoa.codigo}" class="btn btn-success">Editar</a>
							<td><a href="/ServletBasico-VI/Excluir/${pessoa.codigo}" class="btn btn-danger">Excluir</a></td>
						</tr> 
					</c:forEach>
				</tbody>
			</table>
			<a href="/ServletBasico-VI/cadastro.jsp" class="btn btn-primary">Cadastro</a>
			<a href="/ServletBasico-VI/login.jsp" class="btn btn-primary">Sair</a>
		</div>
	</div>
</body>
</html>