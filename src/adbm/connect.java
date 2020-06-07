package adbm;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.*;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;



public class connect {
	
	public DBCollection col;// = null;
	public DB database;// = null;
	//private static connect ref = null;
	HashMap<Integer,String> ctryName = new HashMap<Integer,String>();
	
	public connect() throws Exception
	{
		MongoClient mongoClient = new MongoClient("localhost");
		database = mongoClient.getDB("zomato");
        col = database.getCollection("restaurants");
        ctryName.put(1, "India");
        ctryName.put(14, "Australia");
        ctryName.put(30, "Brazil");
        ctryName.put(37, "Canada");
        ctryName.put(94, "Indonesia");
        ctryName.put(148, "New Zealand");
        ctryName.put(162, "Phillipines");
        ctryName.put(166, "Qatar");
        ctryName.put(184, "Singapore");
        ctryName.put(189, "South Africa");
        ctryName.put(191, "Sri Lanka");
        ctryName.put(208, "Turkey");
        ctryName.put(214, "UAE");
        ctryName.put(215, "United Kingdom");
        ctryName.put(216, "United States");
	}
	
	
	public JSONArray getCountryRestaurants() throws Exception
	{
		
		Integer z[] = new Integer[10000];
		
  	  	BasicDBObject allQuery = new BasicDBObject();
  	  	BasicDBObject fields = new BasicDBObject();
  	  	fields.put("Country Code", 1);
  	  	//fields.put("Aggregate rating", 1);

  	  	DBCursor cursor2 = col.find(allQuery, fields);
  	  	
  	  	JSONArray jsonarray = new JSONArray();
  	  	
  	  	JSONObject jsonobj = new JSONObject();
  	  	HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
  	  	HashMap<String,Integer[]> hmapCluster = new HashMap<String,Integer[]>();
  	  	while (cursor2.hasNext()) {
  	  		
  	  		BasicDBObject obj1 = (BasicDBObject)cursor2.next();
  	  		
  	  		//Double d = obj1.getDouble("Aggregate rating");
  	  		Integer s = obj1.getInt("Country Code");
  	  		
  	  		
  	  		
  	  		if(hmap.containsKey(s))
  	  		{
  	  			int x = hmap.get(s);
  	  			x++;
  	  			hmap.put(s, x);
  	  		}
  	  		else
  	  			hmap.put(s,1);
  	  		
  	  		
  	  		
  	  	}
  	  	
  	  	//System.out.println(jsonarray);
        
  	  	for(Integer key: hmap.keySet())
  	  	{
  	  		//jsonobj = new JSONObject();
  	  		System.out.println("Key: "+ key);
  	  		if(ctryName.get(key) != null)
  	  			jsonobj.put(ctryName.get(key), hmap.get(key));
  	  	}
  	  	
  	  	jsonarray.put(jsonobj);
  	  	System.out.println(jsonarray);
  	  	return jsonarray;

	}
	
	public JSONArray getZomatoAppUsageByCountry() throws Exception
	{
		BasicDBObject allQuery = new BasicDBObject();
  	  	BasicDBObject fields = new BasicDBObject();
  	  	fields.put("Country Code", 1);
  	  	fields.put("Votes", 1);

  	  	DBCursor cursor2 = col.find(allQuery, fields);
  	  	
  	  	JSONArray jsonarray = new JSONArray();
  	  	
  	  	JSONObject jsonobj = new JSONObject();
  	  	HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
  	  	
  	  	while (cursor2.hasNext()) {
  	  		
  	  		BasicDBObject obj1 = (BasicDBObject)cursor2.next();
  	  		
  	  		Integer d = obj1.getInt("Votes");
  	  		Integer s = obj1.getInt("Country Code");
  	  		
  	  		if(hmap.containsKey(s))
  	  		{
  	  			int x = hmap.get(s);
  	  			x+=d;
  	  			hmap.put(s, x);
  	  		}
  	  		else
  	  			hmap.put(s,d);
  	  		
  	  		
  	  		
  	  	}
  	  	
  	  	//System.out.println(jsonarray);
        
  	  	for(Integer key: hmap.keySet())
  	  	{
  	  		//jsonobj = new JSONObject();
  	  		if(ctryName.get(key)!=null)
  	  			jsonobj.put(ctryName.get(key), hmap.get(key));
  	  	}
  	  	
  	  	jsonarray.put(jsonobj);
  	  	System.out.println(jsonarray);
  	  	return jsonarray;
	}
	
