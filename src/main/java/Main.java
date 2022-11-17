import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Store store = new Store(); //Cоздаем экземляр магазина. Был создан отдельный класс Store, на случай, если понадобится несколько разных ассортиментов

        store.addProductAndPrice("Хлеб", 56);
        store.addProductAndPrice("Масло", 153);
        store.addProductAndPrice("Колбаса", 211);
        store.addProductAndPrice("Пирожок", 45);

        Map<String, Integer> products = store.getProducts(); // Ассортимент магазина записываем в переменную products. Тип переменной изменен с HashMap на Map;
        int productsCount = products.size(); //определяем размер ассортимента, чтобы впоследствии отталкиваться от него при создании экземпляра Basket

        store.printAssortment(); //вывод ассортимента выведен в соотвествующий класс - Store (принцип единственной ответственности)


        System.out.println("Введите два слова: название товара и количество. Или end");
        Scanner scanner = new Scanner(System.in);

        //Чтобы класс Purchase не был перегружен неподходящими ему по смыслу функциями, добавим отдельный класс Basket (принцип единственной ответственности)
        Basket basket = new Basket(productsCount); //cоздаем экземпляр Basket в соответствии с размером ассортимента

        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            basket.addPurchase(new Purchase(product, count));
        }

        basket.finalPrint(store); //метод вывода итоговой корзины создан в классе Basket (принцип единственной ответственности)
    }
}
