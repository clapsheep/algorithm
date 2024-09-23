package study0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1976_여행가자 {
	static int N, M;
	static int[] plan;
	static List<Integer>[] adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		// 인접리스트 생성
		adj = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				int end = Integer.parseInt(st.nextToken());
				if (end == 1) {
					adj[i].add(j);
				}
			}

		}

		// 여행 계획
		plan = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		boolean res = true;
		for (int i = 1; i < M; i++) {
			if (!find(plan[i - 1], plan[i])) {
				res = false;
				break;
			}
		}
		System.out.println(res ? "YES" : "NO");
	}

	private static boolean find(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] v = new boolean[N+1];
		q.add(start);
		v[start] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur== end) {
				return true;
			}
			for (int e : adj[cur]) {
				if(v[e])continue;
				v[e] = true;
				q.add(e);
			}
		}
		return false;
	}

}
