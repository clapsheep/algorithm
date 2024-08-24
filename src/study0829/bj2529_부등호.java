package study0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj2529_부등호 {
	static int K;
	static char[] sign;
	static int N = 10;
	static int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int[] choice;
	static boolean[] v;
	static List<String> res;
	// 468ms
	// dfs로 모든 부등호 사이에 숫자가 들어갈 경우를 찾은 후
	//	check로 성립하는 경우에만 sb로 담아서 리턴
	// 나온 모든 결과물의 첫번째(최소)와 마지막(최대)을 출력 -> 이 과정이 조금 비효율적
	public static void main(String[] args) throws IOException {
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
		res = new ArrayList<>();

		dfs(0);
		sb.append(res.get(res.size()-1)).append("\n").append(res.get(0));
		System.out.println(sb);
	}

	static void dfs(int cnt) {
		if (cnt == K + 1) {
			check(choice);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i])
				continue;
			v[i] = true;
			choice[cnt] = nums[i];
			dfs(cnt + 1);
			choice[cnt] = 0;
			v[i] = false;
		}
	}

	static void check(int[] arr) {
		for (int i = 0; i < K; i++) {
			switch(sign[i]) {
			case '<':
				if(arr[i]>arr[i+1]) return;
				break;
			case '>':
				if(arr[i]<arr[i+1]) return;
				break;
			}
			
		}
		StringBuilder linkNum = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			linkNum.append(arr[i]);
		}
		res.add(linkNum.toString());
		
	}

}
