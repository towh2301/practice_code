package dsa_01;

import java.util.*;

class EIUCream {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		long numOfCream = sc.nextLong();
		long creamForPromotion = sc.nextLong();
		long tempCream = numOfCream;
		if (numOfCream < creamForPromotion) {
			System.out.print(numOfCream);
		} else if (numOfCream == creamForPromotion) {
			System.out.print(numOfCream+1);
		} else {
			while (numOfCream > 1 && numOfCream >= creamForPromotion) {
				tempCream = tempCream + numOfCream / creamForPromotion;
				numOfCream = numOfCream / creamForPromotion + numOfCream % creamForPromotion;
			}

			System.out.println(tempCream);
		}

	}

}
