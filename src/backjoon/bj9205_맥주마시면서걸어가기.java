package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj9205_맥주마시면서걸어가기 {
	static int T, N;
	static int[][] map;
	static class Loc{
		int r, c;
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static Loc[] store;
	static boolean[] v;
	static String success = "happy\n";
	static String fail="sad\n";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			store = new Loc[N+2];
			v = new boolean[N+2];
			
			
			for (int n = 0; n < N+2; n++) { // store 0은 집 N+1은 락페
				StringTokenizer st= new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				store[n]  = new Loc(r,c);
			}
			

			boolean res = bfs(); 
			if(res) {
				sb.append(success);
			}else {
				sb.append(fail);
			}

		}
		System.out.println(sb.toString());

	}


	private static boolean bfs() {
		Queue<Loc> q= new LinkedList<>();
		q.offer(store[0]);
		v[0] = true;
		while(!q.isEmpty()) {
			Loc cur = q.poll();
			if(dist(cur,store[N+1])<=1000) {
					return true;
			}
			for (int i = 1; i < N+1; i++) {
				if(v[i]) continue;
				if(dist(store[i],cur)<=1000) {
					v[i] = true;
					q.offer(new Loc(store[i].r, store[i].c));
				}
			}
			
		}
		return false;
	}


	private static int dist(Loc a, Loc b) {		
		return Math.abs(a.r-b.r) + Math.abs(a.c-b.c);
	}




}
