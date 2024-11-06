package organization.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class nPr {
	static int N, M;
	static int[] nums, res;
	static boolean[] v;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		v = new boolean[N];
		res = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		npr(0);
		System.out.println(sb.toString());
	}
	
	private static void npr(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i])continue;
			v[i] = true;
			res[cnt] = nums[i];
			npr(cnt+1);
			res[cnt] = 0;
			v[i] = false;
		}
	}

}
