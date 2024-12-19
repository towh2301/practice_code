import java.util.Scanner;

class EIDISCOU {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double amount = sc.nextLong();
        System.out.println(countDiscount(amount));
    }

    public static long countDiscount(double amount) {
        double[] partOfAmount = { 500000000, 200000000, 100000000, 50000000, 10000000, 2000000 };
        double[] discounts = { 0.15, 0.12, 0.1, 0.07, 0.05, 0.03 };

        // Compare each level
        double totalDiscount = 0;
        for (var i = 0; i < partOfAmount.length; i++) {
            if (amount > partOfAmount[i]) {
                totalDiscount += (amount - partOfAmount[i]) * discounts[i];
                for (var j = i + 1; j < partOfAmount.length; j++) {
                    totalDiscount += (partOfAmount[j - 1] - partOfAmount[j]) * discounts[j];
                }
                break;
            }
        }

        return Math.round((amount - totalDiscount));
    }
}
