package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1107_리모컨2 {
	static int N,M, res;
	static boolean[] isBroken;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		isBroken = new boolean[10];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int input = Integer.parseInt(st.nextToken());
			isBroken[input] = true;
		}
		
		res = Math.abs(N-100);
		dfs(0,0);
		System.out.println(res);

	}


	private static void dfs(int cnt, int cur) {
		 if(cnt == 6) {
			 return;
		 }
		 cur*=10;
		 for (int i = 0; i < 10; i++) {
			if(!isBroken[i]) {
				res = Math.min(res, Math.abs(N-(cur+i)+cnt+1));
				dfs(cnt+1,cur+i);
			}
		}
		
		
	}

}
