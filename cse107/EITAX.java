import java.util.Scanner;

public class EITAX {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double[] level = { 80, 52, 32, 18, 10, 5, 0 };
        double[] taxes = { 0.35, 0.3, 0.25, 0.2, 0.15, 0.1, 0.05 };
        double amount = sc.nextDouble() / 1000000 - 9;
        double totalTax = 0;
        for (int i = 0; i < level.length; i++) {
            if (amount > level[i]) {
                totalTax += (amount - level[i]) * taxes[i];
                for (int j = i + 1; j < level.length; j++) {
                    totalTax += (level[j - 1] - level[j]) * taxes[j];
                }
                break;
            }
        }
        System.out.println(Math.round(totalTax * 1000000));
    }
}
