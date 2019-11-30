

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

public class CatchCHARACTER extends Thread{
	private HttpURLConnection conn;
	private StringBuffer sbuf;
	private InputStream stream;
	private NetworkConnection n_conn;
	private URL url;
	private JsonReader jsonread;
	private ArrayList<ACCOUNTCHARACTER> array[];
	private String getcharacter_name;
	private JSONCHECK_CHARACTER check;
	private String getaccount_ID;
	//private boolean direct;
	
	public CatchCHARACTER()
	{
		
		n_conn = new NetworkConnection();
		this.check = new JSONCHECK_CHARACTER();
	}
	public CatchCHARACTER(String character_ID, String account_ID)
	{
		this.setGetaccount_ID(account_ID);

		
		this.check = new JSONCHECK_CHARACTER();
	}
	public CatchCHARACTER(ArrayList<ACCOUNTCHARACTER>[] read_array)
	{
		this.array = read_array;
		this.check = new JSONCHECK_CHARACTER();
	}


	public void getOneCharacter()
	{
		String url_string=null;
		
		
		ACCOUNTCHARACTER acc = new ACCOUNTCHARACTER("haman2","blight_trapcard_wintero");

		String acc_ID = this.getGetaccount_ID();
		String cha_name= this.getGetcharacter_name();
		//ACCOUNTCHARACTER acc = new ACCOUNTCHARACTER(acc_ID,cha_name);

		url_string="https://www.pathofexile.com/character-window/get-items?accountName=haman92&character=blight_trapcard_wintero";
		//url_string="https://www.pathofexile.com/character-window/get-items?accountName="+acc_ID+"&character="+cha_name;
		try {
			url = new URL(url_string);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sbuf = new StringBuffer();


		try 
		{

			String input = n_conn.urlReader(url);
			StringReader str_reader = new StringReader(input);
			check.read_json(str_reader,acc);
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();

		}catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	
	public void run()
	{
		String url_string=null;
		ACCOUNTCHARACTER character = new ACCOUNTCHARACTER();
		character.setCharacter_name("blight_trapcard_wintero");
		character.setAccount_name("haman92");

		String acc_ID = this.getGetaccount_ID();
		String cha_name= this.getGetcharacter_name();
		url_string="https://www.pathofexile.com/character-window/get-items?accountName=haman92&character=blight_trapcard_wintero";
		//url_string="https://www.pathofexile.com/character-window/get-items?accountName="+acc_ID+"&character="+cha_name;
		try {
			url = new URL(url_string);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sbuf = new StringBuffer();



		try 
		{

			String input = n_conn.urlReader(url);
			StringReader str_reader = new StringReader(input);
			jsonread = new JsonReader(str_reader);
			jsonread.beginObject();
			jsonread.nextName();
			jsonread=null;
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();

		}catch (IOException e1) {
			e1.printStackTrace();
		}

	}
/*	
	public boolean isDirect() {
		return direct;
	}
	public void setDirect(boolean direct) {
		this.direct = direct;
	}
*/
	public String getGetaccount_ID() {
		return getaccount_ID;
	}
	public void setGetaccount_ID(String getaccount_ID) {
		this.getaccount_ID = getaccount_ID;
	}
	public String getGetcharacter_name() {
		return getcharacter_name;
	}
	public void setGetcharacter_name(String getcharacter_name) {
		this.getcharacter_name = getcharacter_name;
	}
}
