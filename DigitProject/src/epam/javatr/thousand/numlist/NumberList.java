package epam.javatr.thousand.numlist;

import java.util.List;
import java.util.ArrayList;

public class NumberList {

		private List<Integer> numlist;
		
		public NumberList(List<String> strlist){
			numlist = new ArrayList<Integer>(strlist.size());
			for (String myInt : strlist) { 
			numlist.add(Integer.valueOf(myInt)); 
			}	
		};
		
		public void setNumber(List<Integer> n){
			numlist=n;
		}
		
		public List<Integer> getNumber(){
			return numlist;
		}

}
