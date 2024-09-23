package study0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1477_휴게소세우기_그리디로접근했는데안됌 {
	static PriorityQueue<Integer> pq;
	static int N, M, L;
	static int[] station;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		station = new int[N + 2];
		station[0] = 0;
		station[N + 1] = L;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			station[i + 1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(station);
		pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int i = 1; i < N + 2; i++) {
			pq.offer(station[i] - station[i - 1]);
		}
		System.out.println(Arrays.toString(station));
		System.out.println(pq);
		while (M-- != 0) {
			int cur = pq.poll();
			System.out.println(cur);
			if (cur % 2 == 0) {
				pq.offer(cur / 2);
				pq.offer(cur / 2);
			} else {
				pq.offer((cur - 1) / 2);
				pq.offer((cur - 1) / 2 + 1);
			}
		}
		System.out.println(pq.poll());
	}

}
