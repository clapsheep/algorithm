package imp;

public class BS {
	static int[] nums = { 2, 4, 7, 9, 11, 19, 23 };

	public static void main(String[] args) {
		int N = nums.length;
		int index = bs(0, N - 1, 8);
		System.out.println(index);

	}

	private static int bs(int start, int end, int i) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;

		if (nums[mid] == i) {
			return mid;
		} else if (nums[mid] < i) {
			return bs(mid + 1, end, i);
		} else {
			return bs(start, mid - 1, i);
		}
		
	}

}
