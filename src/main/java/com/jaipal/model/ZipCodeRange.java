package com.jaipal.model;

import com.jaipal.exception.InvalidZipCodeLengthException;
import com.jaipal.exception.InvalidZipCodeRangeException;

/**
 * ZipCodeRange is a model to hold the lower and upper bounds of the Zip Codes
 * 
 * @author Jaipal Modugu
 */
public class ZipCodeRange{
	private Integer lowerBound;
	private Integer upperBound;
	
	public static final int ZIP_CODE_LENGHT = 5;

	public ZipCodeRange(Integer lowerBound, Integer upperBound){
		super();
		if(lowerBound > upperBound)
			throw new InvalidZipCodeRangeException();
		int lowerBoundLength = lowerBound.toString().length();
		int upperBoundLength = upperBound.toString().length();
		if(lowerBoundLength < ZIP_CODE_LENGHT || lowerBoundLength > ZIP_CODE_LENGHT || 
				upperBoundLength < ZIP_CODE_LENGHT || upperBoundLength > ZIP_CODE_LENGHT)
			throw new InvalidZipCodeLengthException();	
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public Integer getLowerBound() {
		return lowerBound;
	}
	public Integer getUpperBound() {
		return upperBound;
	}

	@Override
	public String toString() {
		return "("+lowerBound+", "+upperBound+")";

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lowerBound == null) ? 0 : lowerBound.hashCode());
		result = prime * result + ((upperBound == null) ? 0 : upperBound.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZipCodeRange other = (ZipCodeRange) obj;
		if (lowerBound == null) {
			if (other.lowerBound != null)
				return false;
		} else if (!lowerBound.equals(other.lowerBound))
			return false;
		if (upperBound == null) {
			if (other.upperBound != null)
				return false;
		} else if (!upperBound.equals(other.upperBound))
			return false;
		return true;
	}

}
