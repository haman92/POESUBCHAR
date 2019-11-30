import java.util.ArrayList;

public class ACCOUNTCHARACTER {

	private String character_ID;
	private String character_class;
	private String character_name;
	//private String account_ID;
	private String account_name;
	private String active_skill1;
	private String active_skill2;
	private String active_skill3;
	private String active_skill4;
	private String active_skill5;
	private ArrayList<ITEM> unique_item_list;
	public ACCOUNTCHARACTER()
	{
		setUnique_item_list(new ArrayList<ITEM>());
	}
	public ACCOUNTCHARACTER(String id, String name)
	{
		this.character_ID=id;
		this.character_name=name;
	}
	public ACCOUNTCHARACTER(String id, String cha_class, String name)
	{
		this.character_ID= id;
		this.character_class= cha_class;
		this.character_name=name;
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
	public String getActive_skill1() {
		return active_skill1;
	}
	public void setActive_skill1(String active_skill1) {
		this.active_skill1 = active_skill1;
	}
	public String getActive_skill2() {
		return active_skill2;
	}
	public void setActive_skill2(String active_skill2) {
		this.active_skill2 = active_skill2;
	}
	public String getActive_skill3() {
		return active_skill3;
	}
	public void setActive_skill3(String active_skill3) {
		this.active_skill3 = active_skill3;
	}
	public String getActive_skill5() {
		return active_skill5;
	}
	public void setActive_skill5(String active_skill5) {
		this.active_skill5 = active_skill5;
	}
	public String getActive_skill4() {
		return active_skill4;
	}
	public void setActive_skill4(String active_skill4) {
		this.active_skill4 = active_skill4;
	}
	public ArrayList<ITEM> getUnique_item_list() {
		return unique_item_list;
	}
	public void setUnique_item_list(ArrayList<ITEM> unique_item_list) {
		this.unique_item_list = unique_item_list;
	}
}
