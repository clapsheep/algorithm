package study0905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2110_공유기설치 {
	static int N, C, res;
	static int[] street;
	static int[] selected;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		street = new int[N];
		selected = new int[C];
		v= new boolean[N];
		for (int i = 0; i < N; i++) {
			street[i] = Integer.parseInt(br.readLine());
		}
		res = 0;
		dfs(0);
		System.out.println(res);
	}

	private static void dfs(int cnt) {
		
		if(cnt == C) {
			int temp = Integer.MAX_VALUE;
			for (int i = 1; i < C; i++) {
				temp = Math.min(temp, selected[i]-selected[i-1]);
			}
			res = Math.max(res, temp);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i])continue;
			v[i] = true;
			selected[cnt] = street[i];
			dfs(cnt+1);
			selected[cnt] = 0;
			v[i] = false;
		}
		
	}

}
