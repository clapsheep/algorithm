package study0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj6603_로또 {
	static int K;
	static int M = 6;
	static int[] nums, selected;
	static boolean[] v;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if(K==0) return;
			
			selected = new int[M];
			v = new boolean[K];
			nums = new int[K];
			for (int i = 0; i < K; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			dfs(0,0);
			System.out.println(sb);
			
		}

	}

	 static void dfs(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < K; i++) {
			if(v[i]) continue;
			v[i] = true;
			selected[cnt] = nums[i];
			dfs(cnt+1,i);
			selected[cnt] = 0;
			v[i] = false;
		}
		
	}

}
