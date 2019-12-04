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
		conn= (HttpURLConnection) url.openConnection();
		sbuf = new StringBuffer();
		conn.setRequestMethod("GET");
		conn.setReadTimeout(3000);
		conn.setConnectTimeout(3000);
		
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows 10;) Chrome/16.0.912.75 Safari/535.7");
		try
		{
			stream = conn.getInputStream();
		}catch(IOException E)
		{
			return "Forbidden";
		}
		
		
		InputStreamReader isr = new InputStreamReader(stream, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		String str ;
		
		while((str=br.readLine()) != null){

			sbuf.append(str + "\r\n") ;

		}
		
		System.out.println("urlconnection complete");
		stream.close();
		conn.disconnect();
		return sbuf.toString();
		
	}
	
}