package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10816_숫자카드2 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int m = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			int h = upper( m);
			int l = lower( m);
			cnt = h - l;
			sb.append(cnt).append(" ");

		}
		System.out.println(sb.toString());
	}

	private static int lower( int o) {
		int start = 0;
		int end = N;
		while(start<end) {
			int mid = (start+end)/2;
			if(arr[mid]>=o) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		return end;
	}

	private static int upper(int o) {
		int start = 0;
		int end = N;
		while(start < end) {
			int mid = (start+end)/2;
			if(arr[mid]<=o) {
				start = mid+1;
			}else {
				end=mid;
			}
		}
		return end;
	}
}
