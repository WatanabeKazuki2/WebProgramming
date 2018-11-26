<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="UserEntry.css">
	<title>ユーザー登録画面</title>
</head>
	<body>
		<h1 class = "UserEntry">ユーザー新規登録</h1>
		<table class = out>
			<tr>
				<td>ユーザー名</td>
				<td><a href = "Login">ログアウト</a></td>
			</tr>
		</table>
		<form>
			<table class="style">
				<tr>
					<td>ログインID</td>
					<td><input type = text Id = "ログインID"></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type = text Password = "パスワード"></td>
				</tr>
				<tr>
					<td>パスワード(確認)</td>
					<td><input type = text Password = "パスワード"></td>
				</tr>
				<tr>
					<td>ユーザー名</td>
					<td><input type=text UserName = "ユーザー名"></td>
				</tr>
				<tr>
					<td>生年月日</td>
					<td><input type=text Birthday = "生年月日"></td>
				</tr>
			</table>
			<p class = "UserEntry"><input type="submit" value="登録"></p>
		</form>
		<a href = "URL">戻る</a>
	</body>
</html>