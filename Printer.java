package Homework;

public class Printer {
    //클래스에는 필드, 생성자, 메서드가 들어감.
    //클래스에 필드가 반드시 있어야하는것은 아니다.

    //메서드 선언 -> 반환값 메소드명(매개변수){}

    //메서드 오버로딩
    static void println(int x){
     int value= x;
     System.out.println(value);
    }

    static void println(boolean x){
        boolean value = x;
        System.out.println(value);
    }

    static void println(double x){
        double value = x;
        System.out.println(value);
    }

    static void println(String x){
        String value = x;
        System.out.println(value);
    }
}
