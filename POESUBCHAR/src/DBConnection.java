import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {

	private Connection conn;
	private Statement state;
	private Statement state2;
	private ResultSet rs;
	private ResultSet rs2;
	private ArrayList<PARAM>[] arr1;//active
	private ArrayList<PARAM>[] arr2;//aura
	ArrayList<TotalPARAM> arr3;
	private String[] classes = {
			"Ascendant",
			"Assassin",
			"Berserker",
			"Champion",
			"Chieftain",
			"Deadeye",
			"Elementalist",
			"Gladiator",
			"Guardian",
			"Hierophant",
			"Inquisitor",
			"Juggernaut",
			"Necromancer",
			"Occultist",
			"Pathfinder",
			"Raider",
			"Saboteur",
			"Slayer",
			"Trickster",
	};
	private String[] classes1 =
		{
				"asc",
				"ass",
				"ber",
				"cha",
				"chi",
				"dea",
				"ele",
				"gla",
				"gua",
				"hie",
				"inq",
				"jug",
				"nec",
				"occ",
				"pat",
				"rai",
				"sab",
				"sla",
				"tri"	
		};
	public DBConnection()
	{
		this.conn=null;
		this.state = null;
		this.rs= null;
		this.arr1 = (ArrayList<PARAM>[])new ArrayList[19];
		this.arr2 = (ArrayList<PARAM>[])new ArrayList[19];
		for(int i =0 ;i<19;i++)
		{
			this.arr1[i]= new ArrayList<PARAM>();
			this.arr2[i]= new ArrayList<PARAM>();
		}
		this.arr3 = new ArrayList<TotalPARAM>();
		
	}

	public boolean connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/new_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			//jdbc:mysql://localhost:3306/nini_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC


			this.conn=DriverManager.getConnection(url, "haman92", "poesubchar");
			//System.out.println("연결성공");
			return true;
		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean insertLabyrinthLadder(int total, int ascendant, int assasin, int berserker, int champion, int chieftain, int deadeye, int elementalist, int guardian, int gladiator, int hierophant, int inquisitor, int juggernaut, int necromancer, int occultist, int raider, int saboteur, int slayer, int trickster,int pathfinder, String labyrinthladderdate)
	{
		try {
			state = this.conn.createStatement();
			String sql="insert into labyrinthladder values ('"+labyrinthladderdate+"',"+String.valueOf(total)+","+String.valueOf(ascendant)+","+String.valueOf(assasin)+","+String.valueOf(berserker)+","+String.valueOf(champion)+","+String.valueOf(chieftain)+","+String.valueOf(deadeye)+","+String.valueOf(elementalist)+","+String.valueOf(guardian)+","+String.valueOf(gladiator)+","+String.valueOf(hierophant)+","+String.valueOf(inquisitor)+","+String.valueOf(juggernaut)+","+String.valueOf(necromancer)+","+String.valueOf(occultist)+","+String.valueOf(raider)+","+String.valueOf(saboteur)+","+String.valueOf(slayer)+","+String.valueOf(trickster)+","+String.valueOf(pathfinder)+");";
			state.executeUpdate(sql);

			state.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}

	}

	public boolean insertpoecharacter(ACCOUNTCHARACTER character,String labyrinthdate)
	{
		try {
			state = this.conn.createStatement();
			String sql="insert into poecharacter values('"+character.getCharacter_name()+"','"+labyrinthdate+"','"+character.getCharacter_ID()+"','"+character.getAccount_name()+"','"+character.getCharacter_class()+"','"+character.getTwitch_ID()+"');";
			state.executeUpdate(sql);

			state.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}

	}

	public boolean insertusing_activegem(ACCOUNTCHARACTER character,String labyrinthdate)
	{
		try {


			for(GEM temp : character.getActive_skill_list())
			{

				String sql="insert into using_activegem values('"+character.getCharacter_name()+"','"+labyrinthdate+"','"+character.getCharacter_class()+"','"+temp.getGem_name()+"','"+temp.getSocketed_item_inventory_id()+"');";

				state = this.conn.createStatement();

				//System.out.println(sql);
				state.executeUpdate(sql);

			}
			state.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
	}
	public boolean insertusing_hearald_curse_aura(ACCOUNTCHARACTER character,String labyrinthdate)
	{
		try {


			for(GEM temp : character.getHearld_aura_curse_list())
			{
				state = this.conn.createStatement();
				String sql="insert into using_herald_curse_aura values('"+character.getCharacter_name()+"','"+labyrinthdate+"','"+character.getCharacter_class()+"','"+temp.getGem_name()+"','"+temp.getSocketed_item_inventory_id()+"');";
				//System.out.println(sql);
				state.executeUpdate(sql);

			}
			state.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
	}
	public boolean insertusing_uniqueitem(ACCOUNTCHARACTER character,String labyrinthdate)
	{
		int flask_count=0;
		String flaskstr=null;
		try {


			for(ITEM temp : character.getUnique_item_list())
			{
				if(temp.getInventoryID().equals("Flask"))
				{
					flask_count++;
					temp.setInventoryID("flask"+String.valueOf(flask_count));
				}
				state = this.conn.createStatement();
				String sql="insert into using_uniqueitem values('"+character.getCharacter_name()+"','"+labyrinthdate+"','"+character.getCharacter_class()+"','"+temp.getItem_name()+"','"+temp.getInventoryID()+"');";
				//System.out.println(sql);
				state.executeUpdate(sql);


			}
			state.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
	}
	public void close()
	{
		try{
			if( this.conn != null && !this.conn.isClosed()){
				this.conn.close();
			}
		}
		catch( SQLException e){
			e.printStackTrace();
		}
	}

	public void insertasc()
	{
		for(int i=0;i<19;i++)
		{


			try {
				state =this.conn.createStatement();
				state2 = this.conn.createStatement();
				String SQL = "select labyrinthladderdate , gemname , count(gemname)	from using_activegem where ascendancy='"+this.classes[i]+"' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)	group by labyrinthladderdate,ascendancy,gemname";
				rs = state.executeQuery(SQL);
				while(rs.next())
				{

					String SQL1 ="insert into ascendancy_activegem_count_"+this.classes1[i]+" values ('"+rs.getString("labyrinthladderdate")+"','"+rs.getString("gemname")+"',"+rs.getInt("count(gemname)")+")";
					System.out.println(SQL1);
					state2.executeUpdate(SQL1);

				}


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public void insertasc1()
	{
		for(int i=0;i<19;i++)
		{


			try {
				state =this.conn.createStatement();
				state2 = this.conn.createStatement();
				String SQL = "select labyrinthladderdate , gemname , count(gemname)	from using_herald_curse_aura where ascendancy='"+this.classes[i]+"' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)	group by labyrinthladderdate,ascendancy,gemname";
				rs = state.executeQuery(SQL);
				while(rs.next())
				{
					String idtemp= rs.getString("gemname");
					char c = 39;
					if(idtemp.contains(String.valueOf(c)))
					{
						idtemp = idtemp.replace("'", String.valueOf(c)+String.valueOf(c));
						
					}
					String SQL1 ="insert into ascendancy_herald_curse_aura_count_"+this.classes1[i]+" values ('"+rs.getString("labyrinthladderdate")+"','"+idtemp+"',"+rs.getInt("count(gemname)")+")";
					System.out.println(SQL1);
					state2.executeUpdate(SQL1);

				}

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public ArrayList<PARAM>[] selectactive()
	{
		PARAM param;
		for(int i=0;i<19;i++)
		{


			try {
				state =this.conn.createStatement();
				state2 = this.conn.createStatement();
				String SQL = "select labyrinthladderdate , gemname , count(gemname)	from using_activegem where ascendancy='"+this.classes[i]+"' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)	group by labyrinthladderdate,ascendancy,gemname";
				rs = state.executeQuery(SQL);
				while(rs.next())
				{
					param = new PARAM();
					String labyrinthladderdate= rs.getString("labyrinthladderdate");
					String gemname = rs.getString("gemname");
					int gemcount = rs.getInt("count(gemname)");
					param.setGemcount(gemcount);
					param.setGemname(gemname);
					param.setLabyrinthladderdate(labyrinthladderdate);
					this.arr1[i].add(param);

				}


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.arr1;
	}
	public ArrayList<PARAM>[] selectaura()
	{
		PARAM param;
		for(int i=0;i<19;i++)
		{


			try {
				state =this.conn.createStatement();
				state2 = this.conn.createStatement();
				String SQL = "select labyrinthladderdate , gemname , count(gemname)	from using_herald_curse_aura where ascendancy='"+this.classes[i]+"' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)	group by labyrinthladderdate,ascendancy,gemname";
				rs = state.executeQuery(SQL);
				while(rs.next())
				{
					param = new PARAM();
					String labyrinthladderdate= rs.getString("labyrinthladderdate");
					String idtemp = rs.getString("gemname");
					char c = 39;
					if(idtemp.contains(String.valueOf(c)))
					{
						idtemp = idtemp.replace("'", String.valueOf(c)+String.valueOf(c));
						
					}
					String gemname = idtemp;
					int gemcount = rs.getInt("count(gemname)");
					
					param.setGemcount(gemcount);
					param.setGemname(gemname);
					param.setLabyrinthladderdate(labyrinthladderdate);
					this.arr2[i].add(param);

				}


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.arr2;
	}
	public TotalPARAM selecttotal()
	{
		TotalPARAM param=null;
		try {
			state =this.conn.createStatement();
			String SQL = "select  labyrinthladderdate, total, ascendant, assasin,  berserker, champion, chieftain,  deadeye,  elementalist,  guardian, gladiator, hierophant, inquisitor,  juggernaut, necromancer, occultist, raider, saboteur, slayer, trickster, pathfinder from labyrinthladder where labyrinthladderdate = (select max(labyrinthladderdate) from labyrinthladder)";
			rs = state.executeQuery(SQL);
			param= new TotalPARAM();
			while(rs.next())
			{
				param.setLabyrinthladderdate(rs.getString("labyrinthladderdate"));
				param.setTotal(rs.getInt("total"));
				param.setAscendant(rs.getInt("ascendant"));
				param.setAssassin(rs.getInt("assasin"));
				param.setBerserker(rs.getInt("berserker"));;
				param.setChampion(rs.getInt("champion"));;
				param.setChieftain(rs.getInt("chieftain"));;
				param.setDeadeye(rs.getInt("deadeye"));;
				param.setElementalist(rs.getInt("elementalist"));;
				param.setGladiator(rs.getInt("guardian"));
				param.setGuardian(rs.getInt("gladiator"));;
				param.setHierophant(rs.getInt("hierophant"));;
				param.setInquisitor(rs.getInt("inquisitor"));;
				param.setJuggernaut(rs.getInt("juggernaut"));
				//necromancer, occultist, raider, saboteur, slayer, trickster, pathfinder
				param.setNecromancer(rs.getInt("necromancer"));
				param.setOccultist(rs.getInt("occultist"));
				param.setPathfinder(rs.getInt("pathfinder"));
				param.setRaider(rs.getInt("raider"));
				param.setSaboteur(rs.getInt("saboteur"));
				param.setSlayer(rs.getInt("slayer"));
				param.setTrickster(rs.getInt("trickster"));
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return param;
	}

}
