package tuan3Bai6HangThucPham;


import java.text.DecimalFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham {
	private String maHang;
	private String tenHang;
	private double donGia;
	private LocalDate ngaySX;
	private LocalDate ngayHH;

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) throws Exception {
		if (maHang != null) this.maHang = maHang;
		else throw new Exception("Mã hàng không được để trống");
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) throws Exception {
		if (tenHang != null) this.tenHang = tenHang;
		else throw new Exception("Tên hàng không được để trống");
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) throws Exception {
		if (donGia > 0) this.donGia = donGia;
		else throw new Exception("Đơn giá phải lớn hơn 0");
	}

	public LocalDate getNgaySX() {
		return ngaySX;
	}

	public void setNgaySX(LocalDate ngaySX) throws Exception {
		if (ngaySX != null) this.ngaySX = ngaySX;
		else throw new Exception("Ngày sản xuất không được để trống");
	}

	public LocalDate getNgayHH() {
		return ngayHH;
	}

	public void setNgayHH(LocalDate ngayHH) throws Exception {
		if (ngayHH != null || ngayHH.isBefore(ngaySX)) this.ngayHH = ngayHH;
		else throw new Exception("Ngày hết hạn không hợp lệ");
	}

	public HangThucPham(String maHang, String tenHang, double donGia, LocalDate ngaySX, LocalDate ngayHH) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		this.ngaySX = ngaySX;
		this.ngayHH = ngayHH;
	}

	public HangThucPham(String maHang) {
		super();
		this.maHang = maHang;
	}

	public HangThucPham() {
		super();

	}

	public boolean daHetHan() {
		if (ngayHH.isBefore(LocalDate.now())) return true;
		else return false;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String strSX = ngaySX.format(pattern);
		String strHH = ngayHH.format(pattern);
		DecimalFormat formatter = new DecimalFormat("###,###,###.00");
		return String.format("%-10s\t%-15s\t%20s\t%-15s\t%-15s\t%-10s", maHang, tenHang,
		formatter.format(donGia)+" VND",
		strSX, strHH,
		daHetHan()?"Đã hết hạn":"Còn hạn");
		}
}
