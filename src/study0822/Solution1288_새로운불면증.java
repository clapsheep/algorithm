package study0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1288_새로운불면증 {
	static int T;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int cnt = 0;
			// 0~9 index가 나왔는지 체크하는 배열
			boolean[] numbers = new boolean[10];
			
			// while문 멈추는 친구
			boolean breaker = true;
			while(breaker) {
				cnt++;
				int now = N*cnt;
				// 현재 배수의 각 자리 수 검사
				char[] nums = String.valueOf(now).toCharArray();
				for (int i = 0; i < nums.length; i++) {
					int index = nums[i]-'0'; 
					numbers[index] = true;
				}
				breaker = false;
				for (int i = 0; i < numbers.length; i++) {
					if(numbers[i]== false) { // 모두가 트루면 브레이커 false  
						breaker = true;
					}
				}	
			}
			System.out.println("#"+t+" "+ cnt*N);
		}
	}

}
