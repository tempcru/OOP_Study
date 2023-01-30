package oop.demo.oo.v3.provider;

import java.util.ArrayList;
import java.util.List;

import oop.demo.oo.v1.MenuDataLoader;
import oop.demo.oo.v1.entity.Menu;

public class MenuDataDBProvider implements MenuDataLoader {

	@Override
	public List<Menu> loadData() {
		return new ArrayList<Menu>();
	}

}
