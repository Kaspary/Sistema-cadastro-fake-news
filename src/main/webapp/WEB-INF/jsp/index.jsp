<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Index</title>

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
<script src="js/input_file.js" type="text/javascript"></script>
<script src="js/my_script.js" type="text/javascript"></script>
<script src="js/jquery.simplePagination.js" type="text/javascript"></script>

</head>
<body class="menu-position-top full-screen with-content-panel">

	<div class="top-bar color-scheme-light">
		<ul>
			<li class="active"><a>Início</a></li>
			<c:if test="${isLoged}">
				<li><a href="/new_news">Escrever notícia</a></li>
			</c:if>
		</ul>


		<c:choose>
			<c:when test="${isLoged}">
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
		</c:when>
		<c:otherwise>
			<ul>
				<li>
					<a href="register">
						<span>Registrar-se</span>
					</a>
				</li>
				<li>
					<a href="/login">
						<span>Login</span>
					</a>
				</li>
			</ul>
		</c:otherwise>
	</c:choose>
	</div> 


	<div class="content-i">
	    <div class="row">
	        <div class="col-lg-8 mx-auto my-background">
	            <div class=" text-center">
	            <h2>Todas notícias</h2>
	               <c:forEach items="${news}" var="news">
						<c:if test="${news.approved}"><!-- news.isApproved -->
							<c:choose>
								<c:when test="${empty news.photoImageName}">
					                <div class="blog-card text col-lg-10">
					                    <div class="description" style="flex-basis: 100%;">
					                        <h1>${news.title}</h1>
					                        <h2>${news.subtitle}</h2>
					                        <p> ${news.text}</p>
					                        <p class="read-more">
					                            <a href="/show_news?id=${news.id}">Ler Mais</a>
					                        </p>
					                    </div>
					                </div>
								</c:when>

								<c:when test="${empty news.text}">
					                <div class="blog-card image alt col-lg-10" style="min-height: 220px;">
					                    <div class="meta" style="flex-basis: 90%;">
					                        <div class="photo" style="background-image: url(/uploads/notice/${news.photoImageName})"></div>
					                    </div>
					                    <div class="description">
					                        <h1>${news.title}</h1>
					                        <h2>${news.subtitle}</h2>
					                        <p style="min-height: 70px;"></p>
					                        <p class="read-more">
					                            <a href="/show_news?id=${news.id}">Ler Mais</a>
					                        </p>
					                    </div>
					                </div>
				               	</c:when>

								<c:otherwise>
									<div class="blog-card normal col-lg-10">
									    <div class="meta">
									        <div class="photo" style="background-image: url(/uploads/notice/${news.photoImageName})"></div>
									    </div>
									    <div class="description">
									        <h1>${news.title}</h1>
									        <h2>${news.subtitle}</h2>
									        <p> ${news.text}</p>
									        <p class="read-more">
									            <a href="/show_news?id=${news.id}">Ler Mais</a>
									        </p>
									    </div>
									</div>
								</c:otherwise>


							</c:choose>
						</c:if>
	                </c:forEach>
	            </div>
	                
	            <div id="pagination-container"></div>
	                
	        </div>
	    </div>
	</div>
		


</body>
</html>