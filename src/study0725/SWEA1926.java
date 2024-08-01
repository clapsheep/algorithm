package study0725;

import java.util.Scanner;

public class SWEA1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int n = 1; n <= N; n++) {
			String res = "";
			int a = n%10; // 일의자리
			int b = n/10; //십의자리
			int c = n/100; // 백의 자리
			
			if(a==3||a==6||a==9) {
				res+="-";
			}
			if(b==3||b==6||b==9) {
				res+="-";
			}
			if(c==3||c==6||c==9) {
				res+="-";
			}
			if(res.length() ==0) {
				System.out.print(n+" ");
			}else {
				System.out.print(res+ " ");
			}

		}
	}
	
}
