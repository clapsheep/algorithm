package backjoon;

import java.util.Scanner;

public class bj1463_1로만들기 {
	static int N;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		div(N);
		System.out.println(cnt);
	}
	static int div(int n) {
		if(n == 1) return n; 
		if(n%3 == 0) {
			cnt++;
			return div(n/3);
		}else if(n%2 == 0) {
			cnt++;
			return div(n/2);
		}else {
			cnt++;
			return div(n-1);
		}
	}

}
