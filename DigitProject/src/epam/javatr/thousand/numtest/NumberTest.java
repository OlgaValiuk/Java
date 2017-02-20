package epam.javatr.thousand.numtest;

import static java.lang.Math.abs;
import java.util.List;

public class NumberTest {
	
	public List<String> testNumber(List<String> str){
		
		int i=0;
		while (i<str.size()){
		
		try {
			 int num=Integer.parseInt(str.get(i));
			
			 if ((num>=1000 && num<=9999) || (num>=-9999 && num<=-1000) ) {
				num=abs(num);
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
