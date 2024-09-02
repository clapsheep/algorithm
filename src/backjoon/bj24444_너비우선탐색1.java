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
	static int[][] map;
	static boolean[] v;
	static List<Integer>[] adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int n = Integer.parseInt(st.nextToken());
//			int r = Integer.parseInt(st.nextToken());
//			map[n-1][r-1] = 1;
//			map[r-1][n-1] = 1;
//		}
		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			adjList[n-1].add(r-1);
			adjList[r-1].add(n-1);
		}
		for (int i = 0; i < M; i++) {
			Collections.sort(adjList[i]);
		}
		
		v = new boolean[N];
		bfs(R - 1);
		for (int i = 0; i < N; i++) {
			if(!v[i])System.out.println(0);
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		v[start] = true;
		System.out.println(start + 1);
		while (!q.isEmpty()) {
			int s = q.poll();
			for (int ss = 0; ss < adjList[s].size(); ss++) {
				int e =adjList[s].get(ss);
				if (v[e])continue;
		
					q.offer(e);
					v[e] = true;
					System.out.println(e + 1);
				
			}
		}

	}

}
