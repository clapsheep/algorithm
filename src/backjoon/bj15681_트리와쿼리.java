package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj15681_트리와쿼리 {
	static int N,R,Q;
	static List<Integer>[] adj;
	static int[] dp;
	static boolean[] v;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		sb= new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		dp = new int[N+1];
		v = new boolean[N+1];
		
		for (int i = 0; i < N+1; i++) {
			adj[i]= new ArrayList<Integer>();
		}
		for (int i = 0; i < N-1; i++) {
			st= new StringTokenizer(br.readLine());
			int a  = Integer.parseInt(st.nextToken());
			int b  = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		dfs(R);
		for (int i = 0; i < Q; i++) {
			int q = Integer.parseInt(br.readLine());
			sb.append(dp[q]).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static int dfs(int node) {
		if(dp[node] != 0) {
			return dp[node];
		}
		
		v[node] = true;
		int cnt = 1;
		for(int n : adj[node]) {
			if(v[n])continue;
			cnt += dfs(n);
		}
		dp[node] = cnt;
		return dp[node];
	}

	


}
