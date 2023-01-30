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

		Car car1 = new Car("���", "���� �ƹ���");
		Car car2 = new Car("������", "BMW 520d");
		Car car3 = new Car("�Ķ���", "���� ��200");
		
		car1.print();
		car2.print();
		car3.print();
		
	} 
	 
}
