package tuan5Bai2Sach;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class SachGiaoKhoa extends Sach {
	private boolean tinhTrang;
	private final double LUATSACHCU = 0.5f;
	
	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public double thanhTien() {
		double thanhTien;
		if (isTinhTrang())
			thanhTien = getSoLuong() * getDonGia();
		else
			thanhTien = getSoLuong() * getDonGia() * LUATSACHCU;
		return thanhTien;
	}

	public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan,
			boolean tinhTrang) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.tinhTrang = tinhTrang;
	}

	public SachGiaoKhoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		String tinhTrangString;
		if (isTinhTrang()) tinhTrangString = "Sách mới";
		else tinhTrangString = "Sách cũ";
		
		DecimalFormat thanhTienFormat = new DecimalFormat("###,###,###.00VND");
		String thanhTienString = thanhTienFormat.format(thanhTien());
		
		return super.toString() + String.format("%20s %30", tinhTrangString, thanhTienString);
	}
}
