package backjoon;

import java.util.Scanner;

public class bj10808_알파뱃개수 {
	static int[] alpha;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		String input = sc.next();
		alpha = new int[26];
		for (int i = 0; i < input.length(); i++) {
			int n = input.charAt(i) - 'a';
			alpha[n]++;
		}
		for (int i = 0; i < 26; i++) {
			sb.append(alpha[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
