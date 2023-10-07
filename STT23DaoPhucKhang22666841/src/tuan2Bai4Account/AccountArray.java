package tuan2Bai4Account;

public class AccountArray {
	private Account[] accounts;
	public int sptThuc = 0;

	public Account[] getAllAccount() {
		return this.accounts;
	}

	public int indexOfAccount(long accountNumber) {
		for (int i =0; i < sptThuc; i++) {
			if (accountNumber == accounts[i].getNumOfAcc()) return i;
		}
		return -1;
	}

	public Account searchAccount(long accountNumber) {
		for (int i =0; i < sptThuc; i++) {
			if (accounts[i].getNumOfAcc() == accountNumber) return accounts[i];
		}
		return null;
	}

	public void delete(long accountNumber) throws Exception {
		int i = indexOfAccount(accountNumber);
		if (i != -1) {
			for (int k = i; k < sptThuc - 1; k++) {
				accounts[k] = accounts[k + 1];
			}
			sptThuc--;
		}else
			throw new Exception("Không tìm thấy tài khoản.");
	}

	public void add(Account acc) throws Exception {
		if (!isExistingAccNumber(acc.getNumOfAcc())){
			if (sptThuc == accounts.length) 
				accounts = tangKichThuoc(accounts, accounts.length*2);
				accounts[sptThuc++] = acc;
		}else 
			throw new Exception("Số tài khoản này đã tồn tại");
	}

	public boolean isExistingAccNumber(long accountNumber) {
		for (int i = 0; i < sptThuc; i++) {
			if (accounts[i].getNumOfAcc() == accountNumber) return true;
		}
		return false;
	}

	public Account[] tangKichThuoc(Account[] arr, int newLength) {
		Account[] newArr = new Account[newLength];
		for (int i = 0; i < sptThuc; i++) 
			newArr[i] = arr[i];
		return newArr;
	}

	public AccountArray() {
		super();
		this.accounts = new Account[1];
		sptThuc = 0;
	}

}
