
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
//import java.sql.DriverManager;

public class Main {

	
	public static void main(String[] args)
	{
		CatchLadder catchladder;
		CatchCHARACTER catchc;

		
		
	

		catchladder = new CatchLadder();
	
		long currenttime = System.currentTimeMillis();
		
		//catchladder.run();
		//catchc.run();
		//catchc.getOneCharacter();
		catchladder.run();
		
		catchc = new CatchCHARACTER(catchladder.getArray());
		catchc.run();
		long currenttime2 = System.currentTimeMillis();
		
		System.out.println("checktime"+(currenttime2-currenttime));
		//catchladder.getTotal();
	
		return ;
		
	}
}
