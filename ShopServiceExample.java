package Homework;

public class ShopServiceExample {
    public static void main(String[] args) {
        ShopService obj1=ShopService.getInstance(); //get 메소드를 통해 객체를 얻어온다.
        ShopService obj2=ShopService.getInstance();

        if(obj1==obj2){
            System.out.println("같은 ShopService 객체입니다"); //같은 ShopService 객체입니다.
        }else{
            System.out.println("다른 ShopService 객체입니다");
        }
    }
}
