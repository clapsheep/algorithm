package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15650_N과M2 {
	static int N,M;
	static int[] nums;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());
	p = new int[N];
	nums = new int[M];
	
	for (int i = 0; i < N; i++) {
		p[i] = i+1;
	}
	nCm(0,0);
	}

	private static void nCm(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(nums[i]+" "); 
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {

			nums[cnt] = p[i];
			nCm(cnt+1,i+1);
			nums[cnt] = 0;

		}
		
	}

}
