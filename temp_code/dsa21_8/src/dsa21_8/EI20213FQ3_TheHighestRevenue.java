package dsa21_8;

import java.io.*;
import java.util.*;

public class EI20213FQ3_TheHighestRevenue {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int numOfTrans = reader.nextInt();
		TransInfor transInfor;
		List<TransInfor> listTrans = new ArrayList<>();
		for (int i = 0; i < numOfTrans; i++) {
			String transCode = reader.next();
			int productCode = reader.nextInt();
			long sellingPrice = reader.nextInt();
			int quantity = reader.nextInt();
			transInfor = new TransInfor(productCode, sellingPrice, quantity);
			listTrans.add(transInfor);
		}

		// sort
		listTrans.sort((s1, s2) -> {
			int compare = s1.productCode - s2.productCode;
			if (compare == 0) {
				compare = Float.compare(s1.sellingPrice, s2.sellingPrice);
			}
			return compare;
		});

		//cal
		HighestRevenue revenue = new HighestRevenue();
		int tempCode = listTrans.get(0).productCode;
		for(int i = 0; i<listTrans.size(); i++) {
			if(listTrans.get(i).productCode == tempCode) {
				long tempPrice = listTrans.get(i).sellingPrice;
				int tempQuantity = listTrans.get(i).quantity;
				revenue.savePirce(tempPrice, tempQuantity);
				revenue.calRevenue(tempCode);
			}else {
				revenue.calRevenue(tempCode);
				tempCode=listTrans.get(i).productCode;
				revenue.mapSellingPrice = new HashMap<>();
				i--;
			}
		}
		

		//
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(revenue);
		System.out.println(sBuilder);

	}

	public static class HighestRevenue {
		HashMap<Long, Integer> mapSellingPrice;
		HashMap<Integer, String> codeAndPrice;

		public HighestRevenue() {
			this.mapSellingPrice = new HashMap<>();
			this.codeAndPrice = new LinkedHashMap<>();
		}

		public void savePirce(long tempPrice, int quantity) {
			int count = 0;
			//codeAndPrice.put(code, "");
			if (mapSellingPrice.containsKey(tempPrice)) {
				count = mapSellingPrice.get(tempPrice) + quantity;
				mapSellingPrice.replace( tempPrice, count);
			} else
				mapSellingPrice.put(tempPrice, quantity);
		}

		public void calRevenue(int code) {
			List<Long> keyPrice = new ArrayList<>(mapSellingPrice.keySet());
			float minPrice = 1000000;
			float maxRevenue = 0;
			
			//
			for (Long key : keyPrice) {
				float temp = key * mapSellingPrice.get(key);
				if(temp > maxRevenue) {
					maxRevenue = temp;
					minPrice = key;
				}else {
					if(temp == maxRevenue) {
						if(minPrice>key) {
							minPrice = key;
						}
					}
				}
			}
			
			//
			String revenue = Math.round(minPrice) + " " + Math.round(maxRevenue);
			codeAndPrice.put(code, revenue);
			//mapSellingPrice=new HashMap<>();
		}
		
		@Override
		public String toString() {
			StringBuilder sBuilder = new StringBuilder();
			for(Map.Entry<Integer, String> map : codeAndPrice.entrySet()) {
				sBuilder.append(map.getKey()).append(" ").append(map.getValue()).append("\n");
			}
			return sBuilder.toString();
		}

	}

	public static class TransInfor {
		int productCode, quantity;
		long revenue, sellingPrice;

		public TransInfor(int productCode, long sellingPrice, int quantity) {
			this.productCode = productCode;
			this.quantity = quantity;
			this.sellingPrice = sellingPrice;
			this.revenue = sellingPrice * quantity;
		}

		@Override
		public String toString() {
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append(productCode).append(" ").append(sellingPrice).append(" ").append(quantity).append("\n");
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
