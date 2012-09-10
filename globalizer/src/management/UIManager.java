
/*
 * Filename: UIManager.java
 * Package: management
 * Project: Globalizer
 * Created By: Tina Kurian
 * Date: 19.07.2012
 * Description: 
 */



// packages
package management;

//imports
import utilities.FileIO;
import windows.windowsGUI;







/*
 * class Name: FileIO
 * Description: 
 */
public class UIManager 
{
	/******************************************************************
	 * 						STATIC VARIABLES						   *
	 ******************************************************************/
	static FileIO file = new FileIO(); 
	
	
	
	
	
	
	/******************************************************************
	 * 						PUBLIC STATIC MAIN						  *
	 ******************************************************************/
	
	
	
	/*
	 * Method Name:main
	 * Parameters: String[] args
	 * Parameter Description: main arguments
	 * Method Description: main method which calls on loading in the main .c file
	 * Return: void
	 *
	 * @name: main
	 * @params: String[] args
	 * @desc: main method which calls on loading in the main .c file
	 * @return: void
	 * @see java.lang.Enum#toString()
	 * 
	 */
	public static void main(String[] args)
	{
		try
		{
			windowsGUI.uiSetup(); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
