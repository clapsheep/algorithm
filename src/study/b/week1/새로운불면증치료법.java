package study.b.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 새로운불면증치료법 {
	static int T, num, next;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			num = Integer.parseInt(br.readLine());
			next= num;
			visited = new boolean[10];
			int res = 1;
			while (true) {
				String input = next + "";
				for (int i = 0; i < input.length(); i++) {
					visited[input.charAt(i)-'0'] = true;
				}
				if(!check()) {
					break;
				};
				next = num * res;
				res++;
				
			}
			sb.append(next);
			System.out.println(sb.toString());
		}
	}

	private static boolean check() {
		for (int i = 0; i < 10; i++) {
			if (!visited[i]) {
				return true;
			}
		}
		return false;
	}

}
