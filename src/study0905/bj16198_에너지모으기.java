package study0905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16198_에너지모으기 {
	static int N, res;
	static int[] E;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		E = new int[N];
		v= new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			E[i] = Integer.parseInt(st.nextToken());
		}
		res = 0;
		dfs(N, 0);
		System.out.println(res);
	}
	private static void dfs(int cnt, int sum) {
		if(cnt==2) {
			res= Math.max(res, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if(i==0 || i== N-1)continue;
			if(v[i])continue;
			v[i] = true;
			int leftIdx = i;
			int rightIdx = i;
			while(v[leftIdx])leftIdx--;
			while(v[rightIdx])rightIdx++;
			dfs(cnt-1, sum+E[leftIdx]*E[rightIdx]);
			v[i] = false;
					
		}
		
	}

}
