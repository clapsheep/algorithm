package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1253_좋다 {
	static int N;
	static int[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		boolean[] v = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		
		int res = 0;
		for (int i = 0; i < N; i++) {
			int target = list[i];
			int left = 0;
			int right = N-1;
			while(left < right) {
				if(left == i) {
					left++;
					continue;
				}
				if(right == i) {
					right--;
					continue;
				}
				int sum = list[left] + list[right];
				if(sum == target) {
					res++;
					break;
				}else if(sum < target) {
					left++;
				}else {
					right--;
				}
			}
		}
		System.out.println(res);

	}

}
