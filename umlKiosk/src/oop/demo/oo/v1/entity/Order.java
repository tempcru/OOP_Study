package oop.demo.oo.v1.entity;

import java.util.List;

public class Order {

	private int selMenu;
	private List<Option> selOption;
	public Order(int selMenu, List<Option> selOption) {
		super();
		this.selMenu = selMenu;
		this.selOption = selOption;
	}
	public int getSelMenu() {
		return selMenu;
	}
	public void setSelMenu(int selMenu) {
		this.selMenu = selMenu;
	}
	public List<Option> getSelOption() {
		return selOption;
	}
	public void setSelOption(List<Option> selOption) {
		this.selOption = selOption;
	}
	
	
	
}
