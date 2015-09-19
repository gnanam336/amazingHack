/**
 * 
 */
package com.topcoder.processing.bolts;

/**
 * @author agnanas
 *
 */
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topcoder.processing.util.ThreadUtil;
import com.topcoder.processing.util.TopologyConstant;
import com.topcoder.processing.util.TupleHelpers;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

/**
 * @author agnanas
 *
 */
@SuppressWarnings("serial")
public class InitializerBolt extends BaseRichBolt{
	
	private static final Logger logger = LoggerFactory.getLogger(InitializerBolt.class);
	
	private OutputCollector collector;
	
	private int totalCount;

	@SuppressWarnings("rawtypes")
	public void prepare(Map stormConf, TopologyContext context,	OutputCollector collector) {
		this.collector = collector;
		
	}
	
	/* (non-Javadoc)
	 * @see backtype.storm.topology.IComponent#declareOutputFields(backtype.storm.topology.OutputFieldsDeclarer)
	 */
	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) 
	{
		declarer.declare(new Fields(TopologyConstant.FILES_JAVA_OBJECT));	
	}

	@SuppressWarnings("unchecked")
	public void execute(Tuple tuple) {
		
		ObjectMapper mapper = new ObjectMapper();
		String fileJsonStr = null;
		Map<String,Object> files = null;
		boolean exists = false;
		try 
		{
			fileJsonStr = tuple.getStringByField(TopologyConstant.FILES_JSON_STRING);
			System.out.println("String-->" +fileJsonStr);
//			if (fileJsonStr != null && !fileJsonStr.isEmpty()) 
//			{
//				files = mapper.readValue(fileJsonStr,Map.class);
//				System.out.println("**********************************************************************************************");
//				System.out.println("Message Posted to topic-->" +files);
//				System.out.println("**********************************************************************************************");
//			}
		} 
		catch (Exception e) 
		{
			logger.warn("Ignore the event, Json conversion issue {}", fileJsonStr, e);
		}
		this.collector.ack(tuple);
		totalCount++;
		
//		String message = null;
//		
//		message = tuple.getString(0);
//		System.out.println("**********************************************************************************************");
//		System.out.println("Message Posted to topic-->" +message);
//		System.out.println("**********************************************************************************************");
//		this.collector.ack(tuple);
		
//		if (TupleHelpers.isTickTuple(tuple)) {	
//			 logger.info("transformer messages received :"+totalCount+" time:"+ThreadUtil.getCpuTime(Thread.currentThread().getId()));
//		}
//		
//		else
//		 {
//			ObjectMapper mapper = new ObjectMapper();
//			String fileJsonStr = null;
//			Map<String,Object> files = null;
//			boolean exists = false;
//			try 
//			{
//				fileJsonStr = tuple.getStringByField(TopologyConstant.FILES_JSON_STRING);
//				if (fileJsonStr != null && !fileJsonStr.isEmpty()) 
//				{
//					files = mapper.readValue(fileJsonStr,Map.class);
//					exists = checkInMongo(files);
//					if (!exists)
//					{
//						logger.debug("EventTransformerBolt::execute::Output Events Object {}", files);
//						this.collector.emit(tuple, new Values(files));
//					}
//				}
//			} 
//			catch (Exception e) 
//			{
//				logger.warn("Ignore the event, Json conversion issue {}", fileJsonStr, e);
//			}
//			this.collector.ack(tuple);
//			totalCount++;
//		 }
		
	}
	
	@SuppressWarnings("unchecked")
	private boolean checkInMongo(Map<String, Object> object)
	{
		boolean ignoreEvents = false;
		List<Map<String,Object>> file = ((List<Map<String,Object>>)object.get(TopologyConstant.FILES_OBJECT));			
		if (file != null && !file.isEmpty()) 
		{
			Map<String, Object> f = file.get(0);
			if (f.get(TopologyConstant.ID_FIELD) != null)
			{
				String eventType = (String)f.get(TopologyConstant.TYPE);
				if (TopologyConstant.FILTER_DOM_EVENTS.equalsIgnoreCase(eventType))
				{
					ignoreEvents = true;
					logger.info("Ignoring the dom event {}", object);
				}
			}
		}
		return ignoreEvents;
	}

}

