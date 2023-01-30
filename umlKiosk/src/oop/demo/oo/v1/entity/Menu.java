package oop.demo.oo.v1.entity;

import java.util.List;

public class Menu {

	private String name;
	private int price;
	private List<Option> options;
	
	public Menu(String menuName, int price, List<Option> optionList) {
		super();
		this.name = menuName;
		this.price = price;
		this.options = optionList;
	}
	
	public String getMenuName() {
		return name;
	}
	public void setMenuName(String menuName) {
		this.name = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Option> getOptionList() {
		return options;
	}
	public void setOptionList(List<Option> optionList) {
		this.options = optionList;
	}
	
}
