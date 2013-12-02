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
					<li id="one" class="files">
						<a href="#one">2013 Dec<span>51</span></a>
						<ul class="sub-menu">
							<li><a href="#"><em>01</em>연무동<span>20</span></a></li>
							<li><a href="#"><em>02</em>영화동<span>11</span></a></li>
							<li><a href="#"><em>03</em>병점동<span>25</span></a></li>
						</ul>
					</li>
					<li id="two" class="mail">
						<a href="#one">2013 Nov<span>10</span></a>
						<ul class="sub-menu">
							<li><a href="#"><em>01</em>불광동<span>2</span></a></li>
							<li><a href="#"><em>02</em>연신내<span>5</span></a></li>
							<li><a href="#"><em>03</em>녹번동<span>3</span></a></li>
						</ul>
					</li>
					<li id="three" class="cloud">
						<a href="#one">2013 Oct<span>38</span></a>
						<ul class="sub-menu">
							<li><a href="#"><em>01</em>천안<span>12</span></a></li>
							<li><a href="#"><em>02</em>인계동<span>5</span></a></li>
							<li><a href="#"><em>03</em>팔달문<span>13</span></a></li>
							<li><a href="#"><em>03</em>장안문<span>8</span></a></li>
						</ul>
					</li>
				</ul>
			</div>
			<div style="clear: both;"></div>
		</div>
	</div>
	<div id="footer">Designed by Free CSS and TaeJoeh, Thanks!</div>
</body>
</html>
