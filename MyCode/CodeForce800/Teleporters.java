import java.util.*;

public class Teleporters {
    public static void main(String[] args) {
        StringBuilder sBuilder = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        //
        for(; tests > 0 ; tests--){
            //initialize variables
            long teleports = sc.nextInt();
            long coins = sc.nextInt();
            List<Long> arr = new ArrayList<>();

            //add to array
            int temp = 0;
            for(int i = 0; i < teleports; i++){
                arr.add(i + sc.nextLong() +1);
            }

            //
            Collections.sort(arr);
            for (Long num : arr) {
                coins -= num;
                if (coins >= 0) temp++;
            }

            sBuilder.append(temp).append("\n");
        }
        System.out.println(sBuilder);
        sc.close();
    }
}
