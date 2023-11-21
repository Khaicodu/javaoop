package quanly;

import java.io.Serializable;

public class NhanVien extends Nguoi implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String maNV;
	public String phong;
	public String tangCa;
	
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

	public String getTangCa() {
		return tangCa;
	}

	public void setTangCa(String tangCa) {
		this.tangCa = tangCa;
	}

	public NhanVien(String hoTen, int tuoi, String gioiTinh, String maNV, String phong, String tangCa) {
		super(hoTen, tuoi, gioiTinh);
		this.maNV = maNV;
		this.phong = phong;
		this.tangCa = tangCa;
	}

	public NhanVien(String hoTen, int tuoi, String gioiTinh) {
		super(hoTen, tuoi, gioiTinh);
	}

	
	
}
