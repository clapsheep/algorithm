	import java.util.*;
	import java.io.*;
public class Solution_임스의싸피알고리즘 {
	    static int T, N, M;
	    static int[] count, res;
	    
	    
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        T = Integer.parseInt(br.readLine());
	        for(int t = 1; t<=T; t++){
	            StringBuilder sb= new StringBuilder();
	            sb.append("#").append(t).append(" ");

	            N = Integer.parseInt(br.readLine());
	            count = new int[N];
	            StringTokenizer st= new StringTokenizer(br.readLine());
	            for(int i = 0; i < N; i++){
	                count[i] = Integer.parseInt(st.nextToken());
	            }
	            
	            res = new int[N];
	            M =  Integer.parseInt(br.readLine());

	            int idx = 0;
	            int temp =0;
	            for(int i = 0 ; i < M ; i++){
	                st= new StringTokenizer(br.readLine());
	                String sub = st.nextToken();
	                int grade = Integer.parseInt(st.nextToken());
	                int cnt =  Integer.parseInt(st.nextToken());

	                for(int j = 0; j < cnt;j++){
	                    if(sub.equals("ko")&& grade>=3){
	                        res[idx]++;
	                    }
	                    temp++;
	                    if(temp == count[idx]){
	                        sb.append(res[idx]).append(" ");
	                        idx++;
	                        temp = 0;
	                    }
	                    
	                }
	                
	            }
	            System.out.println(sb.toString());
	            
	        }
	    }
	}