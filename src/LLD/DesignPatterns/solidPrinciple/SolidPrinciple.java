package LLD.DesignPatterns.solidPrinciple;

// S - Single Responsibility Principle
// O - Open-Close Principle
// L - Liskov Substitution Principle
// I - Interface seggrataion Principle
// D - Dependency Inversion Principle
public class SolidPrinciple {
}

//1.Single Responsibility Principle, each class should be responsible for single task, example
class SingleResponsibility1 {
    static void task1() {
        System.out.println("Task1");
    }
}

class SingleResponsibility2 {
    static void task2() {
        System.out.println("Task3");
    }
}


//2.Open-Close Principle, a class should be always open to extend but close to modify, example
class Student{
    String studentName(){
        return "student1";
    }
}
//open to extend example
class JuniorStudent extends  Student{
    String getJuniorStudentName(){
        return super.studentName();
    }
}
//close to modify example
class SeniorStudent extends Student{
    @Override
    String studentName() {
        return "modified Student name";
    }
}

//3.Liskov Substitution Principle - if base class A is subtype of sub class B, then  class A should be substituble
//by B and B should be subsstituble by A

//4.Interface seggregation Principle, interface is seggregated for single task, example
interface Vehicle{
    void Drive();
    void Refuel();
    void OpenDoor();
}

class Bike implements Vehicle{
    @Override
    public void Drive() {}
    @Override
    public void Refuel() {}
    // Not applicable bike, but still we're forced to implement it which is not good
    // to solve this we'll create separate interface for each interface method
    @Override
    public void OpenDoor() {}
}

// Now Interface has been seggaragated,
interface DriveInterface {
    void Drive();
}

interface RefuelInterface {
    void Refuel();
}

interface OpenDoorInterface {
    void OpenDoor();
}

class Bike_ implements RefuelInterface {
    // Now only implementing which is needed for Bike
    @Override
    public void Refuel() {
    }
}

class Car implements DriveInterface, RefuelInterface, OpenDoorInterface {
    // Now only implementing which is needed for Car
    @Override
    public void Drive() {}
    @Override
    public void Refuel() {}
    @Override
    public void OpenDoor() {}
}

//5.Dependency Inversion Principle, where we should use abstraction layer(interface or abstract)
//instead of direct concrete implementation to make the code loose coupling, example  -

class Animal {

    // Direct or concrete implementaion, we should avoid this.
    String getAnimal() {
        return AnimalNameImpl.getAnimalName();
    }

    // Now, with abstraction
    String getAnimal_() {
        return AnimalName_.getAnimalName_();
    }
}

abstract class AnimalName_ {
    static String getAnimalName_() {
        return AnimalNameImpl.getAnimalName_();
    }

}

class AnimalNameImpl extends AnimalName_ {
    static String getAnimalName() {
        return "Lion";
    }
    static String getAnimalName_() {
        return "Lion From Abstraction Layer";
    }
}
