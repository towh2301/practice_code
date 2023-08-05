package dsa_01;

import java.io.*;
import java.util.*;

public class Polynomial {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int t = reader.nextInt();
		if (1 <= t && t <= 1000) {
			for(int i = 1; i<=t; i++) {
				int n = reader.nextInt();
				double x = reader.nextDouble();
				if (n < 100 && x < 1000) {
					double[] valueOfA = new double[n + 1];
					valueOfA = input(valueOfA);
					double P = sum(n, x, valueOfA);
					System.out.println();
					System.out.println(P);
				}			
			}
		}
		

	}

	// sum
	public static double sum(int n, double x, double[] a) {
		double P = 0;
		for (int i = 0; i < a.length; i++) {
			P = P + a[i] * exponent(n, x);
			n--;
		}
		return P;
	}

	// input
	public static double[] input(double[] a) {
		double[] arr = new double[a.length];
		for (int i = 0; i < a.length; i++)
			arr[i] = reader.nextDouble();
		return arr;
	}

	// exponents
	public static double exponent(int n, double x) {
		double valueEx = 1;
		if(n==0)
			return valueEx;
		else
		for (int i = n; i > 0; i--)
			valueEx *= x;
		
		return valueEx;
	}

	// InputReader
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
