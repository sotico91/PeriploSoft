package com.co.periferiaIT.PeriploSoft.client.exceptions;

import com.co.periferiaIT.PeriploSoft.client.exceptions.impl.ResourceBadRequestException;
import com.co.periferiaIT.PeriploSoft.client.exceptions.impl.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GlobalControllerExceptionHandlerTest {

    @Test
    void testHandleException() {

        GlobalControllerExceptionHandler exceptionHandler = new GlobalControllerExceptionHandler();
        Exception ex = new Exception();

        ResponseEntity<String> response = exceptionHandler.handleException(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal Server Error", response.getBody());
    }

    @Test
    public void testHandleResourceNotFoundException() {

        GlobalControllerExceptionHandler exceptionHandler = new GlobalControllerExceptionHandler();
        ResourceNotFoundException ex = new ResourceNotFoundException("Client not found");

        ResponseEntity<String> response = exceptionHandler.handleResourceNotFoundException(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Client is not found", response.getBody());
    }

    @Test
    public void testHandleResourceBadRequestException() {

        GlobalControllerExceptionHandler exceptionHandler = new GlobalControllerExceptionHandler();
        ResourceBadRequestException ex = new ResourceBadRequestException("Bad request");

        ResponseEntity<String> response = exceptionHandler.handleConversion(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Bad request", response.getBody());
    }

    @Test
    void testHandleNoResourceFoundException() {

        GlobalControllerExceptionHandler exceptionHandler = new GlobalControllerExceptionHandler();
        NoResourceFoundException ex = new NoResourceFoundException(HttpMethod.GET, "/no-existe");

        ResponseEntity<String> response = exceptionHandler.handleException(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Not Found", response.getBody());
    }

    @Test
    void testHandleMethodNotSupportedException() {

        GlobalControllerExceptionHandler exceptionHandler = new GlobalControllerExceptionHandler();
        HttpRequestMethodNotSupportedException ex = new HttpRequestMethodNotSupportedException("POST");

        ResponseEntity<String> response = exceptionHandler.handleException(ex);

        assertEquals(HttpStatus.METHOD_NOT_ALLOWED, response.getStatusCode());
    }

    @Test
    void testHandleTypeMismatchException() {

        GlobalControllerExceptionHandler exceptionHandler = new GlobalControllerExceptionHandler();
        TypeMismatchException ex = new TypeMismatchException("abc", Long.class);

        ResponseEntity<String> response = exceptionHandler.handleException(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
