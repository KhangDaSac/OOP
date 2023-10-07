package tuan1Bai3Vehicle;

public class Vehicle {
	private String tenChuXe;
	private String loaiXe;
	private int dungTich;
	private double giaTri;

	public String getTenChuXe() {
		return tenChuXe;
	}

	public void setTenChuXe(String tenChuXe) throws Exception  {
		if (!tenChuXe.isEmpty()) {
			this.tenChuXe = tenChuXe;
		}else {
			throw new Exception("Tên không hợp lệ");
		}
		
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) throws Exception {
		if (!loaiXe.isEmpty()) {
			this.loaiXe = loaiXe;
		}else {
			throw new Exception("Tên xe không hợp lệ");
		}
	}

	public int getDungTich() {
		return dungTich;
	}

	public void setDungTich(int dungTich) throws Exception {
		if (dungTich > 0) {
			this.dungTich = dungTich;
		}else {
			throw new Exception("Dung tích phải lớn hơn 0");
		}
	}

	public double getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(double giaTri) throws Exception {
		if (giaTri > 0) {
			this.giaTri = giaTri;
		}else {
			throw new Exception("Dung tích phải lớn hơn 0");
		}
	}

	public Vehicle() {
		super();
	}

	public Vehicle(String tenChuXe, String loaiXe, int dungTich, double giaTri) {
		super();
		this.tenChuXe = tenChuXe;
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.giaTri = giaTri;
	}

	public double thue() {
		if (this.getDungTich() < 100) return this.getGiaTri() * 1/100;
			else if (this.getDungTich() <= 200) return this.getGiaTri() * 3/100;
				else return this.getGiaTri() * 5/100;
	}
	
	@Override
	public String toString() {
		String str = String.format("%-20s %-20s %10d %20.2f %20.2f",getTenChuXe(), getLoaiXe(), getDungTich(), getGiaTri(), thue());
		return str;
	}
}
