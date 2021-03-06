
/*
 * Filename: UserInput.java
 * Package: utilities
 * Project: Globalizer
 * Created By: Tina Kurian
 * Date: 19.07.2012
 * Description: 
 */

package utilities;

public enum SymbolsEnum 
{
	/******************************************************************
	 * 						ENUM VALUES								  *
	 ******************************************************************/
	

	SEMICOLON(";"),
	CURLY_BRACE_OPEN("{"),
	CURLY_BRACE_CLOSE("}"); 
	
	
	
	
	
	
	/******************************************************************
	 * 						PRIVATE VARIABLES						  *
	 ******************************************************************/	
	
	 private final String text;
	
	
	
	 
	 
	 
	 
	
	/******************************************************************
	 * 						PRIVATE METHODS							  *
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
	private SymbolsEnum(final String text) 
	{
	    this.text = text;
	}

   
	
	
	
	
	
	/******************************************************************
	 * 						PUBLIC METHODS							  *
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
    @Override
    public String toString() 
    {
        // TODO Auto-generated method stub
        return text;
    }
}
