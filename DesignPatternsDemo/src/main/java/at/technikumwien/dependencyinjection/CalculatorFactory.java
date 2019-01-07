package at.technikumwien.dependencyinjection;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

@SuppressWarnings("serial")
public class CalculatorFactory {
	@Inject
	@Any
	Instance<Calculator> instance;
	
	@Produces
	public Calculator createInstance() {
		if ("true".equalsIgnoreCase(System.getProperty("extended"))) {
			return instance.select(new AnnotationLiteral<Extended>() {}).get();
		}
		
		return instance.select(new AnnotationLiteral<Simple>() {}).get();
	}
}