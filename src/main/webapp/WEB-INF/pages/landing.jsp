<!DOCTYPE html>
<html>
<head>
	<title>HTML5 Login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	
	<section class="loginform cf">
		<h1 >Give me a phone number!</h1>
		<form name="landing" action="combination" method="get" accept-charset="utf-8">
			<ul>
				<li>
					<label for="phone">7 or 10 digits</label>
					<input type="text" name="phoneNumber" placeholder="1234567890" required>
				</li>
				<li>
					<input type="submit" value="Submit">
				</li>
			</ul>
		</form>
	</section>
    
</body>
</html>