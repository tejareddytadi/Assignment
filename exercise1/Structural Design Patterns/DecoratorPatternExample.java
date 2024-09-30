package exercise1;

//Use Case 6: Decorator Pattern (Structural)
//Component Interface
interface Coffee {
 double cost();
 String description();
}

//Concrete Component
class SimpleCoffee implements Coffee {
 @Override
 public double cost() {
     return 2.0; // Basic cost
 }

 @Override
 public String description() {
     return "Simple Coffee";
 }
}

//Decorator Class
abstract class CoffeeDecorator implements Coffee {
 protected Coffee coffee;

 public CoffeeDecorator(Coffee coffee) {
     this.coffee = coffee;
 }

 @Override
 public double cost() {
     return coffee.cost();
 }

 @Override
 public String description() {
     return coffee.description();
 }
}

//Concrete Decorator 1
class MilkDecorator extends CoffeeDecorator {
 public MilkDecorator(Coffee coffee) {
     super(coffee);
 }

 @Override
 public double cost() {
     return coffee.cost() + 0.5;
 }

 @Override
 public String description() {
     return coffee.description() + ", Milk";
 }
}

//Usage
public class DecoratorPatternExample {
 public static void main(String[] args) {
     Coffee simpleCoffee = new SimpleCoffee();
     System.out.println(simpleCoffee.description() + " - $" + simpleCoffee.cost());

     Coffee milkCoffee = new MilkDecorator(simpleCoffee);
     System.out.println(milkCoffee.description() + " - $" + milkCoffee.cost());
 }
}
