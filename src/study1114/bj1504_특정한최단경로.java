package study1114;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1504_특정한최단경로 {
	static int N, E;

	static class Edge {
		int v, w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static List<Edge>[] adj;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			adj[a].add(new Edge(b, w));
			adj[b].add(new Edge(a, w));
		}
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken()) - 1;
		int second = Integer.parseInt(st.nextToken()) - 1;

		int res1 = INF;
		int a = dijkstra(0, first);
		int b = dijkstra(first, second);
		int c = dijkstra(second, N - 1);
		if (a != -1 && b != -1 && c != -1) {
			res1 = a + b + c;
		}

		int res2 = INF;
		a = dijkstra(0, second);
		b = dijkstra(second, first);
		c = dijkstra(first, N - 1);
		if (a != -1 && b != -1 && c != -1) {
			res2 = a + b + c;
		}

		int result = Math.min(res1, res2);
		if (result == INF) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		int[] dist = new int[N];
		Arrays.fill(dist, INF);
		boolean[] visited = new boolean[N];
		dist[start] = 0;
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.v])
				continue;
			visited[cur.v] = true;
			for (Edge e : adj[cur.v]) {
				if (!visited[e.v] && dist[e.v] > dist[cur.v] + e.w) {
					dist[e.v] = dist[cur.v] + e.w;
					pq.add(new Edge(e.v, dist[e.v]));
				}
			}
		}
		return dist[end] == INF ? -1 : dist[end];
	}
}