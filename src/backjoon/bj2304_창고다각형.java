package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2304_창고다각형 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr= new int[1001]; // 배열의 인덱스가 위치 값이 높이
		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;
		int maxIdx = Integer.MIN_VALUE;
		int maxH = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L =  Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			arr[L] = H;
			start = Math.min(start, L); // 기둥 시작점
			end = Math.max(end, L); // 기둥 끝점
			
		}
		for (int i = start; i <= end; i++) {
			if(arr[i]>maxH) {
				maxIdx = i;
				maxH = arr[i];
			}
		}
		for (int i = start; i < maxIdx; i++) {
			if(arr[i]>arr[i+1]) {
				arr[i+1] = arr[i];
			}
		}
		for (int i = end; i > maxIdx; i--) {
			if(arr[i]>arr[i-1]) {
				arr[i-1]=arr[i];
			}
		}
		int sum= 0;
		for (int i = start; i <= end; i++) {
			sum += arr[i];
		}
		System.out.println(sum);

	}

}
