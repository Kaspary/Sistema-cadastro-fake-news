<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Registro</title>

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
    <link rel="stylesheet" href="css/input_file.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/input_file.js"></script>

</head>
<body>
    <div class="all-wrapper menu-side with-pattern">
        <div class="auth-box-w wider">
            <div class="logo-w"><a href="/"><img alt="" src="img/image-site/logo-fake-news-big.png"></a></div>
            <h4 class="auth-header">Criar uma nova conta</h4>
            <form:form action="/register" method="post" modelAttribute="user" enctype="multipart/form-data">
                <form:hidden path="id"/>
                <div class="form-group">
                	<form:label path="name">Nome</form:label>
                	<form:input path="name" class="form-control" placeholder="Nome" required="required"/>
                	<div class="pre-icon os-icon os-icon-user-male-circle"></div>
                </div>
                <div class="form-group">
                	<form:label path="email">Endereço de e-mail</form:label>
                	<form:input path="email" class="form-control" placeholder="emailexemplo@exemplo.com" required="required"/>
                	<div class="pre-icon os-icon os-icon-email-2-at2"></div>
                </div>
                <div class="form-group">
	                <form:label path="password">Senha</form:label>
	                <form:password path="password" class="form-control" placeholder="Senha" required="required"/>
                    <div class="pre-icon os-icon os-icon-fingerprint"></div>
                </div>
                
                <div class="form-group">
	                <form:label path="photo">Foto</form:label>
	                <div class="pre-icon os-icon os-icon-documents-07"></div>
	                <div class="attachment attachment--image">
						<input onchange="changePhoto(this)" class="file" type="file" id="photo" name="photo" accept=".jpg,.jpeg,.png,.gif" required/>                               
						<div class="attachment--label">
							<span class="placeholder">Imagem (jpg, jpeg, png, gif)</span>
							<span class="file-name"></span>
							<span class="attachment--remove">Remover</span>
						</div>
						<div class="attachment--error"></div>
					</div>
				</div>
                
                <div class="buttons-w">
                	<form:button class="btn btn-primary">Cadastrar</form:button>
                </div>
                <a class="link" href="/login">Login</a>
            </form:form>
        </div>
    </div>
</body>
</html>