package epam.javatr.thousand.main;

import java.util.List;

import epam.javatr.thousand.file.FileRead;
import epam.javatr.thousand.multiplicate.Multiplication;
import epam.javatr.thousand.numlist.NumberList;
import epam.javatr.thousand.numtest.NumberTest;
import epam.javatr.thousand.write.FileWrite;

public class Main {

	public static void main(String[] args)  {
		
		FileRead fileread = new FileRead();
		List<String> strread=fileread.getFileNumber();
		
		NumberTest numtest = new NumberTest();
		List<String> strclear = numtest.testNumber(strread);
		
		NumberList number = new NumberList(strclear);
		List<Integer> numlist = number.getNumber();
		
		Multiplication multi = new Multiplication();
		String msgout = multi.multiplicateDigits(numlist);

		FileWrite strwrite = new FileWrite();
		strwrite.setFileNumber(msgout);

	}

}
