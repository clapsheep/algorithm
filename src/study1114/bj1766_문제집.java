package study1114;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1766_문제집 {
	static int N, M;
	static int[] p;
	static List<Integer>[] adj;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		adj = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
			p[i] = 0;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			p[b]++; //b의 선행해야하는 갯수
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 번호가 작은 순으로 빨리 풀어야 함
		
		for (int i = 1; i < N+1; i++) {
			if(p[i]==0) {
				pq.offer(i); // 선행 조건이 없는 과목 다 넣고 시작 
			}
		}
		
		while(!pq.isEmpty()) {
			Integer cur = pq.poll(); // 선행 조건 없고,번호 가장 작은 순으로 나옴
			sb.append(cur).append(" ");
			for (Integer i : adj[cur]) { // cur를 선행으로 해야하는 과목 차수 다 감소
				p[i]--;
				if(p[i]==0) { // 선행을 모두 완료하면 pq 추가
					pq.offer(i);
				}
				
			}
			
		}
		System.out.println(sb.toString());

	}

}
