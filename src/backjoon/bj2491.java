package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2491 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 1;
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if(arr[i-1]<=arr[i]) {
				cnt++;
				max= Math.max(max, cnt);
			}else {
				cnt = 1;
			}
		}
		
		cnt = 1;
		for (int i = 1; i < N; i++) {
			if(arr[i-1]>=arr[i]) {
				cnt++;
				max= Math.max(max, cnt);
			}else {
				cnt = 1;
			}
		}
	
		System.out.println(max);
	}

}
