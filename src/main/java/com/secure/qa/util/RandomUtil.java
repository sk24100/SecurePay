package com.secure.qa.util;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.secure.qa.base.TestBase;

public class RandomUtil extends TestBase{

	public int getRandomNumber(int min, int max) {
		if(min==max) {
			return min;
		}
		
		Random r=new Random();
		return r.nextInt((max-min)+1)+min;
	}
	
	
	public String getRandomReason() {
		String enquiry[]= {"Support","Accounts"};
		return (enquiry[new Random().nextInt(enquiry.length)]);
	}
	
	public String getRandomString(int min, int max) {
		
		return RandomStringUtils.randomAlphabetic(min, max);
	}
	
	public String getRandomEmail() {
		
		return RandomStringUtils.random(10, true, true);
	}
	
	public String getRandomInteger() {
		return RandomStringUtils.randomNumeric(10);
	}

}
