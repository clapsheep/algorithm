package study0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2252_줄세우기 {
	static int N,M;
	static int[] degree;
	static int[][] adj;
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj= new int[N+1][N+1];
		degree = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1; //a->b로 향하는 친구
			degree[b]++; // b의 진입차수 증가
		}
		Queue<Integer> q= new LinkedList<>();
		for (int i = 1; i < N+1; i++) {
			if(degree[i]==0) {
				q.offer(i); // 아무도 진입하지 않은 친구들을 넣음(진입차수 0) 즉 시작점으로 가능한 친구들
			}
		}
		while(!q.isEmpty()) {
				int cur = q.poll(); 
				sb.append(cur).append(" ");
				for (int i = 1; i < N+1; i++) {
					if(adj[cur][i]==1) { // cur와 연결된 친구들 조회;
						degree[i]--; // 연결했으니 1깎아.
						if(degree[i]==0) { // 더이상 연결된게 없으면
							q.offer(i); // 다음 시작점으로 합당해
						}
					}
				}
			
		}
		System.out.println(sb.toString());
	}
}
