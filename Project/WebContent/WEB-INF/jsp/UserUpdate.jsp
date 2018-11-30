<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/UserUpdate.css">
	<title>Update</title>
</head>
	<body>
		<h1 class="UserUpdate">ユーザー情報更新</h1>
		<table class = out>
		<c:if test="${errMsg != null}" >
	    <div class="UserEntry color">
		  ${errMsg}
		</div>
		</c:if>
			<tr>
				<td>${user.name }</td>
				<td><a href = "LogoutServlet">ログアウト</a></td>
			</tr>
		</table>
		<form action = "UserUpdateServlet" method = "post">
			<input type = "hidden" name = "id" value = "${userUpdate.id}">
			<table class = "style">
				<tr>
					<td>ログインID </td>
					<td>${userUpdate.loginId}</td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type = "text" name="password" password = "パスワード">
				</tr>
				<tr>
					<td>パスワード確認</td>
				 	<td><input type = "text" name="password2" password2 = "パスワード"></td>
				 </tr>
				 <tr>
					<td>ユーザ名</td>
					<td><input type = "text" value="${userUpdate.name}" name = "userName" userName ="ユーザー名"></td>
				</tr>
				<tr>
					<td>生年月日</td>
					<td><input type = "text" value="${userUpdate.birthDate}" name = "birthDate" birthDate ="生年月日"></td>
				</tr>
			</table>
			<p class = "UserUpdate"><a href = "UserListServlet"></a><input type ="submit" value ="更新" ></p>
		</form>
		<a href = "UserListServlet">戻る</a>
	</body>
</html>