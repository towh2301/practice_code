import java.util.*;
import java.io.*;

class EIUTHU {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws java.lang.Exception {
        String part_1 = sc.next();
        String part_2 = sc.next();

        // part_1 end with start of part_2
        concatAndCount(part_1, part_2);
    }
    
    public static void concatAndCount(String part_1, String part_2) {
        int l1 = part_1.length();
        int redundant = 0;

        // init length
        int length = (part_1.length() > part_2.length()) ? part_2.length() : part_1.length();

        for (int i = length; i > 0; i--) {
            int temp = l1 - i;
            if (part_2.substring(0, i).equals(part_1.substring(temp, l1))) {
                redundant = i;
                break;
            }
        }

        System.out.println(l1 + part_2.length() - redundant);
    }
}
