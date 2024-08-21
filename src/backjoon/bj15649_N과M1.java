package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15649_N과M1 {
	static int N,M;
	static boolean[] visited;
	static int[] nums;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());
	p = new int[N];
	visited = new boolean[N];
	nums = new int[M];
	
	for (int i = 0; i < N; i++) {
		p[i] = i+1;
	}
	nPm(0);
	

	}

	private static void nPm(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(nums[i]+" "); 
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i])continue;
			visited[i] = true;
			nums[cnt] = p[i];
			nPm(cnt+1);
			nums[cnt] = 0;
			visited[i] = false;
		}
		
	}

}
