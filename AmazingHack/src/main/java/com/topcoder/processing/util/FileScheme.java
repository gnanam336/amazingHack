/**
 * 
 */
package com.topcoder.processing.util;


import java.io.Serializable;

import storm.kafka.StringScheme;
import backtype.storm.tuple.Fields;

@SuppressWarnings("serial")
public class FileScheme extends StringScheme implements Serializable 
{
	/* (non-Javadoc)
	 * @see storm.kafka.StringScheme#getOutputFields()
	 */
	@Override
	public Fields getOutputFields() 
	{
		// TODO Auto-generated method stub
		return new Fields(TopologyConstant.FILES_JSON_STRING);
	}
}