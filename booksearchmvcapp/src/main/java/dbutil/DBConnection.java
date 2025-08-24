package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection conn;
	static {
		try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","javabackend","students");
			
		}catch(Exception ex) {
			System.out.println("Error in opening conn:"+ex);
		}
	}
	public static Connection getConn() {
		return conn;
	}
	public static void closeConnection() {
		if(conn!=null) {
			try {
				conn.close();
			}catch(Exception ex) {
				System.out.println("Error in opening conn:"+ex);
			}
		}
	}
}
