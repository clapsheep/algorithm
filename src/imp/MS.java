package imp;
import java.util.Arrays;

public class MS {
	static int[] arr = {4,7,10,1,2,6,9,};
	static int N = arr.length;
	static int[] temp = new int[N];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort(0,N-1);
		System.out.println(Arrays.toString(arr));
	}
	static void MergeSort(int start, int end) {
		if(start >= end) return;
			int mid = (start + end)/2;
			MergeSort(start,mid);
			MergeSort(mid+1,end);
			merge(start,mid,end);
		
	}
	private static void merge(int start,int mid, int end) {
		
		int L = start;
		int R = mid+1;
		int index= L;
		
		while(L<= mid && R<=end) {
		if(arr[L]<=arr[R]) {
			temp[index++] = arr[L++];
		}else {
			temp[index++] = arr[R++];
		}
		}
		if(L<=mid) {
			for (int i = L; i <= mid; i++) {
				temp[index++] = arr[i];
			}
		}
		else {
			for (int i = R; i <= end; i++) {
				temp[index++] = arr[i];
			}
		}
		for (int i = start; i <= end; i++) {
			arr[i] = temp[i];
		}
	}

}
