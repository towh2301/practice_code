
import java.util.*;
import java.io.*;

class distinct_values {
	static InputReader rd = new InputReader(System.in);

	public static void main(String[] args) {
				int a = rd.nextInt();
				int[] arr = new int[a];
				arr = input(a);
				Arrays.sort(arr);
				appearCheck(arr);
				
	}

	// appearCheck;
	public static void appearCheck(int[] a) {
		int[] arr = new int[2000000000];
		for (int i = 0; i < a.length; i++) {
			arr[a[i]]++;
		}
		for (int i = arr.length-1; i >=0 ; i++)
			if(arr[i]!=0) {
				System.out.print(i + " " + arr[i]);
				System.out.println();
			}
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
