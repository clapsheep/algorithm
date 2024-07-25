package backjoon;

import java.util.Scanner;

public class bj5597 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] students = new int[30];
		
		for (int i = 0; i < students.length; i++) {
			students[i] = i+1;
		}
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 28; i++) {
			int checked = sc.nextInt();
			
			students[checked-1] = 0;
			
		}
		for (int i = 0; i < students.length; i++) {
			if(students[i] != 0) {
			System.out.println(students[i]);
			}
		}
	}

}
