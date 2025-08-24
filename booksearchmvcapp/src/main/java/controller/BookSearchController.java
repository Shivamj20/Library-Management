package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.BookDao;
import dbutil.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Book;

public class BookSearchController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subject=req.getParameter("subject");
		if(subject.isEmpty()) {
			RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			req.setAttribute("error","subject cannot be left blank");
			rd.forward(req, resp);
		}else {
			try {
				List<Book>bookList=BookDao.getAllBooksBySubject(subject);
				RequestDispatcher rd=req.getRequestDispatcher("showbooks.jsp");
				req.setAttribute("books",bookList);
				rd.forward(req, resp);
			}catch(SQLException ex) {
				RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
				req.setAttribute("error",ex.getMessage());
				rd.forward(req, resp);
			}
		}
	}
	@Override
	public void destroy() {
		DBConnection.closeConnection();
	}
}


