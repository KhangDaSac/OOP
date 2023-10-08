package tuan3Bai7SinhVien;

import java.util.Arrays;
import java.util.Comparator;


import tuan2Bai4Account.Account;

public class SinhVienList {
	private SinhVien[] listSinhVien;
	public int count;

	public SinhVienList() {
		listSinhVien = new SinhVien[10];
		count = 0;
	}

	public SinhVien[] getAllSinhVien() {
		return listSinhVien;
	}

	public int indexOfSinhVien(long maSinhVien) {
		for (int i =0; i < count; i++) {
			if (maSinhVien == listSinhVien[i].getMaSinhVien()) return i;
		}
		return -1;
	}

	public SinhVien searchSinhVien(long maSinhVien) {
		for (int i =0; i < count; i++) {
			if (maSinhVien == listSinhVien[i].getMaSinhVien()) return listSinhVien[i];
		}
		return null;
	}

	public void delete(long maSinhVien) throws Exception {
		int i = indexOfSinhVien(maSinhVien);
		if (i != -1) {
			for (int k = i; k < count - 1; k++) {
				listSinhVien[k] = listSinhVien[k + 1];
			}
			count--;
		}else
			throw new Exception("Không tìm thấy sinh viên.");
	}

	public void add(SinhVien sv) throws Exception {
		if (!isExistingSinhVien(sv.getMaSinhVien())){
			if (count == listSinhVien.length) 
				listSinhVien = tangKichThuoc(listSinhVien, listSinhVien.length*2);
			listSinhVien[count++] = sv;
		}else 
			throw new Exception("Sinh viên này đã tồn tại");
	}

	public boolean isExistingSinhVien(long maSinhVien) {
		for (int i = 0; i < count; i++) {
			if (listSinhVien[i].getMaSinhVien() == maSinhVien) return true;
		}
		return false;
	}

	public SinhVien[] tangKichThuoc(SinhVien[] arr, int newLength) {
		SinhVien[] newArr = new SinhVien[newLength];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		return newArr;
	}

	public void sortSinhVien() {
		Comparator<SinhVien> quyLuatSapXep = new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien sv1,SinhVien sv2) {
				if (sv1 == null && sv2 == null) {
                    return 0;
                } else if (sv1 == null) {
                    return 1; 
                } else if (sv2 == null) {
                    return -1; 
                }
				return Long.compare(sv1.getMaSinhVien(), sv2.getMaSinhVien());
			}
		};
		Arrays.sort(listSinhVien, quyLuatSapXep);
	}
}