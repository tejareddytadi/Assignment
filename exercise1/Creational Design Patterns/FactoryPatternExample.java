package exercise1;
//Use Case 4: Factory Pattern (Creational)
//Product Interface
interface Shape {
 void draw();
}

//Concrete Product 1
class Circle implements Shape {
 @Override
 public void draw() {
     System.out.println("Drawing a Circle");
 }
}

//Concrete Product 2
class Square implements Shape {
 @Override
 public void draw() {
     System.out.println("Drawing a Square");
 }
}

//Factory Class
class ShapeFactory {
 public Shape createShape(String type) {
     if (type.equalsIgnoreCase("circle")) {
         return new Circle();
     } else if (type.equalsIgnoreCase("square")) {
         return new Square();
     }
     return null;
 }
}

//Usage
public class FactoryPatternExample {
 public static void main(String[] args) {
     ShapeFactory shapeFactory = new ShapeFactory();

     Shape shape1 = shapeFactory.createShape("circle");
     shape1.draw();

     Shape shape2 = shapeFactory.createShape("square");
     shape2.draw();
 }
}

