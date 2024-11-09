package imp;

public class Power {

	public static void main(String[] args) {
		long num = power(2,50);
		System.out.println(num);

	}

	static long power(int n1, int n2) { // 메모이제이션을 하는 계산
		if(n2==0) return 1;
		if(n2%2==0) {
			long temp =power(n1,n2/2);  // 메모이제이션 부분
			return temp*temp;
		}else {
			long temp = power(n1,(n2-1)/2);
			return n1 * temp * temp;
		}
	}

}
