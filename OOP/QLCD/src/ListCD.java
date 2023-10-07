public class ListCD {
    private CD[] listCD;
    private int count;

    public ListCD() {
        listCD = new CD[10];
        count = 0;
    }

    public ListCD(int size) {
        listCD = new CD[size];
        count = 0;
    }

    public CD find(int maCD) {
        for (int i = 0; i < count; i++)
            if (listCD[i].getMaCD() == maCD)
                return listCD[i];
        return null;
    }

    public void add(CD cd) {
        if (count == listCD.length || find(cd.getMaCD()) != null)
            throw new IllegalStateException("Không thể thêm CD này vào danh sách!");
        listCD[count++] = cd;
    }

    public void getSLCD() {
        System.out.println("Số lượng CD hiện có trong danh sách: " + count);
    }

    public double gia() {
        double gia = 0;
        for (int i = 0; i < count; i++)
            gia += listCD[i].getGiaThanh();
        return gia;
    }

    public void sortGTCD() {
        for (int i = 0; i < count - 1; i++)
            for (int j = i + 1; j < count; j++)
                if (listCD[i].getGiaThanh() < listCD[j].getGiaThanh()) {
                    CD temp = listCD[i];
                    listCD[i] = listCD[j];
                    listCD[j] = temp;
                }
    }

    public void sortTuaCD() {
        for (int i = 0; i < count - 1; i++)
            for (int j = i + 1; j < count; j++)
                if (listCD[i].getTuaCD().compareTo(listCD[j].getTuaCD()) > 0) {
                    CD temp = listCD[i];
                    listCD[i] = listCD[j];
                    listCD[j] = temp;
                }
    }

    public void display() {
        System.out.println("Danh sách CD hiện có:");
        System.out.println(String.format("%-10s %-20s %-20s %-20s", "Mã CD", "Tựa CD", "Số bài hát", "Giá thành"));
        for (int i = 0; i < count; i++)
            System.out.println(listCD[i]);
    }

}
