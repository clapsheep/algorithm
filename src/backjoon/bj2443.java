package backjoon;

import java.util.Scanner;

public class bj2443 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = i; j <=i ; j++) {
				System.out.print(" ");
			}
			for (int j = N; j >=N-i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
