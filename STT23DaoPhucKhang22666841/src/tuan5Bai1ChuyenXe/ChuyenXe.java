package tuan5Bai1ChuyenXe;

import java.text.DecimalFormat;
import java.util.Objects;

public class ChuyenXe {
	protected String maChuyenXe;
	protected String hoTenTaiXe;
	protected int soXe;
	protected double doanhThu;
	public String getMaChuyenXe() {
		return maChuyenXe;
	}
	public void setMaChuyenXe(String maChuyenXe) {
		this.maChuyenXe = maChuyenXe;
	}
	public String getHoTenTaiXe() {
		return hoTenTaiXe;
	}
	public void setHoTenTaiXe(String hoTenTaiXe) {
		this.hoTenTaiXe = hoTenTaiXe;
	}
	public int getSoXe() {
		return soXe;
	}
	public void setSoXe(int soXe) {
		this.soXe = soXe;
	}
	public double getDoanhThu() {
		return doanhThu;
	}
	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maChuyenXe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChuyenXe other = (ChuyenXe) obj;
		return Objects.equals(maChuyenXe, other.maChuyenXe);
	}

	public ChuyenXe(String maChuyenXe, String hoTenTaiXe, int soXe, double doanhThu) {
		super();
		this.maChuyenXe = maChuyenXe;
		this.hoTenTaiXe = hoTenTaiXe;
		this.soXe = soXe;
		this.doanhThu = doanhThu;
	}

	public ChuyenXe() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		String doanhThuString = df.format(getDoanhThu());
		return String.format("%10s %20s %10d %25s", getMaChuyenXe(), getHoTenTaiXe(), getSoXe(), doanhThuString);
	}
}
