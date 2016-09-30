<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored ="false" %> 
<!-- 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
-->
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>"/> 
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/styles.css"/>"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Digite Usuário e Senha para entrar no sistema</h1>
            <div class="account-wall">
                <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120" alt="">
                <form class="form-signin" method="post" action="/ServletBasico-VI/Login">
                	<input type="text" name="usuario" class="form-control" placeholder="Usuário" required autofocus>
                	<input type="password" name="senha" class="form-control" placeholder="Senha" required>
                	<button class="btn btn-lg btn-primary btn-block" type="submit">Registrar</button>
	                <!-- 
	                <label class="checkbox pull-left">
    	                <input type="checkbox" value="remember-me">
        	            Remember me
            	    </label>
               	 	<a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                	-->
                </form>
            </div>
            <!-- 
            <a href="#" class="text-center new-account">Create an account </a>
        	-->
        </div>
    </div>
</div>
</body>
</html>