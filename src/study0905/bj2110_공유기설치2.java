package study0905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2110_공유기설치2 {
	static int N, C, res;
	static int[] street;
	static int[] selected;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		street = new int[N];
		for (int i = 0; i < N; i++) {
			street[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(street);
		res = 0;
		for (int i = 1; i < N-1; i++) {
			int left = street[i] - street[0];
			int right = street[N-1] - street[i];

			int temp=Math.min(left, right); // 양 끝중 더 가까운 곳
			res = Math.max(res, temp);
			
		}
		System.out.println(res);
		


	}

}
