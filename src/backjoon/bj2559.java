package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj2559 {
	static int N;
	static int[] arr;
	static int day;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		day= Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i <= N-day; i++) {
			int sum = 0;
			for (int j = i; j < i+day; j++) {
				sum += arr[j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
			
			
			
			
			
			
			
			

			
		
	}
}
