import java.util.Scanner;

public class Solution_비트연산하는임스 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            
            String result = canBeShifted(N) ? "YES" : "NO";
            System.out.println("#" + t + " " + result);
        }

        scanner.close();
    }

	private static boolean canBeShifted(int n) {
		String str= Integer.toBinaryString(n);
		if(str.charAt(str.length()-1)=='1') {
			return false;
		}
		return true;
	}

}