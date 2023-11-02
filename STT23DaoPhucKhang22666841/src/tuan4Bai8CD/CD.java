package tuan4Bai8CD;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class CD {
	private int maCD;
	private String tuaCD;
	private String caSi;
	private int soBaiHat;
	private double giaThanh;
	private LocalDate ngayPhatHanh;
	
	public int getMaCD() {
		return maCD;
	}
	public void setMaCD(int maCD) {
		this.maCD = maCD;
	}
	public String getTuaCD() {
		return tuaCD;
	}
	public void setTuaCD(String tuaCD) throws Exception {
		if (tuaCD != null) this.tuaCD = tuaCD;
		else throw new Exception("Tựa CD không được để trống");
	}
	public String getCaSi() {
		return caSi;
	}
	public void setCaSi(String caSi) throws Exception {
		if (caSi != null) this.caSi = caSi;
		else throw new Exception("Tên ca sĩ không được để trống");
	}
	public int getSoBaiHat() {
		return soBaiHat;
	}
	public void setSoBaiHat(int soBaiHat) throws Exception {
		if (soBaiHat > 0) this.soBaiHat = soBaiHat;
		else throw new Exception("Số bài hát phải lớn hơn 0");
	}
	public double getGiaThanh() {
		return giaThanh;
	}
	public void setGiaThanh(double giaThanh) throws Exception {
		if (giaThanh > 0) this.giaThanh = giaThanh;
		else throw new Exception("Giá thành phải lớn hơn 0");
	}
	public LocalDate getNgayPhatHanh() {
		return ngayPhatHanh;
	}
	public void setNgayPhatHanh(LocalDate ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}
	public CD(int maCD, String tuaCD, String caSi, int soBaiHat, double giaThanh, LocalDate ngayPhatHanh) {
		super();
		this.maCD = maCD;
		this.tuaCD = tuaCD;
		this.caSi = caSi;
		this.soBaiHat = soBaiHat;
		this.giaThanh = giaThanh;
		this.ngayPhatHanh = ngayPhatHanh;
	}
	public CD() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat moneyFormat = new DecimalFormat("#,##0.00 VNĐ");
		String strPH = ngayPhatHanh.format(pattern);
		String giaThanhString = moneyFormat.format(getGiaThanh());
		return String.format("%10d %30s %30s %15d %20s %20s", getMaCD(), getTuaCD(), getCaSi(), getSoBaiHat(), giaThanhString,strPH);
	}
	
}
