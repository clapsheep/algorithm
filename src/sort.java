import java.util.Arrays;

public class sort {

	public static void main(String[] args) {
		int[] arr = {-1,9,3,2,6,4,5};
		
		int[] bubbleArr = new int[arr.length];
		bubbleArr = bubble(arr);
		System.out.println(Arrays.toString(bubbleArr));
		System.out.println(binarySearch(bubbleArr,4));
		System.out.println(practice(bubbleArr,-1));
		

	}
	static int[] bubble(int[] intArr) {
		int[] res = Arrays.copyOf(intArr, intArr.length);
		int N = res.length;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N-1; j++) {
				if(res[j] > res[j+1]) {
					int tmp = res[j];
					res[j] = res[j+1];
					res[j+1] = tmp;
				}
			}
			
		}
		return res;
	}
	static int binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length-1;
		while(left <= right) {
			int mid = (left + right)/2;
			if(arr[mid] == key) {
				return mid;
			} else if (arr[mid]<key){
				left = mid+1;
			} else {
				right = mid -1;
			}
		}
		return -1;
	}
	static int practice (int[] arr, int key) {
		int left = 0;
		int right = arr.length-1;
		while(left<= right) {
			int mid = (left + right)/2;
			if(arr[mid]== key) {
				return mid;
			}else if (arr[mid]< key) {
				left = mid +1;
			}else {
				right = mid -1;
			}
		}
		return -1;
	}
}
