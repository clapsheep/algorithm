package imp;
import java.util.Arrays;

public class 병합정렬연습 {
	static int[] arr = { 1, 6, 7, 4, 3, 2, 9, 8 };
	static int N;
	static int[] temp;

	public static void main(String[] args) {
		N = arr.length;
		temp = new int[N];

		mergeSort(0, N - 1);
		System.out.println(Arrays.toString(arr));
	}

	static void mergeSort(int start, int end) {
		if(start>=end)return;
		int mid = (start+end)/2;
		mergeSort(start,mid);
		mergeSort(mid+1,end);
		merge(start, mid, end);
		
	}

	static void merge(int start, int mid, int end) {
		int L = start;
		int R = mid+1;
		int index = start;
		while(L<=mid && R<=end) {
			if(arr[L]<=arr[R]) {
				temp[index++] = arr[L++];
			}else {
				temp[index++] = arr[R++];
			}
		}
		if(L<= mid) {
			for (int i = L; i <= mid; i++) {
				temp[index++] = arr[i];
			}
		}else {
			for (int i = R; i <= end; i++) {
				temp[index++] = arr[i];
			}
		}
		for (int i = start; i <= end; i++) {
			arr[i] = temp[i];
		}
	}

	

}
