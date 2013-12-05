<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<%@ include file="./layout/style.jspf"%>
<%@ include file="./layout/script_head.jspf"%>
<html>
<head>
<title>Tasty_Home</title>
</head>
<body>
	<div id="homeHeader">
		<h1>[ Food Blog ]</h1>
	</div>

	<div id="homeContent"></div>

	<div id="homeSide">
		<div class="Sidelogininfo">
			<ul class="-login-loginForm">
				<c:choose>
					<c:when test="${not empty sessionScope.userInfo }">
						<li><h2>${sessionScope.userInfo.name }님환영합니다.</h2></li>
						<li><a href="<c:url value='/login/logout/'/>">로그아웃</a></li>
						<li id="my_blog_go_wrap" data-address="${blogInfo.blogAddress }"><input
							id="my_blog_go" type="button" value="나의 블로그로 가기" /></li>
						<li><a href="<c:url value='/modify/'/>">수정하기</a></li>
					</c:when>
					<c:otherwise>
						<%-- <form:form commandName="userInfo" class="login">
							<p>
								<label for="login">ID:</label>
								<form:input value="id" path="userId" />
							</p>
							<p>
								<label for="password">Password:</label>
								<form:password path="password" value="********" />
							</p>
							<p class="login-submit">
								<!-- :before -->
								<button type="submit" class="login-button">:before
									"Login" :after</button>
								<!-- :after -->
							</p>

							<div style="float: left; margin-left: 365px">
								<a href="<c:url value='/join/' />"> <img alt="loginError"
									src="${cp}/resources/image/btn_sign_in.png" width="150px"
									height="150px" />
								</a>
							</div>
						</form:form> --%>
						<form:form commandName="userInfo">
							<li><form:input path="userId" value="아이디" size="250" id="home-login-input"/></li>
							<li><form:password path="password" value="password" size="250" id="home-password-input"/></li>
							<li><input type="submit" value="로그인" /></li>
							<br>
							<li><a href="<c:url value='/join/' />">회원가입</a></li>
						</form:form>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>

		<div class="homeSideadinfo1">광고</div>

		<div class="homeSideadinfo2">광고</div>
	</div>
</body>
</html>
