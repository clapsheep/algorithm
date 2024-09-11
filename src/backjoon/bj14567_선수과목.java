package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14567_선수과목 {
	static int N, M;
	static List<Integer>[] adj;
	static int[] p, sem;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		p = new int[N + 1];
		sem = new int[N + 1];
		v = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			adj[out].add(in);
			p[in]++;
		}
		int time = 1;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < N + 1; i++) {
			if (p[i] == 0) {
				q.offer(i);
				sem[i] = time;
			}
		}

		while (!q.isEmpty()) {
			time++;
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				for (int in : adj[cur]) {
					p[in]--;
					if(p[in]==0) {
						q.offer(in);
						sem[in] = time;
					}
				}
			}
		}
		for (int i = 1; i < N + 1; i++) {
			sb.append(sem[i]).append(" ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}

}
