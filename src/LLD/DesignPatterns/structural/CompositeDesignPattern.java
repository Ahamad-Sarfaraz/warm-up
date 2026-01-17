package LLD.DesignPatterns.structural;

import java.util.ArrayList;
import java.util.List;

public class CompositeDesignPattern {
    public static void main(String[] args) {


        // Use case 1 - Smart Home system design using composite pattern
        /*Ac ac = new Ac("AC");
        Light light = new Light("Light");
        Fan fan = new Fan("Fan");

        Room rooms = new Room("Room");
        rooms.addAppliances(ac);
        rooms.addAppliances(light);
        rooms.addAppliances(fan);
        rooms.removeAppliances(fan);

        Floor floors = new Floor("floor");
        floors.addRooms(rooms);


        House houses = new House("House");
        houses.addFloors(floors);


        houses.switchOn();
        houses.switchOff();*/

        // Use case 2 - File system Structure design using composite pattern
        Directory root = new Directory("root");
        File file1 = new File("fil1.txt",10);
        File file2 = new File("fil2.txt",15);

        root.addComponent(file1);
        root.addComponent(file2);

        // Directory 1 and it's content
        Directory directory1 = new Directory("directory1");
        File file3 = new File("image.png",25);
        directory1.addComponent(file3);

        // Directory2 and it's content
        Directory directory2 = new Directory("directory2");
        File file4 = new File("video.mp4",100);
        directory2.addComponent(file4);

        directory1.addComponent(directory2);
        root.addComponent(directory1);


        // Final Structure : root -> file1, file2, directory1 -> file3, directory2 -> file4

        // file1.printFileNameAndSize();

        // file2.printFileNameAndSize();

        // root.printFileNameAndSize();

        // directory1.printFileNameAndSize();

        // directory2.printFileNameAndSize();
    }
}


// Composite Design pattern  -  Manage the heirarchy of the object and treat the individual(leaf) object and
// group of object(composite) uniformly
// what problem does it solve - when you have tree like structure, and you want to treat the individual object and group of object uniformly
// use composite design patter


// File System Use case
//root(directory) -> file1, directory1 -> file2, directory2 -> ...... nested structure

// SmartHome Use case
// root(house) -> floor -> room -> ac, light, cooler -> ....nested

interface Switchable {
    void switchOn();

    void switchOff();
}

class Fan implements Switchable {
    String name;

    public Fan(String name) {
        this.name = name;
    }

    @Override
    public void switchOn() {
        System.out.println("Fan is ON");
    }

    @Override
    public void switchOff() {
        System.out.println("Fan is OFF");
    }
}

class Ac implements Switchable {

    String name;

    public Ac(String name) {
        this.name = name;
    }

    @Override
    public void switchOn() {
        System.out.println("Ac is ON");
    }

    @Override
    public void switchOff() {
        System.out.println("Ac is OFF");
    }
}

class Light implements Switchable {

    String name;

    public Light(String name) {
        this.name = name;
    }

    @Override
    public void switchOn() {
        System.out.println("Light is ON");
    }

    @Override
    public void switchOff() {
        System.out.println("Light is OFF");
    }
}

class Room implements Switchable {

    List<Switchable> switchables = new ArrayList<>();


    String name;

    public Room(String name) {
        this.name = name;
    }

    @Override
    public void switchOn() {
        System.out.println("Room");
        for (Switchable switchableItem : switchables) {
            switchableItem.switchOn();
        }
    }

    @Override
    public void switchOff() {
        System.out.println("Room");
        for (Switchable switchableItem : switchables) {
            switchableItem.switchOff();
        }
    }


    Switchable addAppliances(Switchable switchable) {
        this.switchables.add(switchable);
        return this;
    }

    Switchable removeAppliances(Switchable switchable) {
        this.switchables.remove(switchable);
        return this;
    }


}

class Floor implements Switchable {

    String name;

    public Floor(String name) {
        this.name = name;
    }

    List<Switchable> rooms = new ArrayList<>();

    @Override
    public void switchOn() {
        System.out.println("Floor");
        for (Switchable room : rooms) {
            room.switchOn();
        }
    }

    @Override
    public void switchOff() {
        System.out.println("Floor");
        for (Switchable room : rooms) {
            room.switchOff();
        }
    }

    public Switchable addRooms(Switchable switchable) {
        this.rooms.add(switchable);
        return this;
    }


    public Switchable removeRooms(Switchable switchable) {
        this.rooms.remove(switchable);
        return this;
    }
}

class House implements Switchable {
    String name;

    public House(String name) {
        this.name = name;
    }

    List<Switchable> floors = new ArrayList<>();

    @Override
    public void switchOn() {
        System.out.println("House");
        for (Switchable floor : floors) {
            floor.switchOn();
        }
    }

    @Override
    public void switchOff() {
        System.out.println("House");
        for (Switchable floor : floors) {
            floor.switchOff();
        }
    }

    public Switchable addFloors(Floor floors) {
        this.floors.add(floors);
        return this;
    }

    public Switchable removeFloors(Floor floors) {
        this.floors.remove(floors);
        return this;
    }
}


// File System implementation using composite design pattern

//root -> file1.txt, file2.txt, directory2-> file3.txt, directory3-> fil5.txt

interface FileSystem {
    void printFileNameAndSize();
}


// Leaf
class File implements FileSystem {
    String fileName;
    int fileSize;


    public File(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }


    @Override
    public void printFileNameAndSize() {
        System.out.println(STR."File Name :  \{this.fileName}, Size : \{this.fileSize}");
    }

}


class Directory implements FileSystem {


    List<FileSystem> fileSystemList = new ArrayList<>();

    String directoryName;
//    int directorySize;


    public Directory(String directoryName/* int directorySize*/) {
        this.directoryName = directoryName;
//        this.directorySize = directorySize;
    }


    @Override
    public void printFileNameAndSize() {
        System.out.println(STR."Folder : \{this.directoryName}");
        for(FileSystem fileSystem:fileSystemList){
            fileSystem.printFileNameAndSize();
        }
    }


    public void addComponent(FileSystem component){
        fileSystemList.add(component);
    }

}





