package kz.mun.soap.webservicedemo.soap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

import java.io.Serial;

@SoapFault(faultCode = FaultCode.CLIENT, customFaultCode = "{}")
public class CourseNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 3518170101751491969L;
    public CourseNotFoundException(String message) {
        super(message);
    }
}
