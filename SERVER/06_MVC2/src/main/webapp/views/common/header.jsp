<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ path }/resources/css/style.css">
<script src="${ path }/resources/js/jquery-3.6.0.js"></script>
</head>
<body>
	<header>
		<h1>Hello MVC</h1>
		<div class="login-container">
			<!-- 영역객체에 로그인 멤버가 있으면(정상적으로 로그인이 될 경우) c:if 내에 있는 내용들이 출력되지 않는다. -->
			<!-- chrome -> application -> cookies : 세션 확인 가능 -->
			<c:if test="${ empty loginMember }">
				<!-- 로그인 버튼을 누르면 /login 페이지로 넘어갈 수 있게(not jsp파일) -->
				<form id="loginFrm" action="${ path }/login" method="post">
					<table>
						<tr>
							<td>
								<input type="text" name="userId" id="userId" placeholder="아이디" 
										value="${ empty cookie.saveId ? '' : cookie.saveId.value }" required>
							</td>
							<td></td>
						</tr>
						<tr>
							<td>
								<input type="password" name="userPwd" id="userPwd" placeholder="비밀번호" required>
							</td>
							<td>
								<input type="submit" value="로그인">						
							</td>
						</tr>
						<tr>
							<td colspan="2">
								
								<label><input type="checkbox" name="saveId" ${ empty cookie.saveId ? "" : "checked" }>아이디 저장</label>
								<input type="button" value="회원가입" onclick="location.href = '${ path }/member/enroll';"> 
							</td>
						</tr>
					</table>
				</form>
			</c:if>
			<c:if test="${ !empty loginMember }">
				<table>
					<tr>
						<td colspan="2">
							<!-- loginMember 객체 안에 저장되어 있는 name 필드를 EL 구문으로 호출 -->
							${ loginMember.name } 님 안녕하세요.
						</td>
					</tr>
					<tr>
						<td>
							<button onclick="location.href='${ path }/member/myPage'">내 정보</button>
						</td>
						<td>
							<button onclick="location.replace('${ path }/logout')">로그아웃</button>
						</td>
					</tr>
				</table>
			</c:if>
		</div>
		<nav>
			<ul class="main-nav">
				<li class="home"><a href="${ path }/">Home</a></li>
				<li id="board"><a href="${ path }/board/list">게시판</a></li>
				<c:if test="${ !empty loginMember && loginMember.role == 'ROLE_ADMIN'}">
					<li id="admin-member">
						<a href="${ path }/admin/members">회원관리</a>
					</li>
				</c:if>
			</ul>
		</nav>
	</header>