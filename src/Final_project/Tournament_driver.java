package Final_project;

import java.util.Scanner;

public class Tournament_driver
{
   public static void main(String[] args) throws Exception
   {
	   char user_choice;
	   String db_name = "World_Cup_"+ Date.year();
	   Scanner in = new Scanner(System.in);

	   System.out.println("\n**************************************************************************");
	   System.out.println("*\t\t\t\t\t\t\t\t\t *");
	   System.out.println("*\tWelcome to the World Cup Tracking System\t\t\t *");
	   System.out.println("*\t\t\t\t\t\t\t\t\t *");
	   System.out.println("*\t\t\t\t\t\t\t\t\t *");
	   System.out.println("*\tAs this is your first log in.\t\t\t\t\t *");
	   System.out.println("*\tWe need to setup your pc.\t\t\t\t\t *");
	   System.out.println("*\t\t\t\t\t\t\t\t\t *");
	   System.out.println("*\tPlease copy the link below to your browser.\t\t\t *");
	   System.out.println("*\thttps://www.apachefriends.org/download.html\t\t\t *");
	   System.out.println("*\tDownload and instal XAMPP\t\t\t\t\t *");
	   System.out.println("*\t\t\t\t\t\t\t\t\t *");
	   System.out.println("*\tOnce completed please start Apache and Mysql\t\t\t *");
	   System.out.println("*\t\t\t\t\t\t\t\t\t *");
	   System.out.println("**************************************************************************");

	   System.out.println("\n\tWhen ready please press Enter to continue.");
	   jdbc.open_db();
	   System.in.read();

	   System.out.println("\tWould you like to pick the tournament name?");
	   user_choice = in.next().charAt(0);

	   if(user_choice == 'y' || user_choice == 'Y')
	   {
		   System.out.println("\tPlease enter the Tournament name you want\n\tone word no spaces like: database_1.");
		   db_name = in.next();
		   jdbc.update_db("CREATE DATABASE IF NOT EXISTS " + db_name);
	   }
	   else
	   {
		   jdbc.create_db(db_name);
	   }

	   Referee.create_ref(db_name);

	   Referee.fill_ref_table(db_name);

	   Team.create_team(db_name);

	   Team.fill_team_table(db_name);

	   Field.create_field(db_name);

	   Field.fill_field_table(db_name);

	   Group.create_group(db_name);

	   Group.fill_group_table(db_name);

	   Group_stage.create_Group_stage(db_name);

	   Group_stage.fill_Group_stage_table(db_name);

	   jdbc.close_db();
	   in.close();
   }
}
