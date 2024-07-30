package backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj10773 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Integer> arr = new ArrayList<>();
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			if (a == 0) {
				arr.remove(arr.size() - 1);
			} else {
				arr.add(a);
			}
		}
		int sum = 0;
		for(int a : arr) {
			sum+=a;
		}
		System.out.println(sum);

	}

}
