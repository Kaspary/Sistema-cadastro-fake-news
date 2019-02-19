<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>${news.title}</title>

<meta charset="UTF-8">
<meta content="ie=edge" http-equiv="x-ua-compatible">
<meta content="template language" name="keywords">
<meta content="Tamerlan Soziev" name="author">
<meta content="Admin dashboard html template" name="description">
<meta content="width=device-width, initial-scale=1" name="viewport">
<link href="img/image-site/logo-fake-news-big.png" rel="shortcut icon">
<link href="apple-touch-icon.png" rel="apple-touch-icon">
<link
	href="//fast.fonts.net/cssapi/487b73f1-c2d1-43db-8526-db577e4c822b.css"
	rel="stylesheet" type="text/css">
<link href="bower_components/select2/dist/css/select2.min.css"
	rel="stylesheet">
<link
	href="bower_components/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">
<link href="bower_components/dropzone/dist/dropzone.css"
	rel="stylesheet">
<link
	href="bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link href="bower_components/fullcalendar/dist/fullcalendar.min.css"
	rel="stylesheet">
<link
	href="bower_components/perfect-scrollbar/css/perfect-scrollbar.min.css"
	rel="stylesheet">
<link href="bower_components/slick-carousel/slick/slick.css"
	rel="stylesheet">
<link href="css/main.css?version=4.4.1" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" href="css/input_file.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/jquery.simplePagination.js" type="text/javascript"></script>
<script type="text/javascript" src="js/input_file.js"></script>
<script type="text/javascript" src="js/my_script.js"></script>

</head>
<body class="menu-position-top full-screen with-content-panel">

	<div class="top-bar color-scheme-light">
		<ul>
			<li><a href="/">Início</a></li>
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
								<li><a href="/register"><i
										class="os-icon os-icon-pencil-2"></i><span>Perfil</span></a></li>
								<li><a href="/logout"><i
										class="os-icon os-icon-signs-11"></i><span>Logout</span></a></li>
							</ul>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<ul>
					<li><a href="register"> <span>Registrar-se</span></a></li>
					<li><a href="/login"> <span>Login</span></a></li>
				</ul>
			</c:otherwise>
		</c:choose>
	</div>



	<div class="content-i">
		<div class="row">
			<div class="col-lg-8 mx-auto my-background">
				<div class="element-wrapper">
					<div class="blog-card col-lg-10">
						<div class="description" style="flex-basis: 100%;">
							<h1>${news.title}</h1>
							<h2>${news.subtitle}</h2>
							<span class="posted-time">Editado por ${news.editor.name} dia <fmt:formatDate
									value="${news.date.time}" pattern="dd/MM/yyyy" /></span>
							<p></p>
							<img class="image-news" alt="" src="/uploads/notice/${news.photoImageName}">
							<p>${news.text}</p>
							<div class="rodape-show">
								<c:if test="${news.link != ''}">
									<a style="color: #047bf8" href="${news.link}">Link de
										origem</a>
								</c:if>
								<c:choose>
									<c:when test="${news.fakeNews}">
										<div>
											Esta notícia foi considerada como FakeNews pelo editor
											<img class="image-fake" src="/img/image-site/false.png" alt="FakeNews">
										</div>
									</c:when>
									<c:otherwise>
										<div>
											Esta notícia foi considerada como Verdadeira pelo editor
											<img class="image-fake" src="/img/image-site/true.png" alt="FakeNews">
										</div>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>

					<div class="aec-reply col-lg-10 mx-auto" style="margin: 10px 0px;">
						<h4>Comentários</h4>
						<div class="comments-container">
							<c:choose>
								<c:when test="${not empty comments}">
									<ul id="comments_list" class="comments-list">
										<c:forEach items="${comments}" var="comment">
											<li>
												<div class="comment-main-level">
													<div class="comment-avatar">
														<img src="/uploads/user/${comment.user.photoImageName}"
															alt="">
													</div>
													<div class="comment-box">
														<div class="comment-head">
															<h6 class="comment-name">${comment.user.name}</h6>
															<span class="posted-time"><fmt:formatDate
																	value="${comment.date.time}" pattern="dd/MM/yyyy" /></span>
														</div>
														<div class="comment-content">${comment.comment}</div>
													</div>
												</div>
											</li>
										</c:forEach>
									</ul>
								</c:when>
								<c:otherwise>
								<ul id="comments_list">
										<li>Esta notícia ainda não tem comentários, seja o primeiro
											a comentar.</li>
								</ul>
								</c:otherwise>
							</c:choose>
						</div>
						<c:if test="${isLoged}">
							<div class="reply-header"
								style="border-bottom: 0px; padding-bottom: 2px;">
								<h5>Novo Comentário</h5>
							</div>
							<textarea id="text_comment"
								placeholder="Escreva seu comentário..." maxlength="250" id=""
								rows="5" style="width: 100%; padding: 10px;"></textarea>
							<div class="text-right">
								<a id="add_comment" class="btn btn-primary"
									onclick="send_comment(${news.id})" href="#!"> <i
									class="os-icon os-icon-mail-07"></i> <span>Comentar</span>
								</a>
							</div>
						</c:if>
					</div>

				</div>

			</div>
		</div>
	</div>


</body>
</html>