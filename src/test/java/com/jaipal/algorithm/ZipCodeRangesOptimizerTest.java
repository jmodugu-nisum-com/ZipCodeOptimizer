package com.jaipal.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jaipal.algorithm.ZipCodeRangesOptimizer;
import com.jaipal.model.ZipCodeRange;


/**
 * Unit test for ZipCodeRangesOptimizer.
 * @author Jaipal Modugu
 */
public class ZipCodeRangesOptimizerTest {

	private static ZipCodeRangesOptimizer zipCodeRangesOptimizerTest;

	@BeforeClass
	public static void setup(){
		zipCodeRangesOptimizerTest = new ZipCodeRangesOptimizer();
	}

	@AfterClass
	public static void tear(){
		zipCodeRangesOptimizerTest = null;
	}


	@Test
	public void optimizeZipCodeRanges_test1()
	{
		List<ZipCodeRange> zipCodes_1 = new LinkedList<>();
		zipCodes_1.add(new ZipCodeRange(50139, 50199));
		zipCodes_1.add(new ZipCodeRange(50209, 50299));
		zipCodes_1.add(new ZipCodeRange(50651, 50699));
		zipCodes_1.add(new ZipCodeRange(50701, 50799));

		assertEquals(Arrays.asList(
				new ZipCodeRange(50139, 50199), 
				new ZipCodeRange(50209, 50299), 
				new ZipCodeRange(50651, 50699), 
				new ZipCodeRange(50701, 50799)),
				zipCodeRangesOptimizerTest.optimizeZipCodeRanges(zipCodes_1));
	}

	@Test
	public void optimizeZipCodeRanges_test2()
	{
		List<ZipCodeRange> zipCodes_1 = new LinkedList<>();
		zipCodes_1.add(new ZipCodeRange(50139, 50199));
		zipCodes_1.add(new ZipCodeRange(50149, 50299));
		zipCodes_1.add(new ZipCodeRange(50651, 50699));
		zipCodes_1.add(new ZipCodeRange(50701, 50799));

		zipCodeRangesOptimizerTest.optimizeZipCodeRanges(zipCodes_1);
		assertEquals(Arrays.asList(
				new ZipCodeRange(50139, 50299), 
				new ZipCodeRange(50651, 50699), 
				new ZipCodeRange(50701, 50799)),
				zipCodeRangesOptimizerTest.optimizeZipCodeRanges(zipCodes_1));
	}

	@Test
	public void optimizeZipCodeRanges_test3()
	{
		List<ZipCodeRange> zipCodes = new LinkedList<>();
		zipCodes.add(new ZipCodeRange(50139, 50199));
		zipCodes.add(new ZipCodeRange(50149, 50299));
		zipCodes.add(new ZipCodeRange(50651, 50699));//upperBound of this is same as lowerBound of the next
		zipCodes.add(new ZipCodeRange(50699, 50799));

		zipCodeRangesOptimizerTest.optimizeZipCodeRanges(zipCodes);
		assertEquals(Arrays.asList(
				new ZipCodeRange(50139, 50299), 
				new ZipCodeRange(50651, 50799)),
				zipCodeRangesOptimizerTest.optimizeZipCodeRanges(zipCodes));
	}

	@Test
	public void optimizeZipCodeRanges_test4()
	{
		List<ZipCodeRange> zipCodes = new LinkedList<>();
		zipCodes.add(new ZipCodeRange(50139, 50199));
		zipCodes.add(new ZipCodeRange(50149, 50299));
		zipCodes.add(new ZipCodeRange(50651, 50699));//upperBound of this is 1 more than the lowerBound of next
		zipCodes.add(new ZipCodeRange(50700, 50799));

		zipCodeRangesOptimizerTest.optimizeZipCodeRanges(zipCodes);
		assertEquals(Arrays.asList(
				new ZipCodeRange(50139, 50299), 
				new ZipCodeRange(50651, 50799)),
				zipCodeRangesOptimizerTest.optimizeZipCodeRanges(zipCodes));
	}

	@Test
	public void optimizeZipCodeRanges_test5()
	{
		List<ZipCodeRange> zipCodes_5 = new LinkedList<>();
		zipCodes_5.add(new ZipCodeRange(50139, 50199));
		zipCodes_5.add(new ZipCodeRange(50149, 50299));
		zipCodes_5.add(new ZipCodeRange(50239, 50799));//the range of next is in the range of this
		zipCodes_5.add(new ZipCodeRange(50601, 50699));


		assertEquals(Arrays.asList(new ZipCodeRange(50139,50799)),
				zipCodeRangesOptimizerTest.optimizeZipCodeRanges(zipCodes_5));
	}

}
