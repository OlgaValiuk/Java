package epam.javatr.circle.rtest;

import java.util.List;

public class RadiusTest {

public List<String> testRadius(List<String> str){
		
		int i=0;
		while (i<str.size()){
		
		try {
			 double num=Double.parseDouble(str.get(i));
			
			 if (num>0 ) {
				i++;
			 } else str.remove(i);
		 }
		 catch (NumberFormatException ex3){
			str.remove(i);
		 }
		
		}
		return str;
	} 
}
