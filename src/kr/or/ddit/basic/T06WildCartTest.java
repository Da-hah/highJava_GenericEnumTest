package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06WildCartTest {
	// 장바구니 항목 조회를 위한 메서드 (모든 항목을 담은 장바구니)
	public static void displayCartItemInfo(Cart<?> cart) {
		System.out.println("= 음식류 장바구니 항목 리스트 =");
		for(Object obj : cart.getCartList()) {
			System.out.println(obj);
		}
		System.out.println("---------------------------------------");
	}

	// 장바구니 항목 조회를 위한 메서드 (음료나 그 하위 항목을 담은 장바구니)
	public static void displayCartItemInfo2(Cart<? extends Drink> cart) {
		System.out.println("= 음료나 그 하위 항목 장바구니 리스트 =");
		for(Object obj : cart.getCartList()) {
			System.out.println(obj);
		}
		System.out.println("---------------------------------------");
	}

	// 장바구니 항목 조회를 위한 메서드 (고기나 그 상위 항목을 담은 장바구니)
	public static void displayCartItemInfo3(Cart<? super Meat> cart) {
		System.out.println("= 음료나 그 하위 항목 장바구니 리스트 =");
		for(Object obj : cart.getCartList()) {
			System.out.println(obj);
		}
		System.out.println("---------------------------------------");
	}
	
	public static void main(String[] args) {
		
		Cart<Food> foodCart = new Cart<>();
		foodCart.addItem(new Meat("돼지고기", 10000));
		foodCart.addItem(new Meat("소고기", 20000));
		foodCart.addItem(new Juice("오렌지쥬스", 1500));
		foodCart.addItem(new Coffee("아메리카노", 1500));
		
		Cart<Meat> meatCart = new Cart<>();
		meatCart.addItem(new Meat("돼지고기", 10000));
		meatCart.addItem(new Meat("소고기", 20000));
//		meatCart.addItem(new Juice("오렌지쥬스", 1500));
//		meatCart.addItem(new Coffee("아메리카노", 1500));

		Cart<Drink> drinkCart = new Cart<>();
		drinkCart.addItem(new Juice("오렌지쥬스", 1500));
		drinkCart.addItem(new Coffee("아메리카노", 1500));
//		drinkCart.addItem(new Meat("돼지고기", 10000));
//		drinkCart.addItem(new Meat("소고기", 20000));
		
		displayCartItemInfo(foodCart);
		displayCartItemInfo(meatCart);
		displayCartItemInfo(drinkCart);
		
//		displayCartItemInfo2(foodCart);
//		displayCartItemInfo2(meatCart); //타입제한에 걸림
		displayCartItemInfo2(drinkCart);

		displayCartItemInfo3(foodCart);
		displayCartItemInfo3(meatCart); 
//		displayCartItemInfo3(drinkCart);//타입제한에 걸림
	}
}

class Food{
	private String name;
	private int price;
	
	public Food(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return name + "\t(" + price + "원)";
	}
}

class Meat extends Food{
	public Meat(String name, int price) {
		super(name, price);
	}
}

class Drink extends Food{
	public Drink(String name, int price) {
		super(name, price);
	}
}

class Juice extends Drink{
	public Juice(String name, int price) {
		super(name, price);
	}
}

class Coffee extends Drink{
	public Coffee(String name, int price) {
		super(name, price);
	}
}

/**
 * 장바구니 클래스
 * @param <T>
 */
class Cart<T>{
	
	private List<T> cartList;
	
	public Cart() {
		cartList = new ArrayList<>();
	}

	public List<T> getCartList() {
		return cartList;
	}
	
	public void addItem(T item) {
		cartList.add(item);
	}
}