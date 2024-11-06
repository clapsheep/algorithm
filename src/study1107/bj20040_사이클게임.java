package study1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20040_사이클게임 {
	static int N; // 점의 갯수
	static int M; // 진행차수
	static int[] p, r;
	static class Edge {
		int a,b;
		public Edge(int a, int b) {
			this.a =a;
			this.b =b;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N];
		r = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
			r[i] = 1;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			if(find(a) == find(b)) {
				System.out.println(i+1);
				return;
			}
			union(a,b);
		}
		System.out.println(0);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return false;
		if(r[a] > r[b]) {
			r[a] += r[b];
			p[b] = a;
		}else {
			r[b] += r[a];
			p[a] = b;
		}
		return true;
	}

	private static int find(int v) {
		if(v != p[v]) {
			return p[v] = find(p[v]);		
		}else {
			return p[v];
		}
	}
	

}
