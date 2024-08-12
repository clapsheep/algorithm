package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14696 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		out : for (int n = 0; n < N; n++) {
			int[] resA = new int[4];
			int[] resB = new int[4];
		
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			for (int i = 0; i < A; i++) {
				int idx = Integer.parseInt(st.nextToken());
				resA[idx-1]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st.nextToken());
			for (int i = 0; i < B; i++) {
				int idx = Integer.parseInt(st.nextToken());
				resB[idx-1]++;
			}
			for (int i = 3; i >= 0; i--) {
				if(resA[i]>resB[i]) {
					System.out.println("A");
					continue out;
				}
				if(resA[i]<resB[i]) {
					System.out.println("B");
					continue out;
				}
			}
			System.out.println("D");
			
			
			
		}
	}

}
