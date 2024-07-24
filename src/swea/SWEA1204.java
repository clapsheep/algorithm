package swea;


import java.util.Arrays;
import java.util.Scanner;

public class SWEA1204 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
	
		int[] arr = new int[1000];
		int [] temp = new int[1000];
		
	
		
		for (int testCase = 0; testCase < N; testCase++) {
			int T =  sc.nextInt();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			};
			for (int i = 0; i < arr.length; i++) {
				int count = 0;
				
				for (int j = 0; j < arr.length; j++) {
					if(arr[i] == arr[j]) {
						count++;
					}
				}
				temp[i]=count;
			}

			int max = 0;
			int index = -1;
				for(int i = 0 ; i<temp.length; i++) {
					max = Math.max(max,temp[i]);
				}

				for(int i = 0; i < temp.length; i++) {
					if(temp[i] == max) {
						index = i;
						break;
					}
				}
		
		
				System.out.println("#"+(testCase+1)+" "+arr[index]);
					
		}
	}
}
