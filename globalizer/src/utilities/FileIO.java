
/*
 * Filename: FileIO.java
 * Package: utilities
 * Project: Globalizer
 * Created By: Tina Kurian
 * Date: 19.07.2012
 * Description: 
 */



// packages
package utilities;

//imports
import globalize.Globalize;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;







/*
 * class Name: FileIO
 * Description: 
 */
public class FileIO 
{
	
	/******************************************************************
	 * 						PRIVATE VARIABLES						  *
	 ******************************************************************/
	
	private Globalize globalize = new Globalize(); 
	private UserInput input = new UserInput(); 
	
	private String finalOutput = ""; 
	private String returnValue = ""; 
	
	
	
	
	
	
	/******************************************************************
	 * 						PUBLIC METHODS							  
	 * @param allPaths2 
	 * @param allPaths *
	 ******************************************************************/
	
	/*
	 * Method Name:
	 * Parameters:
	 * Parameter Description:
	 * Method Description:
	 * Return: 
	 *
	 * @name: 
	 * @params: 
	 * @desc:
	 * @return:
     * @see java.lang.Enum#toString()
     * 
     */
	public String LoadMainFile(String textFilePath, String cSourceFilePath)
	{
		 FileInputStream fstream = null;
		 LoadUserInputFile(textFilePath); 
		 String variableN[] = null; 
		 String variableType = null; 
 
		 for(String functionName: input.map.keySet()) 
		 {
			for(String variableName: input.map.get(functionName)) 
			{
				if(variableName.contains(TypesEnum.INT.toString()))
				{
					variableN = variableName.split(TypesEnum.INT.toString());
					variableN[1] = variableN[1].trim(); 
					variableType = TypesEnum.INT.toString(); 
					
				}
				else if(variableName.contains(TypesEnum.FLOAT.toString()))
				{
					variableN = variableName.split(TypesEnum.FLOAT.toString());
					variableN[1] = variableN[1].trim(); 
					variableType = TypesEnum.FLOAT.toString(); 
					
				}
				else if(variableName.contains(TypesEnum.STRING.toString()))
				{
					variableN = variableName.split(TypesEnum.STRING.toString());
					variableN[1] = variableN[1].trim(); 
					variableType = TypesEnum.STRING.toString(); 
				}
				else if(variableName.contains(TypesEnum.DOUBLE.toString()))
				{
					variableN = variableName.split(TypesEnum.DOUBLE.toString());
					variableN[1] = variableN[1].trim(); 
					variableType = TypesEnum.DOUBLE.toString(); 
				}
				else if(variableName.contains(TypesEnum.SHORT.toString()))
				{
					variableN = variableName.split(TypesEnum.SHORT.toString());
					variableN[1] = variableN[1].trim(); 
					variableType = TypesEnum.SHORT.toString(); 
				}
				else if(variableName.contains(TypesEnum.LONG.toString()))
				{
					variableN = variableName.split(TypesEnum.LONG.toString());
					variableN[1] = variableN[1].trim(); 
					variableType = TypesEnum.LONG.toString(); 
				}
				else if(variableName.contains(TypesEnum.BYTE.toString()))
				{
					variableN = variableName.split(TypesEnum.BYTE.toString());
					variableN[1] = variableN[1].trim(); 
					variableType = TypesEnum.BYTE.toString(); 
					
				}
				 
				 finalOutput = finalOutput + variableType + " VARIABLE_TO_MONITOR_" + variableN[1] + "\n"; 
			}
		 }
		
		try 
		{
			fstream = new FileInputStream(cSourceFilePath);
			//fstream = new FileInputStream("C://Users//tkurian//Downloads//sqrt.c");
			
		} 
		catch (FileNotFoundException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  
		  try 
		  {
			while ((strLine = br.readLine()) != null)   
			  {
				  globalize.FindFunction(strLine, input);  
				  
				  if(globalize.foundAFunction == true)
				  {
					  
					  returnValue = globalize.ReplaceUserInput(strLine);
					  
					  if(globalize.isEndOfFunction == true)
					  {
						  globalize.foundAFunction = false; 
						  globalize.isEndOfFunction = false; 
					  }
					  
					  finalOutput = finalOutput + returnValue; 
				  }
				  else
				  {
					  finalOutput = finalOutput + strLine + "\n";
				  }
			  }
		  } 
		  catch (IOException e1) 
		  {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		  }
		  
		 
		  
		  try 
		  {
			
			in.close();
		  } 
		  catch (IOException e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		  return finalOutput; 
		
	}
	
	
	
	/*
	 * Method Name:
	 * Parameters:
	 * Parameter Description:
	 * Method Description:
	 * Return: 
	 *
	 * @name: 
	 * @params: 
	 * @desc:
	 * @return:
     * @see java.lang.Enum#toString()
     * 
     */
	public void LoadUserInputFile(String textFilePath)
	{
		 int lengthOfLine = 0; 
		 UserInput info = new UserInput();
		 
		 try
		 {
			 FileInputStream fstream = new FileInputStream(textFilePath);
			 //FileInputStream fstream = new FileInputStream("C://Users//tkurian//Downloads//input.txt");
			 DataInputStream in = new DataInputStream(fstream);
			 BufferedReader br = new BufferedReader(new InputStreamReader(in));
			 String strLine;
		  
			 while ((strLine = br.readLine()) != null)   
			 {
				  strLine = strLine.trim(); 
				  String[] str = strLine.split("~"); 
				  
				  String[] varsToAdd = str[0].split(",");
				  lengthOfLine = str.length; 
				  
				  if(lengthOfLine < 2)
				  {
					  throw new IOException("Local variable and/or function name cannot be found!"); 
					  
				  }
				 
				  for(int z = 0; z < varsToAdd.length; z++)
				  {
					  info.addVariable(str[1], varsToAdd[z]);
				  }
				  
			 }
		 }
		 catch (Exception e)
     	 {
     		  System.err.println("Error: " + e.getMessage());
         }

		 input = info; 
	}
}
