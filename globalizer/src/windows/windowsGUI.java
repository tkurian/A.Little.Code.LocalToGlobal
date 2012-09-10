
/*
 * Filename: windowsGUI.java
 * Package: windows
 * Project: Globalizer
 * Created By: Tina Kurian
 * Date: 19.07.2012
 * Description: 
 */


//packages
package windows;

//imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import utilities.FileIO;


/*
 * class Name: windowsGUI
 * Description: 
 */
public class windowsGUI extends JTextPane
{

	//auto-generated serialVersionUID
	private static final long serialVersionUID = -6358713729826011480L;
	
	//static variables
	static FileIO file = new FileIO(); 
    static JOptionPane joptionpane = new JOptionPane(); 
	static String textFilePath = ""; 
	static String cSourceFilePath = ""; 
	static windowsGUI pane = new windowsGUI();
	static boolean isCSource = false; 
	static boolean isText = false; 
	static String updatedFile = null; 
	
	
	/*
	 * Method Name:uiSetup
	 * Parameters: N/A
	 * Parameter Description: N/A
	 * Method Description: this method will setup the gui when a user is running the application through windows				   
	 * Return: void
	 *
	 * @name: uiSetup
	 * @params: N/A
	 * @desc: this method will setup the gui when a user is running the application through windows
	 * @return: void
	 * 
	 */
	public static void uiSetup() 
	{
	   pane.setBackground(Color.BLACK);
	   
	   JFrame frame = new JFrame("Globalizing The Universe One Step At A Time ...");
	   JToolBar toolbar = new JToolBar("Toolbar", JToolBar.HORIZONTAL);
	   final JButton textButton = new JButton(new ImageIcon("C:\\Users\\Tina\\Desktop\\Text.png"));
	   toolbar.add(textButton);
	   final JButton cSourceButton = new JButton(new ImageIcon("C:\\Users\\Tina\\Desktop\\c.png"));
	   toolbar.add(cSourceButton);
	   
	   textButton.addActionListener(new ActionListener() 
	   {
		   
		  /*
		   * Method Name:actionPerformed
		   * Parameters: ActionEvent e
		   * Parameter Description: e: this is the event handler 
		   * Method Description: button event handler
		   * Return: void
		   *
		   * @name: actionPerformed
		   * @params: ActionEvent e
		   * @desc: button event handler
		   * @return: void
		   * 
		   */
        @SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent e)
           {
    		   try
    		   {
	        	   if ( e.getSource ( ) == textButton ) 
	        	   {
	       				textFilePath = joptionpane.showInputDialog ( "Path to input file(format: C:\\location\\of\\the\\input.txt)");
	        	   }
        		   if(textFilePath.contains(".txt"))
        		   {
        			   File file = new File(textFilePath); 
        			   if(file.exists())
        			   {
        				   isText = true;
        			   }
        		   } 
        		   checkStatus(); 
       			}
    		   catch(Exception e1)
    		   {
    			   
    		   }
           }
       }); 

	   cSourceButton.addActionListener(new ActionListener() 
	   {
		   
		  /*
		   * Method Name:actionPerformed
		   * Parameters: ActionEvent e
		   * Parameter Description: e: this is the event handler 
		   * Method Description: button event handler
		   * Return: void
		   *
		   * @name: actionPerformed
		   * @params: ActionEvent e
		   * @desc: button event handler
		   * @return: void
		   * 
		   */
        @SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent e)
           {
    		   try
    		   {
	        	   if ( e.getSource ( ) == cSourceButton ) 
	        	   {
	       			   // Get the URL from the user
	        		   cSourceFilePath = joptionpane.showInputDialog ( "Path to source file(format: C:\\location\\of\\the\\source.c))");
	        		   if(cSourceFilePath.contains(".c"))
	        		   {
	        			   File file = new File(cSourceFilePath); 
	        			   if(file.exists())
	        			   {
	        				   isCSource = true; 
	        			   }
	        		   }
	        		   checkStatus(); 
	       			}
    		   }
    		   catch(Exception e1)
    		   {
    			   
    		   }
           }
       }); 
	   
	   frame.getContentPane().add(toolbar,BorderLayout.NORTH); 
	   frame.getContentPane().add(new JScrollPane(pane));
	   frame.setUndecorated(true);
	   frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   frame.setSize(600, 400);
	   frame.setVisible(true);
	   
	}
		  
	   
	   /*
		* Method Name:checkStatus
		* Parameters: N/A
		* Parameter Description: N/A
		* Method Description: this method checks the status to see if both files have been loaded(input and source)				   
		* Return: void
		*
		* @name: checkStatus
		* @params: N/A
		* @desc: this method checks the status to see if both files have been loaded(input and source)
		* @return: void
		* 
		*/
		public static void checkStatus() 
		{
		   if(isText == true && isCSource == true)
		   {
			   updatedFile = file.LoadMainFile(textFilePath, cSourceFilePath); 
			   windowsGUI.startWindowsGui ( updatedFile);	
			   isText = false; 
			   isCSource = false; 
		   }
		}
		
		
   /*
	* Method Name:showText
	* Parameters: String string
	* Parameter Description: string: the globalized string to be displayed
	* Method Description: this method will setup the colour of the text displayed on the gui				   
	* Return: void
	*
	* @name: colourText
	* @params: N/A
	* @desc: this method will pass both the colour and the globalized string to the appendColours method	
	* @return: void
	* 
	*/
	public static void showText(String string)
	{
		pane.appendColours(Color.WHITE, string);
	}
	
	
   /*
	* Method Name:startWindowsGui
	* Parameters: String theFile
	* Parameter Description: theFile: the globalized file to be displayed on the gui
	* Method Description: this method will take the globalized file and pass it to the showText method			   
	* Return: void
	*
	* @name: startWindowsGui
	* @params: String theFile
	* @desc: this method will take the globalized file and pass it to the showText method
	* @return: void
	* 
	*/
	public static void startWindowsGui(String theFile)
	{
	   showText(theFile);
	}

	
   /*
	* Method Name:appendColours
	* Parameters: Color colour, String string
	* Parameter Description: colour: sets the colour of the text. string: sets the colour of the string passed in
	* Method Description: this method handles colouring the text in the string to be displayed on the ui		   
	* Return: void
	*
	* @name: appendColours
	* @params: Color colour, String string
	* @desc: colour: this method handles colouring the text in the string to be displayed on the ui
	* @return: void
	* 
	*/
	public void appendColours(Color colour, String string) 
	{ 
	   StyleContext styleContext = StyleContext.getDefaultStyleContext();
	   AttributeSet attributeSet = styleContext.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground, colour);
	
	   setCharacterAttributes(attributeSet, false);
	   replaceSelection(string); 
	}
	
}
