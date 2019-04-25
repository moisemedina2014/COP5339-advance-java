package Final_project;

import java.util.Date;

/**************************************************************************
 *** This class will do most of the setup for the individuals that will ***
 *** be interacting with the soccer management program.				    ***
 **************************************************************************/
public class Get_user_info
{
	/**********************************************************************
	 *** Construct an Acc_set_up object that can build the framework	***
	 *** needed for any type of account needed 							***
	 *** @param first_name and last_name name of account owner			***
	 **********************************************************************/
	public Get_user_info(String F_name, String L_name)
	{
		first_name = F_name;
		last_name  = L_name;
	}

	/**********************************************************************
	 *** @param address of account owner								***
	 **********************************************************************/
	public Get_user_info(String Street, String City, String State,
										Integer Zip_code, String Country)
	{
		street	= Street;
		city	= City;
		state	= State;
		zip_code= Zip_code;
		country	= Country;
	}

	/**********************************************************************
	 *** @param gender of account owner									***
	 **********************************************************************/
	public Get_user_info(Character Gender)
	{
		gender = Gender;
	}

	/**********************************************************************
	 *** @param date of birth of account owner									***
	 **********************************************************************/
	public Get_user_info(Date Birth_Date)
	{
		birth_date = Birth_Date;
	}

	/**********************************************************************
	 *** Variables used to store the account owners information			***
	 **********************************************************************/
	@SuppressWarnings("unused")
	private String 		first_name, last_name, street, city, state,	country;
	@SuppressWarnings("unused")
	private Integer 	phone_number, zip_code;
	@SuppressWarnings("unused")
	private Character 	gender;
	@SuppressWarnings("unused")
	private Date 		birth_date;
}