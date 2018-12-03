<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>ユーザー登録画面</title>
	<link rel="stylesheet" href="css/UserEntry.css">
</head>
	<body>

		<h1 class = "UserEntry">ユーザー新規登録</h1>
		<c:if test="${errMsg != null}" >
	    <div class="UserEntry color">
		  ${errMsg}
		</div>
		</c:if>
		<table class = "out">
			<tr>
				<td>${userInfo.name} </td>
				<td><a href = "LogoutServlet">ログアウト</a></td>
			</tr>
		</table>
		<form action = "UserEntryServlet" method = "post">
			<table class="style">
				<tr>
					<td>ログインID</td>
					<td><input type = text name ="loginId" loginId= "ログインID"></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type = text name = "password" password= "パスワード"></td>
				</tr>
				<tr>
					<td>パスワード(確認)</td>
					<td><input type = text name = "password2" password2 = "パスワード"></td>
				</tr>
				<tr>
					<td>ユーザー名</td>
					<td><input type=text name = "userName" userName = "ユーザー名"></td>
				</tr>
				<tr>
					<td>生年月日</td>
					<td><input type=text name = "birthDate" bitrhDate = "生年月日"></td>
				</tr>
			</table>
			<p class = "UserEntry"><input type="submit" value="登録"></p>
		</form>
		<a href = "UserListServlet">戻る</a>
	</body>
</html>