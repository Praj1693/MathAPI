package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MathController {
	
	@Autowired
	MathServices mathServices;
	
	int givenList[] = { 11,10,4, 15, 17, 13, -2, 26 };
	int quantifier = 4;
	int qth_percentile = 25;
	
	@GetMapping("min")
	public int[] min() 
	{
		System.out.println("/min api");
		int minValues[] = mathServices.getMin(givenList, quantifier);
		return minValues;
	}
	
	@GetMapping("max")
	public int[] max() 
	{
		System.out.println("/max api");
		int maxValues[] = mathServices.getMax(givenList, quantifier);
		return maxValues;
	}
	
	@GetMapping("avg")
	public double avg() 
	{
		System.out.println("/avg api");
		double avgValue  = mathServices.getAvg(givenList);
		System.out.println("Average value is: "+ avgValue);
		return avgValue;
	}
	
	@GetMapping("median")
	public double median() 
	{
		System.out.println("/median api");
		double medianValue  = mathServices.getMedian(givenList);
		System.out.println("Median value is: "+ medianValue);
		return medianValue;
	}
	
	@GetMapping("percentile")
	public double percentile() 
	{
		System.out.println("/percentile api");
		long percentileValue  = mathServices.getPercentile(givenList, qth_percentile);
		System.out.println(qth_percentile+ "th percentile of the list is: "+ percentileValue);
		return percentileValue;
	}
}

