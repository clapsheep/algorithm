import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8382_방향전환_CT풀이 {
	static int T;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T= Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringBuilder sb= new StringBuilder();
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			
			int x= Math.abs(x1-x2);
			int y =Math.abs(y1-y2);
			int goon = (x+y)/2;
			int temp = Math.abs(goon-x)+Math.abs(goon-y);
			sb.append(goon*2+temp);
			System.out.println(sb.toString());
			
			 
					
			
			
			
		}

	}

}
