package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class bj1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int[] alphabet = new int[26];
		
		char[] arr= str.toCharArray();
		if(arr.length==0) {
			System.out.println(str.toUpperCase());
			return;
		}else {
		for (int i = 0; i < arr.length; i++) {
			if((int)arr[i]<96) {
				alphabet[arr[i]+32-97]++;
			}else {
				alphabet[arr[i]-97]++;
			}
			
		}
		
		int index = -1;
		int max = -1;
		for (int i = 0; i < alphabet.length; i++) {
			if(alphabet[i]>max) {
				max = alphabet[i];
			}else if(alphabet[i] == max) {
				System.out.println("?");
				return;
			}
		}
		for (int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] == max) {
				index = i;
			}
		}
		char res = (char) (index+65);
		System.out.println(res);
		
		}
		
	}

}
