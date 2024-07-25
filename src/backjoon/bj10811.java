package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10811 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int[] a = new int[N];
		
		for (int i = 0; i < N; i++) {
			a[i] = i + 1;
		
		}
		int M = Integer.parseInt(st.nextToken());
		
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int[] b = Arrays.copyOf(a, N);
			
			if(start == end) {
				continue;
			}
			
			for (int i = start; i <= end; i++) {
				a[i] = b[start+end-i];
			}

		}
		for (int i = 0; i < a.length; i++) {			
		System.out.printf("%d ",a[i]);
		}
	}

}
