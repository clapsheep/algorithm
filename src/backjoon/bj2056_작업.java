package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2056_작업 {
	static int N;
	static List<Integer>[] adj;
	static int[] time;
	static int[] p, noo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N + 1];
		time = new int[N + 1];
		p = new int[N + 1];
		noo = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i] = t;
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int a = Integer.parseInt(st.nextToken());
				adj[a].add(i);
				p[i]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < N + 1; i++) {
			if (p[i] == 0) {
				q.offer(i);
				noo[i] = time[i];
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int in : adj[cur]) {
				p[in]--;
				if(noo[cur]+time[in]>noo[in]) {
					noo[in] =noo[cur]+time[in]; 
				}
				if (p[in] == 0) {
					q.offer(in);
					
				}
			
			}
		}
		int res = 0;
		for (int i = 1; i < N+1; i++) {
			res = Math.max(res, noo[i]);
		}
		System.out.println(res);
		
		
	}

}
