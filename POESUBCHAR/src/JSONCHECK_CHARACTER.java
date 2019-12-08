
import java.io.IOException;
import java.io.StringReader;


import com.google.gson.stream.JsonReader;

public class JSONCHECK_CHARACTER {

	private JsonReader json_reader;

	public JSONCHECK_CHARACTER()
	{
		json_reader = null;
	}
	
	public ACCOUNTCHARACTER read_json(StringReader sr, ACCOUNTCHARACTER character) throws IOException
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
		
		character.check_socketitem_gems();
		/*
		System.out.println("unique");
		for(ITEM temp : character.getUnique_item_list())
		{
			System.out.println(temp.getItem_name());
		}
		System.out.println("Hearld_aura_curse");
		for(String temp : character.getHearld_aura_curse_list())
		{
			System.out.println(temp);
		}
		System.out.println("Active_skill > 4Link");
		for(String temp : character.getActive_skill_list())
		{
			System.out.println(temp);
		}*/
		return character;
	}
	
	
	public void read_item(JsonReader json_reader, ACCOUNTCHARACTER character) throws IOException
	{
		String read_item_temp;
		ITEM temp_item = new ITEM();
		boolean hassocket = false;
		json_reader.beginObject();
		
		while(json_reader.hasNext()==true)
		{
			read_item_temp= json_reader.nextName();
			//System.out.println(read_item_temp);
			if(read_item_temp.equals("frameType"))//유니크 체크
			{
				if(json_reader.nextInt()==3)
				{
					temp_item.setItem_type(3);
				}
				
				
			}
			else if(read_item_temp.equals("sockets"))
			{
				temp_item = this.read_socket(json_reader, temp_item);
				hassocket = true;
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
				char c = 39;
				if(idtemp.contains(String.valueOf(c)))
				{
					idtemp = idtemp.replace("'", String.valueOf(c)+String.valueOf(c));
					
				}
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
			
		}
		
		json_reader.endObject();
		if(temp_item.getItem_type()==3)
		{
			character.add_Unique_item(temp_item);
			
		}
		
		if(!temp_item.getInventoryID().contains("2"))
		{
			if(hassocket)
			{
				character.add_socket_item(temp_item);
			}
			
			
		}
		
		
		
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
		//item.item_Link_Check(sockettemp1);
		item.setSockets(sockettemp1);
		json_reader.endArray();
		return item;
	}

	public ITEM read_socketItems(JsonReader json_reader, ITEM item) throws IOException
	{
		
		json_reader.beginArray();
		while(json_reader.hasNext()==true)
		{
			GEM gem =read_socketgems(json_reader);
			item.add_gems(gem);
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
				String idtemp = json_reader.nextString();
				char c = 39;
				if(idtemp.contains(String.valueOf(c)))
				{
					idtemp = idtemp.replace("'", String.valueOf(c)+String.valueOf(c));
					
				}
				
				temp_gem.setGem_name(idtemp);
			}
			else if(read_temp.equals("socket"))
			{
				temp_gem.setGroup_number(json_reader.nextInt());
			}
			else if(read_temp.equals("properties"))
			{
				temp_gem = read_gem_properties(json_reader,temp_gem);
			}
			else
			{
				json_reader.skipValue();
			}
		}
		json_reader.endObject();
		
		return temp_gem;
	}
	public GEM read_gem_properties(JsonReader json_reader, GEM gem) throws IOException
	{
		
		json_reader.beginArray();

		while(json_reader.hasNext()==true)
		{
			gem =read_gem_properties_in(json_reader, gem);	
		}
			

		json_reader.endArray();
		return gem;
		
	}
	
	public GEM read_gem_properties_in(JsonReader json_reader, GEM gem) throws IOException
	{
		json_reader.beginObject();
		String read_temp=null;
		while(json_reader.hasNext()==true)
		{
			//System.out.println(json_reader.nextString());
			read_temp = json_reader.nextName();
			if(read_temp.equals("name"))
			{
				read_temp=json_reader.nextString();
				if(read_temp.contains("herald")==true || read_temp.contains("Aura") || read_temp.contains("Curse"))
				{
					gem.setAura_herald_curse(true);
					
				}
			}else
			{
				json_reader.skipValue();
			}
		}
		json_reader.endObject();
		return gem;
		
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
