import java.util.Scanner;

class most_prequent_Element {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] num = input();
        mostCommonNum(num);
    }

    // input
    public static int[] input() {
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    /*// most common element
    public static void frequentElement(int[] a) {
        int count = 0;
        int value = 0;
        int n = 0;
        int[] arrays = new int[a.length];        
        for (int i = 0; i < a.length; i++) {
            int Count2 = 0;
            int Value2 = a[i];
            
            if (isValueExist(arrays, a[i])==false) {
                for (int e = 0; e < a.length; e++)
                    if (Value2 == a[e])
                        Count2++;
                if (Count2 > count) {
                    value = Value2;
                    count = Count2;
                } else if (Count2 == count && value > Value2) {
                    value = Value2;
                    count = Count2;
                }
            }
            arrays[n] = a[i];
            n += 1;
        }
        System.out.print(value + " " + count);

    }

    // hàm xét xem giá trị đó có hay chưa
    public static boolean isValueExist(int[] arrays, int a) {
        if (a != 0) {
            for (int i = 0; i < arrays.length; i++) {
                if (a == arrays[i])
                    return true;
            }
            return false;
        } else
            return false;
    }*/
    
    public static void mostCommonNum(int[] a) {
    	int[] arr = new int[1000000]; 	 
    	for (int i = 0; i<arr.length; i++) {
    		arr[i]=0;
    	}
    	for (int i = 0; i<a.length; i++) {
    		arr[a[i]]=arr[a[i]]+1;
    	}
    	int idx = maxArray(arr);
    	int hz = arr[idx];
    	
    	System.out.print(idx + " " + hz  );
    }
    
    //find max
    public static int maxArray(int[] a) {
    	int max = a[0];
    	int idx = 0;
    	for(int i = 0; i<a.length; i++) {
    		if(a[i]>max) {
    			max=a[i];
    			idx = i;
    		}
    	}
    	return idx;
    }

}