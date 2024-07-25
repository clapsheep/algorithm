package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10807 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		
		
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] =Integer.parseInt(st.nextToken());;
		}
		int num = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i]==num) {
				count++;
			}
		}
		System.out.println(count);
	}

}
