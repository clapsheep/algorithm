package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj4386_별자리만들기 {
	static class Edge implements Comparable<Edge> {
		int a, b;
		double w;

		public Edge(int a, int b, double w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}

	}

	static class Star {
		double x, y;

		public Star(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	static List<Star> ss;
	static PriorityQueue<Edge> edges;
	static int N;
	static int[] p,r;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		ss = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			ss.add(new Star(x, y));
		}
		p = new int[N];
		r = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
			r[i] = 1;
		}
		edges = new PriorityQueue<>();
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				double dist = calc(ss.get(i), ss.get(j));
				edges.offer(new Edge(i, j, dist));
			}
		}
		int cnt = 0;
		double dist = 0;
		while (cnt != N - 1) {
			Edge cur = edges.poll();
			if (union(cur.a, cur.b)) {
				dist+=cur.w;
				cnt++;
			}
		}
		System.out.println(Math.round(dist*100)/100.0);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return false;
		} else {
			if(r[a]>r[b]) {
				r[a]+=r[b];
				p[b] = a;
			}else {
				r[b]+=r[a];
				p[a] = b;
			}
		}
		return true;
	}

	private static int find(int v) {
		if (p[v] == v) {
			return v;
		} else {
			return p[v] = find(p[v]);
		}
	}

	private static double calc(Star a, Star b) {
		double w = Math.abs(a.x - b.x);
		double h = Math.abs(a.y - b.y);
		return Math.sqrt(w * w + h * h);
	}


}
