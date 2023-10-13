package tuan5Bai2Sach;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import tuan5Bai1ChuyenXe.ChuyenXe;
import tuan5Bai1ChuyenXe.ChuyenXeNgoaiThanh;

public class DanhSachSach {
	private ArrayList<Sach> listSach;
	
	public ArrayList<Sach> getAll() {
		return this.listSach;
	}
	
	public DanhSachSach() {
		listSach = new ArrayList<Sach>();
	}
	
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
	
	public int findIndexOfChuyenXe(String maSach) {
		for (Sach sach : listSach)
			if (sach.getMaSach().equals(maSach))
				return listSach.indexOf(sach);
		return -1;
	}
	
	public double sumThanhTienSachGiaoKhoa() {
		double sumThanhTienSGK = 0;
		for (Sach sach: listSach) {
			if (sach instanceof SachGiaoKhoa)
				sumThanhTienSGK += sach.thanhTien();
		}
		return sumThanhTienSGK;
	}
	
	public double sumThanhTienSachThamKhao() {
		double sumThanhTienSTK = 0;
		for (Sach sach: listSach) {
			if (sach instanceof SachThamKhao)
				sumThanhTienSTK += sach.thanhTien();
		}
		return sumThanhTienSTK;
	}
	
	public double averageDonGiaSachGiaoKhoa() {
		double sumDonGiaSGK = 0;
		int count = 0;
		for (Sach sach: listSach) {
			if (sach instanceof SachGiaoKhoa)
			{
				sumDonGiaSGK += sach.getDonGia();
				count++;
			}
		}
		double aveDonGia = sumDonGiaSGK/count;
		return aveDonGia;
	}
	
	public double averageDonGiaSachThamKhao() {
		double sumDonGiaSTK = 0;
		int count = 0;
		for (Sach sach: listSach) {
			if (sach instanceof SachThamKhao)
			{
				sumDonGiaSTK += sach.getDonGia();
				count++;
			}
		}
		double aveDonGia = sumDonGiaSTK/count;
		return aveDonGia;
	}
	
	public ArrayList<Sach> danhSachSGK(){
		ArrayList<Sach> listSGK = new ArrayList<Sach>();
		for (Sach sach : listSach) {
			if (sach instanceof SachGiaoKhoa) listSGK.add(sach);
		}
		return listSGK;
	}
	
	public ArrayList<Sach> danhSachSTK(){
		ArrayList<Sach> listSTK = new ArrayList<Sach>();
		for (Sach sach : listSach) {
			if (sach instanceof SachThamKhao) listSTK.add(sach);
		}
		return listSTK;
	}
	
	public ArrayList<Sach> danhSachSachNXB(String tenNXB){
		ArrayList<Sach> danhSachSachNXB = new ArrayList<Sach>();
		for (Sach sach : listSach) {
			if (sach.getNhaXuatBan().equalsIgnoreCase(tenNXB))
				danhSachSachNXB.add(sach);
		}
		return danhSachSachNXB;
	}
	
	public void sortListSachTheoNgayNhap() {
		Collections.sort(listSach, new Comparator<Sach>() {
			@Override
			public int compare(Sach sach1, Sach sach2) {
				LocalDate ngayNhapSach1 = sach1.getNgayNhap();
				LocalDate ngayNhapSach2 = sach2.getNgayNhap();
				return ngayNhapSach1.compareTo(ngayNhapSach2);
			}
		});
	}
}
