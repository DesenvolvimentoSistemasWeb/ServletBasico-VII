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
    	<div class="jumbotron"><h4>Cadastro Básico</h4></div>
    	<a class="btn btn-primary" href="/ServletBasico-VII/cadastro.jsp">Cadastrar</a>
		<a class="btn btn-primary" href="/ServletBasico-VII/Listagem">Listar</a>
		<a href="/ServletBasico-VII/login.jsp" class="btn btn-primary">Sair</a>		
    </div>
</body>
</html>