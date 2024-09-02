import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution2112_보호필름2 {
    static int D,W,K,ans;
    static int[] used;
    static boolean [][] isB;
    static boolean [] A;
    static boolean [] B;
    static boolean [][] tmp;
    static boolean[] Pused;
    static boolean close;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());
 
        for(int t = 1; t <= T; t++){
            sb.setLength(0);
            ans =Integer.MAX_VALUE;
            close=false;
            st = new StringTokenizer(br.readLine());
            D=Integer.parseInt(st.nextToken());
            W=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());
            isB = new boolean[D][W];
            used = new int[D];
             
            A= new boolean[W];
            B= new boolean[W];
            Arrays.fill(B, true);
            tmp = new boolean[D][W];
            Pused = new boolean[D];
                     
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    if(Integer.parseInt(st.nextToken())==1)
                        isB[i][j]=true;
                }
            }
             
            for (int i = 0; i < D; i++) {
                subset(0,0,i);
            }
             
            sb.append("#").append(t).append(" ").append(ans).append("\n");
            System.out.print(sb.toString());
        }
    }
    static void subset(int depth, int idx,int d) {
        if(depth==D) {
            if(idx == d) {
                for (int i = 0; i < idx; i++) {
                    tmp[used[i]]=isB[used[i]];
                }
                powerset(idx,0);
                if(close)return;
                for (int i = 0; i < idx; i++) {
                    isB[used[i]]=tmp[used[i]];
                }
            }
            return;
        }
        if(close)return;
        subset(depth+1,idx,d);
        used[idx]=depth;
        subset(depth+1,idx+1,d);
    }
    static void powerset(int size,int depth) {
        if(depth==size) {
            for (int i = 0; i < size; i++) {
                if(Pused[i]) {
                    isB[used[i]]=A;
                }else
                    isB[used[i]]=B;
            }
            if(check()) {
                close=true;
                ans = size;
            }
            return;
        }
        if(close)return;
        Pused[depth]=true;
        powerset(size,depth+1);
        Pused[depth]=false;
        powerset(size,depth+1);
         
    }
    static boolean check() {
        boolean check = true;
        for (int i = 0; i < W; i++) {
            int sum=1;
            boolean flag = isB[0][i];
            for (int j = 1; j < D; j++) {
                if(flag == isB[j][i]) {
                    sum++;
                }else {
                    sum=1;
                    flag = isB[j][i];
                }
                if(sum==K) {
                    break;
                }
            }
            if(sum<K) {
                check=false;
                break;
            }
        }
        return check;
    }
}