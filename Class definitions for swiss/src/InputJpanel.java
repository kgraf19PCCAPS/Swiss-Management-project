import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputJpanel 
{
	JPanel p = new JPanel(new SpringLayout());
	
	public String[] responses = {};
	public InputJpanel(String[] b, String a)
	{
		String type = a;
		String[] labels = b;
		int numPairs = labels.length;
		//Create and populate the panel.
		
		for (int i = 0; i < numPairs; i++) 
		{
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
				System.out.println(Arrays.toString(UI.GetValues(p)));
				responses = (UI.GetValues(p));
				System.out.println("This enter button is functional.");
				ParseResponse(responses,a);
			}
		});
		p.add(button);
		//Lay out the buttons in one row and as many columns
		//as necessary, with 6 pixels of padding all around.
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
		if(!a.equals("Default"))
		{
			frame.setVisible(true);
		}
	}
	public void show()
	{
		p.setVisible(true);
	}
	public void hide()
	{
		p.setVisible(false);
	}
	public void ParseResponse(String[] array, String type)
	{
		switch (type.toLowerCase()) 
		{
		case "default":
			System.out.println("This shouldn't be here.");
			break;
		case "addtask" ://this has 6 items in the array
			System.out.println("This should be here.");
			Task a = new Task(array[1],array[2], new Calendars(array[3]), 
					Boolean.parseBoolean(array[4]),Integer.parseInt(array[5]));
			Manager.AddTask(array[0], a);
			//TODO replace temp with a valid date value parsed from a string
			break;
		case "addhouse" : // this has one item in the array
			System.out.println("This should be here. x2 ");
			Manager.AddHouse(new House(array[0]));
			break;
		case "clearhouse" : // this has one item in the array
			System.out.println("This should be here. x3");
			Manager.ClearHouse(array[0]);
			break;
		case "addemployee" : // this has one item in the array
			System.out.println("This should be here. x5");
			Manager.EmployeeMap.put(array[0],new Employee(array[0]));
			break;
		case "employeetaskassign" : // this has one item in the array
			System.out.println("This should be here. x76");
			Task gf = new Task(array[1],array[2], new Calendars(array[3]),
					Boolean.parseBoolean(array[4]),Integer.parseInt(array[5]));
			Manager.EmployeeMap.get(array[0]).assign(gf);
			break;
		case "employeehouseassign" : // this has two items in the array
			System.out.println("This should be here. xyz");
			Manager.EmployeeMap.get(array[0]).assign(Manager.HouseTasks.get(array[1]));
			break;
		case "clearemployee" : // this has one item in the array
			System.out.println("This should be here. x270");
			Manager.ClearEmployee(array[0]);
			break;
		default: //this should never trigger
			System.out.println("The programmer who made this screwed up terribly.");
			break;
		}
	}
}
