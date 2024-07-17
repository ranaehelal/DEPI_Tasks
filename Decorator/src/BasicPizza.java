public class BasicPizza implements Pizza{
    @Override
    public String description() {
        return "Pizza ";
    }

    @Override
    public int price() {
        return 40;
    }


}