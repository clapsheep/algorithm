package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj2628 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());

		// 각 조각의 넓이, 높이의 갯수는 = 컷팅횟수 + 1
		int pieceW = 1;
		int pieceH = 1;

		List<Integer> cuttingPointW = new ArrayList<Integer>();
		List<Integer> cuttinPointH = new ArrayList<Integer>();
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int cut = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			// 가로로 자르는 경우
			if (cut == 0) {
				cuttingPointW.add(pos);
				pieceW++;
				// 세로로 자르는 경우 
			} else {
				cuttinPointH.add(pos);
				pieceH++;
			}
		}
		Collections.sort(cuttingPointW);
		Collections.sort(cuttinPointH);

		int max = 0;
		int[] HLengths = new int[pieceW];
		int[] WLengths = new int[pieceH];
		
		// 첫번째 H의 길이 = 0 ~ 컷팅 포인트W의 1
		HLengths[0] = cuttingPointW.get(0);
		// 마지막 H의 길이 = 전체 H - 마지막 컷팅포인트 W
		HLengths[pieceW - 1] = H - cuttingPointW.get(cuttingPointW.size() - 1);
		for (int i = 1; i < pieceW - 1; i++) {
			HLengths[i] = cuttingPointW.get(i) - cuttingPointW.get(i - 1);
		}

		// 첫번째 의 길이 = 0 ~ 컷팅 포인트H의 1
		WLengths[0] = cuttinPointH.get(0);
		WLengths[pieceH - 1] = W - cuttinPointH.get(cuttinPointH.size() - 1);
		for (int i = 1; i < pieceH - 1; i++) {
			WLengths[i] = cuttinPointH.get(i) - cuttinPointH.get(i - 1);
		}
		
		
		
		for (int i = 0; i < HLengths.length; i++) {
			for (int j = 0; j < WLengths.length; j++) {
				int square = HLengths[i] * WLengths[j];
				max = Math.max(max, square);
			}
		}
		if (max!=0) {
		System.out.println(max);
		}else {
			System.out.println(W*H);
		}
	}

}
