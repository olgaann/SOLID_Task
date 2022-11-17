import java.util.Map;

public class Purchase {
    protected String title;
    protected int count;


    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public int purchaseSum(Map<String, Integer> products) { //добавлен отдельный метод во избежание повтора кода (принцип DRY)
        return this.count * products.get(this.title);
    }


}

