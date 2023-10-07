package tuan3Bai7SinhVien;

public class SinhVien {
	private long maSinhVien;
	private String hoVaTen;
	private String diaChi;
	private String soDienThoai;
	
	public long getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(long maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) throws Exception {
		if (hoVaTen != null)
			this.hoVaTen = hoVaTen;
		else 
			throw new Exception("Họ và tên không được để trống");
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) throws Exception {
		if (soDienThoai.length() == 10)
			if(soDienThoai.matches("\\d+"))
				this.soDienThoai = soDienThoai;
			else 
				throw new Exception("Số điện thoại không thể chứa các kí tự khác ngoài số");
		else
			throw new Exception("Số điện thoại phải có 10 chữ số");
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SinhVien(long maSinhVien, String hoVaTen, String diaChi, String soDienThoai) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoVaTen = hoVaTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}
	
	@Override
	public String toString() {
		return String.format("%20s %20s %30s %20s", getMaSinhVien(), getHoVaTen(), getDiaChi(), getSoDienThoai());
	}
}
