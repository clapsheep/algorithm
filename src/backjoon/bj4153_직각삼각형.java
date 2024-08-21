package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj4153_직각삼각형 {
	static int a, b, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0 && c == 0) {
				return;
			}

			if (a * a == b * b + c * c || b * b == a * a + c * c || c * c == b * b + a * a) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}

		}
	}

}
