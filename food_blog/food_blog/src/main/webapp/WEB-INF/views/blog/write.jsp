<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	</table>
	<br>
	<input type="reset" value="재작성" class="writeBt"/>
	<input type="submit" value="확인" class="writeBt"/>	
	</form:form>
</div>
</body>
</html>