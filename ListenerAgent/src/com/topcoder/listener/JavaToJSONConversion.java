package com.topcoder.listener;

import java.util.HashMap;
import java.util.Map;

public class JavaToJSONConversion {
	
	private String id;
	private Map<String, String>attributes = new HashMap<String, String>();
	
	public JavaToJSONConversion(String id, String attribute1, String attribute2)
	{
		this.id = id;
		this.attributes.put(attribute1, attribute2);
	}
	
	
}
