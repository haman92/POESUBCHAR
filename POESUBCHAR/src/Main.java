
import java.sql.*;
//import java.sql.DriverManager;

public class Main {

	
	public static void main(String[] args)
	{
		CatchLadder catchladder;
		catchladder = new CatchLadder();
	
		long currenttime = System.currentTimeMillis();
		
		catchladder.run();
		
		long currenttime2 = System.currentTimeMillis();
		
		System.out.println("checktime"+(currenttime2-currenttime));
		//catchladder.getTotal();
		
		return ;
		
	}
}
