<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>김재현의 단독 게시판</h1>


	<P>현재 시간 : ${serverTime}.</P>

	<form action="/mymember/login" method="post">
		<c:if test="${member == null}">
			<input type="text" name="id" placeholder="아이디" />
			<br>
			<input type="password" name="password" placeholder="비밀번호" />
			<button type="submit">로그인</button>
			<a href="/mymember/join">회원 가입</a>
		</c:if>


		<c:if test="${member != null}">
			<div>
				<p>${member.id}님환영합니다.</p>
				<button id="logoutBtn" type="button">로그아웃</button>

				<script type="text/javascript">
					$(document).ready(function() {
						$("#logoutBtn").on("click", function() {
							location.href = "/mymember/logout";
						})

					})
				</script>

			</div>
		</c:if>
		<c:if test="${msg == false}">
			<p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
		</c:if>

		<p>
			<c:if test="${member != null}">
				<a href="/myboard/list">게시판</a>
			</c:if>
		</p>

	</form>
</body>
</html>
