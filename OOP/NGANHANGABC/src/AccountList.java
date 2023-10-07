public class AccountList {
    private Account[] acclist;
    private int count;

    public AccountList() {
        this.acclist = new Account[10];
        this.count = 0;
    }

    public AccountList(int n) {
        if (n > 0)
            this.acclist = new Account[n];
        else this.acclist = new Account[10];
        this.count = 0;
    }
    public void addAccount(Account other) {
        if (count == acclist.length) {
            System.out.println("so tk dat toi da");
        }
        else {
            acclist[count++] = other;
            System.out.println("Them thanh cong");
        }
    }

    public Account find(long stk) {
        for (int i = 0; i < count; i++)
            if (acclist[i].getStk() == stk) {
                return acclist[i];
            }
        System.out.println("khong tim thay!");
        return null;
    }

    public void remove(long stk) {
        for (int i = 0; i < count; i++)
            if (acclist[i].getStk() == stk) {
                for (int j = i; j < count; j++) {
                    acclist[j] = acclist[j+1];
                }
                System.out.println("Xoa thanh cong!");
                return;
            }
        System.out.println("khong tim thay!");
    }

    public int getCount() {
        return count;
    }
    public void display() {
        for (int i = 0; i < count; i++)
            System.out.println(acclist[i]);
    }
}
