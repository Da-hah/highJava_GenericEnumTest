package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T05WildCardTest {
	
	/*
			와일드 카드 : 
			와일드 카드는 제너릭 타입을 이용한 타입 안전한 코드를 위해 사용되는 특별한 종류의 인수(Argument)로서,
			변수선언, 객체 생성 및 메서드를 정의할 때 사용된다.
			
			<? extends T> 	=> 와일드카드의 상한 제한. T와 그 자손들만 가능
			<? super T> 	=> 와일드카드의 하한 제한. T와 그 조상들만 가능
			<?> 			=> 모든 혀용가능한 타입이 가능 
	 */
	public static void main(String[] args) {
		
		FruitBox<Fruit> fruitBox = new FruitBox<>(); // 과일상자
		FruitBox<Apple> appleBox = new FruitBox<>(); // 사과상자
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());

		appleBox.add(new Apple());
		appleBox.add(new Apple());
		//appleBox.add(new Grape()); 타입이 맞지 않음
		
		Juicer.makeJuice(fruitBox);
		Juicer.makeJuice(appleBox);
	
		List<?> list = new ArrayList<String>();
	}
}

class Juicer{
//	static void makeJuice(FruitBox<Fruit> box) { // Fruit 의 하위 항목도 받지 않는다.
//	static <T extends Fruit> void makeJuice(FruitBox<T> box) { //제너릭 메서드 
	static void makeJuice(FruitBox<?> box) {  // 일반메서드
		String fruitListStr = ""; //과일 목록
		
		int cnt = 0;
		for(Object f : box.getFruitList()) {
			if(cnt == 0) {
				fruitListStr += f;
			}else {
				fruitListStr += ", "+f;
			}
			cnt++;
		}
		System.out.println(fruitListStr + " => 쥬스 완성!!");
	}
}

class Fruit {
	private String name; //과일이름
	
	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "과일 (" + name + ")";
	}
}

class Apple extends Fruit{
	public Apple() {
		super("사과");
	}
}

class Grape extends Fruit{
	public Grape() {
		super("포도");
	}
}

//과일 상자 클래스                                              
class FruitBox<T extends Fruit> {
	private List<T> fruitList;
	
	
	public List<T> getFruitList() {
		return fruitList;
	}

	public FruitBox() {
		fruitList = new ArrayList<>();
	}
	
	public void add(T fruit) {
		fruitList.add(fruit);
	}
}