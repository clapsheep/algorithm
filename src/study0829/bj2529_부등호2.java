package study0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2529_부등호2 {
	static int K;
	static char[] sign;
	static int N = 10;
	static int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int[] choice;
	static boolean[] v;
	static long max, min;
	static String maxString, minString;

	// 424ms
	// dfs로 모든 부등호 사이에 숫자가 들어갈 경우를 찾은 후
	// check로 성립하는 경우에만 sb로 담아서 리턴
	// 나온 모든 결과물을 min와 max에 담아서 출력 -> 그래도 그리 안빠름 
	public static void main(String[] args) throws IOException {
		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		sign = new char[K];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		choice = new int[K + 1];
		v = new boolean[N];
		dfs(0);
		sb.append(maxString).append("\n").append(minString);
		System.out.println(sb.toString());
	}
	
	static void dfs(int cnt) {
		if (cnt == K + 1) {
			if (check(choice)) {
				long num = arrToInt(choice);
				min = Math.min(min, num);
				max = Math.max(max, num);
				if (min == num)
					minString = arrToString(choice);
				if (max == num)
					maxString = arrToString(choice);
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i]) continue;
			v[i] = true;
			choice[cnt] = nums[i];
			dfs(cnt + 1);
			choice[cnt] = 0;
			v[i] = false;
		}
	}

	static boolean check(int[] arr) {
		for (int i = 0; i < K; i++) {
			switch (sign[i]) {
			case '<':
				if (arr[i] > arr[i + 1])
					return false;
				break;
			case '>':
				if (arr[i] < arr[i + 1])
					return false;
				break;
			}
		}
		return true;
	}

	static String arrToString(int[] arr) {
		StringBuilder linkNum = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			linkNum.append(arr[i]);
		}
		return linkNum.toString();
	}

	static long arrToInt(int[] arr) {
		int tenPow = 0;
		long res = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			res += arr[i] * Math.pow(10, tenPow++);
		}
		return res;
	}
}
