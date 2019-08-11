package com.secure.qa.util;

import com.secure.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static String REPORTS_FOLDER="src/test/resources/Report/";
	private static String EXECUTION_TIME_STAMP = null;
	public static final String CUCUMBER_HTML_REPORTS_FOLDER = "test-output/";
	
	
	static {
		EXECUTION_TIME_STAMP=TimeUtil.getCurrentDate("yyyy-MM-dd-HH-mm-ss-SSS");
	}

	public static String getExecutionTimeStamp() {
		return EXECUTION_TIME_STAMP;
	}
}
