package organization.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Perm_중복허용_비내림차순 {
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
		perm(0);
		System.out.println(sb.toString());
	}
	
	private static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int before = 0;
		for (int i = 0; i < N; i++) {
			if(v[i])continue;
			if(before == nums[i])continue;
			v[i] = true;
			res[cnt] = nums[i];
			before = nums[i];
			perm(cnt+1);
			res[cnt] = 0;
			v[i] = false;
		}
	}
}
