package dsa21_8;

import java.io.*;
import java.util.*;

public class dob {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) throws IOException {
		int numOfDOB = reader.nextInt();
		HashMap<String, Integer> mapDob = new LinkedHashMap<>();
		List<Dob> listDOB = new ArrayList<>();
		Dob dob;

		for (int i = 0; i < numOfDOB; i++) {
			int day = reader.nextInt();
			int month = reader.nextInt();
			int year = reader.nextInt();
			dob = new Dob(day, month, year);
			listDOB.add(dob);
		}

		// sort
		listDOB.sort((s1, s2) -> {
			int compare = s1.year - s2.year;
			if (compare == 0) {
				compare = s1.month - s2.month;
				if (compare == 0) {
					compare = s1.day - s2.day;
				}
			}
			return compare;
		});
		
		for (Dob dob1 : listDOB) {
			int count = 0;
			String temp = dob1.toString();
			if(mapDob.containsKey(temp)) {
				count = 1 + mapDob.get(temp);
				mapDob.replace(temp, count);
			}else {
				mapDob.put(temp, 1);
			}
				
		}

		// print
		StringBuilder sBuilder = new StringBuilder();
		for (Map.Entry<String, Integer> map : mapDob.entrySet()) {
			sBuilder.append(map.getKey()).append(" ").append(map.getValue()).append("\n");
		}
		System.out.println(sBuilder);

	}

	public static class Dob {
		int day, month, year;

		public Dob(int day, int month, int year) {
			this.day = day;
			this.month = month;
			this.year = year;
		}

		public String toString() {
			StringBuilder sBuilder = new StringBuilder();
			if(day<10) {
				sBuilder.append("0"+day).append("/");
			}else {
				sBuilder.append(day).append("/");
			}
			if(month<10) {
				sBuilder.append("0"+month).append("/");
			}else {
				sBuilder.append(month).append("/");
			}
			sBuilder.append(year);
			return sBuilder.toString();
		}

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
