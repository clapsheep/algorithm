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
	static List<Node>[] adjForI, adjForH;
	static int[] distForI, distForH;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			E = Integer.parseInt(br.readLine());

			adjForI = new ArrayList[V];
			adjForH = new ArrayList[V];
			for (int i = 0; i < V; i++) {
				adjForI[i] = new ArrayList<>();
				adjForH[i] = new ArrayList<>();
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

				boolean isExsist = false;
				for (Node n : adjForI[start]) {
				    if (n.v == end) {
				        isExsist = true;
				        n.w = w;
				        break;
				    }
				}

				boolean isExsistForH = false;
				for (Node n : adjForH[end]) {
				    if (n.v == start) {
				        isExsistForH = true;
				        n.w = w;
				        break;
				    }
				}

				// 새로운 간선 추가
				if (!isExsist) {
				    adjForI[start].add(new Node(end, w));
				}
				if (!isExsistForH) {
				    adjForH[end].add(new Node(start, w));
				}


			}

			djikstraForI(0);
			djikstraForH(51);
			int I = distForI[51];
			int H = distForH[0];
			
			if (I == INF) {
			    sb.append("NO");
			} else {
			    sb.append(I <= H ? "YES " + I : "NO");
			}


			System.out.println(sb.toString());
		}

	}

	private static void djikstraForH(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] v = new boolean[V];
		distForH[start] = 0;
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (v[curr.v])
				continue;
			v[curr.v] = true;
			for (Node node : adjForH[curr.v]) {
				if (!v[node.v] && distForH[node.v] > distForH[curr.v] + node.w) {
					distForH[node.v] = distForH[curr.v] + node.w;
					pq.add(new Node(node.v, distForH[node.v]));
				}
			}
		}

	}

	private static void djikstraForI(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] v = new boolean[V];
		distForI[start] = 0;
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (v[curr.v])
				continue;
			v[curr.v] = true;
			for (Node node : adjForI[curr.v]) {
				if (!v[node.v] && distForI[node.v] > distForI[curr.v] + node.w) {
					distForI[node.v] = distForI[curr.v] + node.w;
					pq.add(new Node(node.v, distForI[node.v]));
				}
			}
		}

	}

	private static int convert(char c) {
		if (c >= 'a' && c <= 'z') {
			return c - 'a';
		} else {
			return c - 'A' + 26;
		}
	}

}
