import java.util.ArrayList;

public class House
{
	String address;
	ArrayList<Task> tasks;

	public House(String address)
	{
		this.address = address;

		tasks = new ArrayList<Task>();
	}
	public House(String address, ArrayList<Task> tasklist)
	{
		this.address = address;
		tasks = new ArrayList<Task>();
		tasks = tasklist;
	}
	public void addtask(Task task)
	{
		tasks.add(task);
	}
	public ArrayList<Task> GetTasks()
	{
		for(Task a : tasks)
		{
			System.out.println(a);
		}
		return tasks;
	}
	public void CleanupTasks()
	{
		for( int i = 0; i < tasks.size(); i++)
		{
			if(tasks.get(i).completed == true)
			{
				tasks.remove(i);
			}
		}
	}
}

