package backjoon;

import java.util.*;
import java.io.*;

public class bj1018_체스판다시칠하기 {
    static int N,M,cntA,cntB;
    static char[][] map,caseA,caseB;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
        	String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
        caseA = new char[8][8];
        caseB = new char[8][8];
        for(int i = 1; i<=8;i++){
            for(int j = 1; j<=8;j++){
                if(i%2==0){
                    if(j%2==0){
                        caseA[i-1][j-1]='W';
                        caseB[i-1][j-1]='B';
                    }else{
                        caseA[i-1][j-1]='B';
                        caseB[i-1][j-1]='W';
                    }
                }else{
                    if(j%2==0){
                        caseA[i-1][j-1]='B';
                        caseB[i-1][j-1]='W';
                    }else{
                        caseA[i-1][j-1]='W';
                        caseB[i-1][j-1]='B';
                    }
                }
            }    
        }
        int res = Integer.MAX_VALUE;
        for (int r = 0; r <= N-8; r++) {
			for (int c = 0; c <= M - 8; c++) {
				int tempA = 0;
				int tempB = 0;
				for (int rangeR =0; rangeR < 8; rangeR++) {
					for (int rangeC = 0; rangeC < 8; rangeC++) {
						if(map[r+rangeR][c+rangeC] != caseA[rangeR][rangeC])tempA++;
						if(map[r+rangeR][c+rangeC] != caseB[rangeR][rangeC])tempB++;
						
					}
				}

				res =Math.min(res, tempA);
				res =Math.min(res, tempB);
			}
		}
        System.out.println(res);
        
    }
}