package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj13549_숨바꼭질3 {
	static int N, K, Max;
	static int INF = Integer.MAX_VALUE;
	static boolean[] v;
	static int[] dist;

	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Max = 100001;
		dist = new int[Max];
		Arrays.fill(dist, INF);
		dijkstra(N);
		System.out.println(dist[K]);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		v = new boolean[Max];
		dist[start] = 0;
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if(v[K]) {
				return;
			}
			if (v[cur.v])
				continue;
			v[cur.v] = true;
			int[] next = { cur.v * 2, cur.v + 1, cur.v - 1 };
			for (int i = 0; i < 3; i++) {
				if (!check(next[i]))
					continue;
				
				if (i == 0) {
					if (!v[next[i]] && dist[next[i]] > cur.w + 0) {
						dist[next[i]] = cur.w;
						pq.offer(new Node(next[i],dist[next[i]]));
					}
				} else {
					if (!v[next[i]] && dist[next[i]] > cur.w + 1) {
						dist[next[i]] = cur.w + 1;
						pq.offer(new Node(next[i],dist[next[i]]));
					}
				}

			}

		}

	}

	private static boolean check(int i) {
		return i >= 0 && i < Max;
	}

}
