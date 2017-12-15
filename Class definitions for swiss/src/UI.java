import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Don't use the observer/observed system. It's not needed.

public  class UI 
{
	//testing string array
	static String[] a = {"Task Name:","Task Description:","Completion Date:","Employee:"};
	//delete the above after use
	static InputJpanel panel;

	static String[] responses  = {};

	public UI()
	{
		panel = new InputJpanel(a,"Default");
		MainUI();
	}

	static Scanner scanner = new Scanner(System.in);

	//I was young and naive then.
	/**
	public static ArrayList<Task> GetTaskList()
	{
		ArrayList<Task> returned = new ArrayList<Task>();
		boolean done = false;
		while (!done)
		{
			//repeats a form to create a task
			System.out.println("Input the name of the task.");
			String a = scanner.nextLine();
			System.out.println("Input the description of the task.");
			String b = scanner.nextLine();
			System.out.println("Input the day of month the task must be completed.(must be a number)");
			String c = scanner.nextLine();
			System.out.println("Input the month the task must be completed.(must be a number)");
			String d = scanner.nextLine();
			System.out.println("Input the year the task must be completed.(must be a number)");
			String e = scanner.nextLine();
			System.out.println("Will the task repeat?");
			String f = scanner.nextLine();
			System.out.println("How often must the task repeat in days?(must be a number)");
			String g = scanner.nextLine();
			System.out.println("Would you like to add another task?");
			String h = scanner.nextLine();
			if (!h.contains("y"))
			{
				done = true;
			}
			returned.add(new Task(a,b,new Calendars( Integer.parseInt(e),Integer.parseInt(d), Integer.parseInt(c)),f.startsWith("y"), Integer.parseInt(g)));      
		}
		return returned;
	}*/

