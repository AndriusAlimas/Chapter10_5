<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mine" uri="MyTagLib" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Correct Table</title>
</head>
<body>

	<h1>Correct Result</h1>
	<br>
	
	<table border="1">
		<mine:CorrectIterateMovies movieCounter="0">
			<tr><td>${movie}</td></tr>
		</mine:CorrectIterateMovies>
	</table>
	
</body>
</html>