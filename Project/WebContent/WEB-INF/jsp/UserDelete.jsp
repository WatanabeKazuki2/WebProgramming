<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="UserDelete.css">
	<title>Insert title here</title>
</head>
	<body>
		<h1 class="UserDelete">ユーザー削除確認</h1>
		<table class = out>
			<tr>
				<td>ユーザー名</td>
				<td><a href = "Login">ログアウト</a></td>
			</tr>
		</table>
		<p class = "UserDelete">ログインID："ログインID"</p>
		<p class = "UserDelete">を本当に削除してもよろしいでしょうか。</p>
		<table class="style">
			<tr>
				<td><input type = "submit" value = "キャンセル"></td>
				<td><input type = "submit" value = "OK"></td>
		</table>
	</body>
</html>