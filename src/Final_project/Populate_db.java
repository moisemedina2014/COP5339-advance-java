package Final_project;

import java.io.*;
import java.sql.SQLException;

// may not be needed at the end
public class Populate_db
{


	public static void create_db(String db_name) throws Exception
	{
		String sql = "CREATE DATABASE IF NOT EXISTS "+db_name;
		try {
			jdbc.update_db(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The tournament "+ db_name + " has been created.");
	}

	public static void fill_table() throws IOException
	{
		File input = new File("Referees.csv");
		int count = 0;
		String referee;

		@SuppressWarnings("resource")
		BufferedReader next = new BufferedReader(new FileReader(input));
		while((referee = next.readLine()) != null)
		{
			//jdbc.update_db("INSERT INTO `Referees`(`R_id`, `R_name`) VALUES ("+ count++ +","+ referee+")");
		}

		//jdbc.table_exists("Referee");

	}

}
