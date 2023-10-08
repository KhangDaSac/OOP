package tuan1Bai2SinhVien;

public class SinhVien {
	private int maSoSinhVien;
	private String hoTen;
	private float diemLT;
	private float diemTH;
	private int getMaSoSinhVien() {
		return maSoSinhVien;
	}
	public void setMaSoSinhVien(int maSoSinhVien) {
		this.maSoSinhVien = maSoSinhVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public float getDiemLT() {
		return diemLT;
	}
	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}
	public float getDiemTH() {
		return diemTH;
	}
	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}
	
	public float diemTB() {
		float TB = 0;
		TB = (this.getDiemLT() + this.getDiemTH()) / 2;
		return TB;
	}
	
	public SinhVien() {
		super();
	}
	
	public SinhVien(int maSoSinhVien, String hoTen, float diemLT, float diemTH) {
		super();
		this.maSoSinhVien = maSoSinhVien;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}
	
	@Override
	public String toString() {
		String str = String.format("%10d %20s %10.2f %10.2f %10.2f", getMaSoSinhVien(), getHoTen(), getDiemLT(), getDiemTH(), diemTB());
		return str;
	}
	
}
