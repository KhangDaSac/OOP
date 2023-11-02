package tuan3Bai6HangThucPham;

import tuan2Bai4Account.Account;

public class DanhSachHangThucPham {
	private HangThucPham[] hangThucPhamList;
	public int sptThuc = 0;

	public HangThucPham[] getAllThucPham() {
		return this.hangThucPhamList;
	}

	public int indexOfList(String maHang) {
		for (int i =0; i < sptThuc; i++) {
			if (hangThucPhamList[i].getMaHang().equals(maHang)) return i;
		}
		return -1;
	}

	public HangThucPham searchHangThucPham(String maHang) {
		for (int i =0; i < sptThuc; i++) {
			if (hangThucPhamList[i].getMaHang().equals(maHang)) return hangThucPhamList[i];   
		}
		return null;  
	}

	public void delete(String maHang) throws Exception {
		int i = indexOfList(maHang);
		System.out.println(maHang);
		if (i != -1) {
			for (int k = i; k < sptThuc - 1; k++) {
				hangThucPhamList[k] = hangThucPhamList[k + 1];
			}
			sptThuc--;
		}else
			throw new Exception("Không tìm thấy thực phẩm.");
	}

	public void add(HangThucPham thucPham) throws Exception {
		if (!isExistingHangThucPham(thucPham.getMaHang())){
			if (sptThuc == hangThucPhamList.length) 
				hangThucPhamList = tangKichThuoc(hangThucPhamList, hangThucPhamList.length*2);
			hangThucPhamList[sptThuc++] = thucPham;
		}else 
			throw new Exception("Mặt hàng này đã tồn tại");
	}

	public boolean isExistingHangThucPham(String maHang) {
		for (int i = 0; i < sptThuc; i++) {
			if (hangThucPhamList[i].getMaHang() == maHang) return true;
		}
		return false;
	}
	
	public DanhSachHangThucPham danhSachThucPhamHetHan() throws Exception {
		DanhSachHangThucPham thucPhamHetHan = new DanhSachHangThucPham();
		for (int i = 0; i < this.sptThuc; i++) {
			if (hangThucPhamList[i].daHetHan()) {
				thucPhamHetHan.add(hangThucPhamList[i]);
			}
		}
		return thucPhamHetHan;
	}

	public HangThucPham[] tangKichThuoc(HangThucPham[] arr, int newLength) {
		HangThucPham[] newArr = new HangThucPham[newLength];
		for (int i = 0; i < sptThuc; i++) 
			newArr[i] = arr[i];
		return newArr;
	}

	public DanhSachHangThucPham() {
		super();
		hangThucPhamList = new HangThucPham[1];
		this.sptThuc = 0;
	}

		
}
