package quanly;

public class LuongFullTime {
	private int luongcoban = 6000000;
	private int luongtangca = 2000000;
	
	public int getLuongcoban() {
		return luongcoban;
	}
	public void setLuongcoban(int luongcoban) {
		this.luongcoban = luongcoban;
	}
	public int getLuongtangca() {
		return luongtangca;
	}
	public void setLuongtangca(int luongtangca) {
		this.luongtangca = luongtangca;
	}
	
	public LuongFullTime(int luongcoban, int luongtangca) {
		super();
		this.luongcoban = luongcoban;
		this.luongtangca = luongtangca;
	}
	public LuongFullTime() {
		super();
	}
	

}
