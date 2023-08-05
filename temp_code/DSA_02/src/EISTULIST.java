import java.io.*;
import java.util.*;

public class EISTULIST {
	static Scanner sc = new Scanner(System.in);
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sBuilder = new StringBuilder();

	public static void main(String[] args) {
		String input = sc.nextLine();
		//StringTokenizer sToken = new StringTokenizer(input);
		String[] arrayInput = input.split(" ");
		HashMap<String, String> mapOfStudent = new HashMap<>();

		String numberOfStudent = arrayInput[0];
		int a = 1;
		while (a < arrayInput.length) {
			// String[] arrayString = nameList[i].split(" ");
			mapOfStudent.put(arrayInput[a], arrayInput[a + 1] + " " + arrayInput[a + 2] + " " + arrayInput[a + 3]);
			a = a+4;
		}
		// String[] nameList = new String[numberOfStudent];
		// nameList = inputUtils(numberOfStudent);

//		for(int i = 0; i<numberOfStudent; i++) {
//			String[] arrayString = nameList[i].split(" ");
//				mapOfStudent.put(arrayString[0], arrayString[1]+" "+arrayString[2]+" "+arrayString[3]);								
//		}
		// System.out.println(mapOfStudent);

		List<String> nameKey = new ArrayList<String>(mapOfStudent.keySet());
		Collections.sort(nameKey);
		for (int i = 0; i < nameKey.size(); i++) {
			sBuilder.append(nameKey.get(i) + " " + mapOfStudent.get(nameKey.get(i)) + "\n");
		}

		System.out.println(sBuilder);
	}

//	public static String[] inputUtils(int numOfStudent) {
//		String[] tempArray = new String[numOfStudent];
//		for (int i = 0; i < numOfStudent; i++) {
//			String[] temp = sc.nextLine().split();
//			tempArray[i] = temp;
//			System.out.println();
//		}
//		return tempArray;
//	}

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
