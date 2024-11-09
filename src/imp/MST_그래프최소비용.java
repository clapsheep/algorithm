package imp;


import java.util.Arrays;
import java.util.Scanner;

public class MST_그래프최소비용 {

	static int[] p;

	static class Edge implements Comparable<Edge> {
		int A, B, W;

		public Edge(int A, int B, int W) {
			this.A = A;
			this.B = B;
			this.W = W;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int V = sc.nextInt();
		int E = sc.nextInt();
		Edge[] edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			edges[i] = new Edge(A, B, W);
		} // 입력 끝
			// 크루스칼 제 1장 : 가중치 순으로 정렬을 해라!
		Arrays.sort(edges);
		// 크루스칼 제 2장 : V-1개 간선을 뽑아라!(사이클이 발생하지 않게)
		// 상호배타 집합(서로소 집합, 유니온 파인트);
		p = new int[V];
		
		// make-set을 통해 전체 자신을 대표로 만드는 작업을 수행한다.
		for (int i = 0; i < V; i++) {
			p[i] = i;
		}
		int ans =0;
		int pick = 0;
		for (int i = 0; i < E; i++) {
//			int x = edges[i].A;
//			int y = edges[i].B;
//			
//			// 사이클 발생 여부 체크
//			if(findSet(x) != findSet(y)) {
//				// 해당 블록에 들어왔다면... 사이클이 아니라는 뜻
//				union(x,y);
//				ans+=edges[i].W;
//				pick++;
//			}
			int px = findSet(edges[i].A);
			int py = findSet(edges[i].B);
			if(px!=py) {
				union(px,py);
				ans += edges[i].W;
				pick++;
			}
			
			if(pick==(V-1))break;
			
			
		}// 간선의 총 개수 만큼 돌면서
		
		System.out.println(ans);
		
		
		
//		for (Edge e : edges) {
//			System.out.println(e);
//		}

	}
	
	static void makeSet(int x) {
		p[x] = x;
	}
	static int findSet(int x) {
//	 	기본 방식		
//		if(x==p[x])return x;
//		return findSet(p[x]);
		// 위의 코드가 문제점이 있대.. 똑같은 작업을 또 할 수 있어서 비효율적
		if(x!=p[x])
		p[x]= findSet(p[x]);
		return p[x];
	}
	static void union(int x, int y) {
		// x와 y가 대표자여야만 한다.
//		p[findSet(y)] = findSet(x); // x그룹에 y 그룹을 넣는것
		// 애초에 여기 x,y의 대표를 내려보내려면?
		p[y] = x;
		
	}
	
	
	
	
	
	static String input = "7 11\r\n"
			+ "0 1 32\r\n"
			+ "0 2 31\r\n"
			+ "0 5 60\r\n"
			+ "0 6 51\r\n"
			+ "1 2 21\r\n"
			+ "2 4 46\r\n"
			+ "2 6 25\r\n"
			+ "3 4 34\r\n"
			+ "3 5 18\r\n"
			+ "4 5 40\r\n"
			+ "4 6 51\r\n"
			+ "";
}	
