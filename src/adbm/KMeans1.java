package adbm;



import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class KMeans1 {

	public static final int CLUSTERS = 4;
	public static int len;
	public static int[] data;
	public static Integer[] output = new Integer[4];
	public static Integer[] dataarr = new Integer[4];
	
	public static Integer[] getOutput()
	{
		return output;
	}
	
	public static Integer[] getOutputCluster()
	{
		return dataarr;
	}
	
	
	public static void runKmeans()
	{
		data = new int[10000];;// = {1,8,9,3,10,12,-16,-2,-1,0,1,-3};
		getData(data);
		int length = len;
		int[][] sums = new int[CLUSTERS][length];
		int[][] centroids = {{1, 2, 3, 4, 5},{1, 2, 3, 4, 5},{1, 2, 3, 4, 5},{1, 2, 3, 4, 5},{1, 2, 3, 4, 5}};
		int[] count = new int[CLUSTERS];
		int i, j, k;
		long minimum, difference;
		boolean converged = false;

		do {
			
			for(i = 0; i < CLUSTERS; i++) {
				
				centroids[0][i] = centroids[1][i];
				count[i] = 0;
				centroids[1][i] = 0;
			}
			
			for(i = 0; i < length; i++) {
				
				sums[0][i] = 0;
				minimum = centroids[0][0] > data[i] ? centroids[0][0] - data[i] : data[i] - centroids[0][0];
				k = 0;
				
				for(j = 1; j < CLUSTERS; j++) {
					
					sums[j][i] = 0;
					difference = centroids[0][j] > data[i] ? centroids[0][j] - data[i] : data[i] - centroids[0][j];
					
					if(difference < minimum) {
						
						minimum = difference;
						k = j;
					}
				}
				
				sums[k][i] = data[i];
				count[k]++;
			}
			
			converged = true;
			
			for(i = 0; i < CLUSTERS; i++) {
				
				difference = 0;
				
				if(count[i] > 0) {
					for(j = 0; j < length; j++) {
						
						centroids[1][i] += sums[i][j] / count[i];
						difference += sums[i][j] % count[i];
						centroids[1][i] += difference / count[i];
						difference %= count[i];
					}
				}
				
				converged &= centroids[0][i] == centroids[1][i];
			}
		}while(!converged);

		for(i = 0; i < CLUSTERS; i++) {
			
			output[i] = centroids[1][i];
			dataarr[i] = count[i];
			System.out.println(centroids[1][i]);
			System.out.println(dataarr[i]);
		}

	}
	
	
	private static void getData(int[] data) {
		
		MongoClient mongoClient = new MongoClient("localhost");
		DB database = mongoClient.getDB("zomato");
        DBCollection col = database.getCollection("restaurants");
        
        BasicDBObject allQuery = new BasicDBObject();
  	  	BasicDBObject fields = new BasicDBObject();
  	  	fields.put("Country Code", 1);
  	  	fields.put("Price range", 1);
  	  	len = 0;
  	  	DBCursor cursor2 = col.find(allQuery, fields);
  	  	
  	  while (cursor2.hasNext()) {
	  		
	  		BasicDBObject obj1 = (BasicDBObject)cursor2.next();
	  		
	  		//Double d = obj1.getDouble("Aggregate rating");
	  		Double d = obj1.getDouble("Price range");
	  		Integer s = d.intValue();
	  		data[len] = s;
	  		len++;
	  	}
		
	}
	

}
