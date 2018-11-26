<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="login.css">
	<title>ログイン</title>
</head>
	<body>
		<h1 class="login">ログイン画面</h1>
			<form action="LoginServlet" method="post">
				<table class="style">
					<tr>
						<td> ログインID</td>
						<td><input type = "text" name="loginId" Id = "ログインID"></td>
					</tr>
					<tr>
						<td>パスワード</td>
						<td><input type = "text" name= "password" password = "パスワード"></td>
					</tr>
				</table>
				<p class ="login"><input type = "submit" value = "ログイン">
			</form>
	</body>
</html>