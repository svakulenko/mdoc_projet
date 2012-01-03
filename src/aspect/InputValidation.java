package aspect;

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
			String phoneNumber)
	{
		if (firstName.isEmpty())
		{
			System.err.println("First Name is null, please try again");
			System.exit(1);
		}
		if (lastName.isEmpty())
		{
			System.err.println("Last Name is null, please try again");
			System.exit(1);
		}
		if (email.isEmpty())
		{
			System.err.println("email is null, please try again");
			System.exit(1);
		}
		
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
