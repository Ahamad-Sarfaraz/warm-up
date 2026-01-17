package LLD.DesignPatterns.structural;

import java.util.Objects;

public class ProxyDesignPattern {
    public static void main(String[] args) {

        ProxyImage proxyImage = new ProxyImage("Logo.png");
        proxyImage.display();


        proxyImage.display();

    }
}

// structural design patterns - works as middleman to manage the access of a real object, useful for caching, logging and security
// Use case - image caching example


interface Image{
    void display();
}


class RealImage implements  Image{

    String filename;

    public RealImage(String filename){
        this.filename = filename;
    }


    @Override
    public void display() {
        System.out.println("Real image display called..");
    }
}


class ProxyImage implements Image{

    String filename;
    RealImage realImage;

    public ProxyImage(String filename){
        this.filename = filename;
    }

    @Override
    public void display() {
        System.out.println("Proxy display method..");
        if(Objects.isNull(realImage)){
            System.out.println("Image cached..");
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
