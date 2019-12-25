import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkConnection {
	private InputStream stream;
	private HttpURLConnection conn;
	private StringBuffer sbuf;
	
	public String urlReader (URL url) throws IOException
	{
		conn=null;
		sbuf = null;
		HttpURLConnection conn= (HttpURLConnection) url.openConnection();
		sbuf = new StringBuffer();
		conn.setRequestMethod("GET");
		conn.setReadTimeout(5000);
		conn.setRequestProperty("Accept", "application/json");
		conn.setConnectTimeout(5000);
		//conn.addRequestProperty("x-api-key", RestTestCommon.API_KEY);


		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.7 (KHTML, like Gecko) Chrome/16.0.912.75 Safari/535.7");

		

		try
		{
			stream = conn.getInputStream();
		}catch(IOException E)
		{
			System.out.println("¸·Èû IOException");
			return "Forbidden";
		}
		
		
		InputStreamReader isr = new InputStreamReader(stream, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		String str ;
		
		while((str=br.readLine()) != null){

			sbuf.append(str + "\r\n") ;

		}
		
		//System.out.println("urlconnection complete");
		stream.close();
		conn.disconnect();
		return sbuf.toString();
		
	}
	
}