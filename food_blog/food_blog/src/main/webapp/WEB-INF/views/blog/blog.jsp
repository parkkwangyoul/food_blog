<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<%@ include file="../layout/style.jspf"%>
<%@ include file="../layout/script_head.jspf" %>
<html>
<head>
<title>Tasty_Home</title>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<h1>
				<a href="#">Tasty_Blog</a>
			</h1>
		</div>
		<div id="content">
			<div class="right">
				<h2><a href="<c:url value='./write/'/>">글 작성</a></h2>
				<h2>
					<a href="#">SubjectName</a>
				</h2>
				This is contents
			</div>
			<div class="left">
				<img
					src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSnrAmsRR9Iamgo9U_3AgeuCo5mh4CwTGq6_pOd0TbijPZsVqcI"
					height="100" width="100"><br>
					난 보았느니라...
					<c:choose>
						<c:when test = "${not empty sessionScope.userInfo }">
							<h2>${sessionScope.userInfo.name }님 </h2>
						</c:when>
						<c:otherwise>
							<br>손님 환영합니다.<br>
						</c:otherwise>
					</c:choose>
				<h2>Categories :</h2>
				<ul class="accordion">
					<c:forEach var="category" items="${categoryList }" varStatus="i">
						<li id="one${i.count }" class="files${i.count }">
							<a href="${cp }/${category.categoryId}/${category.categoryDetailList[0].detailLinkName}/">${category.categoryName }</a>
							<ul class="sub-menu">
								<c:forEach var="detail" items="${category.categoryDetailList }" varStatus="j">
									<li><a href="${cp }/${category.categoryId}/${detail.detailLinkName}/"><em>${j.count < 10 ? '0' : j.count }${j.count < 10 ? j.count : '' }</em>${detail.detailName }</a></li>
								</c:forEach>
							</ul>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div style="clear: both;"></div>
		</div>
	</div>
	<div id="footer">Designed by Free CSS and TaeJoeh, Thanks!</div>
</body>
</html>
