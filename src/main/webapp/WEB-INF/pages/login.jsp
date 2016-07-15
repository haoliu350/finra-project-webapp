<!DOCTYPE html>
<html>
<head>
	<title>HTML5 Login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	
	<section class="loginform cf">
		<h1 >Welcome to Finra!</h1>
		<form name="login" action="loginCheck" method="get" accept-charset="utf-8">
			<ul>
				<li>
					<label for="usermail">Email</label>
					<input type="email" name="usermail" placeholder="yourname@email.com" required>
				</li>
				<li>
					<label for="password">Password</label>
					<input type="password" name="password" placeholder="password" required></li>
				<li>
					<input type="submit" value="Login">
				</li>
			</ul>
		</form>
	</section>
</body>
</html>