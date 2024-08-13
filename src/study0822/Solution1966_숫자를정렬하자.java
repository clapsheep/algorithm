package study0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1966_숫자를정렬하자 {
	static int T, N;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			int max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max= Math.max(max, arr[i]);
			}
			// 카운팅정렬
			int[] count = new int[max+1];

			for (int i = 0; i < N; i++) {
				count[arr[i]]++;
			}
			for (int i = 1; i < count.length; i++) {
				count[i]+= count[i-1];
			}
			int[] res = new int[N];
			for (int i = N-1; i >= 0; i--) {
				res[count[arr[i]]-1] = arr[i];
				count[arr[i]]--;
			}
			String a =""; 
			for (int i = 0; i < N; i++) {
				a+=(res[i]+" ");
			}
			System.out.println("#"+t+" "+a);
		
			
			
			
//			// 카운팅 배열
//			for (int i = 0; i < N ; i++) {
//				count[arr[i]]++;
//			}
//			// 카운팅 배열을 누적합 배열로 만들기
//			for (int i = 1; i < count.length; i++) {
//				count[i] += count[i-1];
//			}
//			int[] sorted = new int[N];
//			for (int i = N-1; i >= 0; i--) { // 안정정렬을 위해 뒤에서부터 배치
//				//sorted[위치정보 = count의 index숫자] = arr[i]
//				sorted[count[arr[i]]-1] = arr[i]; // 1을 빼주는 이유는 index는 0부터 시작하기 때문(max에 1을 더해준 것과 같은 이)
//				count[arr[i]]--;
//			}
			
			
			
			
		}
	}

}
