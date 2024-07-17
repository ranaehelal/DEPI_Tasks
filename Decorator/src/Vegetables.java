public class Vegetables extends PizzaDecorator{
    Vegetables(Pizza pizza ){
        super(pizza);
    }
    public String description(){
        return super.description()+vegetablePizza();
    }
    public int price(){
        return super.price()+40;
    }
    private String vegetablePizza() {
        if (!(pizza instanceof BasicPizza)) {
            return "and vegetables ";
        }
        return "with vegetables ";
    }


}
