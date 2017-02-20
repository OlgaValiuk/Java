package epam.javatr.circle.main;

import java.util.List;

import epam.javatr.circle.calc.CalcParam;
import epam.javatr.circle.circle.Circle;
import epam.javatr.circle.fileread.FileRead;
import epam.javatr.circle.filewrite.FileWrite;
import epam.javatr.circle.rtest.RadiusTest;

public class Main {

	public static void main(String[] args) {
		
		FileRead fileread = new FileRead();
		List<String> strread=fileread.getFileNumber();
		
		RadiusTest rtest = new RadiusTest();
		List<String> strclear = rtest.testRadius(strread);
		
		Circle circle = new Circle(strclear);
		List<Double> rlist = circle.getRadius();
		
		CalcParam calcparam = new CalcParam();
		String msgout = calcparam.getParams(rlist);

		FileWrite strwrite = new FileWrite();
		strwrite.setFileNumber(msgout);
	}

}
