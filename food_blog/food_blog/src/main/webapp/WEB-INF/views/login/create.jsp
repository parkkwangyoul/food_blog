<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../layout/create_header.jspf"%>
<section class="gi-create-user-wrap">
	<header class="gi-create-user-info">
		<h1>회원가입</h1>
	</header>
	<form:form commandName="userInfo">
		<ul class="gi-login-loginForm">
			<li>아이디</li>
			<li><form:input path="userId" /></li>
			<li>비밀번호</li>
			<li><form:password path="password" /></li>
			<li>이름</li>
			<li><form:input path="name" /></li>
			<li><input type="submit" value="회원가입" /></li>
		</ul>
	</form:form>

	<div class="login-create-tagcloud">
		<c:forEach var="interest" items="${allInterest }">
			<a href="#" class="interest" data-interest="${interest.name }"
				style="font-size:${40 + 1.5*interest.useCount}%;">${interest.name }</a>
		</c:forEach>
	</div>
</section>