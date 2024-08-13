package study0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1983 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			double[] totalScore = new double[N];

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int middle = Integer.parseInt(st.nextToken());
				int last = Integer.parseInt(st.nextToken());
				int hw = Integer.parseInt(st.nextToken());
				// 총점 계산
				totalScore[n] = 0.35 * middle + 0.45 * last + 0.2 * hw;
			}
			// K의 점수 저장
			double Kscore = totalScore[K - 1];
			// 순위를 메기기 위한 정렬
			Arrays.sort(totalScore);
			String grade= "";
			for (int i = 0; i < totalScore.length; i++) {
				// 정렬된 점수들 중 K의 점수 조회
				if (totalScore[i] == Kscore) {
					// 오름차순이므로 전체 수에서 인덱스를 빼면 등수가 나옴
					// 전체 인원에서 등급 갯수만큼 나눈 수 보다 작으면 해당 등급
					if (N - i <= N / 10) {
						grade = "A+";
						break;
					}
					else if (N - i <= 2 * N / 10) {
						grade ="A0";
						break;
					}
					else if (N - i <= 3 * N / 10) {
						grade ="A-";
						break;
					}
					else if (N - i <= 4 * N / 10) {
						grade ="B+";
						break;
					}
					else if (N - i <= 5 * N / 10) {
						grade ="B0";
						break;
					}
					else if (N - i <= 6 * N / 10) {
						grade ="B-";
						break;
					}
					else if (N - i <= 7 * N / 10) {
						grade ="C+";
						break;
					}
					else if (N - i <= 8 * N / 10) {
						grade ="C0";
						break;
					}
					else if (N - i <= 9 * N / 10) {
						grade ="C-";
						break;
					}
					else {
						grade ="D0";
						break;
					}
				}
			}
			System.out.println("#"+t+" "+grade);
		}
	}

}
