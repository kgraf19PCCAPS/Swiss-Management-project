
public class Tester
{
	public static void main(String args[])
	{

		House house = new House("1");
		house.addtask(new Task("Test faucets","Test the faucets in the master bathroom and kitchen",new Calendars(2017,8,6), true, 7));
		house.addtask(new Task("Test faucets","Test the faucets in the master bathroom and kitchen",new Calendars(2017,8,6), true, 7));
		house.addtask(new Task("Test faucets","Test the faucets in the master bathroom and kitchen",new Calendars(2017,8,6), true, 7));
		house.addtask(new Task("Test faucets","Test the faucets in the master bathroom and kitchen",new Calendars(2017,8,6), true, 7));
		house.addtask(new Task("Test faucets","Test the faucets in the master bathroom and kitchen",new Calendars(2017,8,6), true, 7));    
		//System.out.println(house.GetTasks());
		if(Manager.HouseTasks != null)
		{
			Manager.AddHouse(house);
			Manager.UpdateHouse("1", house.tasks);
			Manager.AddHouse(house);
			Manager.AddHouse(new House("two2two2two"));
			Manager.AddHouse(new House("three3three3three"));
			Manager.AddHouse(new House("four4four4four"));
		}

		Employee debra = new Employee("debra");
		//debra.GetTasks();
		debra.assign(house.tasks);
		//debra.GetTasks();
		Manager.EmployeeMap.put("Debra", debra);
		/**
		Calendars caltest = new Calendars(2017,8,20);
		//System.out.println(caltest);
		caltest.add(5);  
		//System.out.println(caltest);
		if(Manager.HouseTasks != null)
		{
			Manager.AddHouse(house);
			Manager.UpdateHouse("1", house.tasks);
			Manager.AddHouse(house);
			Manager.AddHouse(new House("two2two2two"));
			Manager.AddHouse(new House("three3three3three"));
			Manager.AddHouse(new House("four4four4four"));
		}//hooray this works now
		System.out.println(house.tasks.get(0));
		house.tasks.get(0).AddDays(-5);
		//System.out.println(house.tasks.get(0));
		house.tasks.get(0).AddDays(45);
		//System.out.println(house.tasks.get(0));
		house.tasks.get(0).renewfreq = 7;
		house.tasks.get(0).complete();
		System.out.println(house.tasks.get(0));
		System.out.println(house.tasks.get(0).renew);
		System.out.println(house.tasks.get(0).renewfreq);
		System.out.println(house.tasks.get(0).date);
		//System.out.println(house.tasks.get(0).daysleft());  //this is currently broken
		//System.out.println(Calendars.GetCurrentDate());
		//System.out.println(UI.GetTaskList());*/
		//DocReadWrite.Write();
		//DocReadWrite.Read();
		//System.out.println(house.tasks.get(0));
		String[] a = {"dog","cat","a","name"};
		UI.MakeForm(a);
		//System.out.println(UI.MakeForm(a));
		UI doggo = new UI();
	}

}

