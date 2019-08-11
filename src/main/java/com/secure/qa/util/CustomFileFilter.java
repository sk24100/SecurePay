package com.secure.qa.util;

import java.io.File;
import java.io.FileFilter;

public class CustomFileFilter implements FileFilter {

	 private String[] okFileExtensions = new String[] {".json"};
	 public CustomFileFilter(String[] filesExtensionArray) {
		 this.okFileExtensions = filesExtensionArray;  		 
	 }	 
	@Override
	public boolean accept(File file) {
		for (String extension : okFileExtensions)
	    {
	      if (file.getName().toLowerCase().endsWith(extension))
	      {
	        return true;
	      }
	    }
	    return false;
	}
}
