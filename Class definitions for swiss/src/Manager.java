import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author karl
 *Is the class that manages and controls all.
 * Contains all the static values as well
 */
public class Manager 
{
	static Map<String, ArrayList<Task>> HouseTasks = new HashMap<String, ArrayList<Task>>();
	static HashMap<String, Employee> EmployeeMap = new HashMap<String, Employee>();
	static void AddHouse(House house)
	{
		//Now cannot double as an update method
		if(! HouseTasks.containsKey(house.address))
		{
			HouseTasks.put(house.address, house.tasks);
		}
		else
		{
			System.out.println("There is already an object with that address, use the update method.\n");
		}

	}
	static void UpdateHouse(House house, ArrayList<Task> tasks) 
	{
		if( HouseTasks.containsKey(house.address))
		{
			HouseTasks.put(house.address, house.tasks);
		}
		else
		{
			System.out.println("There not an object with that address, use the add method.");
		}
	}
	static void UpdateHouse(String Address, ArrayList<Task> tasks)
	{
		if( HouseTasks.containsKey(Address))
		{
			HouseTasks.put(Address, tasks);
		}
		else
		{
			System.out.println("There not an object with that address, use the add method.");
		}
	}
	static ArrayList<Task> GetTasks(House house)
	{
		return (HouseTasks.get(house.address));
	}
	static ArrayList<Task> GetTasks(String Address)
	{
		return (HouseTasks.get(Address));
	}
	static House GetHouse(String address)
	{
		return(new House(address, HouseTasks.get(address)));
	}
	static ArrayList<Task> GetEmployeeTasks(String name)
	{
		return EmployeeMap.get(name).todolist;
	}
	static  Map<String, ArrayList<Task>> GetAllHousesAndTasks()
	{
		return HouseTasks;
	}
	static void AddTask(String target, Task task)
	{
		ArrayList<Task> b = HouseTasks.get(target);
		b.add(task);
		HouseTasks.put(target, b );
	}
	static void ClearHouse(String target)
	{
		if(HouseTasks.containsKey(target))
		{
			HouseTasks.put(target, new ArrayList<Task>());
		}
	}
	static  HashMap<String, Employee> GetAllEmployees()
	{
		return EmployeeMap ;
	}
	static void ClearEmployee(String target)
	{
		if(EmployeeMap.containsKey(target))
		{
			EmployeeMap.put(target, new Employee(target));
		}
	}

}
