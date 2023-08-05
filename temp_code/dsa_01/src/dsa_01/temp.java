package dsa_01;

import java.util.*;
import java.io.*;

public class temp {
	static StringBuilder sBuilder = new StringBuilder();
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfGifts = reader.nextInt();
		int numberOfWrapping = reader.nextInt();
		int[] arrayOfGifts = new int[numberOfGifts];
		int[] arrayOfWrapping = new int[numberOfWrapping];
		int[] tempArrayOfGifts = new int[numberOfGifts];

		arrayOfGifts = UserInput(numberOfGifts);
		arrayOfWrapping = UserInput(numberOfWrapping);

		int a = SumOfInput(arrayOfWrapping);
		int b = SumOfInput(arrayOfGifts);

		SortIncreasing(arrayOfGifts);
		SortIncreasing(arrayOfWrapping);
		
		//ArrayPrinter(arrayOfWrapping);

		// case 1: gift x3
		int gift = 0;
		int gift1 = 0;
		int gift2 = 0;
		int gift3 = 0;
		int idx = tempArrayOfGifts.length-1;
		int temp = 0;
		tempArrayOfGifts = x3Element(arrayOfGifts);
		for (int i = arrayOfWrapping.length - 1; i>=0; i--) {
			gift = 0;
			temp = arrayOfWrapping[i];
			while (idx > -1 && temp >= 0) {
				temp =  temp - tempArrayOfGifts[idx];
				if (temp >= 0) {
					gift++;
				}	
				idx--;
			}
			if (gift > gift1)
				gift1 = gift;
		}

		// if(gift3>gift1)
		// System.out.println(gift3);
		// else
		System.out.println(gift1);

	}
	
	public static void ArrayPrinter(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++)
			sBuilder.append(inputArray[i] + " ");
		System.out.print(sBuilder);
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

	public static int[] UserInput(int inputNumber) {
		int[] tempArray = new int[inputNumber];
		for (int i = 0; i < tempArray.length; i++)
			tempArray[i] = reader.nextInt();
		return tempArray;
	}

	public static int SumOfInput(int[] InputArray) {
		int sumOfArray = 0;
		for (int i = 0; i < InputArray.length; i++) {
			sumOfArray += InputArray[i];
		}
		return sumOfArray;
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