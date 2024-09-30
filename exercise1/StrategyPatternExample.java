package exercise1;
//Use Case 2: Strategy Pattern (Behavioral)
//Strategy interface
interface PaymentStrategy {
 void pay(double amount);
}

//Concrete Strategy 1
class CreditCardPayment implements PaymentStrategy {
 private String cardNumber;

 public CreditCardPayment(String cardNumber) {
     this.cardNumber = cardNumber;
 }

 @Override
 public void pay(double amount) {
     System.out.println("Paid $" + amount + " using Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4));
 }
}

//Concrete Strategy 2
class PayPalPayment implements PaymentStrategy {
 private String email;

 public PayPalPayment(String email) {
     this.email = email;
 }

 @Override
 public void pay(double amount) {
     System.out.println("Paid $" + amount + " using PayPal account " + email);
 }
}

//Context Class
class PaymentProcessor {
 private PaymentStrategy paymentStrategy;

 public PaymentProcessor(PaymentStrategy paymentStrategy) {
     this.paymentStrategy = paymentStrategy;
 }

 public void executePayment(double amount) {
     paymentStrategy.pay(amount);
 }
}

//Usage
public class StrategyPatternExample {
 public static void main(String[] args) {
     PaymentProcessor processor1 = new PaymentProcessor(new CreditCardPayment("1234567890123456"));
     processor1.executePayment(100.0);

     PaymentProcessor processor2 = new PaymentProcessor(new PayPalPayment("user@example.com"));
     processor2.executePayment(200.0);
 }
}
