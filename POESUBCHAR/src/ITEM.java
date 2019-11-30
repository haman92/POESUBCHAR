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
	
	/*
	private ArrayList<String> item_implicit;
	private ArrayList<String> item_explicit;
	private String item_inventory_type;
	
	*/
}
