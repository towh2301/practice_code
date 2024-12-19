import java.util.Scanner;

class EIUTRAN1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String part1 = sc.next();
        String part2 = sc.next();

        System.out.println(translate(part1, part2));
    }

    public static String translate(String part1, String part2) {
        if (part1.length() == part2.length()) {
            for (int i = 0; i < part1.length(); i++) {
                if (part1.charAt(i) != part2.charAt(part2.length() - 1 - i))
                    return "NO";
            }
            return "YES";
        }
        return "NO";
    }
}
