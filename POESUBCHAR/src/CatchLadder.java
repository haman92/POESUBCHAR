

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import com.google.gson.stream.JsonReader;


public class CatchLadder{

	//积己磊.
	private JSONCHECK_LADDER check;
	private URL url;
	private JsonReader jsonread;
	private NetworkConnection n_conn;
	private long start;
	private String date_string;
	private int total;
	private String league_name;
	
	private Queue<Integer> error_list;
	private Queue<Integer> offset_list;
	ArrayList<ACCOUNTCHARACTER>[] arr;
	
	public CatchLadder()
	{
		this.check= new JSONCHECK_LADDER();
		this.start=this.getTimestamp();
		this.league_name="Metamorph";
		this.error_list= new LinkedList<Integer>();
		this.offset_list= new LinkedList<Integer>();
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
	public String getLeagueName()
	{
		String _league_name=null;
		//http://api.pathofexile.com/leagues?type=season
		return _league_name;
	}
	public int getTotal()
	{

		total =0;
		
		try 
		{
			String url_string="http://api.pathofexile.com/ladders/"+this.league_name+"?type=labyrinth&start="+String.valueOf(this.start)+"&realm=pc&difficulty=Cruel&limit=1";
			url = new URL(url_string);
			System.out.println(url_string);
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
			jsonread.close();
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
		int date = time.get(time.DATE);
		
		this.date_string = String.valueOf(year)+String.valueOf(month)+String.valueOf(date);
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
		int offset=0;
		int count = (total/width)+1;
		
		for(int i =0 ;i<count;i++)
		{
			this.offset_list.add(i*width);
/*
			try {
				Thread.sleep(1010);
			} catch (InterruptedException e3) {
				e3.printStackTrace();
			}
			
			try 
			{
				//https://poe.game.daum.net/ladder/labyrinth/Blight/2/1572739200
				//"http://api.pathofexile.com/ladders/"+this.league_name+"?type=labyrinth&start="
				String url_string="http://api.pathofexile.com/ladders/"+this.league_name+"?type=labyrinth&difficulty=Cruel&start="+String.valueOf(this.start)+"&limit="+String.valueOf(width)+"&offset=";
				offset = i*width;
				
				System.out.println(url_string+String.valueOf(offset));
				url = new URL(url_string+String.valueOf(offset));

			} catch (MalformedURLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}


			try 
			{
				n_conn = new NetworkConnection();

				String input = n_conn.urlReader(url);
				if(input.equals("Forbidden"))
				{
					this.error_list.add(offset);
				}
				StringReader str_reader = new StringReader(input);
				//System.out.println(input);
				check.read_json(str_reader);


				//Thread.sleep(1000);

			}
			
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
*/
			//for end
		}
		
		
		// 俊矾 贸府
		
			while(!this.offset_list.isEmpty())
			{
				
				int temp_offset = this.offset_list.poll();
				String url_string="http://api.pathofexile.com/ladders/"+this.league_name+"?type=labyrinth&difficulty=Cruel&start="+String.valueOf(this.start)+"&limit="+String.valueOf(width)+"&offset=";
				try 
				{

					Thread.sleep(1010);
					url = new URL(url_string+String.valueOf(temp_offset));
					System.out.println(url_string+String.valueOf(temp_offset));
					n_conn = new NetworkConnection();

					String input = n_conn.urlReader(url);
					if(input.equals("Forbidden"))
					{
						this.offset_list.add(offset);
					}
					StringReader str_reader = new StringReader(input);
					check.read_json(str_reader);



				}
				
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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