package imp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최소스패닝트리 {
	static int V, E, cnt, res;
	static int[] p, r;

	static class Edge {
		int a, b, w;

		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		p = new int[V + 1];
		r = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			p[i] = i;
			r[i] = 1;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(a, b, w));
		}
		cnt = 0;
		res = 0;
		while (cnt != V) {
			Edge cur = pq.poll();
			if (union(cur.a, cur.b)) {
				res += cur.w;
				cnt++;
			}
		}
		System.out.println(res);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return false;
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
