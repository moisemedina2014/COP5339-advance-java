package Final_project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Group
{
	public static ResultSet select_group(String dbName) throws Exception
	{
		return jdbc.select_db("SELECT * FROM "+ dbName +".groups");
	}

	public static void insert_group(String dbName, Integer id, String group_name, String team1, String team2, String team3, String team4) throws Exception
	{
		String created_string =
				"insert into " + dbName +
		        ".groups " +
		        "values("+id+", '"+group_name+"', '"+team1+"', '0', '"+team2+"', '0', '"+team3+"', '0', '"+team4+"', '0')";
		if(jdbc.update_db(created_string) == 1)
		{
			System.out.println("\tThe group "+ group_name +" has been created in the database "+ dbName);
		}
		else
		{
			System.out.println("\tThe group "+ group_name +" already exist in the database "+ dbName);
		}
		//System.out.println("\t "+jdbc.update_db(created_string));
	}

	public static void create_group(String dbName) throws Exception
	{
		String created_string =
		        "create table " + dbName +
		        ".groups " +
		        "(GROUP_ID integer NOT NULL, " +
		        "GROUP_NAME varchar(40) NOT NULL, " +
		        "TEAM1_NAME varchar(40) NOT NULL, " +
		        "TEAM1_GSTP integer NOT NULL, " +
		        "TEAM2_NAME varchar(40) NOT NULL, " +
		        "TEAM2_GSTP integer NOT NULL, " +
		        "TEAM3_NAME varchar(40) NOT NULL, " +
		        "TEAM3_GSTP integer NOT NULL, " +
		        "TEAM4_NAME varchar(40) NOT NULL, " +
		        "TEAM4_GSTP integer NOT NULL, " +
		        "PRIMARY KEY (GROUP_ID))";
		if(jdbc.update_db(created_string) == 1)
		{
			System.out.println("\n\n\tThe table groups has been created in the database "+dbName+"\n");
		}
		else
		{
			System.out.println("\n\n\tThe table groups already exist in the database "+dbName+"\n");
		}
		//System.out.println("database \t "+jdbc.update_db(created_string));
	}

	public static void fill_group_table(String dbName) throws Exception
	{
		ArrayList<String> result = new ArrayList<>();
		String[] arrSplit;
		Integer count = 0;

		try (BufferedReader br = new BufferedReader(new FileReader("Groups.csv"))) {
		    while (br.ready()) {
		        result.add(br.readLine());
		    }
		}
		for (String string: result)
		{
			count++;
			arrSplit = string.split("\\s*,\\s*");
			insert_group(dbName, count, arrSplit[0], arrSplit[1], arrSplit[2], arrSplit[3], arrSplit[4]);
			//System.out.println("\tTEAM_ID\t" + count + "\tTEAM_NAME\t" + string);
	    }
	}

}
