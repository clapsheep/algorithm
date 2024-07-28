package backjoon;

import java.util.Iterator;
import java.util.Scanner;

public class bj2108 {
	public static int[] arr;
	public static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(avg());
		System.out.println(center());
		System.out.println(many());
		System.out.println(range());

	}
public static int avg() {
	int sum =0;
	for (int i = 0; i < N; i++) {
		sum += arr[i];
	}
	int res = (int) Math.round((double)sum/N);
	return res;
}

//이것은 버블 정렬인데 이 정렬방식에 문제가 있다. 너무 오래걸림
// 이걸 
public static void sort() {
	int temp =arr[0];
	for (int i = 0; i < arr.length; i++) {
		for (int j = i+1; j < arr.length; j++) {
			if(arr[i]>arr[j]) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
	
}
public static int center() {
	sort();
	return arr[N/2];	
}

public static int many() {
    int[] count = new int[8001]; // 범위 -4000 ~ 4000 (총 8001개)
    int maxCount = 0;
    int secondSmallestIndex = -1; // 두 번째로 작은 최빈값의 인덱스를 저장할 변수

    for (int i = 0; i < N; i++) {
        count[arr[i] + 4000]++; // 범위를 0 ~ 8000으로 변환하여 인덱스 사용
        if (count[arr[i] + 4000] > maxCount) {
            maxCount = count[arr[i] + 4000]; // 최빈값 개수 갱신
            secondSmallestIndex = arr[i] + 4000; // 최빈값의 인덱스 갱신 (범위 변환된 인덱스 사용)
        } else if (count[arr[i] + 4000] == maxCount && arr[i] < arr[secondSmallestIndex - 4000]) {
            // 최빈값의 개수가 같고 현재 값이 이전에 저장된 두 번째로 작은 값보다 작으면
            secondSmallestIndex = arr[i] + 4000; // 두 번째로 작은 값의 인덱스를 갱신
        }
    }

    if (maxCount == 1) { // 최빈값이 하나뿐인 경우
        return arr[secondSmallestIndex - 4000]; // 범위를 다시 -4000 ~ 4000으로 변환
    } else { // 최빈값이 여러 개인 경우
        return arr[secondSmallestIndex - 4000]; // 범위를 다시 -4000 ~ 4000으로 변환
    }
}
public static int range() {
	sort();
	return arr[N-1]-arr[0];
}
}
