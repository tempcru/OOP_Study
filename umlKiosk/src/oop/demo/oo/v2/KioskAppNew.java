package oop.demo.oo.v2;

import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import oop.demo.oo.v1.KioskApp;
import oop.demo.oo.v1.entity.Menu;

public class KioskAppNew extends KioskApp {

	public KioskAppNew() throws Exception {
		super();
	}

	public static void main(String[] args) throws Exception {
		KioskAppNew app = new KioskAppNew();
	}

	@Override
	public void loadData() {

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

	}

}
