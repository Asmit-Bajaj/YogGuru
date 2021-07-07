package com.yogguru.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FileUtilityImpl implements FileUtility{

	//get unique file name
	public String getUniqueName(String prefix) {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		return prefix+timeStamp;
	}

	//get the extension
	public String getExtension(String fileName) {
		return fileName.split("/")[1];
	}
	
}
