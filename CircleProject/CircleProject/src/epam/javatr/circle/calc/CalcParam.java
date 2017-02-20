package epam.javatr.circle.calc;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

import java.text.DecimalFormat;
import java.util.List;

public class CalcParam {
	
	public double calcCircleLentgh(double r){
		
		double cLength;
		cLength = 2 * PI * r;
		return cLength;
	}
	
    public double calcCircleSquare(double r){
		
		double cSquare;
		cSquare = PI * pow(r,2);
		return cSquare;
	}
    
    
    public String getParams(List<Double> numlist){
    	String msg="";
		for (int i=0; i<numlist.size(); i++){
			double l = this.calcCircleLentgh(numlist.get(i));
			double s = this.calcCircleSquare(numlist.get(i));
			
			String pattern = "##0.00";
			DecimalFormat decimalFormat = new DecimalFormat(pattern);
			String lf = decimalFormat.format(l);
			String sf = decimalFormat.format(s);
			
			msg+=("The cicle radius is: "+numlist.get(i)+"\r\n"+"The length of the circle is: "+lf+"\r\n"+"The square of the circle is: "+sf+"\r\n"+"\r\n");
		}
		return msg;
	}
}
