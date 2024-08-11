public class Chicken extends PizzaDecorator{
    public Chicken(Pizza pizza){
        super(pizza);
    }
    @Override
    public String description(){
        return super.description()+ chickenPizza();
    }
    @Override

    public int price(){
        return super.price()+50;
    }
    public String chickenPizza(){
        if (!(pizza instanceof BasicPizza)) {
            return " and Chicken ";
        }
        return "with Chicken ";
    }



}
