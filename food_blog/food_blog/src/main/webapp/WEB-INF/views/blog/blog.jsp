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
					<c:choose>
						<c:when test="${contentList == '[]' or contentList == null }">
							게시물이 없습니다.
						</c:when>
						<c:otherwise>
							<c:forEach var="content" items="${contentList }">
								<div class="blog_content">
									<div class="blog_content_title">
										${content.title }
									</div>
									<div class="blog_content_write_and_date">
										${content.writeUser } ${content.writeDate }
									</div>
									<div class="blog_content_content">
										${content.content }
									</div>
									<c:if test="${content.useStar eq true }">
										<div class="blog_contet_star">
											${content.star }								
										</div>
									</c:if>
									<div class="blog_content_comment">
										<c:forEach var="comment" items="${content.commentList }">
											${comment.writeUser } ${comment.writeDate } 
											${comment.content }
										</c:forEach>
									</div>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
<%@ include file="../layout/footer.jspf" %>
