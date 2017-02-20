package epam.javatr.circle.circle;

import java.util.ArrayList;
import java.util.List;

public class Circle {

	private List<Double> rlist;
	
	public Circle(List<String> strlist){
		rlist = new ArrayList<Double>(strlist.size());
		for (String myInt : strlist) { 
		rlist.add(Double.valueOf(myInt)); 
		}	
	};
	
	public void setRadius(List<Double> n){
		rlist=n;
	}
	
	public List<Double> getRadius(){
		return rlist;
	}
}
