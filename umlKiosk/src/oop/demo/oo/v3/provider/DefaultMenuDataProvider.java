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
		cutletOptions.add(new Option("일반", 0));
		cutletOptions.add(new Option("왕돈까스", 2000));
		cutletOptions.add(new Option("치즈가루", 1000));
		
	    curryOptions.add(new Option("보통", 0));
	    curryOptions.add(new Option("맵게", 200));
	    curryOptions.add(new Option("치킨", 1000));
	    curryOptions.add(new Option("새우", 2000));
	    curryOptions.add(new Option("난 추가", 2000));
		
		menuList.add(new Menu("돈까스", 10000, cutletOptions));
		menuList.add(new Menu("카레라이스", 9000, curryOptions));
		
		return menuList;

	}

}
