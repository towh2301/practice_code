package array;

import java.util.Random;
import java.util.Scanner;

public class arrayBasic {
	
	static Random rd = new Random();
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sBuilder = new StringBuilder();
	
	public static void main(String[] args) {
		int[] array = new int[20]; 
		array = input(array);
		output(array);
	}
	
	public static int[] input(int[] temp) {
		int[] temp1 = new int[temp.length];
		for(int i = 0; i<temp1.length; i++) {
			//temp1[i] = sc.nextInt();
			temp1[i] = (rd.nextInt(10) - 5);
		}
		return temp1;
	}
	
	public static void output(int[] temp) {
		for(int i = 0; i<temp.length; i++) {
			sBuilder.append(temp[i]).append(" ");
		}
		System.out.println(sBuilder);
	}
	
	
	
	
}
