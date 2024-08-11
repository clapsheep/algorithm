package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2477 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		int W = 0;
		int H = 0;

		int preD = 0;
		int preL = 0;
		int blank = 0;
		int start =0;
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			if(i==0) {
				start = length;
			}
			
			if ((direction == 1 && preD != 3) || (direction == 3 && preD != 2) || (direction == 2 && preD != 4)
					|| (direction == 4 && preD != 1)) {
				blank = preL * length;
			}
			if(i==5&& blank ==0) {
				blank = start*length;
			}

			preD = direction;
			preL = length;

			if (direction == 4 || direction == 3) {
				H = Math.max(H, length);
			}
			if (direction == 1 || direction == 2) {
				W = Math.max(W, length);
			}
			
		}
		int res = (W*H - blank)*K;
		System.out.println(res);

	}

}
