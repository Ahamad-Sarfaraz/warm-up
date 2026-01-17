package LLD.DesignPatterns.creational;

import java.util.List;

public class ProtoTypeDesignPattern {

    public static void main(String[] args) throws CloneNotSupportedException {
        BookShop bs = new BookShop();
        bs.setShopName("Shop A");
        bs.loadBooks();
        System.out.println(bs);

        BookShop bs1 = (BookShop) bs.clone();
        bs1.setShopName("Shop B");
        System.out.println(bs1);

        BookShop bs2 = (BookShop) bs.clone();
        bs2.setShopName("Shop C");
        System.out.println(bs2);

    }
}

// Creational Design pattern
// Used to clone existing object instead of creating new to avoid memory and time consumption
class Book {
    private int id;
    private String BookName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    @Override
    public String toString() {
        return STR."Book{id=\{id}, BookName='\{BookName}'}";
    }
}

class BookShop implements Cloneable {
    private String ShopName;
    private List<Book> books;

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    void loadBooks() {
        for (int i = 0; i < 5; i++) {
            Book bk = new Book();
            bk.setId(i);
            bk.setBookName(STR."Book_\{i}");
            this.getBooks().add(bk);
        }
    }

    @Override
    public String toString() {
        return STR."BookShop{ShopName='\{ShopName}', books=\{books}}";
    }
}