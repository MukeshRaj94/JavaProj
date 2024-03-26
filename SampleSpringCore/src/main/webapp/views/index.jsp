<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome Mukesh
	<form action="addAlien" method="post">
		Alien Id:<input type="text" name="aid"><br>
		Alien Name:<input type="text" name="aname"><br>
		<input type="Submit">
	</form>
	<hr>
	<form action="getAlien" method="get">	
		Alien Id:<input type="text" name="aid"><br>
		<input type="Submit">
	</form>
	<hr>
	<form action="getAlienByName" method="get">	
		Alien Name:<input type="text" name="aname"><br>
		<input type="Submit">
	</form>
</body>
</html>