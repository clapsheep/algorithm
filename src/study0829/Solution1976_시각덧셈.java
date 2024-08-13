package study0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1976_시각덧셈 {
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int hour1 = Integer.parseInt(st.nextToken());
			int min1 = Integer.parseInt(st.nextToken());
			int hour2 = Integer.parseInt(st.nextToken());
			int min2 = Integer.parseInt(st.nextToken());
			int hour = hour1 + hour2;
			int min = min1 + min2;
			if(min >=60) {
				hour++;
				min -=60;
			}
			if(hour >12) {
				hour-=12;
			}
			System.out.println("#"+t+" "+hour+" "+min);
			
			
		}
	}

}
