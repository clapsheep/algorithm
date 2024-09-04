import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1197_최소스패닝트리2 {
	static int V, E;
	static int res;
	static List<Edge>[] adj;
	static long min;
	
	static class Edge implements Comparator<Edge> {
		int e, w;

		public Edge(int e, int w) {
		
			this.e = e;
			this.w = w;
		}

		@Override
		public int compare(bj1197_최소스패닝트리2.Edge o1, bj1197_최소스패닝트리2.Edge o2) {
			return o1.w-o2.w;
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new ArrayList[V+1];
		for (int i = 0; i < V+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st= new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new Edge(e,w));
			adj[e].add(new Edge(s,w));
			
		}
		for (int i = 0; i < E; i++) {
			
		}
	}

}
