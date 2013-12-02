<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<%@ include file="./layout/style.jspf"%>
<%@ include file="./layout/script_head.jspf" %>
<html>
<head>
<title>Tasty_Home</title>

<link rel="stylesheet" type="text/css" href="homeStyle.css"
	media="screen" />

 	<div id="container">
		<div id="header">
			<img
				src="http://game.donga.com/images/gamegru_news/newsimage/wanggun20020306.jpg">
		</div>

		<div id="content">
			<img
				src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSnrAmsRR9Iamgo9U_3AgeuCo5mh4CwTGq6_pOd0TbijPZsVqcI">
			난 보았느니라
		</div>

 
		<div id="sidelogininfo">
			<section class="gi-login-body">
				<header class="gi-login-header">
					<form:form commandName="userInfo">
						<ul class="gi-login-loginForm">
							<c:choose>
								<c:when test = "${not empty sessionScope.userInfo }">
									<li><h2>${sessionScope.userInfo.name }님  환영합니다. </h2></li>
									<li><a href="<c:url value='/login/logout/'/>">로그아웃</a></li>
								</c:when>
								<c:otherwise>
									<li><form:input path="userId" value="아이디" /></li>
									<li><input type="submit" value="로그인" /></li>
									<li><form:password path="password" value="password" /></li>
									<br>
									<li><a href="<c:url value='/join/' />">회원가입</a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</form:form>
				</header>
			</section>

		</div>
		<div id="sideadinfo">광고</div>
		<div id="footer">그냥바닥임?</div>
	</div>
</body>
</html>
