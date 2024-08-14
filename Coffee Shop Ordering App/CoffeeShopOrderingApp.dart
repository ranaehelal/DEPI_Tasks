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
  Sugar(3),
  CoffeeShots(5),
  Caramel(7),
  Chocolate(10);
  final double price;
  const Addons(this.price);
}
enum CustomerCategory {
  Regular,
  New,
  VIP,
}


Future<void> notifyOrderReady(Order order) async {
  order.status = Status.pending;
  print("Order ${order.date} is ${order.status.name}!");

  await Future.delayed(Duration(seconds: 2));
  order.status = Status.completed;
  print("Order ${order.date} ${order.customer.name} is ${order.status.name}!");
}
class Coffee{

  String name;
  double price ;
  Size size;
  List<Addons> addons=[];

  Coffee( this.name, this.price, this.size, this.addons){
    if (price < 0) {
    throw ArgumentError('Price cannot be negative');
  }}

  Coffee.special(Size size, List<Addons> addons)
      : this("Special Coffee", 30, size, addons);

  double  get TotalPrice{
    late double totalPrice=price;
    for (final addon in addons){
      totalPrice+=addon.price;
    }
    return totalPrice;

  }
}
class Latte extends Coffee{
  Latte(Size size, List<Addons> addons)
      : super("Lattee", 70, size, addons);

  Latte.small() : this(Size.small, []);
  Latte.medium() : this(Size.medium, []);
  Latte.large() : this(Size.Large, []);
}
class Espresso extends Coffee {
  Espresso(Size size, List<Addons> addons)
      : super("Espresso", 50, size, addons);
  Espresso.small() : this(Size.small, []);
  Espresso.medium() : this(Size.medium, []);
  Espresso.large() : this(Size.Large, []);
}
class Cappuccino extends Coffee{
  Cappuccino(Size size, List<Addons> addons)
      : super("Cappuccino", 80, size, addons);
  Cappuccino.small() : this(Size.small, []);
  Cappuccino.medium() : this(Size.medium, []);
  Cappuccino.large() : this(Size.Large, []);
}
class Order {
  late String date;
  Status status;
  late List<Coffee> items=[];
  Customer customer;
  void addItem(Coffee coffee){
    if (coffee == null) {
      throw ArgumentError('Cannot add a null items.');
    }
    items.add(coffee);
  }

  Order( this.status, this.customer) {
    date = DateTime.now().toString();

    customer.numberOfOrders += 1;

    // Update the customer category ---> new number of orders
    customer.category = customer._categorizeCustomer();
  }
  double orderSummary (){
    double sum = 0.0;
    sum = items.fold(0, (sum, item) => sum + item.price);
    return sum;
  }
  void updateOrder({Status? newStatus, List<Coffee>? newItems, List<Coffee>? addItems,}) {
    if (newStatus != null) {
      status = newStatus;
    }
    if (newItems != null) {
      items = newItems; // Replace existing items with new items
    }
    if (addItems != null) {
      items.addAll(addItems); // Add new items to existing items
    }
  }
  void printOrderDetails() {
    try {
    print("Order Date: $date");
    print("Customer: ${customer.name}");
    print("Status: ${status.name}");
    print("Items:");
    for (var item in items) {
      print("  - ${item.name}: \$${item.price}");
      if (item.addons.isNotEmpty) {
        print("    Extra:");
        for (var addon in item.addons) {
          print("      - ${addon.name}: \$${addon.price}");}
      }

    }
    print("Total: \$${orderSummary()}");
    }
    catch (e) {
      print("Error printing order details: $e");
    }
  }
  }
class OrderManagement {
  late List<Order> orders=[];
  void addOrder(Order order){
    if (order == null) {
      throw ArgumentError('Cannot add a null order.');
    }
    orders.add(order);
  }
  List<Order> filterOrders (Status status){
    if (orders.isEmpty) {
      print('No orders available to filter.');
      return [];
    }
    return orders.where((order)=>order.status==status).toList();
  }
  List<Order> sortOrder (){
    if (orders.isEmpty) {
      print('No orders available to sort.');
      return [];
    }
     orders.map((order)=>order.date).toList().sort((a, b)=> DateTime.parse(a).compareTo(DateTime.parse(b)));
    return orders;
  }

}
extension OrderSearch on OrderManagement {
  List<Order> searchOrdersByCustomer(String customerName) {
    return orders.where((order) => order.customer.name.contains(customerName)).toList();
  }

  List<Order> searchOrdersByCoffeeType(String coffeeType) {
    return orders.where((order) => order.items.any((coffee) => coffee.name.contains(coffeeType))).toList();
  }
}
extension OrderAnalytics on OrderManagement {
  Map<String, int> getPopularCoffeeItems() {
    var coffeeCounts = <String, int>{};

    for (var order in orders) {
      for (var coffee in order.items) {
        coffeeCounts[coffee.name] = (coffeeCounts[coffee.name] ?? 0) + 1;
      }
    }

    return coffeeCounts;
  }
}

