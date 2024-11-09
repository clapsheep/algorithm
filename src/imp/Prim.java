package imp;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {
	static int V, E;
	static List<Edge>[] adj; // 인접 리스트 (index -> v, 가중치 w);
	static boolean[] visited;

	static class Edge {
		int v, w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		adj = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < V + 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			adj[a].add(new Edge(b, w));
			adj[b].add(new Edge(a, w));
		}
		visited = new boolean[V + 1];

		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		visited[1] = true; // 시작정점
		int ans = 0; // 모든 정점에 도달할 때 까지 최소 가중치의 합
		int pick = 1; // 방문한 정점의 
		

		pq.addAll(adj[1]);

		while (pick != V) { // 목표에 도달 할 때 까지
			Edge cur = pq.poll();
			if (visited[cur.v])
				continue;
			ans += cur.w;
			visited[cur.v] = true;
			pick++;
			pq.addAll(adj[cur.v]);
		}
		System.out.println(ans);

	}

}
