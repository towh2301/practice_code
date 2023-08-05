import java.util.*;
import java.io.*;

public class PagesShorting {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sBuilder = new StringBuilder();

	public static void main(String[] args) {
		int numberOfPages = reader.nextInt();
		int[] listOfPages = new int[numberOfPages];

		listOfPages = input(numberOfPages);
		Arrays.sort(listOfPages);

		ShortestListOfPages(listOfPages);

	}

	public static void ShortestListOfPages(int[] listOfPages) {
		int i = 1;
		int temp = 1;
		int tempFirstVal = 0;
		int tempLastVal = 0;
		while (i < listOfPages.length) {
			if (checkPages(listOfPages[i - 1], listOfPages[i]) == true) {
				temp++;
				if (i != listOfPages.length - 1) {
					if (checkPages(listOfPages[i], listOfPages[i+1]) == true)
						temp++;		
					if (temp == 3) 
						tempFirstVal = listOfPages[i-1];
				}
				
				i++;
			} else {
				if (temp == 3) {
					tempFirstVal = listOfPages[i - 1];
					tempLastVal = listOfPages[i + 1];
					temp = 1;
					sBuilder.append(tempFirstVal + "-" + tempLastVal + " ");
				}else 
				if (temp>3){
					tempLastVal = listOfPages[i-2];
					temp = 1;
					sBuilder.append(tempFirstVal + "-" + tempLastVal + " ");
				} else if (temp == 2) {
					temp = 1;
					// sBuilder.append(listOfPages[i - 2] + " ");
					sBuilder.append(listOfPages[i - 1] + " ");
					sBuilder.append(listOfPages[i] + " ");
				} else {
					temp = 1;
					if (i == 1) {
						sBuilder.append(listOfPages[i - 1] + " ");
						sBuilder.append(listOfPages[i] + " ");
					} else
						sBuilder.append(listOfPages[i] + " ");

				}
				i++;

			}

		}System.out.print(sBuilder);

	}

	public static boolean checkPages(int a, int b) {
		if (b - a == 1)
			return true;
		return false;

	}

	public static int[] input(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = reader.nextInt();
		return arr;
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
