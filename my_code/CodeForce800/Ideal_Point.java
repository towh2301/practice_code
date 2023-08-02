import java.util.*;
public class Ideal_Point {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        StringBuilder sBuilder = new StringBuilder();
        int cases = sc.nextInt();


        for(; cases > 0; cases--){
            int tests = sc.nextInt();
            int num = sc.nextInt();
            int acceptance = 0;

            for(int i = 0; i < tests; i++){
                int begin = sc.nextInt();
                int end = sc.nextInt();

                if(num >= begin && num <= end ) acceptance++;
            }
            if(acceptance >= 1 && tests - acceptance > 0) sBuilder.append("YES").append("\n");
            else sBuilder.append("NO").append("\n");
        }

        System.out.println(sBuilder);
    }
}
