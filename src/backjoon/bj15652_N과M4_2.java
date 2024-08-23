package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15652_N과M4_2 {
	static int N,M;
	static int[] nums;
	static int[] p;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	sb = new StringBuilder();
	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());
	p = new int[N];
	for (int i = 0; i < N; i++) {
		p[i] = i+1;
	}
	nums = new int[M];
	npr(0,0);
	System.out.println(sb);
	}
	private static void npr(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			nums[cnt] = p[i];
			
			npr(cnt+1,i);
			nums[cnt] = 0;
			
		}
		
	}
	
}
