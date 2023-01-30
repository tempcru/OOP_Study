package oop.demo.oo.v3.provider;

import java.util.ArrayList;
import java.util.List;

import oop.demo.oo.v1.MenuDataLoader;
import oop.demo.oo.v1.entity.Menu;
import oop.demo.oo.v1.entity.Option;

public class DefaultMenuDataProvider implements MenuDataLoader {

	@Override
	public List<Menu> loadData() {
		List<Menu> menuList = new ArrayList<>(); 
		
		List<Option> cutletOptions = new ArrayList<Option>();
		List<Option> curryOptions = new ArrayList<Option>();
		cutletOptions.add(new Option("�Ϲ�", 0));
		cutletOptions.add(new Option("�յ��", 2000));
		cutletOptions.add(new Option("ġ���", 1000));
		
	    curryOptions.add(new Option("����", 0));
	    curryOptions.add(new Option("�ʰ�", 200));
	    curryOptions.add(new Option("ġŲ", 1000));
	    curryOptions.add(new Option("����", 2000));
	    curryOptions.add(new Option("�� �߰�", 2000));
		
		menuList.add(new Menu("���", 10000, cutletOptions));
		menuList.add(new Menu("ī�����̽�", 9000, curryOptions));
		
		return menuList;

	}

}
