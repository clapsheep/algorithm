package backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class bj2108 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr= new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		avg(arr);
		center(arr);
		System.out.println(whatMany(arr));
		
		range(arr);
	
	}
	static void avg(int[] arr) {
		double sum=0.0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(Math.round(sum/arr.length)); 
	}
	static void center(int[] arr) {
		System.out.println(arr[arr.length/2]);
	}
	static int whatMany(int[] array) {
		//key : 입력받은 숫자의 값 / value : key값의 빈도수
        Map<Integer, Integer> mp = new HashMap<>();

        //array의 길이가 1개일 경우는 차피 값이 하나니까 그 값이 최빈 값
        if (array.length == 1) {
            return array[0];
        }
        for (int i = 0; i < array.length ; i++) {
            //이미 Map에 있는 건 같은 값을 한번더 마주한 것
            if (mp.containsKey(array[i])) {
                // 해당 array[i]을 key 값으로 가지고, 그 key 값의 value(지금까지의 빈도수) + 1
                mp.put(array[i], mp.get(array[i]) + 1);
            } else { // 한 번도 마주한 적이 없는 숫자일 경우
                // 해당 array[i]을 key 값으로 가지고, 빈도수는 당연히 1이므로 value는 1 값을 가진다.
                mp.put(array[i], 1);
            }
        }
        //Map의 모든 value(=빈도)값을 가져와서 최대 값을 구해 maxValue 변수에 저징
        int maxValue = Collections.max(mp.values());

        ArrayList<Integer> arrayList = new ArrayList<>(); //최빈값을 가지는 key값을 저장하는 array

        // 가장 많이 나온 값
        // Map.Entry 객체 컬렉션으로 Map.Entry의 하나 개의 클래스에 저장 키와 값 함께 가져옴
        // Map.Entry : map의 collection-view를 return
        // entrySet() : 해당 map에 담겨있는 key와 value의 연결들(mappings)을 반환
        for (Map.Entry<Integer, Integer> newMap : mp.entrySet()) {
            //해당 value값이 maxValue값과 같으면 최빈 값을 가진 Map이라는 뜻
            if (newMap.getValue() == maxValue) {
                arrayList.add(newMap.getKey());
            }
        }

        Collections.sort(arrayList); //key값을 작은 수 -> 큰 수로 정렬

        // 가장 많이 나온 값이 여러개일 경우 두번째로 작은 값
        if (arrayList.size() > 1) //최빈값이 여러개일 경우
            return arrayList.get(1);
        else //최빈값이 하나면
            return arrayList.get(0); //첫번째 인덱스의 값을 가져오면 된다.
    }
	
	static void range(int[] arr) {
		System.out.println(arr[arr.length-1]-arr[0]);
	}
	
	
}
