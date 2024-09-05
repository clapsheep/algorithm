import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 다잌스트라01_반복문 {
	static class Node {
		int V, W;

		public Node(int v, int w) {
			V = v;
			W = w;
		}

	}

	static final int INF = Integer.MAX_VALUE;
	static int V, E;

	static List<Node>[] adj;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		V = sc.nextInt();
		E = sc.nextInt();
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
		dist = new int[V];
		Arrays.fill(dist, INF);
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			adj[a].add(new Node(b, w));
		}
		dijkstra(0);
		System.out.println(Arrays.toString(dist));
	}

	private static void dijkstra(int start) {
		boolean[] v = new boolean[V];
		dist[start] = 0; // 시작 노드까지 거리는 0으로 최기화
		for (int i = 0; i < V; i++) { // 어디까지 할지는 문제를 보고 결정! (도착지가 주어졌다면 방문하는 순간 멈추게)
			int min = INF;
			int idx = -1;
			for (int j = 0; j < V; j++) {
				if (!v[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}

			// option -> 아래 조건문의 의미는? -> 갈 수 있는게 없다.
//			if(idx == -1) break;

			v[idx] = true; // 해당 지점 뽑았어
			for (Node node : adj[idx]) {
				if (!v[node.V] && dist[node.V] > dist[idx] + node.W) {
					dist[node.V] = dist[idx] + node.W;
				}
			}

		}
	}

	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "";
}
