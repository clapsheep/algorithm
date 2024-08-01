package backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj2635 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int max = 0;
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			List<Integer> arr = new ArrayList<>();
			arr.add(N);
			arr.add(i);
			int lastnum = 0;
			while(lastnum>=0) {
				lastnum =arr.get(arr.size()-2)-arr.get(arr.size()-1);
			arr.add(lastnum);
			if(arr.size()-1>max) {
				max= arr.size()-1;
				for (int j = 0; j < arr.size()-1; j++) {
					res =arr;
				}
			}
			}
		}
		System.out.println(max);
		for (int i = 0; i < res.size()-1; i++) {
			System.out.print(res.get(i)+" ");
		}
	}
}
