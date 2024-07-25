package backjoon;

import java.util.Scanner;

public class bj2480 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dices = new int[3];
		for (int i = 0; i < dices.length; i++) {
			dices[i] = sc.nextInt();
		}
		
		int sum = 0;
		int max = 0;
		// 1개만 같은 경우
		if (dices[0] == dices[1] && dices[1] != dices[2]) {
			sum =1000+ dices[0] *100;
		} else if (dices[1] == dices[2] && dices[0] != dices[1]) {
			sum =1000+ dices[1] *100;
		} else if (dices[0] == dices[2] && dices[0] != dices[1]) {
			sum =1000+ dices[0] *100;
		}

		// 2개 다 같은 경우
		else if (dices[0] == dices[1] && dices[1] == dices[2]) {
			sum =10000+ dices[0] * 1000;
			// 2개만 같은 경우
		} else {
			for (int i = 0; i < dices.length; i++) {
				max = Math.max(max, dices[i]);
			}
			sum =max * 100;
		}
		System.out.println(sum);
	}

}
