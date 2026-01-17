package LLD.DesignPatterns.structural;

import java.util.LinkedHashMap;
import java.util.Map;

public class FlyWeightDesignPattern {

    public static void main(String[] args) {

        FlyweightFactory flyweightFactory = new FlyweightFactory();

        CharacterStyle characterStyle1 = flyweightFactory.getCharacterStyleObject("Arial", "Black", 11);
        CharacterStyle characterStyle2 = flyweightFactory.getCharacterStyleObject("Italic", "Red", 13);
        CharacterStyle characterStyle3 = flyweightFactory.getCharacterStyleObject("Times New Roman", "Blue", 15);
        CharacterStyle characterStyle4 = flyweightFactory.getCharacterStyleObject("Italic", "Red", 13);
        CharacterStyle characterStyle5 = flyweightFactory.getCharacterStyleObject("Times New Roman", "Blue", 15);


        Character char1 = new Character(1, "a", characterStyle1);
        Character char2 = new Character(2, "b", characterStyle2);
        Character char3 = new Character(3, "c", characterStyle3);
        Character char4 = new Character(4, "d", characterStyle4);
        Character char5 = new Character(5, "e", characterStyle5);

        char1.display();
        char2.display();
        char3.display();
        char4.display();
        char5.display();
    }
}

// Structural design pattern - best for memory utilization when we deal with huge number of objects creation
// it cached the object creation based on intrinsic (common) state and reuse the objects instead of new object creation
// this pattern is best when there is very huge number of object creation is required
// when objects have intrinsic(common) and extrinsic(unique) state. so the object creation is cached based on intrinsic state


// Interface
interface CharacterStyle {
    void applyStyle();
}


// Concrete class with intrinsic values
class CharacterStyleImpl implements CharacterStyle {

    private String font;
    private String color;
    private int size;

    public CharacterStyleImpl(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    @Override
    public void applyStyle() {
        System.out.println("Style Applied...");
    }
}

// FlyWeight Factory - to get the objects
class FlyweightFactory {

    Map<String, CharacterStyle> map = new LinkedHashMap<>();

    CharacterStyle getCharacterStyleObject(String font, String color, int size) {
        String key = STR."\{font}|\{color}|\{size}";

        if (!map.containsKey(key)) {
            CharacterStyleImpl characterStyle = new CharacterStyleImpl(font, color, size);
            map.put(key, characterStyle);
            System.out.println(STR."created new object: \{characterStyle} for key : \{key}");
            return characterStyle;
        }

        System.out.println(STR."retrived objects from cache, object: \{map.get(key)} for key : \{key}");
        return map.get(key);
    }
}

// Client Class which holds intrinsic and extrinsic values
class Character {
    private int position; // unique values (extrinsic)
    private String value; // unique values (extrinsic)
    private CharacterStyle style; //possibilities to have shared state (intrinsic)

    public Character(int position, String value, CharacterStyle style) {
        this.position = position;
        this.value = value;
        this.style = style;
    }

    public void display() {
        System.out.println(STR."position: \{position},value: \{value},style: \{style}");
        this.style.applyStyle();
    }
}


