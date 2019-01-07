package at.technikumwien.dependencyinjection;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@ConvertParameter
public class ParameterConverter {
	@Inject
	@Extended
	Calculator calculator;
	
	@Inject
	Event<String> event; 
	
	@AroundInvoke
	public Object convert(InvocationContext ic) throws Exception {
		String method = ic.getMethod().getName();
		int[] numbersIn = (int[]) ic.getParameters()[0];
		
		if ("sum".equalsIgnoreCase(method) && (numbersIn == null || numbersIn.length != 2)) {
			int[] numbersOut = {calculator.sum(numbersIn), 0};
			ic.setParameters(new Object[] {numbersOut});
			
			event.fire("parameter converted");
		}
		
		return ic.proceed();
	}
}