package tuan5Bai1ChuyenXe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import tuan3Bai8CD.CD;

public class DanhSachChuyenXe {
	private ArrayList<ChuyenXe> listChuyenXe;
	
	public DanhSachChuyenXe() {
		listChuyenXe = new ArrayList<ChuyenXe>();
	}

	public ArrayList<ChuyenXe> getAll(){
		return listChuyenXe;
	}

	public void add(ChuyenXe xe) throws Exception {
		if (listChuyenXe.contains(xe) == false) {
			listChuyenXe.add(xe);
		}else {
			throw new Exception("Mã chuyến xe đã trùng");
		}
	}

	public void remove(ChuyenXe xe) throws Exception {
		int index = listChuyenXe.indexOf(xe);
		if (index >= 0) {
			listChuyenXe.remove(index);
		}else {
			throw new Exception("Chuyến xe không tồn tại");
		}
	}

	public double tongDoanhThuXeNoiThanh() {
		double sum = 0;
		for (ChuyenXe xe : listChuyenXe) {
			if (xe instanceof ChuyenXeNoiThanh) 
				sum += xe.getDoanhThu();
		}
		return sum;
	}

	public double tongDoanhThuXeNgoaiThanh() {
		double sum = 0;
		for (ChuyenXe xe : listChuyenXe) {
			if (xe instanceof ChuyenXeNgoaiThanh) 
				sum += xe.getDoanhThu();
		}
		return sum;
	}

	public double tongDoanhThu() {
		double sum = 0;
		for (ChuyenXe xe : listChuyenXe) {
			sum += xe.getDoanhThu();
		}
		return sum;
	}


	public int findIndexOfChuyenXe(String maChuyen) {
		for (ChuyenXe xe : listChuyenXe)
			if (xe.getMaChuyenXe().equals(maChuyen))
				return listChuyenXe.indexOf(xe);
		return -1;
	}

	public ArrayList<ChuyenXe> danhSachChuyenXeNoiThanh(){
		ArrayList<ChuyenXe> listNoiThanh = new ArrayList<ChuyenXe>();
		for (ChuyenXe xe : listChuyenXe) {
			if (xe instanceof ChuyenXeNoiThanh) listNoiThanh.add(xe);
		}
		return listNoiThanh;
	}

	public ArrayList<ChuyenXe> danhSachChuyenXeNgoaiThanh(){
		ArrayList<ChuyenXe> listNgoaiThanh = new ArrayList<ChuyenXe>();
		for (ChuyenXe xe : listChuyenXe) {
			if (xe instanceof ChuyenXeNgoaiThanh) listNgoaiThanh.add(xe);
		}
		return listNgoaiThanh;
	}

	public void sortListChuyenXeTheoMaXe() {
		Collections.sort(listChuyenXe, new Comparator<ChuyenXe>() {
			@Override
			public int compare(ChuyenXe cx1, ChuyenXe cx2) {
				return cx1.getMaChuyenXe().compareTo(cx2.getMaChuyenXe());
			}	
		});
	}

	public void sortListChuyenXeTheoDoanhThu() {
		Collections.sort(listChuyenXe, new Comparator<ChuyenXe>() {
			@Override
			public int compare(ChuyenXe cx1, ChuyenXe cx2) {
				Double doanhThuXe1 = (Double)cx1.getDoanhThu();
				Double doanhThuXe2 = (Double)cx2.getDoanhThu();
				return doanhThuXe2.compareTo(doanhThuXe1);
			}	
		});
	}
}
