package com.paul.LifeisFun.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InterestNotFound extends RuntimeException {

	public InterestNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InterestNotFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InterestNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InterestNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
