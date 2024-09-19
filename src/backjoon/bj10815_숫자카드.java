package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10815_숫자카드 {	
	static int N,M;
	static int[] nums, given;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i]  = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		M = Integer.parseInt(br.readLine());
		given = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			given[i]  = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			if(Arrays.binarySearch(nums, given[i])<0) {
				sb.append(0).append(" ");
			}else {
				sb.append(1).append(" ");
			}
		}
		System.out.println(sb.toString());
		
	}
}
