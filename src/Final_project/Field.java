package Final_project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Field
{
	public static ResultSet select_field(String dbName) throws Exception
	{
		return jdbc.select_db("SELECT * FROM "+ dbName +".fields");
	}

	public static void insert_field(String dbName, Integer id, String Name) throws Exception
	{
		String created_string =
				"insert into " + dbName +
		        ".fields " +
		        "values("+id+", '"+Name+"')";
		if(jdbc.update_db(created_string) == 1)
		{
			System.out.println("\tThe team "+ Name +" has been created in the database "+ dbName);
		}
		else
		{
			System.out.println("\tThe teams "+ Name +" already exist in the database "+ dbName);
		}
		//System.out.println("\t\t"+jdbc.update_db(created_string));
	}

	public static void create_field(String dbName) throws Exception
	{
		String created_string =
		        "create table " + dbName +
		        ".fields " +
		        "(FIELD_ID integer NOT NULL, " +
		        "FIELD_NAME varchar(40) NOT NULL, " +
		        "PRIMARY KEY (FIELD_ID))";
		if(jdbc.update_db(created_string) == 1)
		{
			System.out.println("\n\n\tThe table fields has been created in the database "+dbName+"\n");
		}
		else
		{
			System.out.println("\n\n\tThe table fields already exist in the database "+dbName+"\n");
		}
		//System.out.println("database \t\t"+jdbc.update_db(created_string));
	}

	public static void fill_field_table(String dbName) throws Exception
	{
		ArrayList<String> result = new ArrayList<>();
		Integer count = 0;

		try (BufferedReader br = new BufferedReader(new FileReader("Fields.csv"))) {
		    while (br.ready()) {
		        result.add(br.readLine());
		    }
		}
		for (String ref: result)
		{
			count++;
			insert_field(dbName, count, ref);
			//System.out.println("\tFIELD_ID\t" + count + "\tFIELD_NAME\t" + ref);
	    }
	}

}
