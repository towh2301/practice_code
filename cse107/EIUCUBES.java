import java.util.*;
import java.io.*;

class EIUCUBES {

    static Scanner sc = new Scanner(System.in);

    public static void main (String[] args) throws java.lang.Exception{
        int bricks = sc.nextInt();

        // 1 <= bricks <= 10000
        countPyramid(bricks);
    }
    
    public static void countPyramid(int bricks) {
        int bricksForLayer = 0;
        int currentLayer = 0;

        while (bricks >= bricksForLayer) {
            currentLayer += 1;

            // first count
            bricksForLayer = ((currentLayer + 1) * currentLayer) / 2;
            bricks -= bricksForLayer;

            // second count for condition
            bricksForLayer = ((currentLayer + 1 + 1) * (currentLayer + 1)) / 2;
        }
        
        System.out.println(currentLayer);
    }
}
