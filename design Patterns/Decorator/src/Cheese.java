public class Cheese extends PizzaDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String description() {
        return super.description() + cheesePizza();
    }

    @Override
    public int price() {
        return super.price() + 30;
    }
    public String cheesePizza(){
        if (!(pizza instanceof BasicPizza)) {
            return "and Cheese ";
        }
        return "with Cheese ";
    }
}
