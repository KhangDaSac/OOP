package tuan5Bai1ChuyenXe;

import java.text.DecimalFormat;

public class ChuyenXeNoiThanh extends ChuyenXe {
	private int soTuyen;
	private double soKm;
	
	public int getSoTuyen() {
		return soTuyen;
	}
	public void setSoTuyen(int soTuyen) {
		this.soTuyen = soTuyen;
	}
	public double getSoKm() {
		return soKm;
	}
	public void setSoKm(double soKm) {
		this.soKm = soKm;
	}
	public ChuyenXeNoiThanh(String maChuyenXe, String hoTenTaiXe, int soXe, double doanhThu, int soTuyen, double soKm) {
		super(maChuyenXe, hoTenTaiXe, soXe, doanhThu);
		this.soTuyen = soTuyen;
		this.soKm = soKm;
	}
	public ChuyenXeNoiThanh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChuyenXeNoiThanh(String maChuyenXe, String hoTenTaiXe, int soXe, double doanhThu) {
		super(maChuyenXe, hoTenTaiXe, soXe, doanhThu);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		DecimalFormat kmFormat = new DecimalFormat("#,##0.00km");
		String soKmString = kmFormat.format(getSoKm());
		return super.toString() + String.format(" %10d %20s %20s %20s", getSoTuyen(), soKmString, "---", "---");
	}
	
}

