package Final_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL 		= "jdbc:mysql://localhost";

	static final String USER 	 = "root";
	static final String PASSWORD = "";

	public static void open_db() throws Exception
	{
		connect_db = null;
		stmt_db = null;

		Class.forName(JDBC_DRIVER);

		connect_db = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		stmt_db = connect_db.createStatement();
	}

	public static void create_db(String db_name) throws Exception
	{
		String sql = "CREATE DATABASE IF NOT EXISTS "+db_name;
		try {
			update_db(sql);
		} catch (SQLException e) {
			//e.printStackTrace();
			//do nothing;
		}
		System.out.println("The tournament "+ db_name + " has been created.");
	}

	public static ResultSet select_db(String sql) throws Exception
	{
		stmt_db = null;
	    try {
	    	Statement stmt_db = connect_db.createStatement();
	    	return stmt_db.executeQuery(sql);
	    } catch (SQLException e) {
	    	//e.printStackTrace();
	    	//do nothing;
	    } finally {
	        if (stmt_db != null) { stmt_db.close(); }
	    }
	    return null;
	}

	public static int update_db(String sql) throws Exception
	{
		int status = 0;
		//open_db();
		stmt_db = null;
	    try {
	    	Statement stmt_db = connect_db.createStatement();
	    	status = stmt_db.executeUpdate(sql);
	    } catch (SQLException e) {
	    	//e.printStackTrace();
	    	//do nothing;
	    } finally {
	        if (stmt_db != null) { stmt_db.close(); }
	    }
		return status;
	}

	public static void close_db() throws Exception
	{
		connect_db.close();
	}

	private static Connection connect_db;
	private static Statement stmt_db;
	//private static String sql;
}

/*
 * public static void Select_db(String Sql) throws Exception
	{
		String sql = "USE "+ Sql;
		try {
			jdbc.update_db(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Tournament " + sql + " has been selected.");
	}
*/