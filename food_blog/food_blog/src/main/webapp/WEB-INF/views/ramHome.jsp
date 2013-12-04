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
<link rel="stylesheet" type="text/css" href="homeStyle.css" media="screen" />
</head>
<body>
 	<div id="homeContainer">
		<div id="homeHeader">
			<h1>Main Page!</h1>
		</div>

		<div id="homeContent">
		</div>

 		<div id="homeSide">
			<div id="homeSidelogininfo">
				<section class="gi-login-body">
					<header class="gi-login-header">
						<ul class="gi-login-loginForm">
							<c:choose>
								<c:when test = "${not empty sessionScope.userInfo }">
									<li><h2>${sessionScope.userInfo.name }님  환영합니다. </h2></li>
									<li><a href="<c:url value='/login/logout/'/>">로그아웃</a></li>
									<form:form method="POST" action="./blog/" commandName="userInfo">
										<form:input type = "hidden" path="userId" />
										<input type = "submit" value="나의 블로그로 가기"/>
									</form:form>
								</c:when>
								<c:otherwise>
									<form:form commandName="userInfo">
										<li><form:input path="userId" value="아이디" /></li>
										<li><form:password path="password" value="password" /></li>
										<li><input type="submit" value="로그인" /></li>
										<br>
										<li><a href="<c:url value='/join/' />">회원가입</a></li>
									</form:form>
								</c:otherwise>
							</c:choose>
						</ul>
					</header>
				</section>
			</div>
			
			<div id="homeSideadinfo1">광고</div>
			
			<div id="homeSideadinfo2">광고</div>
		</div>
	</div>
</body>
</html>
