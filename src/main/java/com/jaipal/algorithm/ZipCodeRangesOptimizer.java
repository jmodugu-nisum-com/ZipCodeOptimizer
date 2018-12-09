package com.jaipal.algorithm;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.jaipal.model.ZipCodeRange;

/**
 * ZipCodeRangesOptimizer is a custom class to optimize the collection of zip code ranges
 * @author Jaipal Modugu
 */
public class ZipCodeRangesOptimizer {


	/**
	 * optimizeZipCodeRanges takes collection of zipCodes and return the collection of optimized zipCodes
	 * @param zipCodes
	 * @return zipCodes after optimization
	 */
	public List<ZipCodeRange> optimizeZipCodeRanges(List<ZipCodeRange> zipCodes){

		//Prints input
		System.out.println("input   --> " + zipCodes);

		// # sort the zipCodes list based on the lowerBound
		zipCodes = zipCodes.stream().sorted(Comparator.<ZipCodeRange>comparingInt(ZipCodeRange::getLowerBound)).collect(Collectors.toList());

		for(int i = 0; i < zipCodes.size() - 1; ) {
			// # adding 1 to the difference result because if the lowerBound of the next element is exactly one more than the upperBound of the current element
			// example : input [(90119, 90199), (90200, 90299)] will output [(90119, 90299)]
			Integer difference =  1 +  zipCodes.get(i).getUpperBound() - (zipCodes.get(i+1).getLowerBound());

			if(difference >= 0) {
				Integer optimizedLowerBound =  zipCodes.get(i).getLowerBound();
				Integer optimizesdUpperBound =  zipCodes.get(i).getUpperBound() > zipCodes.get(i+1).getUpperBound() ? zipCodes.get(i).getUpperBound() : zipCodes.get(i+1).getUpperBound();

				ZipCodeRange optimizedZipCodeRange = new ZipCodeRange(optimizedLowerBound, optimizesdUpperBound);

				zipCodes.set(i, optimizedZipCodeRange);
				zipCodes.remove(i+1);
				// start the iteration from the previous index to consider the current changed element. 
				i = i == 0 ?  0 : i-1 ;
			}else
				//jump to next iteration if no changes required for the current iteration
				i++;
		}

		//Prints output	
		System.out.println("output  --> "+zipCodes);

		return zipCodes;
	}

}
