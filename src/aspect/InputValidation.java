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
//		boolean pass = true;
//		if (firstName.isEmpty())
//		{
//			System.err.println("First Name is null, please try again");
//			pass = false;
//		}
//		if (lastName.isEmpty())
//		{
//			System.err.println("last Name is null, please try again");
//			System.exit(1);
//			pass = false;
//		}
//		if (email.isEmpty())
//		{
//			System.err.println("email is null, please try again");
//			pass = false;
//		}
//		if (street.isEmpty())
//		{
//			System.err.println("street is null, please try again");
//			pass = false;
//		}
//		if (city.isEmpty())
//		{
//			System.err.println("city is null, please try again");
//			pass = false;
//		}
//		if (zip.isEmpty())
//		{
//			System.err.println("zip is null, please try again");
//			pass = false;
//		}
//		if (country.isEmpty())
//		{
//			System.err.println("country is null, please try again");
//			pass = false;
//		}
//		if (phoneKind.isEmpty())
//		{
//			System.err.println("phoneKind is null, please try again");
//			pass = false;
//		}
//		if (phoneNumber.isEmpty())
//		{
//			System.err.println("phoneNumber is null, please try again");
//			pass = false;
//		}
		
		System.out.println("Input data are well structured, inserting to the db.....");
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
