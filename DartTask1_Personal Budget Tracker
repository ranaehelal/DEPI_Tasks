class Transaction {
  late double amount ;
  late String description ;
  late String type ;//(: "income" or "expense")
  Transaction(this.amount, this.description, this.type);

}

class Budget {
  List<Transaction> income = [];
  List<Transaction> expenses=[];
  void addTransaction (Transaction transaction ){
    if (transaction.type == "income"){
      income.add(transaction);
    }
    else{
      expenses.add(transaction);
    }

  }

}

class Calculator {
  final Budget budget;
  late List<Transaction> income = budget.income;
  late List<Transaction> expenses = budget.expenses;

  Calculator(this.budget);

  double totalIncome () {
    double sum = 0.0;
    sum = income.map((transaction) => transaction.amount).reduce((a, b) => a + b);
    //convert income to list of transaction amout first and make reduce on it
    //cuz i cant make reduce on list of transactions and i cant make reduce on list of doubles

    return sum;
  }
  double totalExpenses (){
    double sum = 0.0;
    //init value then fold based on the function
    //old value (prev) ,the next value
    sum = expenses.fold(0, (sum, transaction) => sum + transaction.amount);
    return sum;
  }
  double balance (){
    return totalIncome() - totalExpenses();
  }
}

class SummaryPrinter {
  void displaySummary(Calculator calculator) {
    print("Income: ${calculator.totalIncome()}");
    print("Expenses: ${calculator.totalExpenses()}");
    print("Balance: ${calculator.balance()}");
  }
}

void main (){
  Budget budget = Budget();
  budget.addTransaction(Transaction(1000, "Salary", "income"));
  budget.addTransaction(Transaction(1500, "Freelance Work", "income"));
  budget.addTransaction(Transaction(200, "Groceries", "expense"));
  budget.addTransaction(Transaction(150, "Utilities", "expense"));
  budget.addTransaction(Transaction(300, "Rent", "expense"));
  budget.addTransaction(Transaction(50, "Entertainment", "expense"));

  Calculator calculator = Calculator(budget);
  SummaryPrinter summaryPrinter = SummaryPrinter();

  summaryPrinter.displaySummary(calculator);

}
