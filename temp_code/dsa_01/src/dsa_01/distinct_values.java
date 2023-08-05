package dsa_01;

import java.util.*;
import java.io.*;

class distinct_values {
	static InputReader rd = new InputReader(System.in);
	static StringBuilder sBuilder = new StringBuilder();

	public static void main(String[] args) {
		int t = rd.nextInt();
		if (t >= 1 && t <= 10) {
			while (t != 0) {
				int a = rd.nextInt();
				int[] arr = new int[a];
				arr = input(a);
				Arrays.sort(arr);
				for (int i = 0; i < arr.length; i++) {

				}
				compare(arr);
				System.out.println();
				t--;
			}
		}

	}

	// compare
	public static void compare(int[] a) {
		sBuilder = new StringBuilder();
		if(a[0]!=a[1])
			sBuilder.append(a[0] + " ");
		for (int i = 1; i < a.length-1; i++) {
			if (a[i] == a[i - 1]||a[i+1]==a[i])
				continue;
			else {
				sBuilder.append(a[i] + " ");
			}
		}
		if(a[a.length-1]!=a[a.length-2])
			sBuilder.append(a[a.length-1] + " ");
		System.out.print(sBuilder);
		
	}

	// appear check
	public static boolean Appear(int[] a, int idx, int num) {
		for (int i = idx; i > -1; i--) {
			if (a[i] == num)
				return false;
		}
		return true;

	}

	// find max
	public static int findMax(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (max < a[i])
				max = a[i];
		}
		return max;
	}

	// appearCheck;
	public static void appearCheck(int[] a, int max) {
		sBuilder = new StringBuilder();
		int[] arr = new int[max + 1];
		for (int i = 0; i < a.length; i++) {
			arr[a[i]]++;
		}
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == 1)
				sBuilder.append(i + " ");
		System.out.print(sBuilder);
	}

	// input
	public static int[] input(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = rd.nextInt();
		return arr;
	}

	// input reader
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
