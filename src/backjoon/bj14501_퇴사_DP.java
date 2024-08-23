package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP로 풀어야하는 문제라 아직 모름
public class bj14501_퇴사_DP {
	static int N;
	static int[] nums;
	static int[] T;
	static int[] P;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()) + 1;
		nums = new int[N];
		T = new int[N];
		P = new int[N];
		max = 0;
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		ps(1);
		System.out.println(max);
	}
	static void ps(int cnt) {
		if (cnt == N) {
			int sum = calc(nums);
			max = Math.max(max, sum);
			return;
		}
		nums[cnt] = T[cnt];
		ps(cnt + 1);
		nums[cnt] = 0;
		ps(cnt + 1);
	}

	static int calc(int[] Tarr) {
		int sum = 0;
		for (int j = 1; j < N; j++) {
			if (Tarr[j] == 0) continue; // 지금이 안볼날이야? 넘어가
			int nt = j + Tarr[j]-1; // 지금 상담하면 다음 일정은?
			if (nt < N) { // 다음 일정이 가능해?
				sum += P[j]; // 그러면 지금 상담돈 받아
				j = nt; // 다음 상담으로 바로 넘어가
			}else {
				break;
			}
		}
		return sum;
	}


}
