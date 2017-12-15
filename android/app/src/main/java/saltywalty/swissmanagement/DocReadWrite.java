package saltywalty.swissmanagement;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DocReadWrite 
{
	public static void main(String [] args) throws IOException
	{
		//This is a  tester of the class.


		String filename = "/Users/kgraf19/Desktop/PCCAPS/WarAndPeace.txt";
		/**
		try
		{
			String content = new String(Files.readAllBytes(Paths.get(filename)));
			System.out.println(content);
			System.out.println(content.length());
			byte[] b = content.getBytes();
			Files.write(Paths.get(filename), b);
		}
		catch(IOException ex)
		{
            System.out.println( "Error reading file");                  
		}
		 */
	}
	public static void Read()//TODO complete
	{
		String filename = "/Users/kgraf19/Desktop/PCCAPS/WarAndPeace.txt";
		try
		{
			String content = new String(Files.readAllBytes(Paths.get(filename)));
			//TODO make this read what is output by the write() method
			int start = 0;
			int  end = 0;
			while(start < 50)//TODO insert a condition
			{
				end = content.indexOf("=",start+1);
				//System.out.println(start);
				//System.out.println(end);
				String temp = content.substring(start+1, end);
				start = end;
				end = content.indexOf(",",start+1);
				String temptwo = content.substring(start, end);
				System.out.println(temp + temptwo);
			}
			System.out.println(content.substring(content.indexOf("{") + 1, content.indexOf("=")));

		}
		catch(IOException ex)
		{
			System.out.println( "Error reading file");                  
		}
	}
	public static void Write() 
	{
		//String filename = "/Applications/System Preferences.app/Contents/PlugIns/SystemPreferencesDockTile.docktileplugin/Contents/_CodeSignature/CodeResources";
		String filename = "/Users/kgraf19/Desktop/PCCAPS/WarAndPeace.txt";
		String writeout = "";
		writeout += (Manager.HouseTasks +" \n");
		writeout += (Manager.EmployeeMap +" \n");
		System.out.println(writeout);
		try
		{
			Files.write(Paths.get(filename), writeout.getBytes());
		}
		catch(IOException ex)
		{
			System.out.println( "Error writing file");
		}	
	}

}
