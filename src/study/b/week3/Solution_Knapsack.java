package study.b.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Knapsack {
	static int N, T, K;
	static int[] V, C;
	
	// DP테이블이 어떤 정보를 담고 있는지 꼭 말로 표현할 수 있어야 한다.
	// 1 ~ N 물건 사용, 정확히 K만큼의 부피 사용 중 최대 가치
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb= new StringBuilder();
			sb.append("#").append(t).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			V = new int[N];
			C = new int[N];
			dp = new int[N][K];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				V[i] = Integer.parseInt(st.nextToken());
				C[i] = Integer.parseInt(st.nextToken());

			}
		}

	}

}
