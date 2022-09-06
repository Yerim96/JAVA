package Homework;

public class Account {
    private int balance; //필드의 외부 접근 막기

    static final int MIN_BALANCE =0;
    static final int MAX_BALANCE =1000000;

    public int getBalance(){
        return balance;
    }
    public void setBalance(int balance){ //검수 메소드 선언
        if(balance<MIN_BALANCE || balance>MAX_BALANCE){
            return; //그대로 값을 반환

        }else{
            this.balance=balance; //범위안의 수라면 매개변수를 통해 값을 필드에 대입해줌.
        }

        }

}
