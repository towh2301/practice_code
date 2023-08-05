package dsa_01;

import java.util.*;

import java.io.*;

public class ShortPages {

	static InputReader reader = new InputReader(System.in);
	static StringBuilder sBuilder = new StringBuilder();

	public static void main(String[] args) {
		int numberOfPages = reader.nextInt();
		int[] listOfPages = new int[numberOfPages];

		listOfPages = PagesInputUtils(numberOfPages);
		Arrays.sort(listOfPages);

		PagesShortening(listOfPages);

	}

	public static void PagesShortening(int[] a) {
//		if (listOfPages.length <= 3) {
//			if (listOfPages.length == 1)
//				System.out.print(listOfPages[0]);
//			if (listOfPages.length == 2)
//				System.out.print(listOfPages[0] + " " + listOfPages[1]);
//		}
//
//		else {
		int currentPage = 1;
		int previousPage;
		int temp = 0;
		int tempFirstPage = 0;
		int tempLastPage = 0;

		// while (currentPage < listOfPages.length) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 1; j < a.length; j++) {
				if (a[j] - a[i] == 1) {
					temp++;
					break;
				} else {
					if (temp >= 2) {
						System.out.print(a[j - temp] + "-" + a[i]);
					} else
						System.out.print(a[i] + " ");
				}
			}

		}

	}

	public static boolean checkPages(int a, int b) {
		if (b - a == 1)
			return true;
		return false;
	}

	public static int[] PagesInputUtils(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = reader.nextInt();
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
