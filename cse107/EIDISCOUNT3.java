import java.util.Scanner;

class EIDISCOUNT3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double amount = sc.nextLong();
        System.out.println(solve(amount));
    }

    public static long solve(double amount) {
        double afterDiscount = countDiscount(amount);
        afterDiscount = (sc.nextInt() > 0) ? afterDiscount - afterDiscount * 0.02 : afterDiscount;
        afterDiscount = (sc.nextInt() > 0) ? afterDiscount - afterDiscount * 0.02 : afterDiscount;
        afterDiscount = (sc.nextInt() > 0) ? afterDiscount - afterDiscount * 0.02 : afterDiscount;
        return (long) afterDiscount;
    }

    public static long countDiscount(double amount) {
        double[] partOfAmount = { 900000000, 600000000, 300000000, 100000000, 20000000, 5000000 };
        double[] discounts = { 0.15, 0.12, 0.1, 0.07, 0.05, 0.03 };
        double tempAmount = amount;

        // Compare each level
        double totalDiscount = 0;
        for (var i = 0; i < partOfAmount.length; i++) {
            if (amount > partOfAmount[i]) {
                totalDiscount += (tempAmount - partOfAmount[i]) * discounts[i];
                tempAmount = partOfAmount[i];
            }
        }

        return Math.round((amount - totalDiscount));
    }
}
