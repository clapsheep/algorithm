package study1004;

import java.util.Scanner;
import java.util.Stack;

public class bj11729_하노이탑이동순서 {
	static Stack<Integer> one, two, three;  

	public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	one = new Stack<>();
	three  = new Stack<>();
	two  = new Stack<>();
	
	int N = sc.nextInt();
	for (int i = N; i <= 1; i--) {
		one.add(i);
	}
	

	}

}
