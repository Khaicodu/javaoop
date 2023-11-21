package quanly;

import java.util.ArrayList;
import quanly.LuongFullTime;
import java.util.Scanner;
import java.util.*;

public class QuanLyFullTime {
	public ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
	NhanVienDao obj = new NhanVienDao();
	Scanner sc = new Scanner(System.in);
	LuongFullTime lft = new LuongFullTime();
	double totalSalary = 0.0;
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số lượng nhân viên: ");
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= n; i++) {
			System.out.print("Nhập mã nhân viên:   ");
			String maNV = sc.nextLine();
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
			System.out.print("Nhập Phòng:   ");
			String phong = sc.nextLine();
			sc.nextLine();
			System.out.print("Tăng ca:   ");
			String tangCa = sc.nextLine();
			sc.nextLine();
			System.out.println("────────────────────────────────────");
			NhanVien nv = new NhanVien(hoTen, tuoi, gioiTinh, maNV, phong, tangCa);
			dsnv.add(nv);
		}
		obj.ghiFile(dsnv);
	}

	public void docFile() {
		dsnv = obj.docFile("e:\\danhsachnhanvien.bin");
	}
	
	public void luuFile() {
		obj.ghiFile(dsnv);
	}
	
	public void hienThiDanhSachNhanVien() {
	    System.out.println("Danh sách nhân viên:");
	    System.out.println("┌─────────────┬──────────────────────┬──────┬────────────┬───────────┬────────────┐");
	    System.out.printf("│ %-11s │ %-20s │ %-4s │ %-10s │ %-9s │ %-10s │%n",
	            "Mã NV", "Họ Tên", "Tuổi", "Giới Tính", "Phòng", "Tăng Ca");
	    System.out.println("├─────────────┼──────────────────────┼──────┼────────────┼───────────┼────────────┤");

	    for (NhanVien nv : dsnv) {
	        System.out.printf("│ %-11s │ %-20s │ %-4d │ %-10s │ %-9s │ %-10s │%n",
	                nv.getMaNV(), nv.getHoTen(), nv.getTuoi(),
	                nv.getGioiTinh(), nv.getPhong(), nv.getTangCa());
	        System.out.println("├─────────────┼──────────────────────┼──────┼────────────┼───────────┼────────────┤");
	    }
	    System.out.println("└─────────────┴──────────────────────┴──────┴────────────┴───────────┴────────────┘");
	}
	public void xoaNhanVien() {
		System.out.println("Nhập mã nhân viên cần xóa:");
		String maNVCaCanXoa = sc.nextLine();
		int indexToRemove = -1;
		for (int i = 0; i < dsnv.size(); i++) {
			if (dsnv.get(i).getMaNV().equals(maNVCaCanXoa)) {
				indexToRemove = i;
				break;
			}
		}
		if (indexToRemove != -1) {
			dsnv.remove(indexToRemove);
			System.out.println("Nhân viên đã được xóa khỏi danh sách.");
		} else {
			System.out.println("Không tìm thấy nhân viên có mã " + maNVCaCanXoa);
		}
	}

	public void chenNhanVien() {
		System.out.println("Nhập vị trí cần chèn (từ 1 đến " + (dsnv.size() + 1) + "):");
		int viTriChen = sc.nextInt();
		sc.nextLine();
		if (viTriChen < 1 || viTriChen > dsnv.size() + 1) {
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
		System.out.print("Nhập Phòng:   ");
		String phong = sc.nextLine();
		sc.nextLine();
		System.out.print("Tăng ca:   ");
		String tangCa = sc.nextLine();
		sc.nextLine();
		NhanVien nv = new NhanVien(hoTen, tuoi, gioiTinh, maNV, phong, tangCa);
		dsnv.add(viTriChen - 1, nv);
		System.out.println("Nhân viên đã được chèn vào vị trí " + viTriChen);
	}

	public void timKiemNhanVien() {
	    System.out.println("Nhập mã nhân viên cần tìm kiếm:");
	    String maNVCaCanTim = sc.nextLine();
	    boolean found = false;
	    for (NhanVien nv : dsnv) {
	        if (nv.getMaNV().equals(maNVCaCanTim)) {
	            found = true;
	            System.out.println("┌─────────────┬──────────────────────┬──────┬────────────┬───────────┬────────────┐");
	    	    System.out.printf("│ %-11s │ %-20s │ %-4s │ %-10s │ %-9s │ %-10s │%n",
	    	            "Mã NV", "Họ Tên", "Tuổi", "Giới Tính", "Phòng", "Tăng Ca");
	    	    System.out.println("├─────────────┼──────────────────────┼──────┼────────────┼───────────┼────────────┤");
	            System.out.printf("│ %-11s │ %-20s │ %-4d │ %-10s │ %-9s │ %-10s │%n",
	                    nv.getMaNV(), nv.getHoTen(), nv.getTuoi(),
	                    nv.getGioiTinh(), nv.getPhong(), nv.getTangCa());
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

	    for (NhanVien nv : dsnv) {
	        if (nv.getMaNV().equals(maNVCaCanSua)) {
	            System.out.println("Nhập thông tin mới cho nhân viên có mã " + maNVCaCanSua + ":");
	            
	            System.out.print("Nhập Họ Tên mới:   ");
	            String hoTenMoi = sc.nextLine();
	            nv.setHoTen(hoTenMoi);

	            System.out.print("Nhập tuổi mới:   ");
	            int tuoiMoi = Integer.parseInt(sc.nextLine());
	            nv.setTuoi(tuoiMoi);

	            System.out.print("Nhập giới tính mới:   ");
	            String gioiTinhMoi = sc.nextLine();
	            nv.setGioiTinh(gioiTinhMoi);

	            System.out.print("Nhập Phòng mới:   ");
	            String phongMoi = sc.nextLine();
	            nv.setPhong(phongMoi);

	            System.out.print("Nhập Tăng Ca mới:   ");
	            String tangCaMoi = sc.nextLine();
	            nv.setTangCa(tangCaMoi);

	            System.out.println("Thông tin nhân viên đã được cập nhật.");
	            return;
	        }
	    }

	    System.out.println("Không tìm thấy nhân viên có mã " + maNVCaCanSua);
	}

	public void tinhluong() {
	    double totalSalary = 0.0;
	    System.out.println("Thông tin và lương của nhân viên:");
	    System.out.println("┌─────────────┬──────────────────────┬──────┬────────────┬───────────┬────────────┬─────────────────┐");
	    System.out.printf("│ %-11s │ %-20s │ %-4s │ %-10s │ %-9s │ %-10s │ %-15s │%n",
	            "Mã NV", "Họ Tên", "Tuổi", "Giới Tính", "Phòng", "Tăng Ca", "Lương(VNĐ)");
	    System.out.println("├─────────────┼──────────────────────┼──────┼────────────┼───────────┼────────────┼─────────────────┤");

	    for (NhanVien nv : dsnv) {
	        double salary = 0.0;
	        if (nv.getTangCa().equalsIgnoreCase("Có")) {
	            salary = lft.getLuongcoban() + lft.getLuongtangca();
	        } else {
	            salary = lft.getLuongcoban();
	        }
	        System.out.printf("│ %-11s │ %-20s │ %-4d │ %-10s │ %-9s │ %-10s │ %-15.2f │%n",
	                nv.getMaNV(), nv.getHoTen(), nv.getTuoi(),
	                nv.getGioiTinh(), nv.getPhong(), nv.getTangCa(), salary);
	        System.out.println("├─────────────┼──────────────────────┼──────┼────────────┼───────────┼────────────┼─────────────────┤");

	        totalSalary += salary;
	    }
	    System.out.println("└─────────────┴──────────────────────┴──────┴────────────┴───────────┴────────────┴─────────────────┘");
	    System.out.println("Tổng lương của tất cả nhân viên: " + totalSalary + " VNĐ");
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
				else { System.out.println("Tuổi không hợp lệ ");
				System.out.println("Nhập lại");
				tuoi = sc.nextInt();
				}
			}catch (Exception e) { System.out.println("Bạn đã nhập sai tuổi: Tuổi không có giá trị");}
		}
		return (tuoi);
	}

}
