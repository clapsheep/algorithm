package study1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj12015_가장긴증가하는부분수열 {
		static int N;
		static int[] arr;
		static int[] LIS;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		LIS = new int[N];
		
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		LIS[0] = arr[0];
		int rear = 1;
		
		for (int i = 1; i < N; i++) {
			int cur = arr[i];
			if(LIS[rear-1]<cur) {
				LIS[++rear-1] = cur;
			}else {
				int left = 0;
				int right = rear;
				while(left<right) {
					int mid = (left+right)/2;
					if(LIS[mid]<cur) {
						left = mid+1;
					}else{
						right = mid;
					};
				}
				LIS[left] = cur;
			}
		}
		System.out.println(rear);
	}

}
