package javaStudy;

public class Student {
    String name;
    String number;
    int birthYear;

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "홍길동";
        s1.number = "1234";
        s1.birthYear = 1995;

        Student s2 = new Student();
        s2.name = "홍길동";
        s2.number = "1234";
        s2.birthYear = 1995;

        if(s1.equals(s2)) System.out.println("s1객체와 s2객체는 같다");
        else System.out.println("s1객체와 s2객체는 같지 않다");

        }
    }
