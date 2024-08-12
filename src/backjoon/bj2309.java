package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj2309 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		boolean[] visited = new boolean[9];

		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}

		combination(arr, visited, 0, 9, 7);

	}

	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if (r == 0) { // r개 선택 완료
			int res = sum(arr, visited, n); // 출력 함수 맨 아래 합친 코드에서 확인해 주세요.
			if(res == 100) {
				print(arr, visited, n);
				return;
			}
		}

		for (int i = start; i < n; i++) {
			visited[i] = true; // 선택한 원소
			// 선택한 원소의 다음 원소부터 선택하기 때문에(이미 선택한 원소는 선택하면 안되기 때문) i는 1씩 증가하고 r은 선택할 원소의 갯수가
			// 줄어들기 때문에 1씩 감소한다.
			combination(arr, visited, i + 1, n, r - 1);
			visited[i] = false; // 다음 for문 전에 선택 원소 초기화
		}
	}

	static int sum(int[] arr, boolean[] visited, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				sum += arr[i];
			}
		}
		return sum;
	}

	static void print(int[] arr, boolean[] visited, int n) {
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				System.out.println(arr[i]);
			}
		}
	}

}
