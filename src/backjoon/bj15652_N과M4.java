package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15652_N과M4 {
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
	npr(0);
	System.out.println(sb);
	}
	private static void npr(int cnt) {
		if(cnt == M) {
			for (int i = 1; i < M; i++) {
				if(nums[i-1]>nums[i]) {
					return;
				}
			}
			for (int i = 0; i < M; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			nums[cnt] = p[i];
			npr(cnt+1);
			nums[cnt] = 0;
			
		}
		
	}
	
}
