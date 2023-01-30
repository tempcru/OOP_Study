package oop.demo.oo.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import oop.demo.oo.v1.entity.Menu;
import oop.demo.oo.v1.entity.Option;
import oop.demo.oo.v1.entity.Order;

public class KioskApp {

	static boolean VALID = true;
    
	protected static List<Menu> menuList; // �޴� ���
	private static Order order; // �ֹ�
	
	// �����
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public KioskApp() throws Exception {
		// ������ �ε�()
		loadData();
		
		// �޴� ���()
		showMenu();
		
		// �޴� ����()
		selectMenu();
		
		// �ɼ� ����()
		selectOption();
		
		// ���� 
		while(!checkOut()) {
            System.out.println("\n\n>> ���� ����!!!!");
            System.out.println(">> ���� ������ ���� �մϴ�.");
            checkOrder();
            VALID = true;
        }
	}
	
	public static void main(String[] args) throws Exception {
		KioskApp app = new KioskApp();
	}
	
	private static boolean checkOut() {
        System.out.println("\n\n>>>> ������ ���� �մϴ�. <<<<");
        if(VALID == true) {
            System.out.println(">> �ֹ��� �����մϴ�.");
            System.out.println(">> �������� ��� �մϴ�.");
            checkOrder();
            return true;
        } else {
            return false;
        }
    }
 

	private static void checkOrder() {
		
		int totalPrice = 0;
		System.out.println("## " +menuList.get(order.getSelMenu()).getMenuName()+"/"+menuList.get(order.getSelMenu()).getPrice()+"�� �ֹ� ���� Ȯ�� ##");
		System.out.println("======================");
		totalPrice += menuList.get(order.getSelMenu()).getPrice();
		for (Option option : order.getSelOption()) {
			totalPrice += option.getOptionPrice();
			System.out.println(option.getOptionName()+"/"+option.getOptionPrice()+"��");
		}
		System.out.println("## ���� �ݾ�: "+totalPrice+"��");
		
	}

	public static void selectOption() throws IOException {
		System.out.println(menuList.get(order.getSelMenu()).getMenuName()+"/"+menuList.get(order.getSelMenu()).getPrice()+"�� ����: �ɼ��� �����ϼ���(�޸�����)!!");
		
		StringBuffer sb = new StringBuffer();
		int index = 0;
		
		for (Option option : menuList.get(order.getSelMenu()).getOptionList()) {
			sb.append("["+index+"]"+option.getOptionName()+"/"+option.getOptionPrice()+"/ ");
			index++;
		}
		System.out.println(sb.toString());
		
		System.out.print("# �ɼ� => ");
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), ","); 
		List<Option> menuOptions = menuList.get(order.getSelMenu()).getOptionList();
		List<Option> selOptions = new ArrayList<Option>();
		while (st.hasMoreElements()) {
			selOptions.add(menuOptions.get(Integer.parseInt(st.nextToken())));
		}
		order.setSelOption(selOptions);
	}

	public static void selectMenu() throws IOException {
		System.out.print("# �޴��� ���� �ϼ���:");
		
		try {
			int menuNumber = Integer.parseInt(br.readLine());
			order = new Order(menuNumber, null);
		} catch (Exception e) {
			System.out.println("�ֹ��� �� ���� �޴� �Դϴ�.!!");
		}
		
		System.out.println("\n");
	}

	public static void showMenu() {
		System.out.println("#### �޴� ####");
		int menuIndex = 0;
		StringBuffer sb = new StringBuffer();
		for (Menu menu : menuList) {
			System.out.println(menuIndex + ": "+menu.getMenuName()+"/"+menu.getPrice()+"��");
			menuIndex++;
		} 
		System.out.println("-------------------\n");
	}

	protected void loadData() {
		menuList = new ArrayList<>(); 
		
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
		
	}

}
