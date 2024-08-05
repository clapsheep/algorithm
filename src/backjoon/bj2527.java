package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2527 {
	static int x1;
	static int y1;
	static int p1;
	static int q1;
	static int x2;
	static int y2;
	static int p2;
	static int q2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			p1 = Integer.parseInt(st.nextToken());
			q1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			p2 = Integer.parseInt(st.nextToken());
			q2 = Integer.parseInt(st.nextToken());
			if (p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1) {
				System.out.println("d");
			}
			else if ((x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2)) {
				System.out.println("c");
			}
			else if (p1 == x2 || q1 == y2|| p2 == x1 || y1 == q2){
				System.out.println("b");
			}
			else {
				System.out.println("a");
			}
		}
	}

}
