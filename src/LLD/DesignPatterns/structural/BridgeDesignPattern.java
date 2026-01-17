package LLD.DesignPatterns.structural;

public class BridgeDesignPattern {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedColor());
        redCircle.colour.colour();

        Shape blueCircle = new Circle(new BlueColor());
        blueCircle.colour.colour();

        Shape redRectangle = new Rectangle(new RedColor());
        redRectangle.colour.colour();

        Shape blueRectangle = new Rectangle(new BlueColor());
        blueRectangle.colour.colour();

    }

}




// what problem does it solve ? it decouple the abstraction from it's implementation so both classes
// can change independently without affecting each other

//it also solve class explosion problem by introducing has a relationship - check example for this problem on internet

abstract class  Shape{
    Colour colour;

    Shape(Colour colour){
       this.colour = colour;
    }
}

class Circle extends Shape{

    Circle(Colour colour){
        super(colour);
    }
}


class Rectangle extends Shape{

    Rectangle(Colour colour){
        super(colour);
    }
}




interface Colour{
    void colour();
}


class RedColor implements Colour{

    @Override
    public void colour() {
        System.out.println("Red Color");
    }
}

class BlueColor implements Colour{

    @Override
    public void colour() {
        System.out.println("Blue Color");
    }
}

