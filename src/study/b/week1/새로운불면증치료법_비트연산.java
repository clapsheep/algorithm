package study.b.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 새로운불면증치료법_비트연산 {
	static int T, num, next;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			num = Integer.parseInt(br.readLine());
			next = num;
			
			int v = 0;
			int total = (1 << 10) - 1;
			int cnt = 0;
			while (true) {
				cnt++;
				String input = next + "";
				for (int i = 0; i < input.length(); i++) {
					v = v | (1 << input.charAt(i) - '0');
				}
				if (v==total) {
					break;
				};
				next = num * cnt;

			}
			sb.append(next);
			System.out.println(sb.toString());
		}
	}

}
