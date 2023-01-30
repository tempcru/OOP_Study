package oop.demo.oo.v3.provider;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import oop.demo.oo.v1.MenuDataLoader;
import oop.demo.oo.v1.entity.Menu;

public class MenuDataRestProvider implements MenuDataLoader {

	@Override
	public List<Menu> loadData() {
		String url = "https://apingweb.com/api/rest/75a6b514ec991aae3e5d3dd040454e8b11/justin";
		List<Menu> menus = new ArrayList<>();
		try (InputStream is = new URL(url).openStream(); Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
			Gson gson = new Gson();
			JsonObject jsonObject = new Gson().fromJson(reader, JsonObject.class);
			JsonArray jsonArray = jsonObject.getAsJsonArray("menu");
			menus = gson.fromJson(jsonArray, new TypeToken<ArrayList<Menu>>() {
			}.getType());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return menus;  
		
	}

}
