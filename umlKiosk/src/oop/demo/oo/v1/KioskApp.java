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
    
	protected static List<Menu> menuList; // 메뉴 목록
	private static Order order; // 주문
	
	// 입출력
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public KioskApp() throws Exception {
		// 데이터 로딩()
		loadData();
		
		// 메뉴 출력()
		showMenu();
		
		// 메뉴 선택()
		selectMenu();
		
		// 옵션 선택()
		selectOption();
		
		// 결제 
		while(!checkOut()) {
            System.out.println("\n\n>> 결제 실패!!!!");
            System.out.println(">> 결제 수단을 변경 합니다.");
            checkOrder();
            VALID = true;
        }
	}
	
	public static void main(String[] args) throws Exception {
		KioskApp app = new KioskApp();
	}
	
	private static boolean checkOut() {
        System.out.println("\n\n>>>> 결제를 진행 합니다. <<<<");
        if(VALID == true) {
            System.out.println(">> 주문을 저장합니다.");
            System.out.println(">> 영수증을 출력 합니다.");
            checkOrder();
            return true;
        } else {
            return false;
        }
    }
 

	private static void checkOrder() {
		
		int totalPrice = 0;
		System.out.println("## " +menuList.get(order.getSelMenu()).getMenuName()+"/"+menuList.get(order.getSelMenu()).getPrice()+"원 주문 내역 확인 ##");
		System.out.println("======================");
		totalPrice += menuList.get(order.getSelMenu()).getPrice();
		for (Option option : order.getSelOption()) {
			totalPrice += option.getOptionPrice();
			System.out.println(option.getOptionName()+"/"+option.getOptionPrice()+"원");
		}
		System.out.println("## 결제 금액: "+totalPrice+"원");
		
	}

	public static void selectOption() throws IOException {
		System.out.println(menuList.get(order.getSelMenu()).getMenuName()+"/"+menuList.get(order.getSelMenu()).getPrice()+"원 선택: 옵션을 선택하세요(콤마구분)!!");
		
		StringBuffer sb = new StringBuffer();
		int index = 0;
		
		for (Option option : menuList.get(order.getSelMenu()).getOptionList()) {
			sb.append("["+index+"]"+option.getOptionName()+"/"+option.getOptionPrice()+"/ ");
			index++;
		}
		System.out.println(sb.toString());
		
		System.out.print("# 옵션 => ");
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), ","); 
		List<Option> menuOptions = menuList.get(order.getSelMenu()).getOptionList();
		List<Option> selOptions = new ArrayList<Option>();
		while (st.hasMoreElements()) {
			selOptions.add(menuOptions.get(Integer.parseInt(st.nextToken())));
		}
		order.setSelOption(selOptions);
	}

	public static void selectMenu() throws IOException {
		System.out.print("# 메뉴를 선택 하세요:");
		
		try {
			int menuNumber = Integer.parseInt(br.readLine());
			order = new Order(menuNumber, null);
		} catch (Exception e) {
			System.out.println("주문할 수 없는 메뉴 입니다.!!");
		}
		
		System.out.println("\n");
	}

	public static void showMenu() {
		System.out.println("#### 메뉴 ####");
		int menuIndex = 0;
		StringBuffer sb = new StringBuffer();
		for (Menu menu : menuList) {
			System.out.println(menuIndex + ": "+menu.getMenuName()+"/"+menu.getPrice()+"원");
			menuIndex++;
		} 
		System.out.println("-------------------\n");
	}

	protected void loadData() {
		menuList = new ArrayList<>(); 
		
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
		
	}

}
