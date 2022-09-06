package ch06.sec10;

public class Television {
	static String company="Mycompany";
	static String model="LCD";
	static String info;
	
	static {
		info=company +"-"+model;
	}
	
	static {
		System.out.println("ㅇㅇㅇ");
	}
}
