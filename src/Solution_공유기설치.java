import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_공유기설치 {
	static int N, C;
	static int[] house;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house= new int[N];
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		int left = 1; // 최소 거리
		int right = house[N-1]-house[0]+1; // 최대 거리
		while(left < right) {
			int mid  = (left+right)/2; // 중간 거리 이 거리로 C가 나올 수 있는가 판별
			if(canInstall(mid) < C) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		System.out.println(left-1);
	}
	private static int canInstall(int dist) {
		int cnt = 1; // 첫번째 집에 설치
		int last = house[0]; // 
		for (int i = 1; i < house.length; i++) {
			int  loc = house[i];
			if(loc - last >=dist) {
				cnt++;
				last = loc;
			}
		}
		
		return cnt;
	}

}
