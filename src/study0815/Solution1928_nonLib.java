package study0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

public class Solution1928_nonLib {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			String code = br.readLine();
			int cnt = 3; // 3byte씩 (64^2 ,64^1 ,64^0)을 하기위한 카운트
			int sum = 0;
			
			for (int i = 0; i < code.length(); i++) {
				int tmp = base64(code.charAt(i)); // 현재 받은 코드 각 문자를 base64 값으로 변환
				for (int j = 0; j < cnt; j++) {
					tmp *= 64; // 각 문자의 base64 값은 (문자 * 64^자리수)
				}
				sum += tmp;
					if(--cnt == -1) { // 3byte씩 처리했으면
						cnt =3; // cnt초기화
						 char[] arr= new char[3];
						 for (int j = 0; j < 3; j++) {
							arr[2-j] = (char)(sum%256); // 크기 3 배열에 256으로 나눈 수를 아스키 코드로 변환한 문자로 넣고 // 256 = 십진수 비트값 
							sum/=256;
						}
						 sb.append(arr[0]).append(arr[1]).append(arr[2]);
					}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);

	}
	static int base64(char input) {
		// 아스키 to base64
		if(input>=65 && input<=90) return input-65; // 대문자
		else if(input >= 97 && input <=122) return input - 71; // 소문자
		else if(input >= 48 && input <=57) return input+4; // 숫자
		else { // 남은 것 +, /
			if(input == '+') return 62; // +
			else return 63; // /
		}
		
		
	}
}
