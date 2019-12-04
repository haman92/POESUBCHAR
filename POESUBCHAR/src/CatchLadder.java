

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.net.HttpURLConnection;

import com.google.gson.stream.JsonReader;


public class CatchLadder{

	//»ý¼ºÀÚ.
	private JSONCHECK_LADDER check;
	private URL url;
	private JsonReader jsonread;
	private NetworkConnection n_conn;
	ArrayList<ACCOUNTCHARACTER>[] arr;
	public CatchLadder()
	{
		this.check= new JSONCHECK_LADDER();
	}
	
	public ArrayList<ACCOUNTCHARACTER>[] getArray()
	{
		return this.arr;
	}

	public int getTotal()
	{

		int total =0;
		try 
		{
			String url_string="http://api.pathofexile.com/ladders/Blight?type=labyrinth&start=1575158400&realm=pc&difficulty=Cruel&limit=1";
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
			Thread.sleep(300);

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
				Thread.sleep(500);
			} catch (InterruptedException e3) {
				e3.printStackTrace();
			}
			
			try 
			{
				//https://poe.game.daum.net/ladder/labyrinth/Blight/2/1572739200
				String url_string="http://api.pathofexile.com/ladders/Blight?type=labyrinth&realm=pc&difficulty=Cruel&start=1575158400&limit=50&offset=";
				url = new URL(url_string+String.valueOf(i*40));

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
			
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		
		System.out.println("Ascendant"+check.getAscendant());
		System.out.println("Assasin"+check.getAssasin());
		System.out.println("Berserker"+check.getBerserker());
		System.out.println("Champion"+check.getChampion());
		System.out.println("Chieftain"+check.getChieftain());
		System.out.println("Deadeye"+check.getDeadeye());
		System.out.println("Elementalist"+check.getElementalist());
		System.out.println("Gladiator"+check.getGladiator());
		System.out.println("Guardian"+check.getGuardian());
		System.out.println("Hierophant"+check.getHierophant());
		System.out.println("Inquisitor"+check.getInquisitor());
		System.out.println("Juggernaut"+check.getJuggernaut());	
		System.out.println("Necromancer"+check.getNecromancer());
		System.out.println("Occultist"+check.getOccultist());
		System.out.println("Pathfinder"+check.getPathfinder());
		System.out.println("Raider"+check.getRaider());
		System.out.println("Saboteur"+check.getSaboteur());
		System.out.println("Slayer"+check.getSlayer());
		System.out.println("Trickster"+check.getTrickster());
		
		this.arr = check.getArray();
		
	}
}
//1406