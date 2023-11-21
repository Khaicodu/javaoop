package quanly;

public class LuongPartTime {
	private int giolamviec;
	private int luongtheogio = 40000;
	public int getGiolamviec() {
		return giolamviec;
	}
	public void setGiolamviec(int giolamviec) {
		this.giolamviec = giolamviec;
	}
	public int getLuongtheogio() {
		return luongtheogio;
	}
	public void setLuongtheogio(int luongtheogio) {
		this.luongtheogio = luongtheogio;
	}
	public LuongPartTime(int giolamviec, int luongtheogio) {
		super();
		this.giolamviec = giolamviec;
		this.luongtheogio = luongtheogio;
	}
	public LuongPartTime() {
		
	}
	
}
