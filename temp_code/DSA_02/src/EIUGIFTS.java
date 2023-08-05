import java.util.*;
import java.io.*;

class EIUGIFTS {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfItems = reader.nextInt();
		int amountOfMoney = reader.nextInt();

		SelectGifts gifts = new SelectGifts();
		gifts.addMoney(amountOfMoney);
		for (int i = 0; i < numberOfItems; i++) {
			gifts.addGifts(reader.nextInt());
		}

		gifts.calculateBestChoice();

		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(gifts);

		System.out.print(sBuilder);

	}

	static class SelectGifts {

		public int items, amountOfMoney, outputTotal, outputSurplus;
		public List<Integer> itemsList;

		public SelectGifts() {
			this.itemsList = new ArrayList<>();
		}

		public void addGifts(int items) {
			this.itemsList.add(items);
		}

		public void addMoney(int money) {
			this.amountOfMoney = money;
		}

		public void calculateBestChoice() {
			//
			this.itemsList.sort((s1, s2) -> {
				int compare = Integer.compare(s2, s1);
				return compare;
			});

			//
			int tempTotal = 0;
			int tempSurplus = this.amountOfMoney;

			//
			int a = 0;
			for (int i = 1; i < this.itemsList.size(); i++) {
				if (this.itemsList.get(a) >= this.amountOfMoney) {
					a += 1;
				} else {
					tempTotal = this.itemsList.get(a) + this.itemsList.get(i);
					if (tempTotal <= this.amountOfMoney) {
						tempSurplus = this.itemsList.get(a) - this.itemsList.get(i);
						this.outputSurplus = tempSurplus;
						this.outputTotal = tempTotal;
						break;
					}
				}
			}

			//
			int j = a + 2;
			a = a + 1;
			while (j < this.itemsList.size()) {
				tempTotal = this.itemsList.get(a) + this.itemsList.get(j);
				
				if (tempTotal > this.amountOfMoney) {
					j++;
					continue;
				} else if (tempSurplus < this.outputSurplus && tempTotal >= this.outputTotal) {
					this.outputTotal = tempTotal;
					//tempSurplus = this.itemsList.get(a) - this.itemsList.get(j);
					this.outputSurplus = tempSurplus;
					a = a + 1;
					j = a + 1;
				} else if (tempTotal < this.outputTotal) {
					break;
				}

			}

		}

		@Override
		public String toString() {
			StringBuilder sBuilder = new StringBuilder();
			if (this.outputTotal == 0) {
				sBuilder.append(-1).append(" ").append(-1);
			} else {
				sBuilder.append(this.outputTotal).append(" ").append(this.outputSurplus);
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
