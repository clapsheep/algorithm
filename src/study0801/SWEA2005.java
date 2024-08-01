package study0801;

import java.util.Scanner;

public class SWEA2005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			
			System.out.print("#"+i);
			for (int r = 0; r < N+1; r++) {
				for (int j = 1; j <= r; j++) {
					System.out.print(ncr(r-1,j-1)+" ");
				}
				System.out.println();
			}

		}
	}
	static int ncr(int n, int r) {
		int up = 1;
		int down = 1;
		
		if (n == r || r==0) {
			return 1;
		} else {
			int count = r;
			int tn = n;
			while(count-->0) {
				up*=tn--;
			}
			for (int i = r; i > 0; i--) {
				down *= i;
			}
			return up / down;
		}
	}

}
