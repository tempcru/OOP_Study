package oop.demo.procedural;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class KioskAppV1 {

	static String menu;
	static List<String> menuList = new ArrayList<>();
	static List<String> menuOption;
	
	public static void main(String[] args) throws IOException { 
		// 1. �޴� ���
		showMenu();
		
		// 2. �޴� ���� 
		menuSelect();
		
		// 3. �޴� �ɼ� ���
		showMenuOption();
		
		// 2. �޴� �Է�
		optionSelect();
		
		
		checkOrder();
		
		checkOut();
		
		saveOrder();
		
		showBills();
	
	}

	private static void showBills() {
		// TODO Auto-generated method stub
		
	}

	private static void saveOrder() {
		// TODO Auto-generated method stub
		
	}

	private static void showMenu() {
		
		menuList.add("���");
		menuList.add("ī�����̽�");
		
		System.out.println("#### �޴� ####");
		StringBuffer sb = new StringBuffer();
		int index = 1;
		for (String string : menuList) {
			
			index++;
		}
		System.out.println(sb.toString());
		
	}
	
	
	private static void showMenuOption() {
		// TODO Auto-generated method stub
	}
	
	private static void menuSelect() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()); 
		menu = br.readLine(); 
	}
	
	private static void optionSelect() {
		// TODO Auto-generated method stub
		
	}
	
	private static void checkOrder() {
		// TODO Auto-generated method stub
		
	}

	private static void checkOut() {
		// TODO Auto-generated method stub
		
	}

	
	

}
