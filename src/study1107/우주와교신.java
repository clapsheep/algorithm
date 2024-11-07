package study1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 우주와교신 {
	static int N, M;
	static int[] r, p;
	static God[] list;

	static class God {
		int x, y;

		public God(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge> {
		int a, b;
		double w;

		public Edge(int a, int b, double w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.w, e.w);

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new God[N]; // 신들의 리스트
		r = new int[N]; // 랭크
		p = new int[N]; // 부모

		for (int i = 0; i < N; i++) { // make-set
			r[i] = 1;
			p[i] = i;
		}

		for (int i = 0; i < N; i++) { // 신 입력
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[i] = new God(x, y);
		}
		for (int i = 0; i < M; i++) { // 이미 연결된 선 union
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			union(start, end);
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				pq.offer(new Edge(i, j, calcWeight(list[i], list[j])));
			}
		}
		double res = 0.0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (union(cur.a, cur.b)) {
				res += cur.w;
			}
		}
		System.out.println(String.format("%.2f", res));
	}

	public static double calcWeight(God a, God b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}

	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			if (r[a] > r[b]) {
				r[a] += r[b];
				p[b] = a;
			} else {
				r[b] += r[a];
				p[a] = b;
			}
			return true;
		}
		return false;

	}

	private static int find(int v) {
		if (v != p[v]) {
			return p[v] = find(p[v]);
		} else {
			return p[v];
		}
	}
}
