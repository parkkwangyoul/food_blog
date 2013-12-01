<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../layout/login_header.jspf"%>
		
		<center> 아이디나 비밀번호가 맞지 않습니다. </center>
		<br><br>		
		<form:form commandName="userInfo">
			<ul class="gi-login-loginForm">
				<li>아이디</li>
				<li><form:input path="userId" /></li>
				<li>비밀번호</li>
				<li><form:password path="password" /></li>
				<li><input type="submit" value="로그인" /></li>
			</ul>
		</form:form>
	</header>