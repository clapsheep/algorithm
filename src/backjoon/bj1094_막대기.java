package backjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class bj1094_막대기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		int stick = 64;
		int count = 0;

		while (X > 0) {
			if (stick > X) {
				stick /= 2;

			} else {
				X -= stick;
				count++;
			}
		}

		System.out.println(count);
		
	}

}


