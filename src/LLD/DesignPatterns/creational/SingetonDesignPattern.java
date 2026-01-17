package LLD.DesignPatterns.creational;

public class SingetonDesignPattern {
    public static void main(String[] args) {
        Student st1 = Student.getInstance();
        Student st2 = Student.getInstance();
        Student st3 = Student.getInstance();
        Student st4 = Student.getInstance();

        System.out.println(st1 == st2);
        System.out.println(st2 == st3);
        System.out.println(st3 == st4);
    }
}


class Student {
    private static Student instance;

    private Student() {
        System.out.println("Student constructor");
    }

    public static Student getInstance() {
        if (instance == null) return instance = new Student();
        else return instance;
    }
}