package LLD.DesignPatterns.structural;

public class DecoratorDesignPattern {


    public static void main(String[] args) {
        PlainText plainText = new PlainText();

        FormaterDecorator boldFormater = new UnderlineFormater(new ItalicFormater(new BoldFormater(new PlainText())));
        System.out.println(boldFormater.format());


        FormaterDecorator italicFormatter = new ItalicFormater(new PlainText());
        System.out.println(italicFormatter.format());

    }
}


// Structural Design pattern - it add new functionality/behavior to the object during runtime without modifying the original class
// what problem does it solve -
//              without altering the existing behaviour, it adds new functionality to the object by introducing decorators (class)
//             it solve class explosion problem as well, easier to maintain and extend


// Use case - text format processor

//abstract class - which holds the base functionality
interface Formater{
    String format();
}

// concrete (implementation class )
class PlainText implements Formater{
    @Override
    public String format() {
        return "Plain Text";
    }
}

// Decorator class
abstract class FormaterDecorator implements Formater{
    Formater formater;

    public FormaterDecorator(Formater formater){
        this.formater = formater;
    }

     @Override
    public String format() {
        return formater.format();
    }
}

// Italic Formater
class ItalicFormater extends FormaterDecorator{
    ItalicFormater(Formater Formater){
        super(Formater);
    }

    @Override
    public String format() {
        return STR."Italic formated, \{formater.format()}";
    }
}

// Bold Formater
class BoldFormater extends FormaterDecorator{
    BoldFormater(Formater Formater){
        super(Formater);
    }

    @Override
    public String format() {
        return STR."Bold formated, \{formater.format()}";
    }
}

// Underline Formater
class UnderlineFormater extends FormaterDecorator{

    UnderlineFormater(Formater Formater){
        super(Formater);
    }

    @Override
    public String format() {
        return STR."Underline formated, \{formater.format()}";
    }
}








