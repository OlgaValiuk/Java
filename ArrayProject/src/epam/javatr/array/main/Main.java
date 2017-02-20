/*Task5. Create a matrix n-size(n is an even number) */
package epam.javatr.array.main;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		System.out.print("Enter a number: ");
		Scanner scanner = new Scanner(System.in);
		
		try{
			int matricSize=scanner.nextInt();
			if (matricSize%2==0){
			int numAsc=matricSize;
			int numDesc=matricSize;
			
			int [] masAsc = new int[matricSize];
			
			for(int i=0; i<masAsc.length; i++){
				masAsc[i]=numAsc;
				numAsc--;
			}
			
			int [] masDesc = new int[matricSize];
			
			for(int i=masDesc.length-1; i>=0; i--){
				masDesc[i]=numDesc;
				numDesc--;
			}
				
			int [][] matric = new int[matricSize][matricSize];
			
			for(int i = 0; i<matric.length; i++){
				if (i%2==0){
					for(int j = 0; j<matric[i].length; j++){
						matric[i][j]=(int)(masDesc[j]);
					}
				}else{
				for(int j = 0; j<matric[i].length; j++){
					matric[i][j]=(int)(masAsc[j]);
					}
				}
			}
	
			System.out.println(matricSize+"-size matric: ");
			
			for(int[]i:matric){
				for(int j : i){
					System.out.print(j + " ");
				}
				System.out.println();
			}
			}
			else {
				System.out.println("Try again and input an even number!");
			}
		}
		catch (InputMismatchException e) {
			 System.out.println("Try again and input an integer number!");
			}
	}
}