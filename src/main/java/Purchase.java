import java.util.Map;

public class Purchase {
    protected String title;
    protected int count;
    protected Purchase[] purchases; //не будем инициализировать массив по умолчанию

    public Purchase(int productsCount) { //а будем делать это с помощью конструктора
        this.purchases = new Purchase[productsCount];
    }

    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }


    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public int totalSum(Map<String, Integer> products) { //изменено название параметра с prices на products во избежание путаницы
        int sum = 0;
        Purchase purchase;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            purchase = purchases[i];
            if (purchase == null) break; //можно сразу прервать цикл и вернуть 0, не делая лишних итераций
            int currentSum = purchase.currentSum(products);
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + currentSum + " руб.");
            sum += currentSum;
        }
        return sum;
    }

    public int currentSum(Map<String, Integer> products) { //добавлен отдельный метод во избежание повтора кода (принцип DRY)
        return this.count * products.get(this.title);
    }

    public void finalPrint(Map<String, Integer> products) { //добавлен отдельный метод вывода итоговой покупки на экран, чтобы не загромождать класс Main
        System.out.println("Итого: " + this.totalSum(products));
    }
}

