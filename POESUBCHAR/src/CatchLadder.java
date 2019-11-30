

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import com.google.gson.stream.JsonReader;


public class CatchLadder extends Thread{

	//»ý¼ºÀÚ.
	private HttpURLConnection conn;
	private StringBuffer sbuf;
	private InputStream stream;
	private JSONCHECK_LADDER check;
	private URL url;
	private JsonReader jsonread;
	private NetworkConnection n_conn;
	public CatchLadder()
	{
		this.conn = null;
		this.sbuf = null;
		this.stream = null;
		this.check= new JSONCHECK_LADDER();
	}

	public int getTotal()
	{

		int total =0;
		try 
		{
			String url_string="http://api.pathofexile.com/ladders/Blight?type=labyrinth&realm=pc&difficulty=Cruel&limit=1";
			url = new URL(url_string);

		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		}
		try 
		{
			n_conn = new NetworkConnection();

			String input = n_conn.urlReader(url);
			StringReader str_reader = new StringReader(input);
			jsonread = new JsonReader(str_reader);
			jsonread.beginObject();
			jsonread.nextName();
			total  = jsonread.nextInt();
			jsonread=null;
			System.out.println("total"+total);
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();

		}catch (IOException e1) {
			e1.printStackTrace();
		}

		return total;
	}

	public void run()
	{

		int total = this.getTotal();

		int count = (total/40)+1;
		for(int i =0 ;i<count;i++)
		{

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e3) {
				e3.printStackTrace();
			}
			
			try 
			{
				//https://poe.game.daum.net/ladder/labyrinth/Blight/2/1572739200
				String url_string="http://api.pathofexile.com/ladders/Blight?type=labyrinth&realm=pc&difficulty=Cruel&limit=40&offset=";
				url = new URL(url_string+String.valueOf(i*40));
				sbuf = new StringBuffer();

			} catch (MalformedURLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}


			try 
			{
				n_conn = new NetworkConnection();

				String input = n_conn.urlReader(url);
				StringReader str_reader = new StringReader(input);
				check.read_json(str_reader);


				//Thread.sleep(1000);

			}
			/*
			catch (InterruptedException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();

			}
			*/
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		
		System.out.println(check.getAscendant());
		System.out.println(check.getAssasin());
		System.out.println(check.getBerserker());
		System.out.println(check.getChampion());
		System.out.println(check.getChieftain());
		System.out.println(check.getDeadeye());
		System.out.println(check.getElementalist());
		System.out.println(check.getGladiator());
		System.out.println(check.getGuardian());
		System.out.println(check.getHierophant());
		System.out.println(check.getInquisitor());
		System.out.println(check.getJuggernaut());	
		System.out.println(check.getNecromancer());
		System.out.println(check.getOccultist());
		System.out.println(check.getPathfinder());
		System.out.println(check.getRaider());
		System.out.println(check.getSaboteur());
		System.out.println(check.getSlayer());
		System.out.println(check.getTrickster());
		
		

	}
}
