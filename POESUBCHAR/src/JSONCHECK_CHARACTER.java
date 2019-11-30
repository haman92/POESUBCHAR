
import java.io.IOException;
import java.io.StringReader;


import com.google.gson.stream.JsonReader;

public class JSONCHECK_CHARACTER {

	private JsonReader json_reader;

	public JSONCHECK_CHARACTER()
	{
		json_reader = null;
	}
	public void read_json(StringReader sr, ACCOUNTCHARACTER character) throws IOException
	{
		String read_temp;
		json_reader = new JsonReader(sr);
		json_reader.beginObject();
		while(json_reader.hasNext()==true)
		{
			read_temp = json_reader.nextName();
			if(read_temp.equals("items"))
			{
				this.read_itemarray(json_reader, character);
			}else
			{
				json_reader.skipValue();
			}
		}
		json_reader.endObject();
	}
	
	/*
	 * Item{
			verified	boolean
			true if the item has not changed since it was linked.
			
			w	number
			Width of the item in inventory tiles.
			
			h	number
			Height of the item in inventory tiles.
			
			ilvl	number
			item level
			
			icon	string
			url to the image of the item
			
			league	string
			league identifier
			
			id	string($uuid)
			elder	boolean
			true if the item can have elder mods (elder background).
			
			shaper	boolean
			true if the item can have shaper mods (shaper background).
			
			fractured	boolean
			true if the item can have fractured mods (fractured background).
			
			sockets	{...}
			name	string
			unique name of the item
			
			typeLine	string
			name of the baseitem (+prefix/suffix if existing)
			
			identified	boolean
			true if the item is identified
			
			corrupted	boolean
			true if the item is corrupted
			
			properties	[...]
			utilityMods	[...]
			explicitMods	[...]
			craftedMods	[...]
			enchantMods	[...]
			fracturedMods	[...]
			flavourText	[...]
			descrText	string
			description
			
			secDescrText	string
			secondary description
			
			frameType	number
			Frame "color" of the item depending on rarity, item type (e.g. gem) etc. Possible values with examples:
			
			0 - normal items
			1 - magic items
			2 - rare items
			3 - unique items
			4 - gems
			Enum:
			Array [ 5 ]
			category	{...}
			x	number
			X coordinate in the specified frame.
			
			y	number
			Y coordinate in the specified frame.
			
			inventoryId	string
			Id of the slot where this item is located. StashX for stash number X. BodyArmour, Flask etc for actual inventory slots.
			
			isRelic	boolean
			true if the item is a relic item (introduced in Legacy league).
			
			socketetedItems	[...]
			socket	number
			Socket index in the parent item in which this item is socketed.
			
			colour	string
			gem colour (originates from attribute requirement):
			
			D - green
			I - blue
			S - red
			G - white
			Enum:
			Array [ 4 ]
			}
			
			need FrameType
			need name
			need socketedItems
			need socktes
			need sockets.group
	 */
	
	public void read_item(JsonReader json_reader, ACCOUNTCHARACTER character) throws IOException
	{
		String read_item_temp;
		ITEM temp_item = new ITEM();
		json_reader.beginObject();
		
		while(json_reader.hasNext()==true)
		{
			read_item_temp= json_reader.nextName();
			//System.out.println(read_item_temp);
			if(read_item_temp.equals("frameType"))//유니크 체크
			{
				if(json_reader.nextInt()==4)
				{
					temp_item.setItem_type(4);
				}
				
				
			}
			else if(read_item_temp.equals("sockets"))
			{
				temp_item = this.read_socket(json_reader, temp_item);
			}
			else if(read_item_temp.equals("inventoryId"))// 부위 체크
			{
				String idtemp = json_reader.nextString();
				temp_item.setInventoryID(idtemp);
				
			}
			else if(read_item_temp.equals("socketedItems"))// 젬 체크
			{
				temp_item = read_socketItems(json_reader, temp_item);
			}
			else if(read_item_temp.equals("name"))//유니크 이름 체크
			{
				String idtemp = json_reader.nextString();
				temp_item.setItem_name(idtemp);
			}
			else if(read_item_temp.equals("typeLine"))// 베이스 타입 체크
			{
				String idtemp = json_reader.nextString();
				temp_item.setItem_base_type(idtemp);
			} else
			{
				json_reader.skipValue();
			}
			/*
			if(read_item_temp.equals("frameType"))
			{
				
			}
			if(read_item_temp.equals("frameType"))
			{
				
			}
			*/
			
		}
		
		if(temp_item.getItem_type()==3)
		{
			character.getUnique_item_list().add(temp_item);
		}
		
		json_reader.endObject();
	}
	public ITEM read_socket(JsonReader json_reader, ITEM item) throws IOException
	{
		String sockettemp;
		String sockettemp1="";
		json_reader.beginArray();
		while(json_reader.hasNext()==true)
		{
			json_reader.beginObject();
			while(json_reader.hasNext()==true)
			{
			
				sockettemp = json_reader.nextName();
				if(sockettemp.equals("group"))
				{
					sockettemp1 = sockettemp1+String.valueOf(json_reader.nextInt());
					
				}else
				{
					json_reader.skipValue();
				}
			}
			
			json_reader.endObject();
		}
		System.out.println(sockettemp1.length());
		System.out.println(sockettemp1);
		item.setSockets(sockettemp1);
		json_reader.endArray();
		return item;
	}

	public ITEM read_socketItems(JsonReader json_reader, ITEM item) throws IOException
	{
		
		json_reader.beginArray();
		while(json_reader.hasNext()==true)
		{
			read_socketgems(json_reader);
		}
		
		json_reader.endArray();
		return item;
	}
	public GEM read_socketgems(JsonReader json_reader) throws IOException
	{
		GEM temp_gem = new GEM();
		String read_temp=null;
		json_reader.beginObject();
		while(json_reader.hasNext())
		{
			read_temp = json_reader.nextName();
			if(read_temp.equals("support"))
			{
				temp_gem.setSupport(json_reader.nextBoolean());
			}
			else if(read_temp.equals("typeLine"))
			{
				temp_gem.setGem_name(json_reader.nextString());
			}
			else if(read_temp.equals("socket"))
			{
				temp_gem.setGroup_number(json_reader.nextInt());
			}else
			{
				json_reader.skipValue();
			}
		}
		json_reader.endObject();
		
		return temp_gem;
	}
	
	public void read_itemarray(JsonReader json_reader, ACCOUNTCHARACTER character) throws IOException
	{
		json_reader.beginArray();
		while(json_reader.hasNext()==true)
		{
			this.read_item(json_reader, character);
		}
		json_reader.endArray();
	}
}
