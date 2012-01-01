package aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class EmailLogger {
	public void log(String zipcode, String address) {
		System.out.println("log before");
		}
	public void logBefore() {
		System.out.println("log before");
		}
	public void logAfter() {
		System.out.println("log after");
		}
	
	
	public void logBeforeA(ProceedingJoinPoint pjp, String FirstName) throws
	Throwable {
	if (!FirstName.contains("Bill"))
	{
		System.out.println("this is not Bill, continue...");
	//Continue the normal execution
	pjp.proceed();
	}
	else
	{
		System.out.println("this is  Bill!, skip action...");
	// do nothing
	}
	}
}
