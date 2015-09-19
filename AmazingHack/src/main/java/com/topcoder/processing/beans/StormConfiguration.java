/**
 * 
 */
package com.topcoder.processing.beans;

public final class StormConfiguration 
{

	private static int connMaxRetry;
	
	private static int connRetryInterval;

	private static int defaultParallelism;

	private static String kafkaZk;

	private static int maxTaskParallelism;

	private static int msgTimeout;

	private static int numofAckers;
	
	private static int numOfWorkers;

	private static int kafkaSpoutThreads;

    private static String consumerId;
	
	private static int initializerBoltThreads;

	private static String topicName;

	private static boolean topologyDebugMode;

	private static String topologyName;
	
	private static String mongoHosts;
	
	private static int mongoConnections;
	
	private static String mongoWriteConcern;
	
	private static String mongoDBName;

	/**
	 * @return the mongoHosts
	 */
	public static String getMongoHosts() {
		return mongoHosts;
	}

	/**
	 * @param mongoHosts the mongoHosts to set
	 */
	public static void setMongoHosts(String mongoHosts) {
		StormConfiguration.mongoHosts = mongoHosts;
	}

	/**
	 * @return the mongoConnections
	 */
	public static int getMongoConnections() {
		return mongoConnections;
	}

	/**
	 * @param mongoConnections the mongoConnections to set
	 */
	public static void setMongoConnections(int mongoConnections) {
		StormConfiguration.mongoConnections = mongoConnections;
	}

	/**
	 * @return the mongoWriteConcern
	 */
	public static String getMongoWriteConcern() {
		return mongoWriteConcern;
	}

	/**
	 * @param mongoWriteConcern the mongoWriteConcern to set
	 */
	public static void setMongoWriteConcern(String mongoWriteConcern) {
		StormConfiguration.mongoWriteConcern = mongoWriteConcern;
	}

	/**
	 * @return the connMaxRetry
	 */
	public static int getConnMaxRetry() {
		return connMaxRetry;
	}

	/**
	 * @return the connRetryInterval
	 */
	public static int getConnRetryInterval() {
		return connRetryInterval;
	}

	/**
	 * @return the defaultParallelism
	 */
	public static int getDefaultParallelism() {
		return defaultParallelism;
	}


	/**
	 * @return the kafkaZk
	 */
	public static String getKafkaZk() {
		return kafkaZk;
	}

	/**
	 * @return the maxTaskParallelism
	 */
	public static int getMaxTaskParallelism() {
		return maxTaskParallelism;
	}


	/**
	 * @return the msgTimeout
	 */
	public static int getMsgTimeout() {
		return msgTimeout;
	}

	/**
	 * @return the numofAckers
	 */
	public static int getNumofAckers() {
		return numofAckers;
	}

	/**
	 * @return the numOfWorkers
	 */
	public static int getNumOfWorkers() {
		return numOfWorkers;
	}

	/**
	 * @return the topologyName
	 */
	public static String getTopologyName() {
		return topologyName;
	}

	/**
	 * @return the topologyDebugMode
	 */
	public static boolean isTopologyDebugMode() {
		return topologyDebugMode;
	}

	/**
	 * @param connMaxRetry the connMaxRetry to set
	 */
	public static void setConnMaxRetry(int connMaxRetry) {
		StormConfiguration.connMaxRetry = connMaxRetry;
	}

	/**
	 * @param connRetryInterval the connRetryInterval to set
	 */
	public static void setConnRetryInterval(int connRetryInterval) {
		StormConfiguration.connRetryInterval = connRetryInterval;
	}

	/**
	 * @param defaultParallelism the defaultParallelism to set
	 */
	public static void setDefaultParallelism(int defaultParallelism) {
		StormConfiguration.defaultParallelism = defaultParallelism;
	}


	/**
	 * @param kafkaZk the kafkaZk to set
	 */
	public static void setKafkaZk(String kafkaZk) {
		StormConfiguration.kafkaZk = kafkaZk;
	}

	/**
	 * @param maxTaskParallelism the maxTaskParallelism to set
	 */
	public static void setMaxTaskParallelism(int maxTaskParallelism) {
		StormConfiguration.maxTaskParallelism = maxTaskParallelism;
	}

	/**
	 * @param msgTimeout the msgTimeout to set
	 */
	public static void setMsgTimeout(int msgTimeout) {
		StormConfiguration.msgTimeout = msgTimeout;
	}

	/**
	 * @param numofAckers the numofAckers to set
	 */
	public static void setNumofAckers(int numofAckers) {
		StormConfiguration.numofAckers = numofAckers;
	}

	/**
	 * @param numOfWorkers the numOfWorkers to set
	 */
	public static void setNumOfWorkers(int numOfWorkers) {
		StormConfiguration.numOfWorkers = numOfWorkers;
	}

	/**
	 * @param topologyDebugMode the topologyDebugMode to set
	 */
	public static void setTopologyDebugMode(boolean topologyDebugMode) {
		StormConfiguration.topologyDebugMode = topologyDebugMode;
	}

	/**
	 * @param topologyName the topologyName to set
	 */
	public static void setTopologyName(String topologyName) {
		StormConfiguration.topologyName = topologyName;
	}

	private StormConfiguration() 
	{

	}

	/**
	 * @return the mongoDBName
	 */
	public static String getMongoDBName() {
		return mongoDBName;
	}

	public static int getKafkaSpoutThreads() {
		return kafkaSpoutThreads;
	}

	public static void setKafkaSpoutThreads(int kafkaSpoutThreads) {
		StormConfiguration.kafkaSpoutThreads = kafkaSpoutThreads;
	}

	public static String getConsumerId() {
		return consumerId;
	}

	public static void setConsumerId(String consumerId) {
		StormConfiguration.consumerId = consumerId;
	}

	public static int getInitializerBoltThreads() {
		return initializerBoltThreads;
	}

	public static void setInitializerBoltThreads(int initializerBoltThreads) {
		StormConfiguration.initializerBoltThreads = initializerBoltThreads;
	}

	public static String getTopicName() {
		return topicName;
	}

	public static void setTopicName(String topicName) {
		StormConfiguration.topicName = topicName;
	}

	/**
	 * @param mongoDBName the mongoDBName to set
	 */
	public static void setMongoDBName(String mongoDBName) {
		StormConfiguration.mongoDBName = mongoDBName;
	}	
}