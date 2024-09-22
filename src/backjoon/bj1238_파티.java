package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1238_파티 {
	static int N, M, X;
	static final int INF = Integer.MAX_VALUE;
	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	static List<Node>[] adj, revAdj;
	static int[] dist ,revDist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 마을갯수
		M = Integer.parseInt(st.nextToken()); // 간선갯수
		X = Integer.parseInt(st.nextToken()); // 목적지 -> 출발지로 모든 마을에 도달하는 최대 거리를 찾으면 반대로 X까지 가장 먼 친구를 찾을 수 있지 않을까?
	
		adj = new ArrayList[N+1];
		revAdj = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			adj[i] = new ArrayList<>();
			revAdj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[start].add(new Node(end,weight));
			revAdj[end].add(new Node(start,weight));
		}
		
		dist = new int[N+1];
		revDist= new int[N+1];
		Arrays.fill(dist, INF);
		Arrays.fill(revDist, INF);
		
		dijkstra(X);
		revDijkstra(X);
		int res = -1;
		for (int i = 1; i < N+1; i++) {
			res = Math.max(res, dist[i]+revDist[i]);
		}
		System.out.println(res);
		
	}
	private static void dijkstra(int x) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.w-o2.w);
		boolean[] v = new boolean[N+1];
		dist[x] = 0;
		pq.offer(new Node(x,0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(v[cur.v])continue;
			v[cur.v] = true;
			for (Node n : adj[cur.v]) {
				if(!v[n.v]&& dist[n.v]>dist[cur.v]+n.w) {
					dist[n.v]=dist[cur.v]+n.w;
					pq.offer(new Node(n.v,dist[n.v]));
				}
			}
		}
		
	}
	private static void revDijkstra(int x) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.w-o2.w);
		boolean[] v = new boolean[N+1];
		revDist[x] = 0;
		pq.offer(new Node(x,0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(v[cur.v])continue;
			v[cur.v] = true;
			for (Node n : revAdj[cur.v]) {
				if(!v[n.v]&& revDist[n.v]>revDist[cur.v]+n.w) {
					revDist[n.v]=revDist[cur.v]+n.w;
					pq.offer(new Node(n.v,revDist[n.v]));
				}
			}
		}
		
	}

}