	public JSONArray restaurantsByRating() throws Exception
	{
		
		KMeans.runKmeans();
		Integer []arr = KMeans.getOutput();
		Integer arr1[] = KMeans.getClusterOutput();
		int len = KMeans.len;
		System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4]+" ");
		JSONObject obj= new JSONObject();
		
		HashMap<Integer,String> hmap = new HashMap<Integer,String>();
		hmap.put(0, "Not Rated");
		hmap.put(1, "Poor");
		hmap.put(2, "Good");
		hmap.put(3, "Average");
		hmap.put(4, "Very Good");
		hmap.put(5, "Excellent");
		
		
		
		for(int i=0;i<5;i++)
		{
			int num = 0;
			Integer val = arr[i];
			if(val!=-1)
			{
				for(int j=0;j<5;j++)
				{
					if(arr[j] == val)
					{
						num++;
						if(num > 1)
							arr[j] = -1;
					}
				}
				int per=(arr1[i]*100)/len;
				//obj = new JSONObject();
				obj.put(hmap.get(val), per);
				System.out.println(hmap.get(val)+" "+per);
			}
			
		}
		
		
		JSONArray jsonarray = new JSONArray();
		
		obj.put("len", len);
		jsonarray.put(obj);
		return jsonarray;
		/*BasicDBObject allQuery = new BasicDBObject();
  	  	BasicDBObject fields = new BasicDBObject();
  	  	fields.put("Rating text", 1);
  	  	//fields.put("Votes", 1);

  	  	DBCursor cursor2 = col.find(allQuery, fields);
  	  	
  	  	JSONArray jsonarray = new JSONArray();
  	  	
  	  	JSONObject jsonobj = new JSONObject();
  	  	HashMap<String,Integer> hmap = new HashMap<String,Integer>();
  	  	
  	  	while (cursor2.hasNext()) {
  	  		
  	  		BasicDBObject obj1 = (BasicDBObject)cursor2.next();
  	  		
  	  		String d = obj1.getString("Rating text");
  	  		//Integer s = obj1.getInt("Country Code");
  	  		
  	  		if(hmap.containsKey(d))
  	  		{
  	  			int x = hmap.get(d);
  	  			x++;
  	  			hmap.put(d, x);
  	  		}
  	  		else
  	  			hmap.put(d,1);
  	  		
  	  		
  	  		
  	  	}
  	  	
  	  	//System.out.println(jsonarray);
        
  	  	for(String key: hmap.keySet())
  	  	{
  	  		//jsonobj = new JSONObject();
  	  		jsonobj.put(key, hmap.get(key));
  	  	}
  	  	
  	  	jsonarray.put(jsonobj);
  	  	System.out.println(jsonarray);
  	  	return jsonarray;*/
	}
	
	
	public JSONArray getPriceRange() throws Exception
	{
		KMeans1.runKmeans();
		Integer []arr = KMeans1.getOutput();
		Integer []arr1 = KMeans1.getOutputCluster();
		int len = KMeans1.len;
		System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" ");
		JSONObject obj= new JSONObject();
		
		HashMap<Integer,String> hmap = new HashMap<Integer,String>();
		hmap.put(1, "Cheap");
		hmap.put(2, "Budget");
		hmap.put(3, "Average");
		hmap.put(4, "Expensive");
		
		for(int i=0;i<4;i++)
		{
			int num = 0;
			Integer val = arr[i];
			if(val!=-1)
			{
				for(int j=0;j<4;j++)
				{
					if(arr[j] == val)
					{
						num++;
						if(num > 1)
							arr[j] = -1;
					}
				}
				int per=(arr1[i]*100)/len;
				//obj = new JSONObject();
				obj.put(hmap.get(val), per);
				System.out.println(hmap.get(val)+" "+per);
			}
			
		}
		
		
		JSONArray jsonarray = new JSONArray();
		obj.put("len", len);
		jsonarray.put(obj);
		return jsonarray;
	}
}
