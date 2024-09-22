package study0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1916_최소비용구하기 {
	static class Bus {
		int v, cost;

		public Bus(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int N, M, S, E;
	static List<Bus>[] adj;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dist = new int[N + 1];
		Arrays.fill(dist, INF);

		M = Integer.parseInt(br.readLine());
		adj = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 1; i < M + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[start].add(new Bus(end, weight));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dijkstra(S);
		System.out.println(dist[E]);
	}

	private static void dijkstra(int departure) {
		PriorityQueue<Bus> q = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
		boolean[] v = new boolean[N+1]; // 방문배열(가장 짧은 거리를 찾았다.)
		dist[departure] = 0; // 첫 시작점의 거리는 본인이므로 0
		q.offer(new Bus(departure,0)); // 짧은 거리를 가진 구역 순으로 돌기위한 pq
		while(!q.isEmpty()) {
			if(v[E]) return;
			Bus curr = q.poll();
			if(v[curr.v])continue; // 시작점의 도착점이 이미 최단 거리를 찾은 곳이면 컨티뉴
			v[curr.v] = true;
			for (Bus b : adj[curr.v]) { // 현재 선택된 정점이 출발점인 버스들을 모두 순회
				if(!v[b.v]&&dist[b.v]>dist[curr.v]+b.cost) { // 아직 그 버스가 갈 수 있는 곳들 중 아직 최단거리를 못찾았고,
					// 
					dist[b.v]=dist[curr.v]+b.cost;
					q.offer(new Bus(b.v,dist[b.v]));
				}
			}
		
		}
		
	}

}
