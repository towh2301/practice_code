import java.util.Scanner;

public class EIUFING {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = scanner.nextInt();
        findFinger(randomNumber);
    }

    static void findFinger(int randomNumber) {
        String[] finger = { "cai", "tro", "giua", "ap ut", "ut", "ut", "ap ut", "giua", "tro", "cai" };
        String[] ind = { "trai", "phai" };

        int fingerNumber = randomNumber % 18;

        if (10 < fingerNumber && fingerNumber <= 18) {
            fingerNumber = 20 - fingerNumber;
        }
        int index = (fingerNumber > 5) ? 1 : 0;

        System.out.printf("Ngon %s cua ban tay %s", finger[fingerNumber - 1], ind[index]);
    }
}
