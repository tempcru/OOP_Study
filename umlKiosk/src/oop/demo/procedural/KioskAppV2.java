package oop.demo.procedural;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KioskAppV2 {
    // 결제 수단 유효 여부 설정
    boolean VALID = false;
    // 선택한 메뉴를 저장
    String selMenu;
    String[] cutletOptions = {"일반","왕돈까스","치즈가루"};
    String[] curryOptions = {"보통","맵게","치킨","새우","난 추가"};
    // 주문에 포함된 추가 옵션들을 저장
    ArrayList<String> order = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    public KioskAppV2() {
        // 메뉴 선택에 따른 옵션 지정
        String[] oplist = null;
        showMenu();
        System.out.print("# 메뉴를 선택 하세요: ");

        String sel = scan.next();

        switch(sel) {
            case "1":
                selMenu = "돈까스";
                optionSelect(cutletOptions);
                oplist = cutletOptions;
                break;
            case "2":
                selMenu = "카레라이스";
                oplist = curryOptions;
                optionSelect(curryOptions);
                break;
            default:
                System.out.println("주문할 수 없는 메뉴 입니다.!!");
        }

        checkOrder(oplist);

        while(!checkOut()) {
            System.out.println("\n\n>> 결제 실패!!!!");
            System.out.println(">> 결제 수단을 변경 합니다.");
            checkOrder(oplist);
            VALID = true;
        }
    }

    // if 를 사용하지 않기 위해 옵션 목록을 인자로 함.
    private void optionSelect(String[] options) {
        System.out.printf("%s 선택: 옵션을 선택하세요(콤마구분)!!\n", selMenu);
        for(int i=0;i<options.length;i++) {
            System.out.printf("[%d]%s/ ",i, options[i]);
        }
        System.out.print("\n # 옵션 => ");
        String optionSelect = scan.next();
        order.addAll(List.of(optionSelect.split(",")));
    }

    private boolean checkOut() {
        System.out.println("\n\n>>>> 결제를 진행 합니다. <<<<");
        if(VALID == true) {
            System.out.println(">> 주문을 저장합니다.");
            System.out.println(">> 영수증을 출력 합니다.");
            return true;
        } else {
            return false;
        }
    }

    // if 를 사용하지 않기 위해 옵션 목록을 인자로 함.
    private void checkOrder(String[] oplist) {
        System.out.printf("## %s 주문 내역 확인 ##\n",selMenu);
        System.out.println("====================");
        for(String s : order) {
            System.out.print(oplist[Integer.valueOf(s)]+",");
        }
    }

    public void showMenu() {
        System.out.println("#### 메뉴 ####");
        System.out.println("1: 돈까스, 2:카레라이스");
        System.out.println("--------------\n");
    }

    public static void main(String[] args) {
        KioskAppV2 app = new KioskAppV2();
    }
}