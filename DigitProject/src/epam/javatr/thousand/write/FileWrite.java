package epam.javatr.thousand.write;

import java.io.*;

public class FileWrite {
 
    public void setFileNumber(String str) {
    	
    	final String fileout = "./data/writeNumber.txt";

        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileout))) {
            String inputline = null;
            
            	if(str==""){
            	  inputline="There are no numbers!";
            	} else { inputline=str; }
            	
            out.write(inputline);
            out.newLine();
            out.close();
            } 

    	catch(FileNotFoundException ex){
		    System.out.println(ex.getMessage());
		} 
		catch(IOException ex2){
		    System.out.println(ex2.getMessage());
		} 

    } 
}

