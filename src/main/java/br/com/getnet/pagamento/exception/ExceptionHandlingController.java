/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.getnet.pagamento.exception;

import br.com.getnet.pagamento.client.ApiException;
import br.com.getnet.pagamento.client.JSON;
import br.com.getnet.pagamento.util.PagamentoException;
import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import br.com.getnet.pagamento.model.Error;
import br.com.getnet.pagamento.exception.ExceptionResponse;
import javassist.NotFoundException;
import javax.persistence.NoResultException;

@ControllerAdvice
@RestController
public class ExceptionHandlingController extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handlerAllException(Exception e , WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), webRequest.getDescription(true), null);
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ApiException.class)
    public final ResponseEntity<Object> handlerApiException(ApiException e, WebRequest webRequest){
        Error error = JSON.createGson().create().fromJson(e.getResponseBody(),  Error.class);
        String mensagem = null;
        if(error.getDetails().size() > 0 && error.getDetails().get(0).getDescriptionDetail() != null && error.getMessage() == null){
            mensagem = mensagem+error.getDetails().get(0).getDescriptionDetail();
        }else{
            mensagem = error.getMessage();
        }
        
        String status = null;
        if(error.getDetails().get(0).getCodeErro()!= null){
            status = error.getDetails().get(0).getCodeErro();
        }
        
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), mensagem, webRequest.getDescription(false), status);
        
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(PagamentoException.class)
    public final ResponseEntity<Object> handlePagamentoException(PagamentoException e, WebRequest webRequest){
         ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), webRequest.getDescription(true),null);
         return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundError(NotFoundException e, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), webRequest.getDescription(true),null);
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NoResultException.class)
    public final ResponseEntity<Object> handleNoResultError(NoResultException e, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), webRequest.getDescription(true),null);
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    
//    @ExceptionHandler(NoHandlerFoundException.class)
//    public final ResponseEntity<Object> handleNoHandlerFoundError(NoHandlerFoundException e, WebRequest webRequest){
//        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), webRequest.getDescription(true),null);
//        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
//    }
//    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
                ex.getBindingResult().toString(), null);
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }    
}
