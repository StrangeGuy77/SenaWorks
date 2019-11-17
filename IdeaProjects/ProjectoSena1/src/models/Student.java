package models;

public class Student {

    private String name, direction, course;
    private int phone, code;

    public Student(String name, String direction, String course, int phone, int code){
        this.name = name;
        this.course = course;
        this.phone = phone;
        this.direction = direction;
        this.code = code;
    }

}
