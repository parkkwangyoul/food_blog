<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../layout/login_header.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TastyBlog - Login Failed</title>
</head>
<body>
	<center>
		<form:form commandName="userInfo" class="login">
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
				<button type="submit" class="login-button">:before "Login"
					:after</button>
				<!-- :after -->
			</p>
		</form:form>
		<a href="<c:url value='/join/' />"><img alt="loginError" src="../../../resources/image/btn_sign_in.png" ></a>
	</center>
	<%-- <form:form method="POST" action="./join/" commandName="userInfo">
		<form:input type="hidden" path="userId" />
		<input type="image" src="../../../resources/image/btn_sign_in.png" />
	</form:form> --%>
	<%-- <center>아이디나 비밀번호가 맞지 않습니다.</center>
	<br>
	<br>
	<center>
		<div class="login_wrap">
			<form:form commandName="userInfo">
				<ul>
					<li>아이디</li>
					<li><form:input path="userId" /></li>
					<li>비밀번호</li>
					<li><form:password path="password" /></li>
					<li><input type="submit" value="로그인" /></li>
				</ul>
			</form:form>
		</div>
	</center> --%>
</body>
</html>