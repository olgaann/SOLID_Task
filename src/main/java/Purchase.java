import java.util.Map;

public class Purchase {
    protected String title;
    protected int count;


    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public int purchaseSum(Store store) { //добавлен отдельный метод во избежание повтора кода (принцип DRY)
        return this.count * store.getProducts().get(this.title);
    }


}

