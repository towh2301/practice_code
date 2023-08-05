import java.util.*;
import java.io.*;

class EICREDIT {
	static StringBuilder sBuilder = new StringBuilder();
	static Scanner sc = new Scanner(System.in);
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int numOfStudent = sc.nextInt();
		//sc.next();
		int avg = 0;
		int count = 0;
		for (int i = 1; i <= numOfStudent; i++) {
			
			//
			String studentName = sc.next();
			sBuilder.append(studentName + " ");
			int numberOfCourse = sc.nextInt();
			int[] scoreArr = new int[numberOfCourse];
			scoreArr = InputUtils(scoreArr);

			//
			for (int j = 0; j < scoreArr.length; j++) {
				if (scoreArr[j] >= 50) {
					sBuilder.append(scoreArr[j] + " ");
					avg = avg + scoreArr[j];
					count+=1;
				}
			}

			// avg
			if (count > 0) {
				//avg = avg / count;
				sBuilder.append(avg / count +"\n");
			} else
				sBuilder.append("0\n");
			
			//
			avg = 0;
			count = 0;
		}
		
		//
		System.out.println(sBuilder);
	}

	public static void output(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static List<Integer> input(List<Integer> temp, int n) {
		for (int i = 0; i < n; i++) {
			temp.add(sc.nextInt());
		}
		return temp;
	}

	public static int[] InputUtils(int[] numOfScore) {
		int[] temp = new int[numOfScore.length];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = sc.nextInt();
		}
		return temp;
	}

	public static class InputReader {
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
