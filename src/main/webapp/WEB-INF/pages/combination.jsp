<!DOCTYPE html>
<html>
<head>
	<title>HTML5 Login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.10/css/jquery.dataTables.css">
  

	
</head>
<body>
	
	<section class="loginform cf">
		<h1 >Alpha-Numeric Combinations</h1>
		<h3>Input Number : ${phoneNumber}</h3>	
		<h3><span class="totalVal"></span></h3>
		
    	<div id="Results"></div>
    	<input type="button" value="Previous" onclick="PrevPage()" />
    	<input type="button" value="Next" onclick="NextPage()" />
		   
	</section>
	
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.10/js/jquery.dataTables.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	
</body>
</html>