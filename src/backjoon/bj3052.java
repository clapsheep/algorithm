package backjoon;

import java.util.Scanner;

public class bj3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[10];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt() % 42;
		}
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					nums[j] = -1;

				}

			}

		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != -1) {
				count++;
			}
		}
		System.out.println(count);
	}
}
