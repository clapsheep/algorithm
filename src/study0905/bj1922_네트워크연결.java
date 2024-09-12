package study0905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1922_네트워크연결 {
	static class Edge {
		int a, b, w;

		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [a=" + a + ", b=" + b + ", w=" + w + "]";
		}
	}

	static int N, M, cnt,res;
	static int[] p;
	static int[] r;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		p = new int[N + 1];
		r = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			p[i] = i;
			r[i] = 1;
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(a, b, w));
		}
		res = 0;
		cnt = 0;
		while(cnt!= N-1) {
			
			Edge curr = pq.poll();
			if(union(curr.a,curr.b)) {
				res += curr.w;
				cnt++;
			}
		}
		System.out.println(res);
		
	}

	private static boolean union(int a, int b) {
		a= find(a);
		b= find(b);
		if(a== b) return false;
		if(r[a]>r[b]) {
			r[a]+= r[b];
			p[b] = a;
		}else {
			r[b] += r[a];
			p[a] =b;
		}
		return true;
	}

	private static int find(int v) {
		if(p[v]==v)return p[v];
		else {
			return p[v] = find(p[v]);
		}
		
	}

}
