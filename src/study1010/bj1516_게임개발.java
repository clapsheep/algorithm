package study1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1516_게임개발 {
	static int N;
	static int[] p;
	static List<Integer>[] adj;
	static int[] time;
	static int[] completeTime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		p = new int[N+1];
		time = new int[N+1];
		adj = new ArrayList[N+1];
		completeTime = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				time[i] = Integer.parseInt(st.nextToken());

				int temp = Integer.parseInt(st.nextToken()); // i가 필요로 하는 선수 건물
				while (temp != -1) {
					adj[temp].add(i);
					p[i]++;
					temp = Integer.parseInt(st.nextToken());
				}

			}
		}
		Queue<Integer> q= new LinkedList<>();
		for (int i = 1; i < N+1; i++) {
			if(p[i]== 0) {
				q.add(i);
				completeTime[i] = time[i];  // 초기 건물의 완성 시간 설정
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (Integer i: adj[cur]) {
				 completeTime[i] = Math.max(completeTime[i], completeTime[cur] + time[i]);
				p[i]--;
				if(p[i]==0) {
					q.offer(i);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N+1; i++) {
			sb.append(completeTime[i]).append("\n");
		}
		System.out.println(sb.toString());

	}

}
