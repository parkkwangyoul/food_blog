<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jspf" %>
	<h3>새 글 쓰기</h3>
	<form:form  commandName="content" enctype="multipart/form-data">
	<c:choose>
		<c:when test="${categoryId eq null or categoryId eq '' }">
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${detailId eq null or detailId eq null }">
					<form:hidden path="categoryId"/>
					<form:select path="detailId">
						<c:forEach var="category" items="${categoryList }">
							<c:if test="${category.categoryId eq categoryId }">
								<c:forEach var="detail" items="${category.categoryDetailList }">
									<form:option value="${detail.detailId }">${detail.detailName }</form:option>
								</c:forEach>
							</c:if>
						</c:forEach>
					</form:select>
				</c:when>
				<c:otherwise>
					<form:hidden path="categoryId"/>
					<form:hidden path="detailId"/>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	<table class="boardWrite">	
		<table class="common_table_write big_table_write">
			<colgroup>
				<col width="30%" />
				<col width="70%" />
			</colgroup>
			<tfoot>
				<tr>
					<td colspan="2">	
						<button type="button" class="btn_white write_btn" id="board_confirm_btn">
							<span class="btnImage"></span>
							<span class="btnText">Confirm</span>
						</button> 
						<button type="button" class="btn_white cancel_btn" id="board_cancel_btn">
							<span class="btnImage"></span>
							<span class="btnText">Cancel</span>
						</button> 
					</td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td>
						<form:input path="title" cssClass="common_board_input_title"/><br/>
						<form:errors path="title" cssClass="join_error" />
					</td>
				</tr>
				<tr>
					<td id="isWriteBoard">
						<form:textarea path="content" id="writeBoard"></form:textarea><br/>
						<form:errors path="content"  cssClass="join_error"/>
					</td>
				</tr>
				<tr>
					<td><form:input path="attachments" type="file" /></td>
				</tr>
				<c:if test="${fn:length(article.attachmentList) > 0 }">
				<tr>
					<th>Delete attached file${fn:length(article.attachmentList) > 1 ? "s" : "" }</th>
					<td>
						<c:forEach var="attachment" items="${article.attachmentList }" varStatus="i">
							<input class="deleteAttachments" id="attach_${i.index }" type="checkbox" name="deleteAttachments" value="${attachment.seq }" />
							<label class="deleteAttachments" for="attach_${i.index }">${attachment.fileName }</label>
						</c:forEach> 
					</td>
				</tr>
				</c:if>
			</tbody>
		</table>
	</form:form>
<%@ include file="../layout/footer.jspf" %>