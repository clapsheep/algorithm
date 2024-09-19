package study0919;


	import java.io.*;

	public class bj1285_동전뒤집기2 {
	    static int N;
	    static char[][] board;

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        N = Integer.parseInt(br.readLine());
	        board = new char[N][N];

	        for (int i = 0; i < N; i++) {
	            board[i] = br.readLine().toCharArray();
	        }

	        int answer = Integer.MAX_VALUE;

	        // 행을 뒤집는 모든 경우의 수를 고려 (2^N)
	        for (int bit = 0; bit < (1 << N); bit++) {
	            int sum = 0;
	            // 각 열에 대해
	            for (int j = 0; j < N; j++) {
	                int count = 0;
	                // 각 행에 대해
	                for (int i = 0; i < N; i++) {
	                    char curr = board[i][j];
	                    // 해당 행이 뒤집혀야 하는 경우
	                    if ((bit & (1 << i)) != 0) {
	                        curr = (curr == 'H') ? 'T' : 'H';
	                    }
	                    if (curr == 'T') count++;
	                }
	                // 열의 T 개수와 (N - T 개수) 중 작은 값을 선택
	                sum += Math.min(count, N - count);
	            }
	            answer = Math.min(answer, sum);
	        }

	        System.out.println(answer);
	    }
	}