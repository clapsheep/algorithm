package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2512_예산 {
	static int N, sum, totalMoney, max;
	static int[] money;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		money = new int[N];
		sum = 0;
		max = 0;
		StringTokenizer st  = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
			sum += money[i];
			max = Math.max(max, money[i]);
		}
		totalMoney = Integer.parseInt(br.readLine());
		if(totalMoney>=sum) {
			System.out.println(max);
			return;
		}else {
			int left = 1;
			int right = max;
			int res= 0;
			while(left<=right) {
				int mid = (right+left)/2;
				int c = calc(mid);
				if(c <= totalMoney) {
					res = mid;
					left = mid+1;
				}else {
					right = mid-1;
				}
			}
			System.out.println(res);
		}
		
	}
	private static int calc(int mid) {
		int temp = 0;
		for (int i = 0; i < N; i++) {
		 temp += Math.min(money[i], mid);
		}
		return temp;
	}

}
