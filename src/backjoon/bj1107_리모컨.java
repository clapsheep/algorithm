package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj1107_리모컨 {
	static int channel, N, M, min;
	static int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static char[] choice;
	static boolean[] v;
	static List<Integer> live = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		channel = Integer.parseInt(br.readLine()); // 원하는 채널
		N = ("" + channel).length();
		M = Integer.parseInt(br.readLine()); // 고장난 버튼의 수
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < M; i++) {
				int b = Integer.parseInt(st.nextToken());
				nums[b] = -1; // 고장난 버튼 마킹
			}
		}
		for (int i = 0; i < 10; i++) {
			if (nums[i] != -1)
				live.add(i); // 살아남은 번호들
		}
		v = new boolean[live.size()];

		min = 500001;
		// 그냥 100번에서 플마하기
		if (channel < 110 && channel > 90) { // 범위를 이렇게 잡은 이유? 모든 버튼이 고장 났을 수 있으니까?
			min = Math.abs(100 - channel);
		}

		if (isAllBroken()) {
			System.out.println(min);
			return;
		} else {
			// 버튼을 눌러서 만들 수 있는 근사값 구해서 플 마 하기;
			for (int i = 1; i <= N+1; i++) {
				choice = new char[i];
				npr(0, i);
			}
		}
		System.out.println(min);
	}

	private static void npr(int cnt, int target) {

		if (cnt == target) {
			int number = Integer.parseInt(new String(choice));
			int res = Math.abs(number - channel) + target;
			min = Math.min(res, min);
			return;
		}
		for (int i = 0; i < live.size(); i++) {
//			if (cnt == 0 && live.get(i) == 0) continue;
			choice[cnt] = (char) (live.get(i) + '0');
			npr(cnt + 1, target);

		}

	}

	private static boolean isAllBroken() {
		for (int i = 0; i < 10; i++) {
			if (nums[i] != -1)
				return false;
		}
		return true;
	}

}
