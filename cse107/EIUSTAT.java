import java.util.Scanner;

class EIUSTAT {
    static Scanner reader = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int nStudent = reader.nextInt();
        count(nStudent);
        System.out.println(sb);
    }

    public static void count(int nStudent) {
        int nFinished = 0;
        int nFailed = 0;
        for (var i = 0; i < nStudent; i++) {
            String name = reader.next();
            int grade = reader.nextInt();
            if (grade >= 50) {
                nFinished += 1;
                sb.append(name).append("\n");
            } else {
                nFailed += 1;
            }
        }
        sb.append(nFinished).append(" ").append(nFailed);
    }
}
