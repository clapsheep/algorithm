package imp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 프림02_우선순위큐 {
	static final int INF = Integer.MAX_VALUE;

	static class Edge {
		int a, b, w;

		Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int V = sc.nextInt();
		int E = sc.nextInt();
		

		// 인접 리스트 방식
		List<Edge>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			adj[a].add(new Edge(a, b, w));
			adj[b].add(new Edge(b, a, w));

		}

		boolean[] v = new boolean[V]; // 방문 췍~!
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		v[0] = true;
		int res = 0;
		int pick = 1;
		
		for (Edge e : adj[0]) {
			pq.add(e);
		}
//		pq.addAll(adj[0]); // 이것도 가능
		while(pick!=V) {
			Edge e = pq.poll();
			if(v[e.b])continue;
			res+=e.w;
			v[e.b] = true;
			pick++;
			pq.addAll(adj[e.b]);
		}
		System.out.println(res);
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
