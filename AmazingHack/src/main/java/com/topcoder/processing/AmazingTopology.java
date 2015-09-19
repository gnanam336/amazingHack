/**
 * 
 */
package com.topcoder.processing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import storm.kafka.BrokerHosts;
import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.ZkHosts;
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.StormTopology;
import backtype.storm.spout.SchemeAsMultiScheme;
import backtype.storm.topology.TopologyBuilder;

import com.topcoder.processing.beans.StormConfiguration;
import com.topcoder.processing.bolts.InitializerBolt;
import com.topcoder.processing.util.FileScheme;
import com.topcoder.processing.util.TopologyConstant;

public class AmazingTopology 
{

	private final BrokerHosts brokerHosts;
	
	public static final Logger logger = LoggerFactory.getLogger(AmazingTopology.class); 

	/**
	 * 
	 * @param kafkaZookeeper
	 */
	public AmazingTopology(String kafkaZookeeper)
	{
		brokerHosts = new ZkHosts(kafkaZookeeper);
	}
	
	/**
	 * 
	 */
	public static void initializeContext()
	{
		try
		{
			new ClassPathXmlApplicationContext(TopologyConstant.TOPOLOGY_CONTEXT_FILE_NAME);
			logger.info("Application Context Successfully loaded {}", TopologyConstant.TOPOLOGY_CONTEXT_FILE_NAME);
		}
		catch (Exception e)
		{
			logger.error("Failed to load event context xml {}" , TopologyConstant.TOPOLOGY_CONTEXT_FILE_NAME, e);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public StormTopology buildTopology()
	{
		TopologyBuilder builder = new TopologyBuilder();
		
		SpoutConfig kafkaConfig = new SpoutConfig
				(brokerHosts, StormConfiguration.getTopicName(), 
				TopologyConstant.ZK_ROOT_APACHE_KAFKA, StormConfiguration.getConsumerId());
			
		kafkaConfig.scheme = new SchemeAsMultiScheme(new FileScheme());
			
		builder.setSpout("kafkaSpout",	new KafkaSpout(kafkaConfig), StormConfiguration.getKafkaSpoutThreads());
		
		builder.setBolt("initializerBolt", new InitializerBolt(), StormConfiguration.getInitializerBoltThreads()).shuffleGrouping("kafkaSpout");
				
		return builder.createTopology();
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		initializeContext();
		String kafkaZk = StormConfiguration.getKafkaZk();
		logger.info("************** kafkaZk:  {}",  kafkaZk);
		AmazingTopology amazingTopology = new AmazingTopology(kafkaZk);
		Config config = new Config();
		config.put(Config.TOPOLOGY_TRIDENT_BATCH_EMIT_INTERVAL_MILLIS, 1);
	
		StormTopology stormTopology = amazingTopology.buildTopology();
    	config.setNumWorkers(StormConfiguration.getNumOfWorkers());
    	config.setNumAckers(StormConfiguration.getNumofAckers());
        config.setMaxTaskParallelism(StormConfiguration.getMaxTaskParallelism());
		config.setMessageTimeoutSecs(StormConfiguration.getMsgTimeout());
		
		config.setDebug(StormConfiguration.isTopologyDebugMode());
		if ( (args != null && args.length > 0 && args[0].equals("local"))) 
		{
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology(StormConfiguration.getTopologyName(), config, stormTopology);  
            logger.info("Successfully loaded topology {}", StormConfiguration.getTopologyName());
        } 
		else 
		{
			StormSubmitter.submitTopology(StormConfiguration.getTopologyName(), config, stormTopology);
			logger.info("Successfully loaded topology {}", StormConfiguration.getTopologyName());
		}	
	}
}