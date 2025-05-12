package br.edu.iff.ccc.bsi.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiRestControllerAdvice extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(Exception.class)
	ProblemDetail handleDefaultException(Exception e)
	{
		ProblemDetail erroInfo = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404),e.getLocalizedMessage());
		erroInfo.setTitle("Erro Padrão");
		
		return erroInfo;
	}
}
