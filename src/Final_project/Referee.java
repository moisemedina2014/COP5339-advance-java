package Final_project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Referee
{
	public static ResultSet select_ref(String dbName) throws Exception
	{
		return jdbc.select_db("SELECT * FROM "+ dbName +".referees");
	}

	public static void insert_ref(String dbName, Integer id, String Name) throws Exception
	{
		String created_string =
				"insert into " + dbName +
		        ".referees " +
		        "values("+id+", '"+Name+"')";
		if(jdbc.update_db(created_string) == 1)
		{
			System.out.println("\tThe referee "+ Name +" has been created in the database "+ dbName);
		}
		else
		{
			System.out.println("\tThe referee "+ Name +" already exist in the database "+ dbName);
		}
		//System.out.println(" "+jdbc.update_db(created_string));
	}

	public static void create_ref(String dbName) throws Exception
	{
		String created_string =
		        "create table " + dbName +
		        ".referees " +
		        "(REF_ID integer NOT NULL, " +
		        "REF_NAME varchar(40) NOT NULL, " +
		        "PRIMARY KEY (REF_ID))";
		if(jdbc.update_db(created_string) == 1)
		{
			System.out.println("\n\n\tThe table referees has been created in the database "+dbName+"\n");
		}
		else
		{
			System.out.println("\n\n\tThe table referees already exist in the database "+dbName+"\n");
		}
		//System.out.println(" "+jdbc.update_db(created_string));
	}

	public static void fill_ref_table(String dbName) throws Exception
	{
		ArrayList<String> result = new ArrayList<>();
		Integer count = 0;

		try (BufferedReader next_ref = new BufferedReader(new FileReader("Referees.csv"))) {
		    while (next_ref.ready()) {
		        result.add(next_ref.readLine());
		    }
		}
		for (String ref: result)
		{
			count++;
			insert_ref(dbName, count, ref);
			//System.out.println("\tREF_ID\t" + count + "\tREF_NAME\t" + ref);

        }
	}

}
