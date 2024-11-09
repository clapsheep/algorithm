
import java.util.*;
import java.lang.*;
import java.io.*;


class 분해합 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input = sc.next();
        int num = Integer.parseInt(input);
        int leng = input.length();
        int size = num - leng * 9;
        for(int i = size ; i < num ; i++){
            char[] s = (i+"").toCharArray();
            int temp = i; 
            for(int j = 0; j < s.length ; j++){
                temp += s[j]-'0';
            }
            if(temp == num){
                System.out.println(i);
                return; 
            }
        }
        
        return;
        
    }
}