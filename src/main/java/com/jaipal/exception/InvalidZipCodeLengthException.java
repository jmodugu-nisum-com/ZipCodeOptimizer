package com.jaipal.exception;

/**
 * InvalidZipCodeRangeException is a custom Exception to notify the Invalid zip code ranges
 * @author Jaipal Modugu
 */
public class InvalidZipCodeLengthException extends RuntimeException{
	private static final long serialVersionUID = -5642583749894499308L;

	public InvalidZipCodeLengthException() {
		super("Length of zipCode is invalid");
	}
}
