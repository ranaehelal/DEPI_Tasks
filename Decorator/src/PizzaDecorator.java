public abstract class PizzaDecorator implements Pizza {
    Pizza pizza;
    PizzaDecorator (Pizza pizza ){
        this.pizza=pizza;
    }

    public String description(){
        return pizza.description();
    }
    public int price (){
        return pizza.price();
    }

}