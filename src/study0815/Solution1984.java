package study0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1984 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int[] arr = new int[10];
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int sum = 0;
			for (int i = 1; i < 9; i++) {
				sum += arr[i];
			}
			int res = (int)Math.round((1.0*sum)/8);
			System.out.println("#"+t+" "+res);
		}

	}

}
