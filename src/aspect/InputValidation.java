package aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class InputValidation
{
	public void validateBefore(String firstName, 
			String lastName,
			String email,
			String street,
			String city,
			String zip,
			String country,
			String phoneKind,
			String phoneNumber) throws Throwable
	{	
		System.out.println("First Name:" + firstName);
		System.out.println("Last Name:" + lastName);
		System.out.println("Phone: " + phoneNumber);
	}
	public void validateAfterReturning()
	{
		System.out.println("Well organized input datas");
	}
	public void validateAfterThrowing()
	{
		System.out.println("Exception...");
	}
}
