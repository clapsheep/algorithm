package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1753_최단경로 {
	static class Node{
		int V,W;

		public Node(int v, int w) {
			V = v;
			W = w;
		}
		
	}
	static int V,E, start;
	static final int INF = Integer.MAX_VALUE;
	static List<Node>[] adj;
	static int[] dis;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // 정점
		E = Integer.parseInt(st.nextToken()); // 간선
		start = Integer.parseInt(br.readLine());
		adj = new ArrayList[V+1];
		for (int i = 1; i < V+1; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w =  Integer.parseInt(st.nextToken());
			adj[v1].add(new Node(v2,w));
		}
		dis = new int[V+1];
		Arrays.fill(dis, INF);
		dijkstra(start);
		for (int i = 1; i < V+1; i++) {
			System.out.println(dis[i]==INF?"INF":dis[i]);
		}
	}

	private static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.W-o2.W);
		boolean[] vis =  new boolean[V+1];
		dis[s] = 0;
		pq.offer(new Node(s,0));
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(vis[curr.V])continue;
			vis[curr.V] = true;
			for (Node n : adj[curr.V]) {
				if(!vis[n.V]&& dis[n.V]>n.W + dis[curr.V] ) {
					dis[n.V] = n.W + dis[curr.V];
					pq.offer(new Node(n.V,dis[n.V]));
				}
			}
		}
	}

}
