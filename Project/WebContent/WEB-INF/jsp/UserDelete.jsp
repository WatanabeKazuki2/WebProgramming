<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/UserDelete.css">
	<title>Insert title here</title>
</head>
	<body>
		<h1 class="UserDelete">ユーザー削除確認</h1>
		<form action="UserDeleteServlet" method="post">
		<input type = "hidden" name = "id" value = "${userDelete.id}">
		<table class = out>
			<tr>
				<td>${userInfo.name}</td>
				<td><a href = "LogotuServlet">ログアウト</a></td>
			</tr>
		</table>
		<p class = "UserDelete">ログインID："${userDelete.loginId}"</p>
		<p class = "UserDelete">を本当に削除してもよろしいでしょうか。</p>
		<table class="style">
			<tr>
				<td><a href = "UserListServlet"> <button type = button >キャンセル</button></a></td>
				<td><input type="submit" value = "OK"></td>
			</tr>
		</table>
		</form>
	</body>
</html>