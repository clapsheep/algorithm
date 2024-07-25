package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10810 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int[] baskets = new int[N];
		int[] balls = new int[N];
		for (int i = 1; i <= N; i++) {
			balls[i-1] = i;
		}
		
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int ballnumber = Integer.parseInt(st.nextToken());
			
			for (int j = start; j <= end; j++) {
					baskets[j-1] = ballnumber;
			}
		}
		for (int i = 0; i < baskets.length; i++) {
			System.out.printf("%d ",baskets[i]);
		}
	}
}
