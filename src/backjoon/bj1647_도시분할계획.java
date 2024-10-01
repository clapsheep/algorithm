package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1647_도시분할계획 {
	static class Edge {
		int a, b, w;

		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
	}

	static int N, M;
	static int[] p, r;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		
		p = new int[N + 1];
		r = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			p[i] = i;
			r[i] = 1;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(a, b, w));
		}
		
		int res = 0;
		int size = 0;
		int biggest = 0;
		while (size != N-1) {
			Edge cur = pq.poll();
			if (union(cur.a, cur.b)) {
				size++;
				biggest = Math.max(cur.w, biggest);
				res += cur.w;
			}
		}
		System.out.println(res-biggest);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return false;
		}
		if (r[a] > r[b]) {
			r[a] += r[b];
			p[b] = a;
		} else {
			r[b] += r[a];
			p[a] = b;
		}

		return true;
	}

	private static int find(int v) {
		if (p[v] != v) {
			return p[v] = find(p[v]);
		} else {
			return p[v];

		}
	}

}
