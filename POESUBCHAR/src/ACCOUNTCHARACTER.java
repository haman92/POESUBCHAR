import java.util.ArrayList;

public class ACCOUNTCHARACTER {

	private String character_ID;
	private String character_class;
	private String character_name;
	//private String account_ID;
	private String account_name;
	private String twitch_ID;
	private ArrayList<ITEM> unique_item_list;
	private ArrayList<ITEM> has_socket_item_list;
	private ArrayList<String> herald_aura_curse;
	private ArrayList<String> active_skill; // skill has over 4 Link
	public ACCOUNTCHARACTER()
	{
		this.unique_item_list = new ArrayList<ITEM>();
		this.has_socket_item_list = new ArrayList<ITEM>();
		this.herald_aura_curse = new ArrayList<String>();
		this.active_skill = new ArrayList<String>();
	}
	public ACCOUNTCHARACTER(String id, String name)
	{
		this.character_ID=id;
		this.character_name=name;
		this.unique_item_list = new ArrayList<ITEM>();
		this.has_socket_item_list = new ArrayList<ITEM>();
		this.herald_aura_curse = new ArrayList<String>();
		this.active_skill = new ArrayList<String>();
	}
	public ACCOUNTCHARACTER(String id, String cha_class, String name)
	{
		this.character_ID= id;
		this.character_class= cha_class;
		this.character_name=name;
		this.unique_item_list = new ArrayList<ITEM>();
		this.has_socket_item_list = new ArrayList<ITEM>();
		this.herald_aura_curse = new ArrayList<String>();
		this.active_skill = new ArrayList<String>();
	}
	
	public void add_active_skill(String skill_name)
	{
		this.active_skill.add(skill_name);
	}
	
	public void add_Unique_item(ITEM item)
	{
		this.unique_item_list.add(item);
	}
	public void add_socket_item(ITEM item)
	{
		this.has_socket_item_list.add(item);
	}
	public void add_herald_aura_curse(String herald_aura_curse_name)
	{
		this.herald_aura_curse.add(herald_aura_curse_name);
	}
	
	
	
	public String getCharacter_ID() {
		return character_ID;
	}
	
	
	public void setCharacter_ID(String character_ID) {
		this.character_ID = character_ID;
	}
	public String getCharacter_name() {
		return character_name;
	}
	public void setCharacter_name(String character_name) {
		this.character_name = character_name;
	}

	public String getCharacter_class() {
		return character_class;
	}
	public void setCharacter_class(String character_class) {
		this.character_class = character_class;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	
	public ArrayList<ITEM> getUnique_item_list() {
		return unique_item_list;
	}
	public void setUnique_item_list(ArrayList<ITEM> unique_item_list) {
		this.unique_item_list = unique_item_list;
	}
	public String getTwitch_ID() {
		return twitch_ID;
	}
	public void setTwitch_ID(String twitch_ID) {
		this.twitch_ID = twitch_ID;
	}
	
}
