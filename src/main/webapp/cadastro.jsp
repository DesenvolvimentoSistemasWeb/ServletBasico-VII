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
			<h3>Cadastro</h3>
		</div>
		<form class="form-vertical" action="/ServletBasico-VI/Cadastro" method="post">
			<div class="form-group">
				<label>Nome</label>
				<input type="text" name="nome" class="form-control"/>
			</div>
			<input type="submit" class="btn btn-primary" value="Salvar"/>
			<a href="/ServletBasico-VI/index.jsp" class="btn btn-primary">Inicio</a>
			<a href="/ServletBasico-VI/login.jsp" class="btn btn-primary">Sair</a>			
		</form>
	</div>
</body>
</html>