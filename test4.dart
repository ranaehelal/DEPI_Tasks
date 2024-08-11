enum Size {
  small(10),
  medium(15),
  Large(20);
  final double price;
  const Size(this.price);
}
enum Status{
  pending,
  completed;
}
enum Addons{
  Milk(15),
  CoffeShoots(5),
  Cramel(7),
  Choclate(10);
  final double price;
  const Addons(this.price);
}
class Coffee{

  String name;
  double price ;
  Size size;
  List<Addons> addons=[];
  late double totalPrice;

  Coffee( this.name, this.price, this.size, this.addons);
  int totalPrice(){
    for (addon in addons){
      totalPrice+=addon.price();
    }
  }
}

class Lattee extends Coffee{
  Lattee(super.name, super.price, super.size, super.addons);
  Lattee.lattee( Size size,List<Addons> addons):this("lattee", 70,size,addons);

}
class Espresso extends Coffee{
  Espresso(super.name, super.price, super.size, super.addons);
  Espresso.espresso( Size size,List<Addons> addons):this("espresso", 50,size,addons);
}

class Order {
  String date;
  Status status;
  late List<Coffee> items=[];
  void addItem(Coffee coffee){
    items.add(coffee);
  }

  Order(this.date,this.status);
  double orderSummary (){
    double sum = 0.0;
    sum = items.fold(0, (sum, item) => sum + item.price);
    return sum;
  }
}
class OrderMangment {
  late List<Order> orders=[];
  void addOrder(Order order){
    orders.add(order);
  }
  void filterOrders (Status status){
    orders.where((order)=>order.status==status);
  }
  void sortOrder (){
    orders.map((order)=>order.date).toList().sort((a, b){
      return DateTime.parse(a).compareTo(DateTime.parse(b));
    });
  }

}
void main(){
  Coffee latte =Coffee.lattee(Size.medium);
  Coffee espresso =Coffee.espresso(Size.small);

}
