package kr.or.ddit.basic;

class Util2{
	public static <T extends Number> int compare(T t1, T t2){
					// 타입 제한 >> Number 타입이거나, Number의 자식 타입만 올 수있음  
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return Double.compare(v1, v2);
	}
}
public class T04GenericMethodTest {
	public static void main(String[] args) {
		
		int result1 = Util2.compare(10, 20);
		System.out.println(result1);
		
		int result2 = Util2.compare(3.14, 3);
		System.out.println(result2);
		
		//System.out.println(Util2.compare("C", "JAVA")); 
		// >> Number 타입이 아닌 다른 타입이 매개변수로 왔을때 오류 발생 
		
	}
}
