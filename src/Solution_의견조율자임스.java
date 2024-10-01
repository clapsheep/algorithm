import java.util.*;
import java.io.*;

class Solution_의견조율자임스 {
    static int T, N, M;
    static String[] ma, sam;
    static PriorityQueue<String> pq;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t= 1; t<=T; t++){
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ma = new String[N];
            sam = new String[M];
            
            for(int n = 0; n < N ; n++){
                ma[n] = br.readLine();
            }
            for(int m = 0; m < M ; m++){
                sam[m] = br.readLine();
            }
            
            Arrays.sort(ma);
            Arrays.sort(sam);
            
            pq = new PriorityQueue<>((o1,o2)->o1.compareTo(o2));

            for(int i = 0 ;  i < N ; i++){
                int a = Arrays.binarySearch(sam, ma[i], (o1,o2)->o1.compareTo(o2));
                if(a>=0){
                    pq.offer(ma[i]);
                }
            }
            if(pq.size()==0){
                sb.append("NO!!");
            }else{
                for(int i = 0; i< pq.size();i++){
                    sb.append(pq.poll()).append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}