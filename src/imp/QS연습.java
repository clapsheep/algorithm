package imp;
import java.util.Arrays;
// 안정정렬x, 임시메모리 불필요,O(NlogN) 최악에는O(N^2)
public class QS연습 {
	static int[] arr = { 1, 6, 7, 4, 3, 2, 9, 8 };
	static int N;

	public static void main(String[] args) {
		N = arr.length;
		quickSort(0, N - 1);
		System.out.println(Arrays.toString(arr));

	}

	static void quickSort(int start, int end) {
		if(start>=end)return;
		int pivot = partition(start,end);
		quickSort(start, pivot-1);
		quickSort(pivot+1, end);
		
	}

	static int partition(int start, int end) {
		int pivot = arr[start];
		int L = start;
		int R = end;
		while(L<=R) {
			while(L<=R && arr[L]<=pivot)L++;
			while(arr[R]>pivot)R--;
			if(L<R) {
				int temp = arr[L];
				arr[L] = arr[R];
				arr[R] = temp;
			}
		}
		int temp = arr[start];
		arr[start] = arr[R];
		arr[R] = temp;
			
		
		return R;
	}


}
