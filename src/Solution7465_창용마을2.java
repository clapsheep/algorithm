

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7465_창용마을2 {
	static int T, N, M, count;
	static int[][] edges;
	static int[] p, r;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			edges = new int[M][2];

			p = new int[N];
			r = new int[N];
			// 1. makeSet
			for (int i = 0; i < N; i++) {
				p[i] = i;
				r[i] = 1;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;
				edges[i] = new int[] { s, e };
			}

			for (int i = 0; i < M; i++) {
				int a = edges[i][0];
				int b = edges[i][1];
				union(a, b);
			}
			count = 0;
			for (int i = 0; i < N; i++) {
				if(p[i]==i)count++; // 부모의 개수 구하기
			}
			sb.append(count);
			System.out.println(sb.toString());
		}

	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)return;
		if (r[a] > r[b]) {
			r[a] += r[b];
			p[b] = a;
		} else {
			r[b] += r[a];
			p[a] = b;
		}

		return;
	}

	private static int find(int v) {
		if (p[v] != v) {
			return p[v] = find(p[v]);
		} else {
			return p[v];
		}

	}

}
