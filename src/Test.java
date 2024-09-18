import java.util.Arrays;

public class Test {
	static int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int N = 9, M = 3, count;
	static boolean[] v;
	static int[] choice;

	public static void main(String[] args) {
		v = new boolean[N];
		choice = new int[M];
		count=0;
		npr(0);
		System.out.println(count);

	}

	private static void npr(int cnt) {
		if(cnt==M) {
			count++;
			System.out.println(Arrays.toString(choice));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i])continue;
			v[i] = true;
			choice[cnt] = nums[i];
			npr(cnt+1);
			choice[cnt] = 0;
			v[i] = false;
		}
	}

}
