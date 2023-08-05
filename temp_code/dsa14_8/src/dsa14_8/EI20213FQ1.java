package dsa14_8;

import java.util.*;
import java.io.*;

public class EI20213FQ1 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder sBuilder;

	public static void main(String[] args) {
		int transactionCode, productCode, quantity;
		double sellingPrice; 
		int numberOfTransactions = reader.nextInt();
		SaveTransElements transElements = new SaveTransElements();
		for(int i = 0; i<numberOfTransactions; i++) {
			transactionCode = reader.nextInt();
			productCode = reader.nextInt();			
			sellingPrice = reader.nextDouble();
			quantity = reader.nextInt();
			transElements.inputPrice(productCode, sellingPrice, quantity);
			transElements.inputQuantity(productCode, quantity);
		}
		
		transElements.countAvgSellingPrice();		
		sBuilder = new StringBuilder();
		sBuilder.append(transElements);
		System.out.println(sBuilder);
	}

	public static class SaveTransElements {
		private HashMap<Integer, Double> mapPrice;
		private HashMap<Integer, Integer> mapQuantity;
		private HashMap<Integer, Double> mapResult;

		public SaveTransElements() {
			this.mapPrice = new HashMap<>();
			this.mapQuantity = new HashMap<>();
			this.mapResult = new HashMap<>();
		}

		public void inputPrice(int productCode, double sellingPrice, int quantity) {
			double count = 0;
			if(this.mapPrice.containsKey(productCode) == false) {
				this.mapPrice.put(productCode, sellingPrice*quantity);
			}else {
				count = this.mapPrice.get(productCode) + sellingPrice*quantity;
				this.mapPrice.replace(productCode, count);
			}
		}
		
		public void inputQuantity(int productCode, int quantity) {
			int count = 0;
			if(this.mapQuantity.containsKey(productCode) == false) {
				this.mapQuantity.put(productCode, quantity);
			}else {
				count = this.mapQuantity.get(productCode) + quantity;
				this.mapQuantity.replace(productCode, count);
			}
		}
				
		public void countAvgSellingPrice() {
			List<Integer> listCode = new ArrayList<>(this.mapPrice.keySet());
			double avg = 0;
			for(Integer code : listCode) {
				avg = this.mapPrice.get(code)/this.mapQuantity.get(code);
				this.mapResult.put(code, avg);
			}			
		}

		@Override
		public String toString() {			
			List<Integer> listCode = new ArrayList<>(this.mapResult.keySet());
			sBuilder = new StringBuilder();
			for(Integer code : listCode) {
				sBuilder.append(code).append(" ").append(this.mapResult.get(code)).append("\n");
			}
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
