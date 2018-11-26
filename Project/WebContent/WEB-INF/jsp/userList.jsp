<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="UserList.css">
	<title>User List</title>
</head>
	<body>
		<h1 class = "UserList">ユーザー一覧</h1>
		<p class = "position"><a href ="UserEntry" class = "position">新規登録</a></p>
		<table class = "out">
			<tr>
				<td>ユーザー名</td>
				<td><a href = "Login">ログアウト</a></td>
			</tr>
		</table>
		<form>
			<table class = "style">
				<tr>
					<td>ログインID</td>
					<td><input type = "text" name = "loginId" loginId= "ログインID"></td>
				</tr>
				<tr>
					<td>ユーザー名</td>
					<td><input type = "text" name = "userName" userName = "ユーザー名"></td>
				</tr>
				<tr>
					<td>生年月日</td>
					<td><input type ="date" Birthday = "生年月日">～<input type ="date" Bithday2 = "生年月日"></td>
				</tr>
			</table>
			<table border = "1" class = style>
				<tr>
					<th>ログインID</th>
					<th>ユーザー名</th>
					<th>生年月日</th>
					<th></th>
				</tr>
				<tr>
					<td>id001</td>
					<td>田中太郎</td>
					<td>1990年01月01日</td>
					<td>
						<table class = style>
							<tr>
								<td><input type="submit" value = "詳細"></td>
								<td><input type="submit" value = "更新"></td>
								<td><input type="submit" value = "削除"></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>id002</td>
					<td>山田次郎</td>
					<td>1995年02月01日</td>
					<td>
						<table class = style>
							<tr>
								<td><input type="submit" value = "詳細"></td>
								<td><input type="submit" value = "更新"></td>
								<td><input type="submit" value = "削除"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<p class = "position"><input type = "submit" value = "検索"></p>
		</form>
	</body>
</html>