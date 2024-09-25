package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1005_ACM크래프트 {

	static int T, N, K, W, time;
	static int[] cost;
	static List<Integer>[] adj;
	static int[] degree, total;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 건물 수
			K = Integer.parseInt(st.nextToken()); // 건물 건설 조건 수
			cost = new int[N+1];
			total = new int[N+1];
			degree = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N+1; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			adj = new ArrayList[N+1];
			for (int i = 1; i < N+1; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b =  Integer.parseInt(st.nextToken());
				adj[a].add(b);
				degree[b]++;
			}
			W = Integer.parseInt(br.readLine());

			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i < N+1; i++) {
				if(degree[i]==0) {
					q.offer(i);
					total[i] = cost[i];
				}
			}
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for (int end : adj[cur]) {
					degree[end]--;
					total[end] = Math.max(total[cur]+cost[end], total[end]);
					if(degree[end]==0) {
						q.offer(end);
					}
				}
			}
			
			System.out.println(total[W]);
		}
	}


		
	
}
