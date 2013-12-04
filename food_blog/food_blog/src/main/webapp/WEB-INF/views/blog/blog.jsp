<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jspf" %>
		<div id="content">
			<div class="right">
				<h2><a href="<c:url value='./write/'/>">글 작성</a></h2>
				<h2>
					<a href="#">SubjectName</a>
				</h2>
				<div>
					<c:if test="${contentList == '[]' or contentList == null }">
						
					</c:if>
				</div>
			</div>
<%@ include file="../layout/footer.jspf" %>
