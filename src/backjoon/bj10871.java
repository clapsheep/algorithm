package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10871 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		String s2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(s2, " ");
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i]<X) {
			count++;	
			}
		}
		int index = -1;
		int[] res = new int[count];
		for (int i = 0; i <N; i++) {
			if(arr[i]<X) {
				res[++index] = arr[i];	
				}
		}
		for (int i = 0; i < count; i++) {
			System.out.print(res[i]+" ");
		}
	}

}
