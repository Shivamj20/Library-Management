package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBConnection;
import model.Book;

public class BookDao {
	public static List<Book> getAllBooksBySubject(String subject)throws SQLException{
		Connection conn=DBConnection.getConn();
		PreparedStatement ps=conn.prepareStatement("Select * from allbooks where subject=?");
		ps.setString(1, subject);
		ResultSet rs=ps.executeQuery();
		List<Book>bookList=new ArrayList<>();
		while(rs.next()) {
			Book obj=new Book();
			obj.setBookId(rs.getInt(1));
			obj.setBookName(rs.getString(2));
			obj.setBookPrice(rs.getDouble(3));
			obj.setSubject(rs.getString(4));
			bookList.add(obj);
		}
		return bookList;
	}
}
