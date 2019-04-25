package Final_project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Team
{
	public static ResultSet select_team(String dbName) throws Exception
	{
		return jdbc.select_db("SELECT * FROM "+ dbName +".teams");
	}

	public static void insert_team(String dbName, Integer id, String Name) throws Exception
	{
		String created_string =
				"insert into " + dbName +
		        ".teams " +
		        "values("+id+", '"+Name+"')";
		if(jdbc.update_db(created_string) == 1)
		{
			System.out.println("\tThe team "+ Name +" has been created in the database "+ dbName);
		}
		else
		{
			System.out.println("\tThe team "+ Name +" already exist in the database "+ dbName);
		}
	}

	public static void create_team(String dbName) throws Exception
	{
		String created_string =
		        "create table " + dbName +
		        ".teams " +
		        "(TEAM_ID integer NOT NULL, " +
		        "TEAM_NAME varchar(40) NOT NULL, " +
		        "PRIMARY KEY (TEAM_ID))";
		if(jdbc.update_db(created_string) == 1)
		{
			System.out.println("\n\n\tThe table teams has been created in the database "+dbName+"\n");
		}
		else
		{
			System.out.println("\n\n\tThe table teams already exist in the database "+dbName+"\n");
		}
		//System.out.println("database \t "+jdbc.update_db(created_string));
	}

	public static void fill_team_table(String dbName) throws Exception
	{
		ArrayList<String> result = new ArrayList<>();
		Integer count = 0;

		try (BufferedReader br = new BufferedReader(new FileReader("Teams.csv"))) {
		    while (br.ready()) {
		        result.add(br.readLine());
		    }
		}
		for (String ref: result)
		{
			count++;
			insert_team(dbName, count, ref);
			//System.out.println("\tTEAM_ID\t" + count + "\tTEAM_NAME\t" + ref);
	    }
	}

}
