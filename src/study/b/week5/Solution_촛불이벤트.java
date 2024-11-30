package study.b.week5;

import java.util.Scanner;

public class Solution_촛불이벤트 {
	static int T;
	static long N; // 사용할 양초의 갯수
	public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			N = sc.nextLong();
			// 구하고자 하는 건 몇단?
			long L = 1; // 1단 부터 시
			long R = 10000000000L; // 최대 N단
			long res = -1;
			while(L <= R) {
				long mid = (L+R)/2;
				long cnt = calc(mid);
				if(cnt <= N) {
					res = mid;
					L= mid+1;
				}else {
					R = mid-1;
				}
				
			}
			long value = res *(res +1)/2;
			if(N !=value) {
				res = -1;
			}
			sb.append(res);
			System.out.println(sb.toString());
			
		}

	}
	private static long calc(long mid) {
		return mid*(mid+1)/2;
	}

}

