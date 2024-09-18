package study0919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj12886_돌그룹2 {
	static class Stone {
		int a, b, c;

		public Stone(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int sum = A + B + C;

		if (sum % 3 != 0) {
			System.out.println(0);
		} else {
			boolean res = bfs(A, B, C);
			System.out.println(res ? 1 : 0);
		}
	}

	private static boolean bfs(int inputA, int inputB, int inputC) {
		boolean[][] v = new boolean[1501][1501];
		Queue<Stone> q = new LinkedList<>();
		q.offer(new Stone(inputA, inputB, inputC));
		v[inputA][inputB] = true;
		while (!q.isEmpty()) {
			Stone cur = q.poll();
			int A = cur.a;
			int B = cur.b;
			int C = cur.c;

			if (A == B && B == C) {
				return true;
			}
			if (A != B) {
				int na = A > B ? A - B : A + A;
				int nb = A > B ? B + B : B - A;
				if (!v[na][nb]) {
					v[na][nb] = true;
					q.offer(new Stone(na, nb, C));
				}
			}
			if (B != C) {
				int nb = B > C ? B - C : B + B;
				int nc = B > C ? C + C : C - B;
				if (!v[nb][nc]) {
					v[nb][nc] = true;
					q.offer(new Stone(A, nb, nc));
				}
			}
			if (A != C) {
				int na = A > C ? A - C : A + A;
				int nc = A > C ? C + C : C - A;
				if (!v[na][nc]) {
					v[na][nc] = true;
					q.offer(new Stone(na, B, nc));
				}

			}
		}
		return false;
	}

}
