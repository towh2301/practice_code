import java.util.Scanner;
 
public class common_number {
static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int[] num = input();	
		int[] appear = appearCheck(num);		
		int hz = maxAppearCheck(appear);
		int[] idx = idxmaxappear(hz, appear);
		result(idx, num, hz);
	}
	//input
	public static int[] input () {
		int[] arr = new int[sc.nextInt()];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		return arr;
	}

	//Check appear
	public static int[] appearCheck(int[]a) {
		int dem=0;
		int[] appear=new int[a.length];
		for(int i = 0; i<a.length; i++) {
			for(int e = 0; e<a.length; e++) {
				if(a[i]==a[e]) {
					dem++;
				}				
			}
			appear[i]=dem;
			dem=0;	
		}
		return appear;
	}

	//appear max
	public static int maxAppearCheck(int[]appearcheck) {
		int max=appearcheck[0];
		for(int i = 1; i<appearcheck.length; i++) {
			if(appearcheck[i] > max) {
				max = appearcheck[i];
			}
		}
		return max;
	}

	//max appear index
	public static int[] idxmaxappear(int a, int[] b) {
		int[] idx = new int[b.length];
		int idx1=0;
		for (int i = 0; i<b.length; i++) {
			if(a==b[i]) {
				idx[idx1]=i;
				idx1++;
			}
		}
		return idx;
	}
	
	//compare value of index
	public static void result(int[] idxmaxappear, int[]num, int a ) {
		int number=num[idxmaxappear[0]];
		
		for(int i = 0; i<idxmaxappear.length; i++) {
			if(number>num[idxmaxappear[i]]) {
				number=num[idxmaxappear[i]];
				
			}
				
		}
		System.out.println(number + " " + a);
	}
}
