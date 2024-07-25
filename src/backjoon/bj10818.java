package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10818 {

	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	String s = br.readLine();
	StringTokenizer st = new StringTokenizer(s," ");
	int[] arr = new int[N];
	
	for (int i = 0; i < N; i++) {
		arr[i] = Integer.parseInt(st.nextToken());
	}
	int min = arr[0];
	int max = arr[0];
	
	for (int i = 0; i <N; i++) {
		if(arr[i]<min) {
			min = arr[i];
		}
		if(arr[i]>max) {
			max = arr[i];
		}
	}
	System.out.println(min+" "+max);
	}

}
