
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution7465_창용마을3 {

	static class Edge {
		int a, b;

		public Edge(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	static int N, M, T,count;
	static int[] p, r;
	static Edge[] edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = new int[N + 1];
			r = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				p[i] = i;
				r[i] = 1;
			}

			edges = new Edge[M];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(a, b);
			}
			for (int i = 0; i < M; i++) {
				int a = edges[i].a;
				int b = edges[i].b;
				union(a,b);
			}
			count = 0;
			for (int i = 0; i < N; i++) {
				if(p[i]==i)count++;
			}
			sb.append(count);
			System.out.println(sb.toString());
		}
	}

	private static void union(int a, int b) {
		a= find(a);
		b= find(b);
		if(a==b)return;
		if(r[a]>r[b]) {
			r[a] += r[b];
			p[b] = a;
		}else {
			r[b]+= r[a];
			p[a] = b;
		}
		return;
	}
	

	private static int find(int v) {
		if(p[v]!=v) {
			return p[v] = find(p[v]);
		}else {
			return p[v];
		}
	}

}
