package br.com.alura.mudi.controller.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Resource not found")
public class ItemNotFoundException extends RuntimeException {

}
