package swea;

import java.util.Scanner;

public class SWEA2005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			
			for (int r = 0; r < N; r++) {
				for (int j = 1; j <= r+1; j++) {
					if(j==1||j==r+1) {
						System.out.print("1");
					}else {
					System.out.print(j);
					}
				}
				System.out.println();
			}
			
			
			
		}

	}

}
