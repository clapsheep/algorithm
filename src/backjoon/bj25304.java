package backjoon;

import java.util.Scanner;

public class bj25304 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long X = sc.nextLong();
		int N = sc.nextInt();
		
		long sum = 0;
		for (int i = 0; i < N; i++) {
			int price = sc.nextInt();
			int count = sc.nextInt();
			sum += price*count;
		}
		if(X==sum) {
			System.out.println("Yes");
		}else {
			 System.out.println("No");
		}
	}

}
