package study1219;
/*
테스트 1 〉	통과 (0.02ms, 80.5MB)
테스트 2 〉	통과 (0.02ms, 84MB)
테스트 3 〉	통과 (0.02ms, 80.7MB)
테스트 4 〉	통과 (0.03ms, 81MB)
테스트 5 〉	통과 (0.03ms, 81.9MB)
테스트 6 〉	통과 (0.03ms, 79.4MB)
테스트 7 〉	통과 (0.02ms, 77.6MB)
테스트 8 〉	통과 (0.05ms, 70.4MB)
테스트 9 〉	통과 (0.04ms, 75.6MB)
테스트 10 〉	통과 (0.02ms, 74.9MB)
테스트 1 〉	통과 (0.54ms, 54.9MB)
테스트 2 〉	통과 (0.33ms, 54.5MB)
테스트 3 〉	통과 (0.43ms, 54.1MB)
테스트 4 〉	통과 (0.61ms, 54.3MB)
테스트 5 〉	통과 (0.53ms, 53.8MB)
테스트 6 〉	통과 (0.53ms, 53.8MB)
테스트 7 〉	통과 (0.41ms, 61.7MB)
테스트 8 〉	통과 (0.66ms, 53.9MB)
테스트 9 〉	통과 (0.72ms, 53.7MB)
테스트 10 〉	통과 (0.37ms, 53.6MB)
*/
class programmers_등굣길 {
	public int solution(int m, int n, int[][] puddles) {
		int[][] dp = new int[n][m];

		for (int[] p : puddles) {
			dp[p[1] - 1][p[0] - 1] = -1;
		}

		for (int i = 0; i < n; i++) {
			if (dp[i][0] == -1)
				break;
			dp[i][0] = 1;
		}
		for (int i = 0; i < m; i++) {
			if (dp[0][i] == -1)
				break;
			dp[0][i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (dp[i][j] == -1)
					continue;
				int up = dp[i - 1][j] == -1 ? 0 : dp[i - 1][j];
				int left = dp[i][j - 1] == -1 ? 0 : dp[i][j - 1];
				dp[i][j] = (up + left) % 1000000007;
			}
		}
		int answer = dp[n - 1][m - 1];
		return answer;
	}
}