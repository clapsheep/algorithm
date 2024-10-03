package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj2887_행성터널 {
	static class Planet {
		int index,x, y, z;

		public Planet(int index, int x, int y, int z) {
			this.index = index;
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}

	static class Edge {
		int a, b, w;

		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
	}

	static List<Planet> ps;
	static PriorityQueue<Edge> edges;
	static int N;
	static int[] p, r;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ps = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			ps.add(new Planet(i,x, y, z));
		}
		p = new int[N];
		r = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
			r[i] = 1;
		}
		edges = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		addEdgeOnlyNearst();
	
		int cnt = 0;
		int dist = 0;
		while (cnt != N - 1) {
			Edge cur = edges.poll();
			if (union(cur.a, cur.b)) {
				cnt++;
				dist += cur.w;
			}
		}
		System.out.println(dist);

	}

	private static void addEdgeOnlyNearst() {
		
		ps.sort((o1,o2)->o1.x-o2.x);
		for (int i = 0; i < N - 1; i++) {
			Planet p1 = ps.get(i);
			Planet p2 = ps.get(i+1);
				int dist = Math.abs(p1.x-p2.x);
				edges.offer(new Edge(p1.index, p2.index, dist));
		}
		ps.sort((o1,o2)->o1.y-o2.y);
		for (int i = 0; i < N - 1; i++) {
			Planet p1 = ps.get(i);
			Planet p2 = ps.get(i+1);
				int dist = Math.abs(p1.y-p2.y);
				edges.offer(new Edge(p1.index, p2.index, dist));
		}
		ps.sort((o1,o2)->o1.z-o2.z);
		for (int i = 0; i < N - 1; i++) {
			Planet p1 = ps.get(i);
			Planet p2 = ps.get(i+1);
				int dist = Math.abs(p1.z-p2.z);
				edges.offer(new Edge(p1.index, p2.index, dist));
		}
		
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return false;
		} else {
			if (r[a] > r[b]) {
				r[a] += r[b];
				p[b] = a;
			} else {
				r[b] += r[a];
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
}
