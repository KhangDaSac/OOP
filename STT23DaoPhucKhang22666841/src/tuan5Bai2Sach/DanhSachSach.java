package tuan5Bai2Sach;

import java.util.ArrayList;

public class DanhSachSach {
	private ArrayList<Sach> listSach;
	
	public void add(Sach sach) throws Exception {
		if (!listSach.contains(sach)) {
			listSach.add(sach);
		}else
			throw new Exception("Mã sách đã tồn tại");
	}
	
	public void remove(Sach sach) throws Exception {
		if(listSach.indexOf(sach) >= 0) {
			listSach.remove(sach);
		}else
			throw new Exception("Không tìm thấy sách");
	}
	
	public double sumThanhTien() {
		double sumThanhTien = 0;
		for (Sach sach: listSach) {
			sumThanhTien += sach.thanhTien();
		}
		return sumThanhTien;
	}
	
	public double averageDonGia() {
		double sumDonGia = 0;
		for (Sach sach: listSach) {
			sumDonGia += sach.getDonGia();
		}
		double aveDonGia = sumDonGia/listSach.size();
		return aveDonGia;
	}
}
