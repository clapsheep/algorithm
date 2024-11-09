import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim_practice {
	static int V, E;

	static class Edge {
		int v, w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static boolean[] v;
	static List<Edge>[] adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if (V == 0 && E == 0)
				break;
			adj = new ArrayList[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new ArrayList<>();
			}
			int total = 0;
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				total += w;
				adj[a].add(new Edge(b, w));
				adj[b].add(new Edge(a, w));
			}
			v = new boolean[V];

			PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
			v[0] = true;
			int res = 0;
			int pick = 1;
			pq.addAll(adj[0]);
			while (pick != V) {
				Edge cur = pq.poll();
				if (v[cur.v])
					continue;
				res += cur.w;
				v[cur.v] = true;
				pick++;
				pq.addAll(adj[cur.v]);
			}
			sb.append(total - res).append("\n");
		}
		System.out.println(sb.toString());
	}
}
