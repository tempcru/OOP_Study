package oop.demo.oo.v3;

import oop.demo.oo.v1.KioskApp;
import oop.demo.oo.v1.MenuDataLoader;
import oop.demo.oo.v3.provider.DefaultMenuDataProvider;
import oop.demo.oo.v3.provider.MenuDataDBProvider;
import oop.demo.oo.v3.provider.MenuDataJsonProvider;
import oop.demo.oo.v3.provider.MenuDataRestProvider;

public class KioskAppV3 extends KioskApp {

	private static String loadType;
	private MenuDataLoader loader;
	
	public KioskAppV3() throws Exception {
		super();
		this.loader = null;
	}

	public static void main(String[] args) throws Exception {
		
		if(args.length > 0) {
			try {
				loadType = args[0];
			} catch (Exception e) {
				loadType = "rest";
			}
		}
		
		KioskAppV3 app = new KioskAppV3();
	}

	@Override
	public void loadData() {
		
		if(loadType.equals("rest")) {
			loader = new MenuDataRestProvider();
		}else if(loadType.equals("json")) {
			loader = new MenuDataJsonProvider();
		}else if(loadType.equals("db")) {
			loader = new MenuDataDBProvider();
		}else {
			loader = new DefaultMenuDataProvider();
		}
		
		menuList = loader.loadData();
	} 

}
