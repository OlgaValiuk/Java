package epam.javatr.circle.fileread;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRead {
	 
	private List<String> lines = new ArrayList<String>();
	
	public List<String> getFileNumber() { 
		
		final String filein = "./data/readRadius.txt";
		
		try(BufferedReader br = new BufferedReader (new FileReader(filein)))
		{
		   String line;
		   while ((line = br.readLine()) != null) {
	            lines.add(line);
	        }
		}
		catch(FileNotFoundException ex){
		     
		    System.out.println(ex.getMessage());
		} 
		catch(IOException ex2){
		     
		    System.out.println(ex2.getMessage());
		} 
	     return lines;
	  }
}	
