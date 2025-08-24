<%@ page import="java.util.*,model.*" session="false"%>
<html>
<head>
<title>Results Page</title>
</head>
<body>
	<%
	java.util.List<model.Book> bookList = (java.util.List<model.Book>) request.getAttribute("books");
	out.println("<h2>SearchResult</h2>");
	if (bookList.isEmpty()) {
		out.println("<p>No books found for the given subject</p>");
	} else {
		out.println("<table border='2'>");
		out.println("<tr><th>BookId</th><th>BookName</th><th>BookPrice</th><th>Subject</th></tr>");
		for (model.Book b : bookList) {
			out.println("<tr><td>" + b.getBookId() + "</td><td>" + b.getBookName() + "</td><td>" + b.getBookPrice()
			+ "</td><td>" + b.getSubject() + "</td></tr>");

		}
		out.println("</table>");
	}
	%>
</body>
</html>