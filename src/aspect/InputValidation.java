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
		System.out.println("Firstname: " + firstName);
		System.out.println("PhoneKind: " + phoneKind);
		System.out.println("********************************************************");
	}
	public void validateAfterReturning()
	{
		System.out.println("Validate after returning");
	}
	public void validateAfterThrowing()
	{
		System.out.println("Validate after throwing");
	}
}
