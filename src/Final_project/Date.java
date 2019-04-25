package Final_project;

import java.util.Calendar;

public class Date
{
	private static Calendar date = Calendar.getInstance();

	public static Integer year()
	{
		return date.get(Calendar.YEAR);
	}

	public static Integer month()
	{
		return date.get(Calendar.MONTH);
	}

	public static Integer day()
	{
		return date.get(Calendar.DAY_OF_MONTH);
	}
}
