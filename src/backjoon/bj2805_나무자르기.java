package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2805_나무자르기 {
	static int N,M;
	static int[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		int longest = tree[N-1];
		int left = 0;
		int right = longest;
		int mid = 0;
		int res = 0;
		int sum = 0;
		
		while(sum != M) {
			mid = (right + left)/2;
			sum =0;
			for (int i = 0; i < N; i++) {
				int cuttedTree = tree[i]-mid;
				if(cuttedTree<0) {
					cuttedTree = 0;
				}
				sum += cuttedTree;
			}
			if(sum < M) {
				right = mid;
			}else if(sum > M) {
				 left = mid;
			}else {
				res = mid;
				break;
			}
		}
		System.out.println(res);
		
		

	}

}
