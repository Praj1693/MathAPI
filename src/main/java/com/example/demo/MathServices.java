package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MathServices {
	
	public int[] sortList(int[] numbers) {
		int temp;
		for (int i = 0; i < numbers.length; i++) {
	         for (int j = i + 1; j < numbers.length; j++) {
	            if (numbers[i] > numbers[j]) {
	               temp = numbers[i];
	               numbers[i] = numbers[j];
	               numbers[j] = temp;
	            }
	         }
	    }
		return numbers;
	}
	
	public int[] getMin(int[] numbers, int quantifier){
	      int[] minValues = new int[quantifier];      
//	      Sorting array
//	      Arrays.sort(numbers);   // Using sort method of Arrays  
	      numbers = sortList(numbers);
	      for (int i = 0; i < numbers.length; i++) {  
	          if (i < quantifier) {
	          minValues[i] = numbers[i];
	          }
	      }
	      return minValues;
	}
	
	public int[] getMax(int[] numbers, int quantifier){
	      int[] maxValues = new int[quantifier];
	      numbers = sortList(numbers);
	      
	      for (int i = 0, j = numbers.length - 1; i <=j; i++, j--) {
	    	    int temp1 = numbers[i];
	    	    numbers[i]=numbers[j];
	    	    numbers[j]=temp1;
	      }
	      
	      for (int i = 0; i < numbers.length; i++) {  
	          if (i < quantifier) {
	        	  maxValues[i] = numbers[i];
	          }
	      }
	      return maxValues;
	}
	
	public double getAvg(int[] numbers){
		double total = 0;
		for(int i=0; i<numbers.length; i++){
        	total = total + numbers[i];
        }
		double avg = total/numbers.length;
		return Math.round(avg*100)/100D;
	}
	
	public int getMedian(int[] numbers) {
		int median = 0;
		numbers = sortList(numbers);  
		for (int i=0;i<numbers.length;i++) {
		            
		    if (numbers.length % 2 == 1) {
		        median = numbers[numbers.length/2];
		    } else {
		        median = (numbers[(numbers.length/2)] + numbers[(numbers.length/2)-1])/2;
		    }
		}
		return median;
	}
	
	public long getPercentile(int numbers[], double quantifier) {
		numbers = sortList(numbers);
		int index = (int) Math.ceil(quantifier / 100.0 * numbers.length);
		return numbers[index-1];
	}
	
}