class Customer {
  String name;
  int numberOfOrders;
  late CustomerCategory category;


  Customer(this.name, this.numberOfOrders){
    category = _categorizeCustomer();  // Initialize
  }

  CustomerCategory _categorizeCustomer() {
    if (numberOfOrders == 0) {
      return CustomerCategory.New;
    } else if (numberOfOrders < 5) {
      return CustomerCategory.Regular;
    } else {
      return CustomerCategory.VIP;
    }
  }
  @override
  String toString() {
    return "Name: $name, Number of Orders: $numberOfOrders, Category: ${category.name}";
  }


}
class CustomerManagement {
  Set<Customer> customers = {};

  void addCustomer(Customer customer) {
    if (customer == null) {
      throw ArgumentError('Cannot add a null customer.');
    }
    customers.add(customer);
  }
 Customer? filterCustomersByName(String name) {
   var customer= customers.where((customer) => customer.name == name).first;
    if (customer == null) {
      print('Customer with name "$name" not found.');
      return null;
    }
   return customer;

 }
  List<Customer> ?filterCustomersByCategory(CustomerCategory category) {
     List<Customer> filteredCustomers=  customers.where((customer) => customer.category == category).toList();
    if (customers.isEmpty) {
      print('Customer with category "$category" not found.');
      return null;
    }
    return filteredCustomers;

  }

  void displayAllCustomers() {
    customers.forEach((customer) {
      print(customer);
    });
  }
}

void main() async {
  try {
    // Create customers
    CustomerManagement customerManagement = CustomerManagement();
    customerManagement.addCustomer(Customer("Ahmed", 0));
    customerManagement.addCustomer(Customer("Rana", 0));
    customerManagement.addCustomer(Customer("Sama", 0));
    customerManagement.addCustomer(Customer("Alice", 5));
    customerManagement.addCustomer(Customer("Bob", 2));
    customerManagement.addCustomer(Customer("Charlie", 10));
    customerManagement.addCustomer(Customer("David", 7));

    // Create orders
    var customerRana = customerManagement.filterCustomersByName("Rana");
    if (customerRana == null) {
      print("Customer Rana not found.");
      return;
    }
    var order1 = Order(Status.pending, customerRana);
    order1.addItem(Latte(Size.small, [Addons.Milk]));
    order1.addItem(Latte(Size.Large, [Addons.Milk, Addons.Sugar]));
    order1.addItem(Espresso.small());

    var customerSama = customerManagement.filterCustomersByName("Sama");
    if (customerSama == null) {
      print("Customer Sama not found.");
      return;
    }
    var order2 = Order(Status.pending, customerSama);
    order2.addItem(Cappuccino(Size.medium, [Addons.Caramel, Addons.Chocolate]));
    order2.addItem(Latte(Size.medium, [Addons.Caramel, Addons.CoffeeShots]));

    var customerRanaAgain = customerManagement.filterCustomersByName("Rana");
    if (customerRanaAgain == null) {
      print("Customer Rana not found.");
      return;
    }
    var order3 = Order(Status.pending, customerRanaAgain);
    order3.addItem(Latte(Size.Large, [Addons.Caramel]));

    // add orders to Order Management
    var orderManagement = OrderManagement();
    orderManagement.addOrder(order1);
    orderManagement.addOrder(order2);
    orderManagement.addOrder(order3);

    // Display all orders before notification
    print("-------------------------------------------- Orders Before Notification --------------------------------------------");
    order1.printOrderDetails();
    order2.printOrderDetails();
    order3.printOrderDetails();

    // Notify orders are ready
    await notifyOrderReady(order1);
    await notifyOrderReady(order2);
    await notifyOrderReady(order3);

    // Display all orders after notification
    print("-------------------------------------------- Orders After Notification --------------------------------------------");
    order1.printOrderDetails();
    order2.printOrderDetails();
    order3.printOrderDetails();

    // Filter orders by status
    var completedOrders = orderManagement.filterOrders(Status.completed);
    print("--------------------------------------------Completed Orders--------------------------------------------");
    for (var order in completedOrders) {
      order.printOrderDetails();
    }

    // Search orders by customer name
    var searchResults = orderManagement.searchOrdersByCustomer("Rana");
    print("----------------------------------------------- Search Orders by Customer: Rana --------------------------------------------");
    for (var order in searchResults) {
      order.printOrderDetails();
    }

    // Get popular coffee items
    var popularItems = orderManagement.getPopularCoffeeItems();
    print("----------------------------------------------- Popular Coffee Items -----------------------------------------------");
    popularItems.forEach((name, count) {
      print("Coffee: $name, Ordered: $count times");
    });

    print("\n--- All Customers ---");
    customerManagement.displayAllCustomers();
  } catch (e) {
    print("An error occurred: $e");
  }
}
