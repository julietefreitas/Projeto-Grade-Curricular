package com.rasmo.escola.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rasmo.escola.exception.MateriaException;
import com.rasmo.escola.model.ErrorResponse;
import com.rasmo.escola.model.ErrorResponse.ErrorResponseBuilder;

@ControllerAdvice
public class ResourceHandler {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){

			Map<String,String> erros = new HashMap<>();
			
			e.getBindingResult().getAllErrors().forEach(erro-> {
				String campo = ((FieldError)erro).getField();
				String mensagem = erro.getDefaultMessage();	
				erros.put(campo, mensagem);
			});
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
	}
	
	@ExceptionHandler(MateriaException.class)
	public ResponseEntity<ErrorResponse> handlerMateriaException(MateriaException e){
			ErrorResponseBuilder erro = ErrorResponse.builder();
			erro.httpStatus(e.getHttpStatus().value());
			erro.mensagem(e.getMessage());
			erro.timeStamp(System.currentTimeMillis());
			return ResponseEntity.status(e.getHttpStatus()).body(erro.build());
	}

}
