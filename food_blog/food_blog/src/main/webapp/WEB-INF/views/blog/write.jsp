<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>새 글 쓰기</title>
</head>
<body>
<div class="wrapper">	
	<h3>새 글 쓰기</h3>
	<form:form  commandName="content">
	<table class="boardWrite">	
		<tr>
			<th><label>내용</label></th>
			<form:hidden path="writeUser" value="뿌뿌뿡"/>
			<form:hidden path="blogAddress" value="asd"/>
			<td><form:textarea path="content"/></td>			
		</tr>
		<tr>
			<th>체크박스로 인트해줄수있나 ㅠ<br>별점 할 체크박스</th>
			<td><form:textarea path="star"/>별점</td>
		</tr>
		<tr>
			<th>댓글은 추후에 ^^</th>
		</tr>
	</table>
	<br>
	<input type="submit" value="확인"/>	
	</form:form>
</div>
</body>
</html>