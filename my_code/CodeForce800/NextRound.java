import java.util.Scanner;
public class NextRound {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int contestant = sc.nextInt();
        int place = sc.nextInt();
        int passNum = 0;
        int[] scoreList = new int[contestant];

        for(int i = 0; i<contestant;i++){
            scoreList[i] = sc.nextInt();
        }
        for(int i = 0; i<contestant; i++){
            if(scoreList[i] >= scoreList[place-1] && scoreList[i] != 0){
                passNum++;

            }
       }

        System.out.println(passNum);
    }
}