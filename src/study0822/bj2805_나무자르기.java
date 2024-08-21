package study0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2805_나무자르기 {
	static int N;
	static long M;
	static int[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		int left = 0;
		int right = tree[N-1];
		long sum = 0;
		
		while(sum != M) {
			int mid = (right + left)/2;
			if(left == mid) {
				System.out.println(mid);
				break;
			}
			sum =0;
			for (int i = N-1; i >= 0; i--) {
				int cuttedTree = tree[i]-mid;
				if(cuttedTree<=0) {
					break;
				}
				sum += cuttedTree;
			}
			if(sum < M) {
				right = mid;
			}else if(sum > M) {
				 left = mid;
			}else {
				System.out.println(mid);
				return;	
			}
		}
	}

}
