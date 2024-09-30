package exercise1;
//Use Case 1: Observer Pattern (Behavioral)
import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(float price);
}

// Subject class
class StockMarket {
    private List<Observer> observers = new ArrayList<>();
    private float stockPrice;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setStockPrice(float price) {
        this.stockPrice = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
}

// Concrete Observer
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(float price) {
        System.out.println("User " + name + " received stock price update: $" + price);
    }
}

// Usage
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        market.addObserver(user1);
        market.addObserver(user2);

        market.setStockPrice(100.0f); // Notify all observers
    }
}
