package study0919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj12886_돌그룹 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			int input = Integer.parseInt(st.nextToken());
			q.offer(input);
		}

		boolean res = calc(q);
		System.out.println(res ? 1 : 0);
	}

	private static boolean calc(Queue<Integer> q) {
		boolean[][][] v = new boolean[1001][1001][1001];
		while (!q.isEmpty()) {
			int A = q.poll();
			int B = q.poll();
			int C = q.poll();
			if (v[A][B][C])
				return false;
			v[A][B][C] = true;
			if (A == B && B == C) { // 꺼낸 3가지 모두가 같을 때
				return true;
			} else if (A != B) { // 첫번째와 두번째가 다를 떄
				if (A > B) {
					q.offer(C);
					q.offer(A - B);
					q.offer(B * 2);
				} else {
					q.offer(C);
					q.offer(B - A);
					q.offer(A * 2);
				}
			}else { // 첫번째와 두번째가 같을 때
				if (A > C) {
					q.offer(B);
					q.offer(A - C);
					q.offer(C * 2);
				} else {
					q.offer(B);
					q.offer(C - A);
					q.offer(A * 2);
				}
			}

		}
		return false;
	}

}
