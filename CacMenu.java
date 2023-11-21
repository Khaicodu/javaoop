package quanly;

import java.util.Scanner;

public class CacMenu {
    QuanLyFullTime quanLyFT = new QuanLyFullTime();
    QuanLyPartTime quanLyPT = new QuanLyPartTime();
    Scanner sc = new Scanner(System.in);

    public void quanLyFT() {
        int c1;

        do {
        	System.out.println("┌────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│            CHÀO MỪNG ĐẾN VỚI MENU QUẢN LÝ NHÂN VIÊN FULL TIME          │");
            System.out.println("├────────────────────────────────────────────────────────────────────────┤");
            System.out.println("│      1. Nhập thông tin nhân viên                                       │");
            System.out.println("│      2. Hiển thị danh sách nhân viên                                   │");
            System.out.println("│      3. Xóa nhân viên                                                  │");
            System.out.println("│      4. Chèn nhân viên                                                 │");
            System.out.println("│      5. Tìm kiếm nhân viên                                             │");
            System.out.println("│      6. Sửa thông tin nhân viên                                        │");
            System.out.println("│      7. Tính lương                                                     │");
            System.out.println("│      8. Thoát                                                          │");
            System.out.println("└────────────────────────────────────────────────────────────────────────┘");
            System.out.println("Nhập lựa chọn của bạn: ");
            
            c1 = sc.nextInt();
           
            switch (c1) {
                case 1:
                    quanLyFT.nhap();
                    quanLyFT.docFile();
                    break;
                case 2:
                	quanLyFT.docFile();
                    quanLyFT.hienThiDanhSachNhanVien();     
                    break;
                case 3:
                    quanLyFT.xoaNhanVien();
                    quanLyFT.luuFile();
                    System.out.println("Danh sách nhân viên sau khi xóa");
                    quanLyFT.docFile();
                    quanLyFT.hienThiDanhSachNhanVien(); 
                    break;
                case 4:
                    quanLyFT.chenNhanVien();
                    quanLyFT.luuFile();
                    System.out.println("Danh sách nhân viên sau khi chèn");
                    quanLyFT.docFile();
                    quanLyFT.hienThiDanhSachNhanVien();
                    break;
                case 5:
                    quanLyFT.timKiemNhanVien();
                    break;
                case 6:
                    quanLyFT.suaNhanVien();
                    quanLyFT.luuFile();
                    System.out.println("Danh sách nhân viên sau khi sửa");
                    quanLyFT.docFile();
                    quanLyFT.hienThiDanhSachNhanVien();
                    break;
                case 7:
                    quanLyFT.tinhluong();
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
        } while (c1 != 0);
    }
    
    
    public void quanLyPT() {
		int c1;
		do {
				System.out.println("┌────────────────────────────────────────────────────────────────────────┐");
				System.out.println("│            CHÀO MỪNG ĐẾN VỚI MENU QUẢN LÝ NHÂN VIÊN PART TIME          │");
		        System.out.println("├────────────────────────────────────────────────────────────────────────┤");
	            System.out.println("│          1. Nhập thông tin nhân viên part-time                         │");
	            System.out.println("│          2. Hiển thị danh sách nhân viên                               │");
	            System.out.println("│          3. Xóa nhân viên                                              │");
	            System.out.println("│          4. Tìm kiếm nhân viên                                         │");
	            System.out.println("│          5. Sửa thông tin nhân viên                                    │");
	            System.out.println("│          6. Chèn nhân viên mới                                         │");
	            System.out.println("│          7. Tính lương                                                 │");
	            System.out.println("│          8. Lương trên 5 triệu                                         │");
	            System.out.println("│          9. Sắp xếp theo giờ làm việc                                  │");
	            System.out.println("│          0. Thoát                                                      │");
	            System.out.println("└────────────────────────────────────────────────────────────────────────┘");
	            System.out.println("Nhập lựa chọn của bạn: ");
	            c1 = sc.nextInt();

	            switch (c1) {
                case 1:
                    quanLyPT.nhap();
                    quanLyPT.docFile();
                    break;
                case 2:
                	quanLyPT.docFile();
                	quanLyPT.hienThiDanhSachNhanVien();
                    break;
                case 3:
                    quanLyPT.xoaNhanVien();
                    quanLyPT.luuFile();
                    System.out.println("Danh sách nhân viên sau khi xóa");
                    quanLyPT.docFile();
                	quanLyPT.hienThiDanhSachNhanVien();
                    break;
                case 4:
                	quanLyPT.timKiemNhanVien();
                    break;
                case 5:
                	quanLyPT.suaNhanVien();
                	quanLyPT.luuFile();
                	System.out.println("Danh sách nhân viên sau khi sửa");
                    quanLyPT.docFile();
                	quanLyPT.hienThiDanhSachNhanVien();
                    break;
                case 6:
                	quanLyPT.chenNhanVien();
                	quanLyPT.luuFile();
                	System.out.println("Danh sách nhân viên sau khi chèn");
                    quanLyPT.docFile();
                	quanLyPT.hienThiDanhSachNhanVien();
                    break;
                case 7:
                	quanLyPT.tinhLuong();
                    break;
                case 8:
                	quanLyPT.hienThiLuongTren5Trieu();
                    break;
                case 9:
                	quanLyPT.sapXepTheoGioLam();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (c1 != 0);
    }
		
			

}