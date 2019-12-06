

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

import com.google.gson.stream.JsonReader;

public class CatchCHARACTER {
	private NetworkConnection n_conn;
	private URL url;
	private String getcharacter_name;
	private JSONCHECK_CHARACTER check;
	private String getaccount_ID;
	private ArrayList<ACCOUNTCHARACTER>[] account_array;
	private FileWriter fwriter;
	private BufferedWriter bwriter;
	private int forbidden_count;
	private String date;
	private int total;
	//private boolean direct;

	public CatchCHARACTER()
	{
		this.forbidden_count=0;
		n_conn = new NetworkConnection();
		this.check = new JSONCHECK_CHARACTER();
	}
	public CatchCHARACTER(String character_ID, String account_ID,int total1)
	{
		this.forbidden_count=0;
		this.setGetaccount_ID(account_ID);
		n_conn = new NetworkConnection();

		this.total = total1;
		this.check = new JSONCHECK_CHARACTER();
	}
	public CatchCHARACTER(ArrayList<ACCOUNTCHARACTER>[] read_array, String date_string, int total1)
	{
		this.forbidden_count=0;
		n_conn = new NetworkConnection();
		this.total = total1;
		this.date = date_string;
		this.account_array= read_array;
		this.check = new JSONCHECK_CHARACTER();
	}


	public void getOneCharacter()
	{
		String url_string=null;


		ACCOUNTCHARACTER acc = new ACCOUNTCHARACTER("haman2","blight_trapcard_wintero");

		String acc_ID = this.getGetaccount_ID();
		String cha_name= this.getGetcharacter_name();
		//ACCOUNTCHARACTER acc = new ACCOUNTCHARACTER(acc_ID,cha_name);

		url_string="https://www.pathofexile.com/character-window/get-items?accountName=Havoc6&character=HavocZM";
		//url_string="https://www.pathofexile.com/character-window/get-items?accountName="+acc_ID+"&character="+cha_name;
		try {
			url = new URL(url_string);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try 
		{

			String input = n_conn.urlReader(url);
			StringReader str_reader = new StringReader(input);
			if(input.contains("Forbidden"))
			{

				System.out.println("Forbidden");
				Thread.sleep(1000);
				return;
			}
			acc = check.read_json(str_reader,acc);
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

		for(ArrayList<ACCOUNTCHARACTER> temp_arr:this.account_array)
		{
			for(ACCOUNTCHARACTER temp_acc : temp_arr)
			{

				//System.out.println(temp_acc.getCharacter_name());

				try
				{

					Thread.sleep(1000);
				}catch(Exception e)
				{
					e.printStackTrace();
				}

				String acc_ID = temp_acc.getAccount_name();
				String cha_name = temp_acc.getCharacter_name();

				url_string = "https://www.pathofexile.com/character-window/get-items?accountName="+acc_ID+"&character="+cha_name;
				try {
					url = new URL(url_string);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				String input;
				try {
					input = n_conn.urlReader(url);

					StringReader str_reader = new StringReader(input);
					if(input.contains("Forbidden"))
					{
						//System.out.println("ID "+acc_ID+"c_name "+cha_name);
						this.forbidden_count++;
						//System.out.println("Forbidden");
						continue;
					}

					temp_acc = check.read_json(str_reader,temp_acc);

					DBConnection db = new DBConnection();
					if(db.connect())
					{
						if(!db.insertpoecharacter(temp_acc, this.date))
						{
							System.out.println("poecharacter false");
						}
						if(!db.insertusing_activegem(temp_acc, this.date))
						{
							System.out.println("activegem false");
						}
						if(!db.insertusing_hearald_curse_aura(temp_acc, this.date))
						{
							System.out.println("herald_curse_aura false");
						}
						if(!db.insertusing_uniqueitem(temp_acc, this.date))
						{
							System.out.println("uniqueitem false");
						}
						db.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
			}
		}
		//this.fwriter = new FileWriter();
		/*
		File file = new File("12.02.txt");
		try {
			this.bwriter = new BufferedWriter(new FileWriter(file,false));
			for(ArrayList<ACCOUNTCHARACTER> temp_array:this.account_array)
			{
				for(ACCOUNTCHARACTER temp_acc:temp_array)
				{
					if(temp_acc.getHas_sockte_item_list().size()==0)
					{
						continue;
					}
					bwriter.write(temp_acc.getCharacter_name()+" "+temp_acc.getCharacter_class()+" ");
					bwriter.write("Active_Skill");
					for(String temp :temp_acc.getActive_skill_list())
					{
						bwriter.write(" ");
						bwriter.write(temp);

					}

					bwriter.write(" ");
					bwriter.write("Herald_aura_curse");
					for(String temp : temp_acc.getHearld_aura_curse_list())
					{
						bwriter.write(" ");
						bwriter.write(temp);
					}
					bwriter.write(" ");
					bwriter.write("Unique");
					for(ITEM temp: temp_acc.getUnique_item_list())
					{
						bwriter.write(" ");
						bwriter.write(temp.getItem_name());
					}
					bwriter.newLine();

				}
			}
			this.bwriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 */

		System.out.println("forbiddencount "+this.forbidden_count);

		int collect_count = this.total - this.forbidden_count;
		System.out.println("collect count"+collect_count);

	}

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
//524
//forbiddencount 886 709 1500
//forbiddencount 879 709 1000
//forbiddencount     785 800
//forbiddencount 1061 700
//forbiddencount 1177 500
//forbiddencount 1359 300
