<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jspf"%>
	<div class="right">
		<c:if test="${not empty sessionScope.userInfo and (sessionScope.userInfo.blogAddress eq blogInfo.blogAddress) }">	
			<h2>
				<c:choose>
					<c:when
						test="${(categoryId eq null or categoryId eq '') and (detailId eq null or detailId eq '') }">
					</c:when>
					<c:when test="${detailId eq null or detailId eq '' }">
						<a href="${cp }/blog/${blogAddress }/${categoryId }/write/">글 작성</a>
					</c:when>
					<c:otherwise>
						<a
							href="${cp }/blog/${blogAddress }/${categoryId }/${detailId }/write/">글
							작성</a>
					</c:otherwise>
				</c:choose>
			</h2>
		</c:if>
		<div>
			<c:choose>
				<c:when test="${contentList == '[]' or contentList == null }">
					게시물이 없습니다.
				</c:when>
				<c:otherwise>
					<c:forEach var="content" items="${contentList }">
						<div class="blog_content blog_dotBottom" data-pn="${content.pn }" data-user="${sessionScope.userInfo.name }">
							<div class="blog_content_title">${content.title }</div>
							<div class="blog_content_file">
								<c:forEach var="file" items="${content.attachmentList }">
									<a href="${cp }/download/${file.seq}">${file.fileName }</a>
								</c:forEach>
							</div>
							<div class="blog_content_write_and_date">
								${content.writeUser } ${content.writeDate }</div>
							<div class="blog_content_content">${content.content }</div>
							<c:if test="${content.useStar eq true }">
								<div class="blog_contet_star">${content.star }</div>
							</c:if>
							<div class="blog_content_comment">
								<c:forEach var="comment" items="${content.commentList }">
									<ul>
										<li class="name">${comment.writeUser }</li>
										<li>${comment.content }</li>
										<li class="date">${comment.writeDate }</li>
									</ul>
									<%-- <form:input path="userId" class="input" data-form="create" /> --%>
								</c:forEach>								
							</div>
							<div class="blog_content_comment_add_wrap" id="borderTop">
								<ul>
									<li class="blog_comment_add_input_li"><input class="blog_comment_input_input" type="text" /></li>
									<li><button class="blog_comment_add" >작성</button></li>
								</ul>
							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
<%@ include file="../layout/footer.jspf"%>
