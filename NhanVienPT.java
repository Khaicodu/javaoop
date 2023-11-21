package quanly;

import java.io.Serializable;

public class NhanVienPT extends Nguoi implements Serializable{
	private static final long serialVersionUID = 1L;
	public String maNV;
	public String phong;
	public int gioLamViec;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getPhong() {
		return phong;
	}
	public void setPhong(String phong) {
		this.phong = phong;
	}
	public int getGioLamViec() {
		return gioLamViec;
	}
	public void setGioLamViec(int gioLamViec) {
		this.gioLamViec = gioLamViec;
	}
	public NhanVienPT(String hoTen, int tuoi, String gioiTinh, String maNV, String phong, int gioLamViec) {
		super(hoTen, tuoi, gioiTinh);
		this.maNV = maNV;
		this.phong = phong;
		this.gioLamViec = gioLamViec;
	}

	

	
	
	

}
