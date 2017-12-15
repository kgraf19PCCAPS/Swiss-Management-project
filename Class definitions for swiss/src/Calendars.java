import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calendars extends Calendar 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -65240073806219411L;
	Date sD;
	Calendar setDate = Calendar.getInstance();
	
    public Calendars(int month, int day, int year)
    {
        setDate.set(month, day, year);
        sD = setDate.getTime();
    }
    public Calendars(String date) {
        String startDateString = date;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate = null;
        try {
            startDate = df.parse(startDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sD = startDate;
    }
	@Override
	protected void computeTime()
	{
		// TODO Auto-generated method stub

	}
	@Override
	protected void computeFields()
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void add(int field, int amount)
	{
		//Calendar.DAY_OF_YEAR or month or year.
		setDate.add(field, amount);
		sD = setDate.getTime();
	}
	public void add(int amount) 
	{
		setDate.add(Calendar.DAY_OF_YEAR, amount);
		sD = setDate.getTime();
	}

	@Override
	public void roll(int field, boolean up)
	{
		// TODO Auto-generated method stub

	}
	@Override
	public int getMinimum(int field)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getMaximum(int field)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getGreatestMinimum(int field)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getLeastMaximum(int field)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	public void CalendarPrint()
	{
		System.out.println(sD);
	}
	public String toString()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    		System.out.println(dateFormat.format(sD));
		return (dateFormat.format(sD));
	}
	public int GetDayOfYear()
	{//TODO fix this
		return this.get(DAY_OF_YEAR);
	}
	public static int GetCurrentDate()
	{
		Calendar rn = Calendar.getInstance();
		return rn.get(DAY_OF_YEAR);
	}
	
}