	public static void frametest()//Creates a basic single field frame
	{
		String[] labels = {"Name: ", "Fax: ", "Email: ", "Address: "};
		int numPairs = labels.length;

		JFrame frame = new JFrame("SpringDemo1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set up the content pane.
		Container contentPane = frame.getContentPane();
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		JLabel label = new JLabel("Label: ");
		JTextField textField = new JTextField("Text field", 15);
		contentPane.add(label);
		contentPane.add(textField);
		layout.putConstraint(SpringLayout.WEST, label,
				5,
				SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, label,
				5,
				SpringLayout.NORTH, contentPane);

		//Adjust constraints for the text field so it's at
		//(<label's right edge> + 5, 5).
		layout.putConstraint(SpringLayout.WEST, textField,
				5,
				SpringLayout.EAST, label);
		layout.putConstraint(SpringLayout.NORTH, textField,
				5,
				SpringLayout.NORTH, contentPane);
		//Display the window.
		frame.pack();
		frame.setVisible(true);

	}
	public static void MakeForm()
	{
		String[] labels = {"Name: ", "Fax: ", "Email: ", "Address: "};
		int numPairs = labels.length;

		//Create and populate the panel.
		JPanel p = new JPanel(new SpringLayout());
		for (int i = 0; i < numPairs; i++) {
			JLabel l = new JLabel(labels[i], JLabel.TRAILING);
			p.add(l);
			JTextField textField = new JTextField(10);
			l.setLabelFor(textField);
			p.add(textField);
		}
		JButton button = new JButton("Enter");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("this is working");
				System.out.println(Arrays.toString(GetValues(p)));
			}
		});

		p.add(button);
		//Lay out the panel.
		SpringUtilities.makeCompactGrid(p,
				numPairs, 2, //rows, cols
				6, 20,        //initX, initY
				4, 4);       //xPad, yPad

		//Create and set up the window.
		JFrame frame = new JFrame("SpringForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set up the content pane.
		p.setOpaque(true);  //content panes must be opaque
		frame.setContentPane(p);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	/**
	public static void MakeForm(String[] b)//TODO fix this as it is essential and non-functional.
	{
		String[] labels = b;
		int numPairs = labels.length;
		//Create and populate the panel.
		JPanel p = new JPanel(new SpringLayout());
		for (int i = 0; i < numPairs; i++) {
			JLabel l = new JLabel(labels[i], JLabel.TRAILING);
			p.add(l);
			JTextField textField = new JTextField(10);
			l.setLabelFor(textField);
			p.add(textField);
		}
		JButton button = new JButton("Enter");
		button.addActionListener(new ActionListener()
		{

			public  void actionPerformed(ActionEvent e)
			{
				//System.out.println("this is working");
				//System.out.println(Arrays.toString(GetValues(p)));
				UI.responses = (GetValues(p));
			}
		});

		p.add(button);
		//Lay out the panel.
		SpringUtilities.makeCompactGrid(p,
				numPairs, 2, //rows, cols
				6, 20,        //initX, initY
				4, 4);       //xPad, yPad

		//Create and set up the window.
		JFrame frame = new JFrame("SpringForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set up the content pane.
		p.setOpaque(true);  //content panes must be opaque
		frame.setContentPane(p);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}*/
	//uses observable classes
	public static void MakeForm(String[] b)
	{
		panel = new InputJpanel(b,"MakeForm");
	}
	public static void DispForm( Map<String, ArrayList<Task>> b , String a)
	{
		//TODO make this display large strings better
		String[] strings = new String[b.keySet().size()];
		int d = 0;
		for(String c : b.keySet())
		{
			strings[d] = c;
			d++;
		}
		int numPairs = strings.length;
		//Create and populate the panel.
		JPanel p = new JPanel(new SpringLayout());
		for (int i = 0; i < numPairs; i++) {
			JLabel l = new JLabel(strings[i], JLabel.TRAILING);
			p.add(l);
			JTextField textField = new JTextField(10);
			l.setLabelFor(textField);
			textField.setText((b.get(strings[i])).toString());
			textField.setEditable(false);
			p.add(textField);
		}
		//Lay out the panel.
		SpringUtilities.makeCompactGrid(p,
				numPairs, 2, //rows, cols
				6, 20,        //initX, initY
				4, 4);       //xPad, yPad

		//Create and set up the window.
		JFrame frame = new JFrame(a);

		//Set up the content pane.
		p.setOpaque(true);  //content panes must be opaque
		frame.setContentPane(p);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	public static void DispEmployee( Map<String, Employee> b , String a)
	{
		//TODO make this display large strings better
		String[] strings = new String[b.keySet().size()];
		int d = 0;
		for(String c : b.keySet())
		{
			strings[d] = c;
			d++;
		}
		int numPairs = strings.length;
		//Create and populate the panel.
		JPanel p = new JPanel(new SpringLayout());
		for (int i = 0; i < numPairs; i++) 
		{
			JLabel l = new JLabel(strings[i], JLabel.TRAILING);
			p.add(l);
			JTextField textField = new JTextField(10);
			l.setLabelFor(textField);
			textField.setText((b.get(strings[i])).todolist.toString());
			textField.setEditable(false);
			p.add(textField);
		}
		//Lay out the panel.
		SpringUtilities.makeCompactGrid(p,
				numPairs, 2, //rows, cols
				6, 20,        //initX, initY
				4, 4);       //xPad, yPad

		//Create and set up the window.
		JFrame frame = new JFrame(a);

		//Set up the content pane.
		p.setOpaque(true);  //content panes must be opaque
		frame.setContentPane(p);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	public static void MakeForm(String[] fields, String type)
	{
		panel = new InputJpanel(fields, type);
	}
	public static String[] GetValues(JPanel a)
	{
		String[] output = new String[(a.getComponentCount())/2];
		for(int i =0; i < a.getComponentCount()/2; i ++)
		{
			output[i] =( (JTextField)a.getComponent((i*2)+1)).getText();
			//output[i] = String.valueOf(a.getComponentCount());
		}
		//output[1] =(String)(((JTextField) a.getComponent(1)).getText());
		return output;
	}

	public static void MainUI()
	{
		JFrame frame = new JFrame("SpringBox");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set up the content pane.
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new SpringLayout());
		String[] strings;
		JButton button = new JButton("Add Task");
		button.addActionListener(new ActionListener()
		{
			public  void actionPerformed(ActionEvent e)
			{
				String[] strings = new String[6]; 
				strings[0] = "Owner:";
				strings[1] = "Task Name:";
				strings[2] = "Task Description:";
				strings[3] = "Completion Date:(MM/DD/YYYY";
				strings[4] = "Renewing:(True/False)";
				strings[5] = "Renew Frequency:";
				UI.MakeForm( strings ,"AddTask" );
			}
		});
		contentPane.add(button);
		button = new JButton("Add House");
		button.addActionListener(new ActionListener()
		{
			public  void actionPerformed(ActionEvent e)
			{
				String[] strings = new String[1]; 
				strings[0] = "Owner:";
				UI.MakeForm( strings ,"AddHouse" );
			}
		});
		contentPane.add(button);
		button = new JButton("Get Tasks");
		button.addActionListener(new ActionListener()
		{
			public  void actionPerformed(ActionEvent e)
			{
				 Map<String, ArrayList<Task>> map = Manager.GetAllHousesAndTasks();
				UI.DispForm( map ,"Get Tasks" );
			}
		});
		contentPane.add(button);
		button = new JButton("Clear House");
		button.addActionListener(new ActionListener()
		{
			public  void actionPerformed(ActionEvent e)
			{
				String[] strings = new String[1]; 
				strings[0] = "Owner:";
				UI.MakeForm( strings ,"ClearHouse" );
			}
		});
		contentPane.add(button);
		button = new JButton("Add Employee");
		button.addActionListener(new ActionListener()
		{
			public  void actionPerformed(ActionEvent e)
			{
				String[] strings = new String[1]; 
				strings[0] = "Name:";
				UI.MakeForm( strings ,"AddEmployee" );
			}
		});
		contentPane.add(button);
		button = new JButton("Assign task to Employee");
		button.addActionListener(new ActionListener()
		{
			public  void actionPerformed(ActionEvent e)
			{
				String[] strings = new String[6]; 
				strings[0] = "Owner:";
				strings[1] = "Task Name:";
				strings[2] = "Task Description:";
				strings[3] = "Completion Date:(MM/DD/YYYY";
				strings[4] = "Renewing:(True/False)";
				strings[5] = "Renew Frequency:";
				UI.MakeForm( strings ,"EmployeeTaskAssign" );
			}
		});
		contentPane.add(button);
		button = new JButton("Assign House to Employee");
		button.addActionListener(new ActionListener()
		{
			public  void actionPerformed(ActionEvent e)
			{
				String[] strings = new String[2]; 
				strings[0] = "Employee";
				strings[1] = "Owner:";
				UI.MakeForm( strings ,"EmployeeHouseAssign" );
			}
		});
		contentPane.add(button);
		button = new JButton("Clear Employee");
		button.addActionListener(new ActionListener()
		{
			public  void actionPerformed(ActionEvent e)
			{
				String[] strings = new String[1]; 
				strings[0] = "Name:";
				UI.MakeForm( strings ,"ClearEmployee" );
			}
		});
		contentPane.add(button);
		button = new JButton("Get Employees");
		button.addActionListener(new ActionListener()
		{
			public  void actionPerformed(ActionEvent e)
			{
				 Map<String, Employee> map = Manager.GetAllEmployees();
				UI.DispEmployee( map ,"Get  Employees" );
			}
		} );
		contentPane.add(button);
		
		
		//Lay out the buttons in one row and as many columns
		//as necessary, with 6 pixels of padding all around.
		SpringUtilities.makeCompactGrid(contentPane, contentPane.getComponentCount(),
				1,
				6, 6, 6, 6);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	
}


