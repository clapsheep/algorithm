package imp;
import java.util.Arrays;

public class QuickSort {
	static int[] arr = { 3, 5, 7, 1, 2, 9, 8, 0 };
	static int N = arr.length;

	public static void main(String[] args) {
		quickSort(0, N - 1);

		System.out.println(Arrays.toString(arr));

	}

	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
	}

	static int partition(int left, int right) {
		int pivot = arr[left];
		int L = left + 1;
		int R = right;
		while (L <= R) {
			while (L <= R && arr[L] <= pivot) L++; // L 피봇보다 큰 값을 찾을 때 까지.
			while (arr[R] > pivot) R--;
			if(L<R) {
				int temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			}
		}
		int temp = arr[left];
		arr[left] = arr[R];
		arr[R] = temp;
		
		
		return R;
	}
}
