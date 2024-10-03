package study1004;

import java.util.Scanner;


public class bj11729_하노이탑이동순서 {

	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sb = new StringBuilder();

		int count = hanoi(N, 1, 2, 3, 0);
		System.out.println(count);
		System.out.println(sb.toString());

	}

	private static int hanoi(int n, int start, int sub, int end, int count) {
		if (n == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			return count+1;
		}
		count = hanoi(n-1, start, end, sub, count);
		sb.append(start).append(" ").append(end).append("\n");
		count = hanoi(n-1,sub,start,end,count);
		return count+1;
	}

}
