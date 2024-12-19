import java.util.Scanner;

/**
 * EILTGRADE
 */
class EILTGRADE {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int grade = sc.nextInt();
        System.out.println(calGrade(grade));
    }

    public static String calGrade(int score) {
        if (score >= 90 && score <= 100) {
            return "A";
        } else if (score >= 85 && score < 90) {
            return "A-";
        } else if (score >= 80 && score < 85) {
            return "B+";
        } else if (score >= 75 && score < 80) {
            return "B";
        } else if (score >= 70 && score < 75) {
            return "B-";
        } else if (score >= 65 && score < 70) {
            return "C+";
        } else if (score >= 60 && score < 65) {
            return "C";
        } else if (score >= 55 && score < 60) {
            return "C-";
        } else if (score >= 53 && score < 55) {
            return "D+";
        } else if (score == 52) {
            return "D";
        } else if (score >= 50 && score < 52) {
            return "D-";
        } else if (score >= 0 && score < 50) {
            return "F";
        }
        return "";
    }
}