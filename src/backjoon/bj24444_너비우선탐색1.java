package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj24444_너비우선탐색1 {
	static int N, M, R;
	static boolean[] v;
	static List<Integer>[] adj;
	static int[] res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			adj[n].add(r);
			adj[r].add(n);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}
		res = new int[N];
		v = new boolean[N+1];
		StringBuilder sb = new StringBuilder();
		bfs(R);
		for (int i = 0; i < N; i++) {
			sb.append(res[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		v[start] = true;
		int cnt =1;
		while (!q.isEmpty()) {
			int curr = q.poll();
			res[curr-1] =cnt++; 
			for (int w : adj[curr]) {
				if(v[w])continue;
				v[w]=true;
				q.offer(w);
			}
		}

	}

}
