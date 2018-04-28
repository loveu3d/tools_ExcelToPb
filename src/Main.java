import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import xapp.battle.Battle;
import xapp.battle.Battle.BattleResources;
import xapp.battle.Battle.Talent;
import xapp.battle.Battle.Talent.Builder;
import xapp.battle.Battle.Task;



public class Main {

	public static void main(String[] args) 
	{
	
		
		//all export sheet name

		
			//declare pb object
			BattleResources.Builder builder = BattleResources.newBuilder();
			
			//talent
			String path_xls ="/Developer/cocos2d-x-3.6/Project/PaPaRoom/tools/JavaExcel2PB/xls/";
			//---------------------------------------------------------
			TalentR.bulid_resource(builder,path_xls,"Talent");//
			SoundR.bulid_resource(builder,path_xls,"Sound");//
			StoryR.bulid_resource(builder,path_xls,"Story");//
			TaskR.bulid_resource(builder,path_xls,"Task");//
			SceneR.bulid_resource(builder,path_xls,"Scene");//
			ShopR.bulid_resource(builder,path_xls,"Shop");//
			
			AchievementR.bulid_resource(builder,path_xls,"Achievement");
			ArmsR.bulid_resource(builder,path_xls,"Arms");
			BetR.bulid_resource(builder,path_xls,"Bet");
			BuildR.bulid_resource(builder,path_xls,"Build");
			GatherR.bulid_resource(builder,path_xls,"Gather");
			GuideR.bulid_resource(builder,path_xls,"Guide");
			HelpR.bulid_resource(builder,path_xls,"Help");
			ItemR.bulid_resource(builder,path_xls,"Item");
			MonsterR.bulid_resource(builder,path_xls,"Monster");
			PageInfoR.bulid_resource(builder,path_xls,"PageInfo");
			ResourceR.bulid_resource(builder,path_xls,"Resource");
			TowerR.bulid_resource(builder,path_xls,"Tower");//

			//---------------------------------------------------------

			//
			BattleResources brs = builder.build();
			//输出所有打表文件
			System.out.println("Export @:"+brs.toString());
			
			byte[] bs = brs.toByteArray();
//			String path ="/Developer/cocos2d-x-3.6/Project/PaPaRoom/tools/JavaExcel2PB/";
			String path ="/Developer/cocos2d-x-3.6/Project/PaPaRoom/Resources/bin/" ;

			String data ="battle.bin";
			try {
				writeFile(path,data,bs);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			System.out.println("Export @:"+path+data);
		
		
	}

	

	static public void writeFile(String path,String fileName,byte[] bytes) throws IOException
	{
		String fullName = path+fileName;
    		File file = new File(fullName);
    		if(file.exists()){
    		file.delete();
    		}

        FileOutputStream fs = new FileOutputStream(fullName);
        fs.write(bytes);
        fs.flush();
        fs.close();
	}

	

}
