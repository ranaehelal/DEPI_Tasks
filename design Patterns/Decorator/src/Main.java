public class Main {
    public static void main(String[] args) {
        Pizza pizza1 = new Vegetables(new Chicken(new BasicPizza()));
        System.out.println(pizza1.description() + "cost: " + pizza1.price());

        Pizza pizza2 = new Cheese(new BasicPizza());
        System.out.println(pizza2.description() + "cost: " + pizza2.price());

        Pizza pizza3 = new Vegetables(new Chicken(new BasicPizza()));
        System.out.println(pizza3.description() + "cost: " + pizza3.price());

        Pizza pizza4 = new Vegetables(new Cheese(new BasicPizza()));
        System.out.println(pizza4.description() + "cost: " + pizza4.price());

        Pizza pizza5 = new Cheese(new Vegetables(new Chicken(new BasicPizza())));
        System.out.println(pizza5.description() + "cost: " + pizza5.price());


    }}

