package parserClient;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Test {

	
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		
		 URL url = new URL("https://hlep.herokuapp.com/parse/send message to dad at 5 pm content iw ill be back soon".replace(" ", "%20"));
		 
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         // read the response
         InputStream in = new BufferedInputStream(conn.getInputStream());
         
             BufferedReader reader = new BufferedReader(new InputStreamReader(in));
             StringBuilder sb = new StringBuilder();
      
             String line;
             try {
                 while ((line = reader.readLine()) != null) {
                     sb.append(line).append('\n');
                 }
             } catch (IOException e) {
                 e.printStackTrace();
             } finally {
                 try {
                     in.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
             
             String Sjaon = sb.toString().replace("'", "\"");
             System.out.println(Sjaon);
             System.out.println(Sjaon);

             System.out.println(Sjaon);

             String Sjaon2 = Sjaon.replace("\\", "");
             System.out.println(Sjaon2);
             String Sjaon3 = Sjaon2.replace("[", "").replace("]", "").replace(" ", "");
             System.out.println(Sjaon3);

             Object obj= new JSONParser().parse(Sjaon3);
             //Object obj= new JSONParser().parse("{ \"CommandVerb\":\"send\", \"Intent\":\"message\", \"Receiver\":\"dad\", \"Time\":\"5 pm\", \"Content\":\"iw ill be back soon\"}");


             JSONObject jo = (JSONObject) obj;
             System.out.println(jo.get("Initial"));
             System.out.println(jo.get("Intent"));
             System.out.println(jo.get("Time"));
             System.out.println(jo.get("Frequency"));
             System.out.println(jo.get("Receiver"));
             System.out.println(jo.get("AdditionalSound"));
             System.out.println(jo.get("Content"));	
	}
	
	

}
