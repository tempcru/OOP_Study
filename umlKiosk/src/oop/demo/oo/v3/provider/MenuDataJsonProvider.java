package oop.demo.oo.v3.provider;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import oop.demo.oo.v1.MenuDataLoader;
import oop.demo.oo.v1.entity.Menu;

public class MenuDataJsonProvider implements MenuDataLoader {

	@Override
	public List<Menu> loadData() {
		List<Menu> menuList = new ArrayList<>(); 
		JsonObject jsonObject;
		try {
			jsonObject = new Gson().fromJson(new FileReader("src/menu.json"), JsonObject.class);
			JsonArray jsonArray = jsonObject.getAsJsonArray("menu");
			Gson gson = new Gson();

			menuList = gson.fromJson(jsonArray, new TypeToken<ArrayList<Menu>>() {
			}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}

}
