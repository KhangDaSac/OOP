package tuan6Bai2Sach;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class SachThamKhao extends Sach {
	private double thue;
	
	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	@Override
	public double thanhTien() {
		return getSoLuong()*getDonGia() + getThue();
	}

	public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.thue = thue;
	}

	public SachThamKhao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		DecimalFormat moneyFormat = new DecimalFormat("###,###,###.00 VND");
		String thanhTienString = moneyFormat.format(thanhTien());
		String thueString = moneyFormat.format(thue);
		return super.toString() + String.format(" %15s %20s %20s", "---", thueString, thanhTienString);
	}
	
	
}
