
import java.io.*;
import java.util.StringTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class file.
 */
public class file{
	
	/**
	 * Readfile.
	 *
	 * @param a the a
	 */
	public static void readfile(String a)
	{
		  String[] result;
	      String line; 	// String that holds current file line
          int count = 0;	// Line number of count 
      
          // Read first line
		 try {
				
				/*	Sets up a file reader to read the file passed on the command
					line one character at a time */
				FileReader input = new FileReader(a);
	            
				/* Filter FileReader through a Buffered read to read a line at a
				   time */
				BufferedReader bufRead = new BufferedReader(input);
				
	      
	            line = bufRead.readLine();
	            count++;
	            
				// Read through file one line at time. Print line # and line
	            while (line != null)
	            {
	            int i=0;
	            	StringTokenizer token=new StringTokenizer(line,"() ,.!-+=;:?&{}\\");
	            	result = new String[token.countTokens()];
	            	int total=token.countTokens();
	            	while(token.hasMoreTokens()) 
	            	{ 
	            		result[i++] = token.nextToken();
	            		//String val = token.nextToken(); 
	            		//if (key.equals(val)==true){
	            		//System.out.println(key + ""+val+ "\t" ); 
	            		//} 
	            	}		
	            
	            	for (int a1=0; a1<=total-1;a1++)
	            	{
	            		for(int a2=a1+1;a2<=total-1;a2++)
	            		{
	            	if(result[a1].equals(result[a2]))
	            	System.out.println(result[a2]+ " " + result[a1]);
	            		}
	            	}
	            	
	                line = bufRead.readLine();
	                count++;
	            //	System.out.println(count+": "+line);
	            }
	            
	            bufRead.close();
				
	        }catch (ArrayIndexOutOfBoundsException e){
	            /* If no file was passed on the command line, this expception is
				generated. A message indicating how to the class should be
				called is displayed */
				System.out.println("outofrange");			

			}catch (IOException e){
				// If another exception is generated, print a stack trace
	            e.printStackTrace();
	        }
	}
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args)
    {
       
        readfile(args[0]);
        
    }// end main
}