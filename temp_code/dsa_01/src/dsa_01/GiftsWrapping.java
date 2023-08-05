package dsa_01;

import java.util.*;
import java.io.*;

public class GiftsWrapping {
	static StringBuilder sBuilder = new StringBuilder();
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfGifts = reader.nextInt();
		int numberOfWrapping = reader.nextInt();
		int[] arrayOfGifts = new int[numberOfGifts];
		int[] arrayOfWrapping = new int[numberOfWrapping];
		int[] tempArrayOfGifts = new int[numberOfGifts];
		int gift = 0;
		int gift1 = 0;
		int temp = 1;

		arrayOfGifts = UserInput(numberOfGifts);
		arrayOfWrapping = UserInput(numberOfWrapping);

		SortIncreasing(arrayOfGifts);
		SortDecreasing(arrayOfWrapping);
		
		tempArrayOfGifts = x2Element(arrayOfGifts);
		
		
		if(CompareMaxMin(arrayOfWrapping, tempArrayOfGifts) == true) {
			for(int i = 0; i<arrayOfWrapping.length; i++) {
				gift1 = 0;
				temp = 0;
				for(int j = 0; j < tempArrayOfGifts.length; j++) {
					temp = arrayOfWrapping[i] - tempArrayOfGifts[j];
					if(temp<0)
						break;
					else
						gift1++;
					if(gift1 > gift)
						gift = gift1;
					arrayOfWrapping[i] = arrayOfWrapping[i] - tempArrayOfGifts[j];
			}
		}
			
			
		}else {
			tempArrayOfGifts = x2Element(arrayOfGifts);
			for(int i = 0; i<arrayOfWrapping.length; i++) {
				gift1 = 0;
				temp = 0;
				
					for(int j = 0; j < tempArrayOfGifts.length; j++) {
						temp = arrayOfWrapping[i] - tempArrayOfGifts[j];
						if(temp<0)
							break;
						else
							gift1++;
						if(gift1 > gift)
							gift = gift1;
						arrayOfWrapping[i] = arrayOfWrapping[i] - tempArrayOfGifts[j];							
					
				}
			}
		}
		
		System.out.print(gift);
		

	}

	// for gifts
	public static int[] x3Element(int[] arrayOfGifts) {
		int[] tempArr = new int[arrayOfGifts.length];
		for (int i = 0; i < arrayOfGifts.length; i++) {
			arrayOfGifts[i] = arrayOfGifts[i] * 3;
		}
		tempArr = arrayOfGifts;
		return tempArr;
	}

	// for gifts
	public static int[] x2Element(int[] arrayOfGifts) {
		int[] tempArr = new int[arrayOfGifts.length];
		for (int i = 0; i < arrayOfGifts.length; i++) {
			arrayOfGifts[i] = arrayOfGifts[i] * 2;
		}
		tempArr = arrayOfGifts;
		return tempArr;
	}

	// Use this method to compare max of Wrapping and Min of Gifts(x2 or x3)
	public static boolean CompareMaxMin(int[] maxWrap, int[] minGifts) {
		if (maxWrap[maxWrap.length-1] > minGifts[0])
			return true;
		return false;
	}

	// Use this method in x3 or x2 arrayOfGifts's Elements
	public static int MinArrElement(int[] inputArray) {
		int tempMin = inputArray[0];
		for (int i = 0; i < inputArray.length; i++) {
			if (tempMin > inputArray[i])
				tempMin = inputArray[i];
		}
		return tempMin;
	}

	public static int MaxArrElement(int[] inputArray) {
		int tempMax = inputArray[0];
		for (int i = 0; i < inputArray.length; i++) {
			if (tempMax < inputArray[i])
				tempMax = inputArray[i];
		}
		return tempMax;
	}

	public static int[] SortIncreasing(int[] inputArray) {
		Arrays.sort(inputArray);
		for (int i = 0; i < inputArray.length; i++) {

		}
		return inputArray;
	}
	
	public static int[] SortDecreasing(int[] inputArray) {
		Arrays.sort(inputArray);
		for (int i = inputArray.length - 1; i >= 0; i--) {

		}
		return inputArray;
	}

	public static void ArrayPrinter(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++)
			sBuilder.append(inputArray[i] + " ");
		System.out.print(sBuilder);
	}

	public static int[] UserInput(int inputNumber) {
		int[] tempArray = new int[inputNumber];
		for (int i = 0; i < tempArray.length; i++)
			tempArray[i] = reader.nextInt();
		return tempArray;
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

}
