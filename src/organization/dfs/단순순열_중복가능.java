package organization.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 단순순열_중복가능{
	static int N, M;
	static int[] num, res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		res = new int[M];
		
		for(int i= 0; i < N; i++){
			num[i] = i+1;
		}
		
		perm(0);
		
	}
	private static void perm(int cnt){
		if(cnt == M){
			System.out.println(Arrays.toString(res));
			return;
		}
		for(int i = 0; i < N; i++){
			res[cnt] = num[i];
			perm(cnt+1);
			res[cnt] = 0;
		}
	}
}