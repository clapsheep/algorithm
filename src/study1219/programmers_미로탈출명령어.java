package study1219;
import java.util.*;
import java.io.*;

/*
테스트 1 〉	통과 (0.37ms, 86.9MB)
테스트 2 〉	통과 (0.36ms, 82MB)
테스트 3 〉	통과 (0.06ms, 90.2MB)
테스트 4 〉	통과 (0.07ms, 81.9MB)
테스트 5 〉	통과 (0.10ms, 88.4MB)
테스트 6 〉	통과 (0.07ms, 69.4MB)
테스트 7 〉	통과 (0.07ms, 85.6MB)
테스트 8 〉	통과 (0.07ms, 86.7MB)
테스트 9 〉	통과 (2.12ms, 76.8MB)
테스트 10 〉	통과 (2.99ms, 83.7MB)
테스트 11 〉	통과 (3.61ms, 79.9MB)
테스트 12 〉	통과 (2.45ms, 77MB)
테스트 13 〉	통과 (2.25ms, 86.9MB)
테스트 14 〉	통과 (3.34ms, 79.6MB)
테스트 15 〉	통과 (2.07ms, 91.1MB)
테스트 16 〉	통과 (3.04ms, 79.5MB)
테스트 17 〉	통과 (2.18ms, 76.7MB)
테스트 18 〉	통과 (2.22ms, 92.4MB)
테스트 19 〉	통과 (2.04ms, 75MB)
테스트 20 〉	통과 (2.34ms, 87.4MB)
테스트 21 〉	통과 (2.57ms, 93.1MB)
테스트 22 〉	통과 (2.54ms, 88.9MB)
테스트 23 〉	통과 (3.20ms, 77.1MB)
테스트 24 〉	통과 (2.13ms, 76.7MB)
테스트 25 〉	통과 (2.90ms, 81.2MB)
테스트 26 〉	통과 (2.76ms, 77.4MB)
테스트 27 〉	통과 (2.24ms, 84.1MB)
테스트 28 〉	통과 (2.55ms, 79MB)
테스트 29 〉	통과 (2.92ms, 85.4MB)
테스트 30 〉	통과 (2.93ms, 83.2MB)
테스트 31 〉	통과 (0.04ms, 91.3MB)
*/

class programmers_미로탈출명령어 {
    static char[] route = {'d','l','r','u'};
    static int[] dr = {1,0,0,-1};
    static int[] dc = {0,-1,1,0};
    static int N,M,X,Y,R,C,K;
    static String res;
    static StringBuilder sb;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        sb = new StringBuilder();
        N = n;
        M = m;
        X = x-1;
        Y = y-1;
        R = r-1;
        C = c-1;
        K = k;
        
        int leng = dist(X,Y,R,C);
        if((K-leng)%2 == 1 || K < leng){
            return "impossible";
        }
        dfs(X,Y,0);
        
        return res==null?"impossible":res;
    }
    public static void dfs(int nowX, int nowY, int cnt){
        if(res != null) return;  // 이미 경로를 찾았으면 더 찾지 않기
        // 지금 온 거리 + 남은 최단거리가 목표치보다 크면? 프루닝
        if(cnt+dist(nowX,nowY,R,C) > K) return;
        if(K == cnt){
            if(nowX == R &&  nowY == C){
            res = sb.toString();
        }
            return;
        }
        for(int d = 0; d < 4; d++){
            int nx = nowX + dr[d];
            int ny = nowY + dc[d];
            if(!check(nx,ny))continue;
               sb.append(route[d]);
               dfs(nx,ny,cnt+1);
               sb.delete(cnt,cnt+1);
        }
        
    }
    public static int dist(int x, int y, int r, int c){
        return Math.abs(x-r) + Math.abs(y-c);
    }
    public static boolean check(int r, int c){
        return r>=0 && c>=0 && r<N && c<M;
    }
}