package study0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class bj1339_단어수학_dfs실패 { // 시간초과
	static Set<Character> alpha;
	static Character[] alphaList;
	static int[] alphaToNums;
	static boolean[] v;
	static int M;
	static int N;
	static String[] words;
	static int[] nums = {0,1,2,3,4,5,6,7,8,9};
	static int max;
	static Map<Character, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = Integer.MIN_VALUE;
		words = new String[N];
		alpha = new HashSet<>();
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
			int n = words[i].length();
			for (int j = 0; j < n; j++) {
				alpha.add(words[i].charAt(j));
			}
		}
	
		M = alpha.size();
		alphaList =alpha.toArray(new Character[0]);
		
		
		v = new boolean[10];
		alphaToNums = new int[M];
		dfs(0);
		
		System.out.println(max);

	}

	static void dfs(int cnt) {
		if(cnt == M) {
			int res = calc(alphaToNums);
			max = Math.max(res, max);
			return;
		}
		for (int i = 0; i < 10; i++) {
			if(v[i]) continue;
			v[i] = true;
			alphaToNums[cnt] = nums[i];
			dfs(cnt+1);
			alphaToNums[cnt] = 0;
			v[i] = false;
		}
		
	}

	static int calc(int[] numbers) {
		for (int i = 0; i < M; i++) {
			map.put(alphaList[i], numbers[i]);
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			StringBuilder toNum = new StringBuilder();
			for (int j = 0; j < words[i].length(); j++) {
				 toNum.append(map.get(words[i].charAt(j)));
			}
			sum += Integer.valueOf(toNum.toString());
		}
		
		return sum;
		
	}

}
