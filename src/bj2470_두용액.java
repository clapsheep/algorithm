import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2470_두용액 {
	static int N;
	static long[] liq; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		liq = new long[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liq[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(liq);
		long sum = Long.MAX_VALUE;
		int L = 0;
		int R = 0;
		out : for (int i = 0; i < N; i++) {
			
			int left = i+1;
			int right = N-1;
			while(left <= right) {
				int mid = (left + right)/2;
				long temp = liq[i]+ liq[mid];
				if(temp < 0 ) {
					left = mid+1;
				}else if(temp>0){
					right = mid-1;
				}else {
					L = i;
					R = mid;
					break out;
				}
				
				if(Math.abs(temp) < sum) {
					sum = Math.abs(temp);
					L = i;
					R = mid;
				}
				
			}
			
		}
		System.out.println(liq[L] + " "+ liq[R]);

	}

}
