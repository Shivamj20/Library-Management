<html>
<head>
<title>Home Page</title>
</head>
<body>
	<%
	String error = (String) request.getAttribute("error");
	if (error != null) {
		out.println("<p style='color:red'>" + error + "</p>");
	}
	%>
	<form action="BookSearchController" method="get">
		<p>Enter subject name</p>
		<input type="text" name="subject" /><br>
		<button type="submit">Show Books</button>
	</form>
</body>
</html>