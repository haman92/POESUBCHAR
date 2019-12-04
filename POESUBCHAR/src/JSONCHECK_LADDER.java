
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;


import com.google.gson.stream.JsonReader;

public class JSONCHECK_LADDER {


	private JsonReader json_reader;
	private String read_temp;
	private int total;
	private int time;
	private ArrayList<ACCOUNTCHARACTER> array[];
	private int juggernaut;//juggernaut
	private int berserker;//berserker
	private int chieftain;//chieftain
	private int deadeye;//deadeye
	private int raider;//raider
	private int pathfinder;//pathfinder
	private int necromancer;//necromancer
	private int occultist;//occultist
	private int elementalist;//elementalist
	private int slayer;//slayer
	private int gladiator;//gladiator
	private int champion;//champion
	private int inquisitor;//inquisitor
	private int hierophant;//hierophant
	private int guardian;//guardian
	private int assassin;//assasin
	private int saboteur;//saboteur
	private int trickster;//trickster
	private int ascendant;
	
	
	public ArrayList<ACCOUNTCHARACTER>[] getArray()
	
	{
		return array;
	}
	public int getTotal()
	{
		return this.total;
	}
	public JSONCHECK_LADDER()
	{

		this.json_reader = null;
		this.setAscendant(0);
		this.setAssasin(0);
		this.setBerserker(0);
		this.setChampion(0);
		this.setChieftain(0);
		this.setDeadeye(0);
		this.setElementalist(0);
		this.setGladiator(0);
		this.setGuardian(0);
		this.setHierophant(0);
		this.setInquisitor(0);
		this.setJuggernaut(0);
		this.setNecromancer(0);
		this.setOccultist(0);
		this.setPathfinder(0);
		this.setRaider(0);
		this.setSaboteur(0);
		this.setSlayer(0);
		
		array = (ArrayList<ACCOUNTCHARACTER>[])new ArrayList[16];
		
		for(int i =0 ;i<16;i++)
		{
			array[i] = new ArrayList<ACCOUNTCHARACTER>();
		}
	}

	public ACCOUNTCHARACTER getNewCharacter()
	{
		return new ACCOUNTCHARACTER();
	}

	public void read_json(StringReader sr) throws IOException
	{
		json_reader = new JsonReader(sr);
		ACCOUNTCHARACTER character = null;
		json_reader.beginObject();

		while(json_reader.hasNext()==true)
		{
			read_temp= json_reader.nextName();



			if(read_temp.equals("entries"))
			{
				read_entries(json_reader);
			}
			else if(read_temp.equals("total"))
			{
				this.total = json_reader.nextInt();
			}
			else if(read_temp.equals("startTime"))
			{

				time = json_reader.nextInt();
			} else
			{
				json_reader.skipValue();
			}


			

		}
		json_reader.endObject();
	}

