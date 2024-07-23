package kr.or.ddit.basic;

import java.util.Map;

public class T02GenericClassTest {
	/*
	 		제너릭 클래스 만드는 방법
	 		
	 		형식)
	 		class 클래스명<제너릭타입글자>{
	 			제너릭타입글자 변수명;	//변수선언에 제너릭을 사용하는 경우
	 			...
	 			
	 			제너릭타입글자 메서드명(){ //반환값이 있는 메서드에 제너릭을 사용하는 경우
	 			
	 				...
	 				return 값;
	 			}
	 		}
	 		
	 		-- 제너릭 타입 글자 --
	 		T => Type
	 		K => Key
	 		V => Value
	 		E => Element
	 */	
	public static void main(String[] args) {
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setVal("가나다라");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(10);
		
		String rtnVal1 = (String)ng1.getVal();
		System.out.println("문자열 반환값 rtnVal1 =>" + rtnVal1);
		
		Integer rtnVal12 = (Integer)ng2.getVal();
		System.out.println("정수형 반환값 rtnVal2 => " + rtnVal12);
		
		System.out.println();
		
		MyGeneric<String> mg1 = new MyGeneric(); // 자바 8버전 이후에는 오른쪽의 제너릭은 쓰지 않아도 ㄱ된다. 
		mg1.setVal("우리나라");

		MyGeneric<Integer> mg2 = new MyGeneric<Integer>();
		mg2.setVal(200);
		
		rtnVal1 = mg1.getVal();
		rtnVal12 = mg2.getVal();
		
		System.out.println("제너릭 문자열 반환값 : "+ rtnVal1);
		System.out.println("제너릭 정수형 반환값 : "+ rtnVal12);
		
		
	}
}

class NonGenericClass{
	private Object val; // 그때 그때 내가 원하는 타입으로 사용가능하지만 사용할때마다 캐스팅해서 사용해야한다.

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}
}

class MyGeneric<T>{ //여러개의 타입글자를 사용하려면 꺽쇠 안에서 콤마 쓰고 작성하면된다.
	private T val; // 그때 그때 내가 원하는 타입으로 사용가능 >> 재활용도가 높다는 장점이 있음 

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
}

