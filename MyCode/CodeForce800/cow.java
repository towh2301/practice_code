import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class cow {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args){
            long n = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();
            long result;

            for (; n > 0; n--) {
                long x = sc.nextLong();
                long y = sc.nextLong();
                long r = sc.nextLong();

                result = (long) Math.floor((Math.sqrt(Math.pow((x - a), 2) + Math.pow((y - b), 2)) )) - r - 1;

                if(result < 0) result = 0;
                stringBuilder.append(result).append("\n");
            }
            System.out.println(stringBuilder);
        }



//        int result;
//        int countLine = 0;
//        int n = 0, a = 0, b = 0;
//
//        try {
//            sc = new Scanner(new File("cow.inp"));
//            while (sc.hasNext() && countLine < 1) {
//                n = sc.nextInt();
//                a = sc.nextInt();
//                b = sc.nextInt();
//                countLine++;
//            }
//
//            while (sc.hasNext()) {
//                for (; n > 0; n--) {
//                    int x = sc.nextInt();
//                    int y = sc.nextInt();
//                    int r = sc.nextInt();
//
//                    result = (int) Math.sqrt(Math.pow((x - a), 2) + Math.pow((y - b), 2)) - r;
//                    stringBuilder.append(result).append("\n");
//                }
//                countLine++;
//            }
//
//        } finally {
//            sc.close();
//        }
//
//        try {
//            File myFile  = new File("cow.out");
//            if(myFile.createNewFile()) {
//                try (FileWriter obj = new FileWriter("cow.out")) {
//                    obj.write(String.valueOf(stringBuilder));
//                }
//            }
//        } catch (IOException e){
//            System.out.println("Unsuccessfully!");
//        }
}

