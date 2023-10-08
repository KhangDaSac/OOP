package tuan5Bai1ChuyenXe;

public class ChuyenXeNgoaiThanh extends ChuyenXe {
	private String noiDen;
	private int soNgayDiDuoc;
	
	public String getNoiDen() {
		return noiDen;
	}
	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}
	public int getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}
	public void setSoNgayDiDuoc(int soNgayDiDuoc) {
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	public ChuyenXeNgoaiThanh(String maChuyenXe, String hoTenTaiXe, int soXe, double doanhThu, String noiDen,
			int soNgayDiDuoc) {
		super(maChuyenXe, hoTenTaiXe, soXe, doanhThu);
		this.noiDen = noiDen;
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	public ChuyenXeNgoaiThanh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChuyenXeNgoaiThanh(String maChuyenXe, String hoTenTaiXe, int soXe, double doanhThu) {
		super(maChuyenXe, hoTenTaiXe, soXe, doanhThu);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(" %10s %20s %20s %20d", "---", "---", getNoiDen(), getSoNgayDiDuoc());
	}
}
