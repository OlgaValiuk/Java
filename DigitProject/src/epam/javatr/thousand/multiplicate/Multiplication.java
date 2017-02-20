package epam.javatr.thousand.multiplicate;

import java.util.List;

public class Multiplication {

	public String multiplicateDigits(List<Integer> numlist){
		
		String msg="";
		
		for (int i=0; i<numlist.size(); i++){
		
		int remainder=1;
		int multi=1;
		int num=numlist.get(i);
		
		while(num!=0){
			remainder=num%10;
			multi*=remainder;
			num/=10;
		}
	
		msg+=("The number is: "+numlist.get(i)+"\r\n"+"The multiplication of the digits: "+multi+"\r\n"+"\r\n");
		}
		
		return msg;
	}
}
