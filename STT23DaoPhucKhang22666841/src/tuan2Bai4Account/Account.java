package tuan2Bai4Account;

public class Account {
	private long numOfAcc;
	private String name;
	private double balance;
	private static final double RATE = 0.035;
	
	public long getNumOfAcc() {
		return numOfAcc;
	}

	public void setNumOfAcc(long numOfAcc) {
		this.numOfAcc = numOfAcc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Account() {
		super();
	}

	public Account(long numOfAcc, String name, double balance) {
		super();
		this.numOfAcc = numOfAcc;
		this.name = name;
		this.balance = balance;
	}
	
	public Account(long numOfAcc, String name) {
		super();
		this.numOfAcc = numOfAcc;
		this.name = name;
		this.balance = 50000;
	}
	
	public void deposit(double amout) throws Exception {
		if (amout > 0) {
			double mybalce = this.getBalance();
			mybalce += amout;
			this.setBalance(mybalce);
		}else 
			throw new Exception("Số tiền nạp không hợp lệ. Vui lòng thử lại");
	}
	
	public void withdraw(double amout, double withdrawFee) throws Exception {
		if (amout > 0) {
			if (this.getBalance() - (amout + withdrawFee) > 50000) {
				this.balance -= (amout + withdrawFee);
			}else
				throw new Exception("Số dư không đủ. Vui lòng thử lại");
		}else
			throw new Exception("Số tiền rút không hợp lệ. Vui lòng thử lại");
	}
	
	public void maturity() {
		this.balance += this.balance*RATE;
	}
	
	public void transfer(Account destinationAccount, double amount) throws Exception {
		if (amount > 0) {
			if (this.getBalance() - (amount + 10000) > 50000) {
				this.withdraw(amount, 10000);
				destinationAccount.deposit(amount);
			}else 
				throw new Exception("Số dư không đủ. Vui lòng thử lại");
		}else 
			throw new Exception("Số tiền gửi không hợp lệ. Vui lòng thử lại");
	}
	
	
	@Override
	public String toString() {
		String str = String.format("%20d %-20s %20.2f", getNumOfAcc(), getName(), getBalance());
		return str;
	}
	
}
