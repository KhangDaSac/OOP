package tuan1Bai1HinhChuNhat;

public class HinhChuNhat {
	private float chieuDai;
	private float chieuRong;
	public float getChieuDai() {
		return chieuDai;
	}
	public void setChieuDai(float chieuDai) throws Exception {	
		if (chieuDai > 0) {
			this.chieuDai = chieuDai;
		}else 
			throw new Exception("Chiều dài phải lớn hơn 0");
	}
	
	public float getChieuRong() {
		return chieuRong;
	}
	
	public void setChieuRong(float chieuRong) throws Exception {
		if (chieuRong > 0) {
			this.chieuRong = chieuRong;
		}else 
			throw new Exception("Chiều rộng phải lớn hơn 0");
	}
	
	public HinhChuNhat() {
		super();
	}
	
	public HinhChuNhat(float chieuDai, float chieuRong) throws Exception {
		super();
		setChieuDai(chieuDai);
		setChieuRong(chieuRong);
	}
	
	public float chuVi() {
		float CV = 0;
		CV = (this.getChieuDai() + this.getChieuRong())*2;
		return CV;
	}
	
	public float dienTich() {
		float DT = 0;
		DT = this.getChieuDai()*this.getChieuRong();
		return DT;
	}
	
	@Override
	public String toString() {
		String str = String.format("%10.2f %10.2f %10.2f %10.2f", getChieuDai(), getChieuRong(), chuVi(), dienTich());
		return str;
	}
}
