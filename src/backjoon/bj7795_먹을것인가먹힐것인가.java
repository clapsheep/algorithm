package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj7795_먹을것인가먹힐것인가 {
	static int T,A,B;
	static int[] listA,listB;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			listA = new int[A];
			listB = new int[B];
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < A; i++) {
				listA[i] = Integer.parseInt(st.nextToken()); 
			}
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < B; i++) {
				listB[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(listA);
			Arrays.sort(listB);
			int res = 0;
			for (int i = 0; i < A; i++) {
				int index= search(i);
//				System.out.println(index);
				res += index;
			}
			System.out.println(res);
					
		}
	}
	private static int search(int index) {
		int left = 0;
		int right = B;
		while(left < right) {
			int mid = (left+right) / 2;
			if(listB[mid] < listA[index]) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		return left;
	}

}
