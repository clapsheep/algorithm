package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1546 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] s = new int[N];
		
		double max= 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			s[i] = Integer.parseInt(st.nextToken());
			if(max<s[i]) {
				max = s[i];
			}
		}
		double sum = 0;
		for (int i = 0; i < s.length; i++) {
			sum += s[i]/max*100;
		}
		System.out.println(sum/N);
		
		
		

	}

}
