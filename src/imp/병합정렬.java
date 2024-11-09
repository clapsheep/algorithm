package imp;
import java.util.Arrays;
// 안정정렬, 임시 메모리 필요, O(NlogN);
public class 병합정렬 {
	static int[] arr = {3,5,7,1,2,9,8,0};
	static int N = arr.length;
	static int[] temp = new int[N];
	public static void main(String[] args) {
		ms(0,N-1);
		
		System.out.println(Arrays.toString(arr));
	}
	static void ms(int start, int end) {
		if(start>=end)return;
		int mid = (start+end)/2;
		ms(start,mid);
		ms(mid+1, end);
		m(start,mid,end);
		
	}
	static void m(int start, int mid, int end) {
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
		if(L<=mid) {
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
