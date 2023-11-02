package tuan4Bai8CD;

import java.util.Arrays;
import java.util.Comparator;

public class CDList {
	private CD[] listCD;
	public int count;
	
	public CDList() {
		listCD = new CD[2];
		count = 0;
	}

	public int indexOfList(int maCD) {
		for (int i =0; i < count; i++) {
			if (listCD[i].getMaCD() == maCD) return i;
		}
		return -1;
	}
	
	public CD searchCD(int maCD) {
		for (int i =0; i < count; i++) {
			if (listCD[i].getMaCD() == maCD) return listCD[i];   
		}
		return null;  
	}

	public void add(CD cd) throws Exception {
		if (!isExistingCD(cd.getMaCD())){
			if (count == listCD.length) 
				listCD = tangKichThuoc(listCD, listCD.length*2);
			listCD[count++] = cd;
		}else 
			throw new Exception("CD này đã tồn tại");
	}
	
	public void delete(int maCD) throws Exception {
		int i = indexOfList(maCD);
		if (i != -1) {
			for (int k = i; k < count - 1; k++) {
				listCD[k] = listCD[k + 1];
			}
			count--;
		}else
			throw new Exception("Không tìm thấy CD.");
	}
	
	public boolean isExistingCD(int maCD) {
		for (int i = 0; i < count; i++) {
			if (listCD[i].getMaCD() == maCD) return true;
		}
		return false;
	}
	
	public double tongGiaThanh() {
		double tongGia = 0;
		for (int i = 0; i < count; i++) {
			tongGia += listCD[i].getGiaThanh();
		}
		return tongGia;
	}
	
	public int tongSoCD() {
		return this.count;
	}
	
	public void sortListCDGiaThanh() {
		Comparator<CD> quyLuatSapXep = new Comparator<CD>() {
			@Override
			public int compare(CD cd1,CD cd2) {
				if (cd1 == null && cd2 == null) {
                    return 0;
                } else if (cd1 == null) {
                    return -1; 
                } else if (cd2 == null) {
                    return 1; 
                }
				Double giaCd1 = (Double)cd1.getGiaThanh();
				Double giaCd2 = (Double)cd2.getGiaThanh();
				return giaCd2.compareTo(giaCd1);
			}
		};
		Arrays.sort(listCD, quyLuatSapXep);
	}
	
	
	public void sortListCDTua() {
		Comparator<CD> quyLuatSapXep = new Comparator<CD>() {
			@Override
			public int compare(CD cd1,CD cd2) {
				if (cd1 == null && cd2 == null) {
                    return 0;
                } else if (cd1 == null) {
                    return 1; 
                } else if (cd2 == null) {
                    return -1; 
                }
				return cd1.getTuaCD().compareTo(cd2.getTuaCD());
			}
		};
		Arrays.sort(listCD, quyLuatSapXep);
	}
	
	public CD[] tangKichThuoc(CD[] arr, int newLength) {
		CD[] newArr = new CD[newLength];
		System.arraycopy(arr, 0, newArr, 0, count);
		return newArr;
	}

	public CD[] getAll(){
		return listCD;
	}
}
