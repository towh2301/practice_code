import java.util.*;
import java.io.*;

public class EiuAppear {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sBuilder = new StringBuilder();

	public static void main(String[] args) {
		Integer numOfStudents = reader.nextInt();
		String studentsInput = reader.next();
		String[] studenStringsArray = studentsInput.split(" ");
		String[] studenStringsArray1 = studentsInput.split("\t");
		String[] studenStringsArray2 = studentsInput.split("\n");
		String[] studenStringsArray3 = studentsInput.split("\r");
		//StringTokenizer split = new StringTokenizer(studentsInput);
		// StringTokenizer split = new StringTokenizer(studentsInput, " ", "\t", "\n",
		// "\r");
		// List<Integer> tempStudentNumList = new ArrayList<>();
		// studentsInput.split(new char[] {' ', '\t', '\n', '\r'},
		// StringSplitOptions.RemoveEmptyEntries);
		
		List<String> studentNumList = new ArrayList<>(Arrays.asList(studenStringsArray3));
		for(String element : studentNumList) {
            System.out.println(element);
        }

		//InputUtils(numOfStudents, studentNumList);
		Collections.sort(studentNumList);
		int i = studentNumList.size() - 1;
		while (i >= 0) {
			int count = 1;
			for (int j = i; j > 0; j--) {
				if (studentNumList.get(j) == studentNumList.get(j - 1)) {
					count++;
					continue;
				} else
					break;
			}

			System.out.println(studentNumList.get(i) + " " + count);
			i = i - count;
		}
	}

	public static List<String> InputUtils(Integer numOfStudent, List<String> students) {
		for (int i = 0; i < numOfStudent; i++) {
			students.add(i, reader.next());
		}
		return students;
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
