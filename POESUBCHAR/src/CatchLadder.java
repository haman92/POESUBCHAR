

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.net.HttpURLConnection;

import com.google.gson.stream.JsonReader;


public class CatchLadder{

	//»ý¼ºÀÚ.
	private JSONCHECK_LADDER check;
	private URL url;
	private JsonReader jsonread;
	private NetworkConnection n_conn;
	private long start;
	private String date_string;
	private int total;
	ArrayList<ACCOUNTCHARACTER>[] arr;
	public CatchLadder()
	{
		this.check= new JSONCHECK_LADDER();
		this.start=this.getTimestamp();
	}
	
	public String getDate()
	{
		return this.date_string;
	}
	public ArrayList<ACCOUNTCHARACTER>[] getArray()
	{
		return this.arr;
	}

	public int getvariabletTotal()
	{
		return this.total;
	}
	public int getTotal()
	{

		total =0;
		
		try 
		{
			String url_string="http://api.pathofexile.com/ladders/Blight?type=labyrinth&start="+String.valueOf(this.start)+"&realm=pc&difficulty=Cruel&limit=1";
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
			this.total  = jsonread.nextInt();
			jsonread=null;
			System.out.println("total"+total);
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();

		}catch (IOException e1) {
			e1.printStackTrace();
		}

		return this.total;
	}

	public long getTimestamp()
	{
		DateFormat dateformat = new SimpleDateFormat("yyyyMMdd hh");
		Calendar time = Calendar.getInstance();
		int year = time.get(time.YEAR);
		int month = time.get(time.MONTH)+1;
		int date = time.get(time.DATE)-1;
		
		if(month<10)
		{
			this.date_string= String.valueOf(year)+"0"+String.valueOf(month)+String.valueOf(date);
		}
		if(date<10)
		{
			this.date_string= String.valueOf(year)+String.valueOf(month)+"0"+String.valueOf(date);
		}
		if(month<10&&date<10)
		{
			this.date_string= String.valueOf(year)+"0"+String.valueOf(month)+"0"+String.valueOf(date);
		}
		
		String stime = String.valueOf(year)+String.valueOf(month)+String.valueOf(date)+" 09";
		Date date1=null;
		try {
			date1 = dateformat.parse(stime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date1.getTime()/1000-1);
		return date1.getTime()/1000-1;
	}
	
	public void run()
	{

		int width = 50;
		int total = this.getTotal();

		int count = (total/width)+1;
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
				String url_string="http://api.pathofexile.com/ladders/Blight?type=labyrinth&realm=pc&difficulty=Cruel&start="+String.valueOf(this.start)+"&limit="+String.valueOf(width)+"&offset=";
				String temp = url_string+String.valueOf(i*width);
				//System.out.println(temp);
				url = new URL(url_string+String.valueOf(i*width));

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
		
		DBConnection db = new DBConnection();
		if(db.connect())
		{
			boolean flag = db.insertLabyrinthLadder(total, check.getAscendant(), check.getAssasin(), check.getBerserker(), check.getChampion(),check.getChieftain(),check.getDeadeye(), check.getElementalist(), check.getGuardian(), check.getGladiator(), check.getHierophant(), check.getInquisitor(), check.getJuggernaut(), check.getNecromancer(),check.getOccultist(), check.getRaider(), check.getSaboteur(), check.getSaboteur(), check.getTrickster(), this.date_string);
			
				db.close();
		}
		this.arr = check.getArray();
		
	}
}
//1406