package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2491 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 앞에서 부터 보는 경우
		// 처음 3개 같거나 증가? -> 4개 ->5개 -> 6개 보다가 줄어들 때 stop
		// 다음 3개 같거나 증가? -> 4개 ->5개 -> 6개 보다가 줄어들 때 stop
		// 계속 반복하되, N-3까지만
	

		// 뒤에서 부터 보는 경우

	}

}
