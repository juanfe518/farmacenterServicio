package com.farmacenter.springbootnewsecurity.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
	 public UserAlreadyExistsException(String message){
		 super(message);
	 }
}
