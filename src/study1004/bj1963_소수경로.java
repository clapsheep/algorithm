package study1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1963_소수경로 {
	static int T, end, start;
	static boolean[] prime;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		prime = new boolean[10000];
		setPrime();
		
		
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			v = new boolean[10000];
			int res = bfs();
			System.out.println(res >= 0 ? res : "Impossible");
		}

	}

	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		v[start] = true;
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int cur = q.poll();
				if (cur == end) {
					return count;
				}
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j <= 9; j++) {
						if (i == 0 && j == 0)
							continue;
						int k = change(cur, i, j);
						if (!prime[k])
							continue;
						if (v[k])
							continue;
						v[k] = true;
						q.offer(k);

					}
				}
			}
			count++;
		}
		return -1;
	}

	private static int change(int cur, int position, int num) {
		char[] temp = String.valueOf(cur).toCharArray();
		temp[position] = (char) (num + '0');
		return Integer.parseInt(String.valueOf(temp));
	}

	private static void setPrime() {
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int i = 2; i * i < prime.length; i++) {
			if (prime[i]) {
				for (int j = i * i; j < prime.length; j += i) {
					prime[j] = false;
				}
			}
		}
	}

}
