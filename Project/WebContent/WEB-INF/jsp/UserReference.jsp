<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/UserReference.css">
	<title>UserInfo</title>
</head>
	<body>
		<h1 class = "UserReference">ユーザー情報詳細参照</h1>
		<table class = out>
			<tr>
				<td>ユーザー名</td>
				<td><a href = "LogoutServlet">ログアウト</a></td>
			</tr>
		</table>
		<table class = "style">
			<tr>
				<td>ログインID</td>
				<td>${userDetail.loginId}</td>
			</tr>
			<tr>
				<td>ユーザー名</td>
				<td>${userDetail.name}</td>
			</tr>
			<tr>
				<td>生年月日</td>
				<td>${userDetail.birthDate}</td>
			</tr>
			<tr>
				<td>登録日時</td>
				<td>${userDetail.createDate}</td>
			</tr>
			<tr>
				<td>更新日時</td>
				<td>${userDetail.updateDate}</td>
		</table>
		<a href = "UserListServlet">戻る</a>
	</body>
</html>