package backjoon;

import java.util.Scanner;

public class bj10974_모든순열 {
	static int N;
	static boolean[] v;
	static int[] res;
	static StringBuilder sb;
	public static void main(String[] args) {
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		res = new int[N];
		v= new boolean[N];
		npr(0);
		System.out.println(sb.toString());
	}

	private static void npr(int cnt) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i])continue;
			v[i] = true;
			res[cnt] = i+1;
			npr(cnt+1);
			res[cnt] = 0;
			v[i] = false;
			
		}
		
	}

}
