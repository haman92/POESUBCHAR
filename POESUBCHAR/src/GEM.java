
public class GEM {

	private String gem_name;
	private boolean support;
	private boolean aura_herald_curse;
	private String Socketed_item_inventory_id;
	
	//private boolean active;
	private int group_number;
	public GEM()
	{
		gem_name = null;
		support = false;
		//active = false;
		group_number=-1;
	}
	
	public boolean isNameEqual(GEM gem1, GEM gem2)
	{
		if(gem1.getGem_name().equals(gem2.getGem_name()))
		{
			return true;
		}else
			return false;
	}
	
	public boolean isSupport() {
		return support;
	}
	public void setSupport(boolean support) {
		this.support = support;
	}
	public String getGem_name() {
		return gem_name;
	}
	public void setGem_name(String gem_name) {
		this.gem_name = gem_name;
	}
	/*
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	*/
	public int getGroup_number() {
		return group_number;
	}
	public void setGroup_number(int group_number) {
		this.group_number = group_number;
	}

	public boolean isAura_herald_curse() {
		return aura_herald_curse;
	}

	public void setAura_herald_curse(boolean aura_herald_curse) {
		this.aura_herald_curse = aura_herald_curse;
	}

	public String getSocketed_item_inventory_id() {
		return Socketed_item_inventory_id;
	}

	public void setSocketed_item_inventory_id(String socketed_item_inventory_id) {
		Socketed_item_inventory_id = socketed_item_inventory_id;
	}

}
