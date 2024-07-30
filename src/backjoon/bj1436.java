package backjoon;

import java.util.Scanner;

public class bj1436 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int start = 666;
		int count = 1;
		while(count!= N) {
			start++;
			if(String.valueOf(start).contains("666")) {
				count++;
			}
		}
		System.out.println(start);

	}

}
