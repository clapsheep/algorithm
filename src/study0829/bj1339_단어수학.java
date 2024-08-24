package study0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1339_단어수학 {
	static int N;
	static int[] alp;
	static int[] nums = {9,8,7,6,5,4,3,2,1,0};
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		alp = new int[26];
		for (int i = 0; i < N; i++) {
			char[] word = br.readLine().toCharArray();
			int jari = 0;
			for (int j = word.length - 1; j >= 0; j--) {
				alp[word[j] - 'A']+= Math.pow(10, jari);
				jari++;
			}
		}
		Arrays.sort(alp);
		res = 0;
		for (int i = 0; i < 10; i++) {
			res += alp[25-i]*nums[i];
		}
		System.out.println(res);
	}

}