	public void read_entries(JsonReader json_reader) throws IOException
	{
		json_reader.beginArray();
		while(json_reader.hasNext()==true)
		{
			read_ID(json_reader);
		}
		json_reader.endArray();
	}
	public void read_ID(JsonReader json_reader) throws IOException
	{
		json_reader.beginObject();
		String read_temp_id;
		ACCOUNTCHARACTER add= new ACCOUNTCHARACTER();
		while(json_reader.hasNext()==true)
		{
			read_temp_id= json_reader.nextName();
			if(read_temp_id.equals("character"))
			{
				add = read_character(json_reader,add);
			}else if(read_temp_id.equals("account"))
			{
				add = read_account(json_reader, add);
			}
			else
			{
				json_reader.skipValue();
			}
		}
		//add 어레이 배열에 넣기 작업해야됨
		this.add_ArrayList(add);
		json_reader.endObject();
	}
	public ACCOUNTCHARACTER read_character(JsonReader json_reader,ACCOUNTCHARACTER add)throws IOException
	{
		json_reader.beginObject();
		String read_temp_character;
		String character_class;
		while(json_reader.hasNext())
		{
			read_temp_character = json_reader.nextName();
			if(read_temp_character.equals("name"))
			{
				add.setCharacter_name(json_reader.nextString());
			}
			else if(read_temp_character.equals("class"))
			{
				character_class = json_reader.nextString();
				add.setCharacter_class(character_class);
				
				if(character_class.equals("Juggernaut"))
				{
					this.juggernaut++;
				}
				if(character_class.equals("Chieftain"))
				{
					this.chieftain++;
				}
				if(character_class.equals("Berserker"))
				{
					this.berserker++;
				}
				if(character_class.equals("Deadeye"))
				{
					this.deadeye++;
				}
				if(character_class.equals("Champion"))
				{
					this.champion++;
				}
				if(character_class.equals("Ascendant"))
				{
					this.ascendant++;
				}
				if(character_class.equals("Assassin"))
				{
					this.assassin++;
				}
				if(character_class.equals("Elementalist"))
				{
					this.elementalist++;
				}
				if(character_class.equals("Gladiator"))
				{
					this.gladiator++;
				}
				if(character_class.equals("Guardian"))
				{
					this.guardian++;	
				}
				if(character_class.equals("Hierophant"))
				{
					this.hierophant++;
				}
				if(character_class.equals("Inquisitor"))
				{
					this.inquisitor++;
				}
				if(character_class.equals("Necromancer"))
				{
					this.necromancer++;
				}
				if(character_class.equals("Occultist"))
				{
					this.occultist++;
				}
				if(character_class.equals("Pathfinder"))
				{
					this.pathfinder++;
				}
				if(character_class.equals("Raider"))
				{
					this.raider++;
				}
				if(character_class.equals("Saboteur"))
				{
					this.saboteur++;
				}
				if(character_class.equals("Slayer"))
				{
					this.slayer++;
				}
				if(character_class.equals("Trickster"))
				{
					this.trickster++;
				}
			}
			else if(read_temp_character.equals("id"))
			{
				add.setCharacter_ID(json_reader.nextString());
			}
			else
			{
				json_reader.skipValue();
			}

		}
		json_reader.endObject();
		return add;
	}
	
	
	public ACCOUNTCHARACTER read_account(JsonReader json_reader, ACCOUNTCHARACTER add)throws IOException
	{
		json_reader.beginObject();
		String read_temp_account;
		while(json_reader.hasNext())
		{
			read_temp_account = json_reader.nextName();
			if(read_temp_account.equals("name"))
			{
				add.setAccount_name(json_reader.nextString());
			}
			else if(read_temp_account.equals("twitch"))
			{
				add.setTwitch_ID(read_twitch(json_reader,add));
			}
			else 
			{
				json_reader.skipValue();
			}
		}
		json_reader.endObject();
		return add;
	}
	public String read_twitch(JsonReader json_reader, ACCOUNTCHARACTER add) throws IOException
	{
		json_reader.beginObject();
		String read_temp=null;
		json_reader.nextName();
		read_temp = json_reader.nextString();
		json_reader.endObject();
		return read_temp;
	}
	private void add_ArrayList(ACCOUNTCHARACTER add)
	{
		//0~9 = 48~57, a~z = 97~122
		String id = add.getCharacter_ID();
		int index_i=-1;
		char index = id.charAt(0);
		if(index<60)
		{
			index_i = (int) (index - 48);
		}else if(index>90)
		{
			index_i = (int) (index -87);
		}

		this.array[index_i].add(add);
	}
	
	
	public int getJuggernaut() {
		return juggernaut;
	}
	public void setJuggernaut(int juggernaut) {
		this.juggernaut = juggernaut;
	}
	public int getChieftain() {
		return chieftain;
	}
	public void setChieftain(int chieftain) {
		this.chieftain = chieftain;
	}
	public int getDeadeye() {
		return deadeye;
	}
	public void setDeadeye(int deadeye) {
		this.deadeye = deadeye;
	}
	public int getBerserker() {
		return berserker;
	}
	public void setBerserker(int berserker) {
		this.berserker = berserker;
	}
	public int getPathfinder() {
		return pathfinder;
	}
	public void setPathfinder(int pathfinder) {
		this.pathfinder = pathfinder;
	}
	public int getRaider() {
		return raider;
	}
	public void setRaider(int raider) {
		this.raider = raider;
	}
	public int getSlayer() {
		return slayer;
	}
	public void setSlayer(int slayer) {
		this.slayer = slayer;
	}
	public int getOccultist() {
		return occultist;
	}
	public void setOccultist(int occultist) {
		this.occultist = occultist;
	}
	public int getElementalist() {
		return elementalist;
	}
	public void setElementalist(int elementalist) {
		this.elementalist = elementalist;
	}
	public int getGladiator() {
		return gladiator;
	}
	public void setGladiator(int gladiator) {
		this.gladiator = gladiator;
	}
	public int getChampion() {
		return champion;
	}
	public void setChampion(int champion) {
		this.champion = champion;
	}
	public int getInquisitor() {
		return inquisitor;
	}
	public void setInquisitor(int inquisitor) {
		this.inquisitor = inquisitor;
	}
	public int getHierophant() {
		return hierophant;
	}
	public void setHierophant(int hierophant) {
		this.hierophant = hierophant;
	}
	public int getGuardian() {
		return guardian;
	}
	public void setGuardian(int guardian) {
		this.guardian = guardian;
	}
	public int getAssasin() {
		return assassin;
	}
	public void setAssasin(int assasin) {
		this.assassin = assasin;
	}
	public int getSaboteur() {
		return saboteur;
	}
	public void setSaboteur(int saboteur) {
		this.saboteur = saboteur;
	}
	public int getAscendant() {
		return ascendant;
	}
	public void setAscendant(int ascendant) {
		this.ascendant = ascendant;
	}
	public int getNecromancer() {
		return necromancer;
	}
	public void setNecromancer(int necromancer) {
		this.necromancer = necromancer;
	}
	public int getTrickster() {
		return trickster;
	}
	public void setTrickster(int trickster) {
		this.trickster = trickster;
	}

}
