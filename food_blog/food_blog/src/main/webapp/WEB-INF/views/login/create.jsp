<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../layout/create_header.jspf"%>
<section class="fb-create-user-wrap">
	<header class="fb-create-user-info">
		<h1>회원가입</h1>
	</header>
	<form:form commandName="userInfo">
		<table class="fb-create-user-table">
			<tr>
				<td colspan="2"><input class="fb-create-submit"
					id="createFormSubmitBtn" type="submit" value="가입하기"></td>
			</tr>
			<tbody>
				<tr>
					<th>아이디</th>
					<td>
						<div class="fb-create-user-vaild-wrap">
							<span class="fb-form-invalid">아이디는
								1자&nbsp;이상&nbsp;20자&nbsp;이하를&nbsp;입력해야&nbsp;합니다.</span>
						</div> <form:input path="userId" class="fb-create-user-input"
							data-form="create" />
						<div class="fb-create-user-error">
							<form:errors path="userId" Class="commonError">1</form:errors>
						</div>
					</td>
				</tr>
				<tr>
					<th>이름(별명)</th>
					<td>
						<div class="fb-create-user-vaild-wrap">
							<span class="fb-form-invalid">아이디는
								1자&nbsp;이상&nbsp;20자&nbsp;이하를&nbsp;입력해야&nbsp;합니다.</span>
						</div> <form:input path="name" class="fb-create-user-input"
							data-form="createNm" />
						<div class="fb-create-user-error">
							<form:errors path="name" Class="commonError"></form:errors>
						</div>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<div class="fb-create-user-vaild-wrap" id="passwordLength">
							<span class="fb-form-invalid">비밀번호는&nbsp;8자&nbsp;이상&nbsp;16자&nbsp;이하&nbsp;이어야&nbsp;합니다.</span>
						</div> <form:password path="password" class="fb-create-user-input"
							data-form="createPw" />
						<div class="fb-create-user-error">
							<form:errors path="password" Class="commonError"></form:errors>
						</div>
					</td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td>

						<div class="fb-create-user-vaild-wrap" id="confirmPW">
							<span class="fb-form-invalid">비밀번호를&nbsp;동일하게&nbsp;입력해&nbsp;주시기&nbsp;바랍니다.</span>
						</div> <form:password path="confirmPassword"
							class="fb-create-user-input" />
						<div class="fb-create-user-error">
							<form:errors path="confirmPassword" Class="commonError"></form:errors>
						</div>

					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<div class="fb-create-user-vaild-wrap" id="confirmEmail">
							<span class="fb-form-invalid">정확한&nbsp;이메일&nbsp;주소를&nbsp;입력해&nbsp;주시기&nbsp;바랍니다.(ex&nbsp;abcde@abc.com)</span>
						</div> <form:input path="emailAddress" class="fb-create-user-input"
							data-type="email" />
						<div class="fb-create-user-error">
							<form:errors path="emailAddress" cssClass="commonError"></form:errors>
						</div>
					</td>
				</tr>
				<tr>
					<th>블로그 주소</th>
					<td>
						<div class="fb-create-user-vaild-wrap" id="confirmBlog">
							<span class="fb-form-invalid">사용할 블로그 주소를 입력해 주세요.(20자 이내,
								영어,숫자만 가능)</span>
						</div> <form:input path="blogAddress" class="fb-create-user-input" />
						<div class="fb-create-user-error">
							<form:errors path="blogAddress" cssClass="commonError"></form:errors>
						</div>
					</td>
				</tr>

			</tbody>
		</table>
	</form:form>
</section>


