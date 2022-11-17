import java.util.Map;

public class Basket {
    protected Purchase[] purchases;

    public Basket(int productsCount) {
        this.purchases = new Purchase[productsCount];
    }


    public void addPurchase(Purchase purchase) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = purchase;
                return;
            }
            if (purchases[i].title.equals(purchase.title)) {
                purchases[i].count += purchase.count;
                return;
            }
        }
    }

    public int totalSum(Store store) { // параметр изменен на Store
        int sum = 0;
        Purchase purchase;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            purchase = purchases[i];
            if (purchase == null) break; //можно сразу прервать цикл и вернуть 0, не делая лишних итераций
            int currentSum = purchase.purchaseSum(store);
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + currentSum + " руб.");
            sum += currentSum;
        }
        return sum;
    }


    public void finalPrint(Store store) { //добавлен отдельный метод вывода итоговой покупки на экран, чтобы не загромождать класс Main
        System.out.println("Итого: " + this.totalSum(store));
    }
}
