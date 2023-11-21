package quanly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import quanly.LuongPartTime;

public class QuanLyPartTime {
	public ArrayList<NhanVienPT> dsnvpt= new ArrayList<NhanVienPT>();
	NhanVienPTDao obj = new NhanVienPTDao();
	Scanner sc = new Scanner(System.in);
	LuongPartTime lpt = new LuongPartTime();
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số lượng nhân viên: ");
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= n; i++) {
			System.out.print("Nhập mã nhân viên:   ");
			String maNV = sc.nextLine();
			maNV = check(maNV);
			System.out.print("Nhập Họ Tên:   ");
			String hoTen = sc.nextLine();
			hoTen = check1(hoTen);
			sc.nextLine();
			System.out.print("Nhập tuổi:   ");
			int tuoi = sc.nextInt();
			sc.nextLine(); 
			System.out.print("Nhập giới tính:   ");
			String gioiTinh = sc.nextLine();
			System.out.print("Nhập Phòng:   ");
			String phong = sc.nextLine();
			sc.nextLine();
	    	System.out.print("Số giờ làm:   ");
	    	int gioLamViec = sc.nextInt();
	    	gioLamViec = check1(gioLamViec);
	    	System.out.println("────────────────────────────────────");
	    	NhanVienPT nvpt = new NhanVienPT(hoTen, tuoi, gioiTinh, maNV, phong, gioLamViec);
	    	dsnvpt.add(nvpt);
	    }
	    obj.ghiFile(dsnvpt);
	}
	
	public void docFile() {
		dsnvpt = obj.docFile("e:\\danhsachnhanvienpt.bin");
	}
	
	public void luuFile() {
		obj.ghiFile(dsnvpt);
	}
	
	public void hienThiDanhSachNhanVien() {
	    System.out.println("Danh sách nhân viên:");
	    System.out.println("┌──────────┬──────────────────────────┬──────┬───────────┬───────────────┬───────────────────────────┐");
	    System.out.printf("│ %-8s │ %-24s │ %-4s │ %-9s │ %-13s │ %-25s │%n",
	            "Mã NV", "Họ Tên", "Tuổi", "Giới Tính", "Phòng", "Số giờ làm việc");
	    System.out.println("│──────────┼──────────────────────────┼──────┼───────────┼───────────────┼───────────────────────────│");

	    for (NhanVienPT nvpt : dsnvpt) {
	        System.out.printf("│ %-8s │ %-24s │ %-4d │ %-9s │ %-13s │ %-25d │%n",
	                nvpt.getMaNV(), nvpt.getHoTen(), nvpt.getTuoi(),
	                nvpt.getGioiTinh(), nvpt.getPhong(), nvpt.getGioLamViec());
	    }
	    System.out.println("└──────────┴──────────────────────────┴──────┴───────────┴───────────────┴───────────────────────────┘");
	}
	
		public void xoaNhanVien() {
			System.out.println("Nhập mã nhân viên cần xóa:");
			String maNVCaCanXoa = sc.nextLine();

			int indexToRemove = -1;
			for (int i = 0; i < dsnvpt.size(); i++) {
				if (dsnvpt.get(i).getMaNV().equals(maNVCaCanXoa)) {
					indexToRemove = i;
					break;
				}
			}
			if (indexToRemove != -1) {
				dsnvpt.remove(indexToRemove);
				System.out.println("Nhân viên đã được xóa khỏi danh sách.");
			} else {
				System.out.println("Không tìm thấy nhân viên có mã " + maNVCaCanXoa);
			}
		}
		
		public void timKiemNhanVien() {
		    System.out.println("Nhập mã nhân viên cần tìm kiếm:");
		    String maNVCaCanTim = sc.nextLine();
		    boolean found = false;
		    for (NhanVienPT nvpt : dsnvpt) {
		        if (nvpt.getMaNV().equals(maNVCaCanTim)) {
		            found = true;
		            System.out.println("┌─────────────┬──────────────────────┬──────┬────────────┬───────────┬────────────┐");
				    System.out.printf("│ %-11s │ %-20s │ %-4s │ %-10s │ %-9s │ %-10s │%n",
				            "Mã NV", "Họ Tên", "Tuổi", "Giới Tính", "Phòng", "Tăng Ca");
				    System.out.println("├─────────────┼──────────────────────┼──────┼────────────┼───────────┼────────────┤");
		            System.out.printf("│ %-11s │ %-20s │ %-4d │ %-10s │ %-9s │ %-10s │%n",
		                    nvpt.getMaNV(), nvpt.getHoTen(), nvpt.getTuoi(),
		                    nvpt.getGioiTinh(), nvpt.getPhong(), nvpt.getGioLamViec());
		            System.out.println("└─────────────┴──────────────────────┴──────┴────────────┴───────────┴────────────┘");
		            break;
		        }
		    }

		    if (!found) {
		        System.out.println("Không tìm thấy nhân viên có mã " + maNVCaCanTim);
		    }
		}
	  
	  public void suaNhanVien() {
	        System.out.println("Nhập mã nhân viên cần sửa:");
	        String maNVCaCanSua = sc.nextLine();

	        for (NhanVienPT nvpt : dsnvpt) {
	            if (nvpt.getMaNV().equals(maNVCaCanSua)) {
	                System.out.print("Nhập thông tin mới cho nhân viên có mã " + maNVCaCanSua + ":");
	                System.out.print("Nhập Họ Tên mới:   ");
	                String hoTenMoi = sc.nextLine();
	                nvpt.setHoTen(hoTenMoi);
	                System.out.print("Nhập tuổi mới:   ");
	                int tuoiMoi = sc.nextInt();
	                nvpt.setTuoi(tuoiMoi);
	                System.out.print("Nhập giới tính mới:   ");
	                sc.nextLine();
	                String gioiTinhMoi = sc.nextLine();
	                nvpt.setGioiTinh(gioiTinhMoi);
	                System.out.print("Nhập Phòng mới:   ");
	                String phongMoi = sc.nextLine();
	                nvpt.setPhong(phongMoi);
	                System.out.print("Nhập Giờ làm việc mới:   ");
	                int gioLamViecMoi = sc.nextInt();
	                nvpt.setGioLamViec(gioLamViecMoi);
	                System.out.println("Thông tin nhân viên đã được cập nhật.");
	                return; 
	            }
	        }

	        System.out.println("Không tìm thấy nhân viên có mã " + maNVCaCanSua);
	    }
	  
	  public void chenNhanVien() {
		    System.out.println("Nhập vị trí cần chèn (từ 1 đến " + (dsnvpt.size() + 1) + "):");
		    int viTriChen = sc.nextInt();
		    sc.nextLine(); 

		    if (viTriChen < 1 || viTriChen > dsnvpt.size() + 1) {
		        System.out.println("Vị trí chèn không hợp lệ.");
		        return;
		    }

		    System.out.print("Nhập mã nhân viên:   ");
			String maNV = sc.nextLine();
			maNV = check(maNV);
			sc.nextLine();
			System.out.print("Nhập Họ Tên:   ");
			String hoTen = sc.nextLine();
			hoTen = check1(hoTen);
			sc.nextLine();
			System.out.print("Nhập tuổi:   ");
			int tuoi = sc.nextInt();
			sc.nextLine(); 
			System.out.print("Nhập giới tính:   ");
			String gioiTinh = sc.nextLine();
			sc.nextLine();
			System.out.print("Nhập Phòng:   ");
			String phong = sc.nextLine();
	    	System.out.print("Số giờ làm:   ");
	    	int gioLamViec = sc.nextInt();
	    	gioLamViec = check1(gioLamViec);
		    NhanVienPT nvpt = new NhanVienPT(hoTen, tuoi, gioiTinh, maNV, phong, gioLamViec);
		    dsnvpt.add(viTriChen - 1, nvpt);
		    System.out.println("Nhân viên đã được chèn vào vị trí " + viTriChen);
		}
	  
	  public void tinhLuong() {
		    System.out.println("┌──────────┬──────────────────────────┬──────┬───────────┬───────────────┬─────────────────┬───────────────────────────┐");
		    System.out.printf("│ %-8s │ %-24s │ %-4s │ %-9s │ %-13s │ %-13s │ %-25s │%n",
		            "Mã NV", "Họ Tên", "Tuổi", "Giới Tính", "Phòng", "Số giờ làm việc", "Lương (VNĐ)");
		    System.out.println("├──────────┼──────────────────────────┼──────┼───────────┼───────────────┼─────────────────┼───────────────────────────┤");

		    for (NhanVienPT nvpt : dsnvpt) {
		        int gioLamViec = nvpt.getGioLamViec();
		        int luong = gioLamViec * lpt.getLuongtheogio();
		        System.out.printf("│ %-8s │ %-24s │ %-4d │ %-9s │ %-13s │ %-15d │  %-24d │%n",
		                nvpt.getMaNV(), nvpt.getHoTen(), nvpt.getTuoi(), nvpt.getGioiTinh(), nvpt.getPhong(), gioLamViec, luong);
		    }

		    System.out.println("└──────────┴──────────────────────────┴──────┴───────────┴───────────────┴─────────────────┴───────────────────────────┘");
		}
	  
	  public void hienThiLuongTren5Trieu() {
		    System.out.println("Những nhân viên có lương trên 5 triệu:");

		    for (NhanVienPT nvpt : dsnvpt) {
		        int gioLamViec = nvpt.getGioLamViec();
		        int luong = gioLamViec * lpt.getLuongtheogio();

		        if (luong > 5000000) { 
		            System.out.println("Mã NV: " + nvpt.getMaNV());
		            System.out.println("Họ Tên: " + nvpt.getHoTen());
		            System.out.println("Lương: " + luong + " VNĐ");
		            System.out.println("────────────────────────────────────");
		        }   
		    }
		}

	  public void sapXepTheoGioLam() {
		    Collections.sort(dsnvpt, Comparator.comparingInt(NhanVienPT::getGioLamViec).reversed());	    
		    System.out.println("Danh sách nhân viên sau khi sắp xếp theo giờ làm việc (từ cao đến thấp):");
		    hienThiDanhSachNhanVien();
		}
	  
	  public String check(String maNV)
		{
			while (true)
			{
				try
				{
					if(maNV.length()!=0) break;
					else { System.out.println("Không được 'NULL' ");
					System.out.println("Nhap lai");
					maNV= sc.nextLine();
					}
				}catch (Exception e) { System.out.println("Bạn đã nhập sai Mã Nhân Viên = NULL");}
			}
			return (maNV);
		}
	  
		public String check1(String hoTen)
		{
			while (true)
			{
				try
				{
					if(hoTen.length()!=0) break;
					else { System.out.println("Không được 'NULL' ");
					System.out.println("Nhap lai");
					hoTen= sc.nextLine();
					}
				}catch (Exception e) { System.out.println("Bạn đã nhập sai Họ Tên = NULL");}
			}
			return (hoTen);
		}
		
	  public int check(int tuoi)
	  {
		while (true)
		{
			try
			{
				if ( (tuoi>=0) && (tuoi<150) )break;
				else { System.out.println("Tuổi không hợp lệ");
				System.out.println("Nhap lai");
				tuoi = sc.nextInt();
				}
			}catch (Exception e) { System.out.println("Bạn đã nhập sai tuổi: Tuổi Không có giá trị");}
		}
		return (tuoi);
	  }
	  
	  public int check1(int gioLamViec)
	{
		while (true)
		{
			try
			{
				if ( (gioLamViec>=0) && (gioLamViec<200) )break;
				else { System.out.println("Giờ làm việc không hợp lệ ");
				System.out.println("Nhap lai");
				gioLamViec = sc.nextInt();
				}
			}catch (Exception e) { System.out.println("Bạn đã nhập sai giờ làm việc: giờ làm việc không có giá trị");}
		}
		return (gioLamViec);
	}
		

	  
}