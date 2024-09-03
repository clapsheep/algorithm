import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class BC {
	int x, y, P, C;
	boolean isInA = false;
	boolean isInB = false;

	public BC(int x, int y, int p, int c) {
		this.x = x;
		this.y = y;
		this.P = p;
		this.C = c;
	}

}

public class Solution5644_무선충전 {
	static int T, M, BC, sumA, sumB, time;
	static int N = 10;
	static int[] A, B;
	static List<BC> BCs = new ArrayList<>();
	static int[][] map = new int[N][N];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 시간
			BC = Integer.parseInt(st.nextToken()); // 충전기 갯수

			A = new int[M]; // A 경로
			B = new int[M]; // B 경로
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= BC; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;// x
				int y = Integer.parseInt(st.nextToken()) - 1;// y
				int C = Integer.parseInt(st.nextToken());// C
				int P = Integer.parseInt(st.nextToken());// P

				BCs.add(new BC(x, y, C, P));
			}
			time = 0;
			int[] startA = { 0, 0 };
			int[] startB = { 9, 9 };

			calc(startA, startB);// 입력받은 위치의 충전용량 더하기
			for (int i = 0; i < M; i++) {

			}

		}

	}

	private static void calc(int[] a, int[] b) {

		int tempA = 0;
		int tempB = 0;
		
		for (int j = 0; j < BC; j++) {
			BC charger = BCs.get(j);
			
			if (isInCharger(a, charger)) {
				charger.isInA = true;
				tempA++;
			}
			if (isInCharger(b, charger)) {
				charger.isInB = true;
				tempB++;
			}
		}
		
		

	}

	private static boolean isInCharger(int[] person, BC charger) {
		return Math.abs(charger.y - person[0]) + Math.abs(charger.x - person[1]) <= charger.C;
	}

}