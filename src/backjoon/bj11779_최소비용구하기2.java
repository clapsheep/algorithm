package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj11779_최소비용구하기2 {
	static int N, M, start, end;
	static class Node{
		int v, w, cnt;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	static List<Node>[] adj;
	static int[] dist;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();  
		N = Integer.parseInt(br.readLine()); // 도시
		M = Integer.parseInt(br.readLine()); // 버스
		adj = new ArrayList[N+1];
		
		for (int i = 1; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new Node(e,w));
//			adj[e].add(new Node(s,w));
			
		}
		StringTokenizer st= new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(start);
		List<Integer> path= findPath(end);
		sb.append(dist[end]).append("\n");
		sb.append(path.size()).append("\n");
		for (Integer p : path) {
			sb.append(p).append(" ");
		}
		System.out.println(sb.toString());
		
		
		
	}
	private static List<Integer> findPath(int e) {
		List<Integer>path  = new ArrayList<>();
		for (int i = end; i != 0; i=parent[i]) {
			path.add(i);
		}
		Collections.reverse(path);
		return path;
		
	}
	private static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.w-b.w);
		boolean[] v= new boolean[N+1];
		parent = new int[N+1];
		dist[s] = 0;
		Node entry = new Node(s,0);
		pq.offer(entry);
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(v[cur.v]) continue;
			v[cur.v] = true;
			for (Node n : adj[cur.v]) {
				if(!v[n.v]&& dist[n.v] > dist[cur.v]+n.w) {
					dist[n.v] = dist[cur.v]+n.w;
					parent[n.v] = cur.v;
					pq.offer(new Node(n.v,dist[n.v]));
				}
			}
			
		}
		
	}

}
