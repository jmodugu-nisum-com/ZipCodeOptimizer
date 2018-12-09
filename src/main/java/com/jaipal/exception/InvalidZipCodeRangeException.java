package com.jaipal.exception;

/**
 * InvalidZipCodeRangeException is a custom Exception to notify the Invalid zip code ranges
 * @author Jaipal Modugu
 */
public class InvalidZipCodeRangeException extends RuntimeException{
	private static final long serialVersionUID = -5642583749894499308L;

	public InvalidZipCodeRangeException() {
		super("lowerBound cannot be greater than upperBound");
	}
}
