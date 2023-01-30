package oop.demo.basic;

public class Car {

	private String carColor;
	private String carName;
	
	public Car(String carColor, String carName) {
		super();
		this.carColor = carColor;
		this.carName = carName;
	}
	
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}

	@Override
	public String toString() {
		return carColor + " , " + carName;
	}
	
	public void print() {
		System.out.println(this.toString());
	}
	
	
	public static void main(String[] args) {

		Car car1 = new Car("흰색", "현대 아반테");
		Car car2 = new Car("검은색", "BMW 520d");
		Car car3 = new Car("파란색", "벤츠 ㅊ200");
		
		car1.print();
		car2.print();
		car3.print();
		
	} 
	 
}
