<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Nova Notícia</title>

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
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="js/input_file.js"></script>

</head>
<body class="menu-position-top full-screen with-content-panel">

	<div class="top-bar color-scheme-light">
		<ul>
			<li><a href="/">Início</a></li>
			<li class="active"><a>Escrever notícia</a></li>
		</ul>
		<div class="logged-user-w">
			<div class="logged-user-i">
				<div class="avatar-w">
					<img alt="Avatar" src="/uploads/user/${photo}">
				</div>
				<div class="logged-user-menu color-style-bright">
					<div class="logged-user-avatar-info">
						<div class="avatar-w">
							<img alt="Avatar" src="/uploads/user/${photo}">
						</div>
						<div class="logged-user-info-w">
							<div class="logged-user-name">${name}</div>
						</div>
					</div>
					<div class="bg-icon">
						<i class="os-icon os-icon-wallet-loaded"></i>
					</div>
					<ul>
						<li><a href="/register"><i class="os-icon os-icon-pencil-2"></i><span>Perfil</span></a></li>
						<li><a href="/logout"><i class="os-icon os-icon-signs-11"></i><span>Logout</span></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<div class="content-i">
	  <!-- <div class="content-box"> -->
	    <div class="row">
	      <div class="col-lg-8 mx-auto my-background">
	        <div class="element-wrapper">
	          <div class="element-box">
	            <form:form action="/new_news" method="post" modelAttribute="news" enctype="multipart/form-data">
	              <h5 class="form-header">Cadastro de notícia</h5>
	              <div class="form-desc">Aqui da para descrever o formulário</div>
	              <div class="form-group">
	              	<form:label path="title" for=""> Título<smal>*</smal></form:label>
	              	<form:input path="title" class="form-control" placeholder="" required="required"/>
	              </div>
	              <div class="form-group">
	              	<form:label path="subtitle" for=""> Subtítulo</form:label>
	              	<form:input path="subtitle" class="form-control" placeholder=""/>
	              </div>	              
	              <div class="form-group">
	              	  <label path="photo">Foto</label>
		              <div class="attachment attachment--image">
					 	<input onchange="changePhoto(this)" class="file" type="file" id="photo" name="photo" accept=".jpg,.jpeg,.png,.gif"/>                               
						<div class="attachment--label">
							<span class="placeholder">Imagem (jpg, jpeg, png, gif)</span>
							<span class="file-name"></span>
							<span class="attachment--remove">Remover</span>
						</div>
						<div class="attachment--error"></div>
					  </div>
				  </div>	
				  
				  
	              <div class="form-group">
	              	<form:label path="text" for=""> Texto</form:label>
	              	<form:textarea path="text" maxlength="10000" class="form-control" rows="10" name="comment"></form:textarea>
	              </div>
	              
	              <div class="form-group">
	              	<form:label path="link" for=""> Link de origem</form:label>
	              	<form:input path="link" class="form-control" placeholder="https://example.com" type="url"/>
	              </div>
	              
	              
	              <div class="form-group row">
	              	<label class="col-sm-4 col-form-label">Esta notícia é fake?</label>
		              <div class="col-sm-8">
		              	  <div class="form-check">
		              	  	<form:label path="isFake" class="form-check-label">
		              	  	<form:radiobutton path="isFake" class="form-check-input" name="optionsRadios" value="yes"/>Sim</form:label>
		              	  </div>
	              	  	  <div class="form-check">
	              	  		<form:label path="isFake" class="form-check-label">
	              	  		<form:radiobutton path="isFake" class="form-check-input" name="optionsRadios" value="no"/>Não</form:label>
	              	  	  </div>
	              	  </div>
	              </div>
	              
	              <div class="form-group">
	              	<form:label path="comment" for=""> Escreva o seu comentário</form:label>
	              	<form:textarea path="comment" maxlength="250" class="form-control" rows="2" name="comment"></form:textarea>
	              </div>
	              <div class="form-buttons-w"><form:button class="btn btn-primary"> Salvar</form:button></div>
	            </form:form>
	          </div>
	        </div>
	      </div>
	    </div>
	  <!-- </div> -->
	</div>
		
	

</body>
</html>