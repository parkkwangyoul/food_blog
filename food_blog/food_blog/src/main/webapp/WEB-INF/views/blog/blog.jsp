<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="right">
	<h2>
		<a href="<c:url value='./write/'/>">글 작성</a>
	</h2>
	<h2>
		<a href="#">SubjectName</a>
	</h2>
	<c:choose>
		<c:when test="${contentList == '[]' or contentList == null }">
							게시물이 없습니다.
			</c:when>
		<c:otherwise>
			<c:forEach var="content" items="${contentList }">
				<div class="blog_content" id="dotBottom">
					<div class="blog_content_title">${content.title }</div>
					<div class="blog_content_write_and_date">${content.writeUser }
						${content.writeDate }</div>
					<div class="blog_content_content">${content.content }</div>
					<c:if test="${content.useStar eq true }">
						<div class="blog_contet_star">${content.star }</div>
					</c:if>
					<div class="blog_content_comment" id="dotBottom">

						<%@ include file="../layout/header.jspf"%>
						<div class="right">
							<h2>
								<c:choose>
									<c:when
										test="${(categoryId eq null or categoryId eq '') and (detailId eq null or detailId eq '') }">
										<a href="${cp }/blog/${blogAddress }/write/">글 작성</a>
									</c:when>
									<c:when test="${detailId eq null or detailId eq '' }">
										<a href="${cp }/blog/${blogAddress }/${categoryId }/write/">글
											작성</a>
									</c:when>
									<c:otherwise>
										<a
											href="${cp }/blog/${blogAddress }/${categoryId }/${detailId }/write/">글
											작성</a>
									</c:otherwise>
								</c:choose>
							</h2>
							<div>
								<c:choose>
									<c:when test="${contentList == '[]' or contentList == null }">
										게시물이 없습니다.
									</c:when>
									<c:otherwise>
										<c:forEach var="content" items="${contentList }">
											<div class="blog_content">
												<div class="blog_content_title">${content.title }</div>
												<div class="blog_content_file">
													<c:forEach var="file" items="${content.attachmentList }">
											${file.fileName }
										</c:forEach>
												</div>
												<div class="blog_content_write_and_date">
													${content.writeUser } ${content.writeDate }</div>
												<div class="blog_content_content">${content.content }
												</div>
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
											</div>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</div>
<%@ include file="../layout/footer.jspf"%>
