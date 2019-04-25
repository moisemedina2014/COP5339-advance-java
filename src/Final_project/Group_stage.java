package Final_project;

import java.sql.ResultSet;
import java.util.Random;

public class Group_stage
{
	public static void insert_Group_stage(String created_string, String dbName, String team, String opteam) throws Exception
	{
		if(jdbc.update_db(created_string) == 1)
		{
			System.out.println("\tGame "+ team +" VS "+ opteam +" inserted into database "+ dbName);
		}
		else
		{
			System.out.println("\tGame "+ team +" VS "+ opteam +" already exist in the database "+ dbName);
		}
	}

	public static void create_Group_stage(String dbName) throws Exception
	{
		String created_string =
		        "create table " + dbName +
		        ".group_stage " +
		        "(ROUND_ID integer NOT NULL, " +
		        "GROUP_NAME varchar(40) NOT NULL, " +
		        "FIELD varchar(40) NOT NULL, " +
		        "REFEREE varchar(40) NOT NULL, " +
		        "MATCH_NUM varchar(40) NOT NULL, " +
		        "TEAM1_NAME varchar(40) NOT NULL, " +
		        "SCORE1 integer NOT NULL, " +
		        "POINT1 integer NOT NULL, " +
		        "TEAM2_NAME varchar(40) NOT NULL, " +
		        "SCORE2 integer NOT NULL, " +
		        "POINT2 integer NOT NULL, " +
		        "PRIMARY KEY (ROUND_ID))";
		if(jdbc.update_db(created_string) == 1)
		{
			System.out.println("\n\n\tThe table Group_stages has been created in the database "+dbName+"\n");
		}
		else
		{
			System.out.println("\n\n\tThe table Group_stages already exist in the database "+dbName+"\n");
		}
		//System.out.println("database \t "+jdbc.update_db(created_string));
	}

	public static void fill_Group_stage_table(String dbName) throws Exception
	{
		Integer count = 0, match_count = 0;
		String match = null;
		String created_string = null;

		int randomInt;
		Random randomGenerator = new Random();

		ResultSet ref = Referee.select_ref(dbName);
		ref.last();
		int ref_size = ref.getRow();
		String ref_name;

		ResultSet field = Field.select_field(dbName);
		field.last();
		int field_size = field.getRow();
		String field_name;

		ResultSet group = Group.select_group(dbName);

		String group_name, team1, team2, team3, team4;
		Integer score1, score2;
		Integer point1, point2;


		String team = null;
		String opteam = null;

		for(int g = 0; g < 8; g++)
		{
			if(g < 8)
				group.next();
			group_name = group.getString("GROUP_NAME");
			team1 = group.getString("TEAM1_NAME");
			team2 = group.getString("TEAM2_NAME");
			team3 = group.getString("TEAM3_NAME");
			team4 = group.getString("TEAM4_NAME");

			match_count = 0;

			for (int i = 0; i < 3 ;i++ )
			{
				if(i == 0)
					team = team1;
				if(i == 1)
					team = team2;
				if(i == 2)
					team = team3;

				for (int j = i; j < 3; j++ )
				{
					if(j == 0)
						opteam = team2;
					if(j == 1)
						opteam = team3;
					if(j == 2)
						opteam = team4;

					// random referee from 1 to referee table size
					ref = Referee.select_ref(dbName);
					randomInt = randomGenerator.nextInt(ref_size) + 1;
					for (int t = 0; t < randomInt; t++)
					{
						ref.next();
					}
					ref_name = ref.getString("REF_NAME");

					//random field from 2 to field size
					field = Field.select_field(dbName);
					randomInt = randomGenerator.nextInt(field_size-1) + 2;
					for (int t = 0; t < randomInt; t++)
					{
						field.next();
					}
					field_name = field.getString("FIELD_NAME");

					score1 = randomGenerator.nextInt(12) + 0;
					score2 = randomGenerator.nextInt(12) + 0;

					if(score1 > score2)
					{
						point1 = 3;
						point2 = 0;
					}
					else if(score1 < score2)
					{
						point1 = 0;
						point2 = 3;
					}
					else
					{
						point1 = 1;
						point2 = 1;
					}

					count++;
					match_count++;
					match = "Match "+match_count;

					created_string =
							"insert into " + dbName +
					        ".group_stage " +
					        "values("+count+", '"+ group_name+"', '"+field_name+"', '"+ref_name+"', '"+match+
					        "', '"+team+"', '"+score1+"', '"+point1+"', '"+opteam+"', '"+score2+"', '"+point2+"')";

					//sending string is cleaner to many variables to pass
					insert_Group_stage(created_string, dbName, team, opteam);


				}

			}
		}

	}

}

























