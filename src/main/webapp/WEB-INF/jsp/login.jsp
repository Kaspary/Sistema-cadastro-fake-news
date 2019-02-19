<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>

	<meta charset="UTF-8">
    <meta content="ie=edge" http-equiv="x-ua-compatible">
    <meta content="template language" name="keywords">
    <meta content="Tamerlan Soziev" name="author">
    <meta content="Admin dashboard html template" name="description">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link href="img/image-site/logo-fake-news-big.png" rel="shortcut icon">
    <link href="apple-touch-icon.png" rel="apple-touch-icon">
    <link href="//fast.fonts.net/cssapi/487b73f1-c2d1-43db-8526-db577e4c822b.css" rel="stylesheet" type="text/css">
    <link href="bower_components/select2/dist/css/select2.min.css" rel="stylesheet">
    <link href="bower_components/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <link href="bower_components/dropzone/dist/dropzone.css" rel="stylesheet">
    <link href="bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="bower_components/fullcalendar/dist/fullcalendar.min.css" rel="stylesheet">
    <link href="bower_components/perfect-scrollbar/css/perfect-scrollbar.min.css" rel="stylesheet">
    <link href="bower_components/slick-carousel/slick/slick.css" rel="stylesheet">
    <link href="css/main.css?version=4.4.1" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<body class="auth-wrapper">
    <div class="all-wrapper menu-side with-pattern">
        <div class="auth-box-w">
            <div class="logo-w"><a href="/"><img alt="Logo" src="img/image-site/logo-fake-news-big.png"></a></div>
            <h4 class="auth-header">Login Sistema Fake News</h4>
            <form:form action="/login" method="post" modelAttribute="userLogin">
                <div class="form-group">
                	<form:label path="email">E-Mail</form:label>
                	<form:input path="email" class="form-control" placeholder="emailexemplo@exemplo.com"/>
                    <div class="pre-icon os-icon os-icon-email-2-at2"></div>
                </div>
                <div class="form-group">
	                <form:label path="password">Senha</form:label>
	                <form:password path="password" class="form-control" placeholder="Senha"/>
                    <div class="pre-icon os-icon os-icon-fingerprint"></div>
                </div>
                <div class="buttons-w">
                	<form:button class="btn btn-primary">Entrar</form:button>
                    <!-- <div class="form-check-inline"><label class="form-check-label"><input class="form-check-input" type="checkbox">Remember Me</label></div>-->
                </div>
            	<a class="link" href="/register">Registrar-se</a>
            </form:form>
        </div>
    </div>
</body>
</html>