package oop.demo.procedural;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KioskAppV2 {
    // ���� ���� ��ȿ ���� ����
    boolean VALID = false;
    // ������ �޴��� ����
    String selMenu;
    String[] cutletOptions = {"�Ϲ�","�յ��","ġ���"};
    String[] curryOptions = {"����","�ʰ�","ġŲ","����","�� �߰�"};
    // �ֹ��� ���Ե� �߰� �ɼǵ��� ����
    ArrayList<String> order = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    public KioskAppV2() {
        // �޴� ���ÿ� ���� �ɼ� ����
        String[] oplist = null;
        showMenu();
        System.out.print("# �޴��� ���� �ϼ���: ");

        String sel = scan.next();

        switch(sel) {
            case "1":
                selMenu = "���";
                optionSelect(cutletOptions);
                oplist = cutletOptions;
                break;
            case "2":
                selMenu = "ī�����̽�";
                oplist = curryOptions;
                optionSelect(curryOptions);
                break;
            default:
                System.out.println("�ֹ��� �� ���� �޴� �Դϴ�.!!");
        }

        checkOrder(oplist);

        while(!checkOut()) {
            System.out.println("\n\n>> ���� ����!!!!");
            System.out.println(">> ���� ������ ���� �մϴ�.");
            checkOrder(oplist);
            VALID = true;
        }
    }

    // if �� ������� �ʱ� ���� �ɼ� ����� ���ڷ� ��.
    private void optionSelect(String[] options) {
        System.out.printf("%s ����: �ɼ��� �����ϼ���(�޸�����)!!\n", selMenu);
        for(int i=0;i<options.length;i++) {
            System.out.printf("[%d]%s/ ",i, options[i]);
        }
        System.out.print("\n # �ɼ� => ");
        String optionSelect = scan.next();
        order.addAll(List.of(optionSelect.split(",")));
    }

    private boolean checkOut() {
        System.out.println("\n\n>>>> ������ ���� �մϴ�. <<<<");
        if(VALID == true) {
            System.out.println(">> �ֹ��� �����մϴ�.");
            System.out.println(">> �������� ��� �մϴ�.");
            return true;
        } else {
            return false;
        }
    }

    // if �� ������� �ʱ� ���� �ɼ� ����� ���ڷ� ��.
    private void checkOrder(String[] oplist) {
        System.out.printf("## %s �ֹ� ���� Ȯ�� ##\n",selMenu);
        System.out.println("====================");
        for(String s : order) {
            System.out.print(oplist[Integer.valueOf(s)]+",");
        }
    }

    public void showMenu() {
        System.out.println("#### �޴� ####");
        System.out.println("1: ���, 2:ī�����̽�");
        System.out.println("--------------\n");
    }

    public static void main(String[] args) {
        KioskAppV2 app = new KioskAppV2();
    }
}