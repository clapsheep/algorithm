package study0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11722_가장긴감소하는부분수열 {
	static int N;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		dp[0]=1;
		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if(arr[i]<arr[j]) {
					max = Math.max(dp[j], max);
				}
			}
			dp[i] = max +1;
		}
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}

}
