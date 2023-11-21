package main;

import java.util.Scanner;

import quanly.CacMenu;

public class MainQuanLy {
	public static void main(String[] args) {
		CacMenu menu = new CacMenu();
        int chon;

        do {
        	System.out.println("┌─────────────────────────────────────────────────────────┐");
            System.out.println("│         CHÀO MỪNG BẠN ĐẾN VỚI QUẢN LÝ NHÂN VIÊN         │");
            System.out.println("├─────────────────────────────────────────────────────────┤");
            System.out.println("│    1. Quản lý nhân viên full time                       │");
            System.out.println("│    2. Quản lý nhân viên part time                       │");
            System.out.println("│    3. Thoát                                             │");
            System.out.println("└─────────────────────────────────────────────────────────┘");
            System.out.print("Nhập lựa chọn của bạn: ");
            Scanner sc = new Scanner(System.in);
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    menu.quanLyFT();
                    break;
                case 2:
                	menu.quanLyPT();
                case 3:
                    System.out.println("Thoát chương trình. Goodbye!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
        } while (chon != 3);
    }
}

