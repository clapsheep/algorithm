package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2605 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int index = Integer.parseInt(st.nextToken());
			
			if (arr[index] != 0) {
				
				for (int j = N-1; j > index; j--) {
					arr[j]= arr[j-1];
				}
				arr[index] = i+1;
				
			} else {
				arr[index] = i+1;
			}
		}
		String str = "";
		for (int i = N-1; i >= 0; i--) {
			str += arr[i]+" ";
		}
		System.out.println(str);

	}

}
