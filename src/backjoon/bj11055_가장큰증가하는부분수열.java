package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11055_가장큰증가하는부분수열 {
	static int N;
	static int[] arr, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];		
		for (int i = 0; i < N; i++) {
			dp[i]=arr[i];
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j]) {
				dp[i] = Math.max(dp[j]+arr[i],dp[i]);
				}
			}
					
		}
		
		int res = Integer.MIN_VALUE;
		for (int cur : dp) {
			res = Math.max(cur, res);
		}
		System.out.println(res);
	}

}
