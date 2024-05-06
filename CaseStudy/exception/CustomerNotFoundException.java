package CaseStudy.CaseStudy.exception;

import javax.management.RuntimeMBeanException;
public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException() {
        super();
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }


}
