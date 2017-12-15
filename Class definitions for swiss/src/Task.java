

public class Task 
{
	String name;
	String description;
	Calendars date;
	boolean renew;
	int renewfreq;
	boolean completed;
	public Task(String name, String desc, Calendars day, boolean renewing, int freq)
	{
		this.name = name;
		description = desc;
		date = day;
		renew = renewing;
		completed = false;
	}

	public void complete()
	{
		if(!renew)
		{
			completed = true;
		}
		else
		{
			completed = false;
			renew();
		}
	}
	public void renew()
	{
		date.add(renewfreq);
	}
	public String toString()
	{
		return ( name + "\t" + description + ".\t" + date + "\n\t");
	}
	public int daysleft()
	{
		//TODO fix GetDayOfYear
		return(date.GetDayOfYear() - Calendars.GetCurrentDate());
	}
	public String AddDays(int days)
	{
		date.add(days);
		return date.toString();
	}
}
