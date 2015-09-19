package com.topcoder.processing.util;

public interface TopologyConstant 
{

	public static final String TOPOLOGY_CONTEXT_FILE_NAME="/conf/spring/context.xml";
	
	public static final String FILES_JSON_STRING="filesJsonStr";
	
	public static final String EVENT_JSON_STRING="eventJsonStr";
	
	public static final String EVENT_JAVA_OBJECT="eventJavaObj";
	
	public static final String EVENT_JAVA_LIST_OBJECT="eventJavaListObj";
	
	public static final String FILES_JAVA_OBJECT="filesJavaObj";
	
	public static final String EVENT_SENSOR_OBJECT="eventSensorObj";	
	
	public static final String METRICS_JSON_STRING="metricsJsonStr";
	
	public static final String METRIC_JSON_STRING="metricJsonStr";
	
	public static final String METRICS_JAVA_OBJECT="metricsJavaObj";
	
	public static final String METRIC_JAVA_OBJECT="metricJavaObj";
	
	public static final String METRIC_JAVA_LIST_OBJECT="metricJavaListObj";
	
	public static final String WRAPPED_RESOLVED_SENSOR_JAVA_OBJECT="wrappedResolvedSensorObj";
	
	public static final String SENSOR_EVENT_UPDATE_MAP_LIST="sensorEventUpdateMapList";

	public static final String WRAPPED_RESOLVED_METRICS_JAVA_OBJECT="wrappedResolvedMetricsObj";
	
	public static final String WRAPPED_RESOLVED_METRICS_JAVA_LIST_OBJECT="wrappedResolvedMetricsJavaListObj";

	public static final String ZK_ROOT_APACHE_KAFKA="/kafkastorm";
	
	public static final String CONF_FILE_NAME="/conf/storm.properties";
	
	public static final String TOPIC_NAME_EVENT="events";
	
	public static final String OBJ_CAT_METRICS = "METRICS";
	
	public static final String OBJ_CAT_EVENTS = "EVENTS";
	
	public static final String FILES_OBJECT = "files";
	
	public static final String OBJ_CAT_SENSORS = "SENSORS";
	
	public static final String OBJECT_JSON_STRING="objectsJsonStr";
	
	public static final String MONGO_EVENTS_COLLECTION = "events";
	
	public static final String MONGO_OBJECTS_COLLECTION = "objects";
	
	public static final String INVALID_MONGO_EVENTS_COLLECTION = "invalidevents";

	public static final String VALID_EVENTS_INDEX = "events";
	
	public static final String INVALID_EVENTS_INDEX = "invalidevents";

	public static final String VALID_ES_EVENTS_INDEX = "events";
	
	public static final String INVALID_ES_EVENTS_INDEX = "invalidevents";

	public static final String ACTION = "action";
	
	public static final String DATA_OBJECTS = "dataObjects";

	public static final String ES_OBJECTS_INDEX = "objects";
	
	public static final String _ID_FIELD = "_id";
	
	public static final String LIFE_STATE = "lifeState";
	
	public static final String COLLECTION = "COLLECTION";
	
	public static final String OPERATION = "OPERATION";
	
	public static final String OPERATION_INSERT = "INSERT";
	
	public static final String OPERATION_OBJECT_METRICS_UPDATE = "OBJECTS_METRICS_UPDATE";
	
	public static final String OPERATION_SENSOR_EVENT_PVT_UPDATE = "SENSOR_EVENT_PVT_UPDATE";
	
	public static final String OPERATION_DELETE = "DELETE";
	
	public static final String MONGO_JSON_STR = "MONGO_JSON_STR";
	
	public static final String MONGO_JSON_MAP = "MONGO_JSON_MAP";
	
	public static final String TYPE = "type";
	
   	public static final String OBSVD_DT = "obsvdDt";
	
	public static final String OCRD_DT = "ocrdDt";
	
	public static final String RECVD_DT = "recvdDt";

	public static final String KEY = "k";

	public static final String VALUE = "v";

	public static final String APP_FAMILY_OBJECT = "af";	
	
	public static final String PVT = "pvt";
	
	public static final String PVT_DT = "pvtDt";

	public static final String FIRST_EVENT_DT = "firstEventDt";
	
	public static final String SENSORS = "SENSORS";
	
	public static final String OBJECT = "object";

	public static final String OBJ_TID = "objTId";
	
	public static final String EVENT_CODE = "eventCode";
	
	public static final String ACCOUNT_TID = "accountTId";
	
	public static final String TENANT_ID = "tenantId";

	public static final String ID_FIELD = "id";
	
	public static final String ACTV = "ACTV";

	public static final String CRTD_DT = "crtdDt";
	
	public static final String UPTD_DT = "uptdDt";

	public static final String AFNAME = "afName";

	public static final String APP_FAMILY_DATA_OBJECT = "afData";

	public static final String DB_APP_FAMILY_OBJECT = "appFamily";

	public static final String EVENT_DATA_OBJECT = "eventData";

	public static final String OBJ_CAT = "objCat";
	
	public static final String FILTER_DOM_EVENTS = "domevent";
}