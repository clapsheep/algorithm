package study0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1654_랜선자르기 {
	static int N, K;
	static long[] lans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken()); // 이미 가진 랜선
		N = Integer.parseInt(st.nextToken()); // 필요한 랜선
		lans = new long[K];
		for (int i = 0; i < K; i++) {
			lans[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(lans);
		search(0, lans[K - 1]+1);
	}

	static void search(long left, long right) {
		long mid = (left + right) / 2;
		if (left == mid) {
			System.out.println(mid);
			return;
		}
		int cnt = 0;
		for (int i = K - 1; i >= 0; i--) {
			cnt += lans[i] / mid;
			if (lans[i] / mid == 0) {
				break;
			}
		}
		if (cnt < N) {
			search(left, mid);
		} else {
			search(mid, right);
		}

	}

}
