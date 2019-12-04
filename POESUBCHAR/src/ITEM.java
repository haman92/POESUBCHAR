import java.util.ArrayList;

//import java.util.ArrayList;
public class ITEM {
/*
	0 - normal items
	1 - magic items
	2 - rare items
	3 - unique items
	4 - gems
*/
	private int item_type;
	private String inventoryID;
	private String item_name;
	private String item_base_type;
	private String sockets;
	private ArrayList<GEM> socketed_gems;
	public ITEM()
	{
		this.socketed_gems = new ArrayList<GEM>();
	}
	
	public void add_gems(GEM gem)
	{
		this.socketed_gems.add(gem);
	}
	
	public int item_Link_Check(String socket_group)
	{
		int length = socket_group.length();
		int count[] = new int[length];
		int temp_max=-1;
		for(int i=0;i<length;i++)
		{
			
			for(int j = 0;j<length;j++)
			{
				if(socket_group.charAt(j)==(char)(i+48))
				{
					count[i]++;
				}
			}
			if(temp_max<count[i])
			{
				temp_max=count[i];
			}
		}
		return temp_max;
	}
	
	
	public int getItem_type() {
		return item_type;
	}
	public void setItem_type(int item_type) {
		this.item_type = item_type;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_base_type() {
		return item_base_type;
	}
	public void setItem_base_type(String item_base_type) {
		this.item_base_type = item_base_type;
	}
	public String getInventoryID() {
		return inventoryID;
	}
	public void setInventoryID(String inventoryID) {
		this.inventoryID = inventoryID;
	}
	public String getSockets() {
		return sockets;
	}
	public void setSockets(String sockets) {
		this.sockets = sockets;
	}
	public ArrayList<GEM> getSocketed_gems()
	{
		return this.socketed_gems;
	}
	
	/*
	private ArrayList<String> item_implicit;
	private ArrayList<String> item_explicit;
	private String item_inventory_type;
	
	*/
}
