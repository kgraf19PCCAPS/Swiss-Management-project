import java.util.ArrayList;

public class Employee 
{	
	String name;
	ArrayList<Task> todolist;
	public Employee(String name)
	{
		this.name = name;
		todolist = new ArrayList<Task>();
	}
	public ArrayList<Task> GetTasks()
	{
		for(Task a : todolist)
		{
			System.out.println(name + " needs to " + a);
		}
		return todolist;
	}
	public void assign(Task a)
	{
		todolist.add(a);
	}
	public void assign(ArrayList<Task> a)
	{
		for(Task b : a)
		{
			todolist.add(b);
		}
	}
	public ArrayList<Task> GetTasksofHouse(House house)
	{
		return (Manager.GetTasks(house));
	}
	public ArrayList<Task> GetTasksofHouse(String address)
	{
		return (Manager.GetTasks(address));
	}
	public String toString()
	{
		return (name + " \n" + todolist);
	}
}
