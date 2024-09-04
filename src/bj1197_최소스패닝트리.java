import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.print.DocFlavor.STRING;

public class bj1197_최소스패닝트리 {
	static int V, E;
	static int res, cnt;
	static int[] p, r;

	static class Edge {
		int start, end, w;

		public Edge(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		// makeSet;
		p = new int[V];
		r = new int[V];
		for (int i = 0; i < V; i++) {
			p[i] = i; // 정점의 대표는 우선 각 정점
			r[i] = 1; // 정점의 랭크
		}

		Queue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(s, e, w));
		}
		res = 0;
		cnt = 0;
		while (cnt != V - 1) {
			Edge curr = pq.poll();
			kruscal(curr);

		}

		System.out.println(res);
	}

	private static void kruscal(Edge curr) {
		if (union(curr.start, curr.end)) {
			res += curr.w;
			cnt++;
		}

	}

	private static boolean union(int a, int b) {
		// start의 대표와 end의 대표가 다르면 true;
		a = find(a);
		b = find(b);
		if (a == b) return false;
		// 대표찾기 : 다르면? 합칠 수 있다
			if (r[a] > r[b]) {
				r[a] += r[b];
				p[b] = a;
			} else {
				r[b] += r[a];
				p[a] = b;
			}
			return true;
		
	}

	private static int find(int v) {
		if (v != p[v]) {
			return p[v] = find(p[v]);
		} else {
			return p[v];
		}
	}

}
