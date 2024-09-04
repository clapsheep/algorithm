package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18429_근손실 {	
	static int N,K,res;
	static int[] A;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		res= 0;
		dfs(0,500);
		System.out.println(res);
	}
	private static void dfs(int cnt, int w) {
		if(w<500)return;
		if(cnt==N) {
			
			res++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			v[i]=true;
			dfs(cnt+1, w-K+A[i]);
			v[i]=false;
		}
	}

}
