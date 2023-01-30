package oop.demo.oo.v1.entity;

public class Option {

	private String name;
	private int price;
	
	public Option(String optionName, int optionPrice) {
		super();
		this.name = optionName;
		this.price = optionPrice;
	}
	
	public String getOptionName() {
		return name;
	}
	public void setOptionName(String optionName) {
		this.name = optionName;
	}
	public int getOptionPrice() {
		return price;
	}
	public void setOptionPrice(int optionPrice) {
		this.price = optionPrice;
	}
	
	
	
}
