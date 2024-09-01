package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2606_바이러스 {
	static int N, M, cnt;
	static int[][] map;
	
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		v = new boolean[N];
		map = new int[N][N];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c =  Integer.parseInt(st.nextToken());
			map[r-1][c-1] = 1;
			map[c-1][r-1] = 1;
		}
		cnt = 0;
		virus(0);
		System.out.println(cnt);
	}
	static void virus(int pc) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(pc);
		v[pc] = true;
		while(!q.isEmpty()) {
			int s = q.poll();
			for (int e = 0; e < N; e++) {
				if(map[s][e]==1) {
					if(v[e])continue;
					q.offer(e);
					v[e] =true;
					cnt++;
				}
			}
		}
		
		
	}
}
