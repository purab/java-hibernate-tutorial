package in.purabtech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		try {			
			String jdbcurl="jdbc:mysql://localhost:3306/jshopping?useSSL=false";
			String username="root";
			String password="";
			
			Connection conn=DriverManager.getConnection(jdbcurl, username,password);
			
			System.out.println("db connection is done");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
