package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10813 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int[] baskets = new int[N];
		for (int i = 1; i <= N; i++) {
			baskets[i-1] = i;
		}
		
		
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			int basket1 = Integer.parseInt(st.nextToken()) -1;
			int basket2 = Integer.parseInt(st.nextToken()) -1;
			int temp = baskets[basket1];
			baskets[basket1] = baskets[basket2];
			baskets[basket2] = temp;
		}
		for (int i = 0; i < baskets.length; i++) {
			System.out.printf("%d ",baskets[i]);
			
		}
	}
}
