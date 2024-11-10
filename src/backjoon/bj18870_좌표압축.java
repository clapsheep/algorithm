package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj18870_좌표압축 {

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] res = new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			arr[i] = input;
			res[i] = input;
		}
		// 배열을 적은 순으로 갯수를 세기 위해 정렬
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		// 맵에 정렬된 숫자들의 중복없이 인덱스를 값으로 부여
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], cnt++);
			}

		}
		
		for (int i = 0; i < N; i++) {
			sb.append(map.get(res[i])).append(" ");
		}
		System.out.println(sb.toString());
	}

}
