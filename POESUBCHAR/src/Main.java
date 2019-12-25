
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Scanner;
public class Main {

	
	public static void main(String[] args) 
	{
		/*
		String str = "한글";
		URLEncoder urlencoder;
		try {
			System.out.println(new String(URLEncoder.encode(str, "UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		
		File f = new File("path of exile streamer.txt");
		Scanner sc = null;
		
		try {
			 sc= new Scanner(f);
			while(sc.hasNext()==true)
			{
				System.out.print("insert into streamer(Streamer_name,Streamer_twitchid) values('"+sc.next()+"' ,'"+sc.next()+"');");
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			sc.close();
		}
		*/
		
		
		/*
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/new_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			//jdbc:mysql://localhost:3306/nini_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC


			conn=DriverManager.getConnection(url, "haman92", "poesubchar");
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
*/

		CatchLadder catchladder;
		CatchCHARACTER catchc;
	


		
		while(true)
		{


			long currenttime = System.currentTimeMillis();
			System.out.println(((currenttime/1000)%86400)/3600);
			if((((currenttime/1000)%86400)/3600)==0)
			{

				currenttime = System.currentTimeMillis();

				catchladder = new CatchLadder();
			
				catchladder.run();
				
				//래더 의 캐릭터
				catchc = new CatchCHARACTER(catchladder.getArray(),catchladder.getDate(),catchladder.getvariabletTotal());
				catchc.run();
				
				long currenttime2 = System.currentTimeMillis();
				
				System.out.println("checktime"+(currenttime2-currenttime));
				catchladder = null;
				catchc = null;
			}
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//catchladder.run();
		//catchc.run();
		//catchc.getOneCharacter();
	
		//래더

		//catchladder.getTotal();
	

		
		//return ;
		
	}
}
