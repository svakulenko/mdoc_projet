package testDriver;

public class MyBean implements IMyBean{

	@Override
	public void sayHello(String first, String last) {
		// TODO Auto-generated method stub
		System.out.println("Hello " + first + " and " + last);
	}

}
