package study0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1284 {
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			
			int a = P * W;
			int b = Q;
			if(W>R) {
				b+=(W-R)*S;
			}
			
			
			int min = Math.min(a, b);
			System.out.println("#" + t + " " + min);
		}

	}

}
