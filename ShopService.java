package Homework;

public class ShopService {
    private static ShopService shopService= new ShopService(); //한개의 객체만 사용할것이기 때문에 private

    private ShopService(){

    }

    public static ShopService getInstance(){
        return shopService;   //하나의 객체를 가리킨다.
    }

}
