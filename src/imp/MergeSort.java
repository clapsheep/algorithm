package imp;
import java.util.Arrays;

public class MergeSort {
	static int[] arr = { 7, 5, 13, 2, 79, 12, 35, 42 };
	static int N = arr.length;
	static int[] temp = new int[N];

	public static void main(String[] args) {

		mergeSort(0, N - 1);
		System.out.println(Arrays.toString(arr));
	}

	// s = start, e = end
	static void mergeSort(int s, int e) {
		if (s >= e)
			return;
		int m = (s + e) / 2;
		mergeSort(s, m);
		mergeSort(m + 1, e);
		merge(s, m, e);
	}

	static void merge(int s, int m, int e) {
		int L = s; // 왼쪽 시작 포인트
		int R = m + 1; // 오른쪽 시작 포인트
		int idx = L; // temp배열의 인덱스
		while (L <= m && R <= e) { // 각 포인트들이 끝까지 가지 않았다.
			if (arr[L] <= arr[R]) {
				temp[idx++] = arr[L++];
			} else {
				temp[idx++] = arr[R++];
			}

		}
		if (L <= m) { // 왼쪽 구간의 값이 남았거면
			for (int i = L; i <= m; i++) {
				temp[idx++] = arr[i];
			}
		} else {// 오른쪽 구간의 값이 남았다면
			for (int i = R; i <= e; i++) {
				temp[idx++] = arr[i];
			}
		}
		// 원본 배열에 반영
		for (int i = s; i <= e; i++) {
			arr[i] = temp[i];
		}
	}

}
