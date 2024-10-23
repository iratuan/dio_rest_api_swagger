package br.com.dio.api.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }

    public BusinessException(String message, Object ...params){
        super(String.format(message, params));
    }

}
