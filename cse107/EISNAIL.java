import java.util.Scanner;

public class EISNAIL {
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        long a = reader.nextInt();
        long b = reader.nextInt();
        long v = reader.nextInt();
        System.out.println(countDay(a, b, v));
    }

    public static long countDay(long climbed, long dropped, long height) {
        long originalClimbedDay = (long) Math.ceil((double) height / (double) (climbed - dropped));
        long lastDayClimbed = (long) Math.round((double) climbed / (double) (climbed - dropped));

        if (originalClimbedDay * climbed + dropped >= height) {
            return originalClimbedDay;
        }
        return originalClimbedDay + lastDayClimbed;
    }
}
