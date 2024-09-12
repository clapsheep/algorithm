package backjoon;

import java.util.Scanner;

public class bj1065_한수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(hansoo(i)) cnt++;
		}
		System.out.println(cnt);
	}

	private static boolean hansoo(int num) {
		if(num<10) return true;
		char[] c= (""+num).toCharArray();
		int temp = c[c.length-1]-c[c.length-2];
		for (int i = c.length-1; i >= 1; i--) {
			if((c[i]-c[i-1])!=temp)return false;
		}
		return true;
	}

}
