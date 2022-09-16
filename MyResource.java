package ch11.sec04;

public class MyResource implements AutoCloseable {//자동으로 닫히는 리소스로 구현하고싶다.
	
	private String name;
	
	public MyResource(String name) {
		this.name = name;
		System.out.println("myresource"+  name +"열기");
	}
	
	public String read1() {
		System.out.println("myresource"+  name +"읽기");
		return "100"; //리소스가 100가지고있으니 리턴 100
	
	}
	
	public String read2() {
		System.out.println("myresource"+  name +"읽기");
		return "abc"; //리소스가 100가지고있으니 리턴 100
	
	}
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("myresource"+ name+"닫기");
	}
}
