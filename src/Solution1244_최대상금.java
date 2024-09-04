

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1244_최대상금 {
	static int T, C, N, ans;
	//static int[] nums;
	//static int[] chances;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T= Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			String sss = st.nextToken();
			N = sss.length();
			C = Integer.parseInt(st.nextToken());
			v = new boolean[C][1000000];
			ans = -1;
			dfs(0,sss);
			sb.append(ans);
			System.out.println(sb.toString());
		}
	}

	private static void dfs(int cnt, String s) {
		if(cnt==C) {
			int res= Integer.parseInt(s);
			ans = Math.max(res,ans);
			return;
		}
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				char[] nums=s.toCharArray();
				swap(nums,i,j);
				if(v[cnt][Integer.parseInt(new String(nums))])continue;
				v[cnt][Integer.parseInt(new String(nums))] = true;
				dfs(cnt+1,new String(nums));
			}
		}
	}

	private static void swap(char[] nums,int a, int b) {
		char temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}


}
