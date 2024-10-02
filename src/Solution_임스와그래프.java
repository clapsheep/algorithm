import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_임스와그래프 {

	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int V = 52;
	static int T, E;
	static List<Node>[] adj;
	static int[] distForI, distForH;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			E = Integer.parseInt(br.readLine());

			adj = new ArrayList[V];
			
			for (int i = 0; i < V; i++) {
				adj[i] = new ArrayList<>();
			
			}
			distForI = new int[V];
			distForH = new int[V];
			Arrays.fill(distForI, INF);
			Arrays.fill(distForH, INF);
			for (int i = 0; i < E; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = convert(st.nextToken().charAt(0));
				int end = convert(st.nextToken().charAt(0));
				int w = Integer.parseInt(st.nextToken());

//				boolean isExsist = false;
//				for (Node n : adj[start]) {
//				    if (n.v == end) {
//				        isExsist = true;
//				        n.w = w;
//				        break;
//				    }
//				}
//				if (!isExsist) {
				    adj[start].add(new Node(end, w));
//				}
			}

			int I = djikstra(0,51,distForI);
			int H = djikstra(51,0,distForH);
			
			
			
			if (I == INF) {
			    sb.append("NO");
			} else {
			    sb.append(I <= H ? "YES " + I : "NO");
			}

			System.out.println(sb.toString());
		}

	}


	private static int djikstra(int start,int end, int[] dist) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] v = new boolean[V];

		dist[start] = 0;
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (v[curr.v])
				continue;
			v[curr.v] = true;
			for (Node node : adj[curr.v]) {
				if (!v[node.v] && dist[node.v] > dist[curr.v] + node.w) {
					dist[node.v] = dist[curr.v] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
		return dist[end];
	}

	private static int convert(char c) {
		if (c >= 'a' && c <= 'z') {
			return c - 'a';
		} else {
			return c - 'A' + 26;
		}
	}

}
