package com.kata.exceptions;

public class ClientNotFoundException extends RuntimeException{
	    public ClientNotFoundException(Long idClient) {
	    	 super("Client with id : "+idClient+" Not found");
	    }
	}
