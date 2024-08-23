package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15665_N과M11 {
	static int N,M;
	static int[] nums;
	static int[] p;
//	static boolean[] v;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	sb = new StringBuilder();
	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());
	p = new int[N];
	nums = new int[M];
//	v = new boolean[N];
	st= new StringTokenizer(br.readLine());
	for (int i = 0; i < N; i++) {
		p[i] = Integer.parseInt(st.nextToken());
	}
	Arrays.sort(p);
	
	dfs(0);
	
	System.out.println(sb);
	}
	private static void dfs(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int before=0;
		for (int i = 0; i < N; i++) {
			if(before != p[i]) {
			nums[cnt] = p[i];
			before  = p[i];
			dfs(cnt+1);
			nums[cnt] = 0;
			}
		}
	}
	
}
