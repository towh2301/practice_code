import java.util.Scanner;

class EIDISCOUNT2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double amount = sc.nextDouble();
        System.out.println(countDiscount(amount));
    }

    public static long countDiscount(double amount) {
        double[] partOfAmount = { 80000000, 52000000, 32000000, 18000000, 10000000, 5000000, 0 };
        double[] discounts = { 0.65, 0.7, 0.75, 0.8, 0.85, 0.9, 0.95 };

        // Compare each level
        double salary = amount - 11000000;
        double net = 0;
        long gross = 0;
        for (var i = 0; i < partOfAmount.length; i++) {
            if (salary > partOfAmount[i]) {
                net += (salary - partOfAmount[i]) / discounts[i];
                for (var j = i + 1; j < partOfAmount.length; j++) {
                    net += (partOfAmount[j - 1] - partOfAmount[j]) / discounts[j];
                }
                gross = (long) (Math.ceil(net / 1000000) * 1000000 + 11000000);
                break;
                // gross - partOfAmount[i] > partOfAmount[i + 1] && i != 0
            }
        }
        return gross;
    }

}
