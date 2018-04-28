

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

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

import xapp.battle.Battle.Achievement;


public class __main {
	//读取xls的路径
	final static String load_xls ="/Developer/cocos2d-x-3.6/Project/PaPaRoom/tools/JavaExcel2PB/xls/";
	//读取pb的路径
	final static String load_pb ="/Users/liumingliang/Desktop/JavaExcel2PB/battle.proto";
	//1 pb文件message名，2 xls的名，3 xls中sheet名 必须完全一致
	final static String xls_name="Build,Sound,Achievement,Talent,Story,Task,Scene,Shop,Arms,Bet,Gather,Guide,Help,Item,Monster,PageInfo,Resource,Tower";
	//输出的二进制
	final static String output_path ="/Developer/cocos2d-x-3.6/Project/PaPaRoom/Resources/bin/battle.bin" ;

	
	public static void main(String[] args) 
	{
			PbParseManager.getInstance().parse(load_pb);
    		//all export sheet name
		
			//declare pb object
//			BattleResources.Builder builder = BattleResources.newBuilder();
//			Class stuClass2 = builder.getClass();//获取Class对象  
//	        System.out.println(stuClass2.getName());  
	        
			String strClassName ="xapp.battle.Battle$BattleResources$Builder";
			Object obj2=null;
			Class<?> stuClass3 = null;
			try {
				stuClass3 = Class.forName(strClassName);
			    //打印所有构造方法
		        Constructor[] conArray = stuClass3.getDeclaredConstructors();  
		        conArray[1].setAccessible(true);//暴力访问(忽略掉访问修饰符)  
		        obj2 = conArray[1].newInstance(); 
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    
			
	        String[] res = xls_name.split(",");
	        for (String it : res) {
				bulid_resource(stuClass3,obj2,load_xls,it);
	        }

			//talent
			//---------------------------------------------------------
			/*
			TalentR.bulid_resource(builder,load_xls,"Talent");//
			SoundR.bulid_resource(builder,load_xls,"Sound");//
			StoryR.bulid_resource(builder,load_xls,"Story");//
			TaskR.bulid_resource(builder,load_xls,"Task");//
			SceneR.bulid_resource(builder,load_xls,"Scene");//
			ShopR.bulid_resource(builder,load_xls,"Shop");//
			AchievementR.bulid_resource(builder,load_xls,"Achievement");
			ArmsR.bulid_resource(builder,load_xls,"Arms");
			BetR.bulid_resource(builder,load_xls,"Bet");
			BuildR.bulid_resource(builder,load_xls,"Build");
			GatherR.bulid_resource(builder,load_xls,"Gather");
			GuideR.bulid_resource(builder,load_xls,"Guide");
			HelpR.bulid_resource(builder,load_xls,"Help");
			ItemR.bulid_resource(builder,load_xls,"Item");
			MonsterR.bulid_resource(builder,load_xls,"Monster");
			PageInfoR.bulid_resource(builder,load_xls,"PageInfo");
			ResourceR.bulid_resource(builder,load_xls,"Resource");
			TowerR.bulid_resource(builder,load_xls,"Tower");//
*/
			//---------------------------------------------------------

			BattleResources brs = ((BattleResources.Builder)obj2).build();
			//输出所有打表文件
			//System.out.println("Export @:"+brs.toString());
			
			byte[] bs = brs.toByteArray();

			try {
				writeFile(output_path,bs);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			System.out.println("Export @:"+output_path);
		
		
	}

	

	static public void writeFile(String path,byte[] bytes) throws IOException
	{
		String fullName = path;
    		File file = new File(fullName);
    		if(file.exists()){
    		file.delete();
    		}

        FileOutputStream fs = new FileOutputStream(fullName);
        fs.write(bytes);
        fs.flush();
        fs.close();
	}

	public static void bulid_resource(Class stuClass3,Object builder,String pathR,String SHEET_NAME)
	{
		int error_line=-1;
		int error_col=-1;
		

		//cell for FSM sheet
		String path_xls=pathR +SHEET_NAME+".xls";
	
		//read xls
		InputStream in;
		try {
		in = new FileInputStream(new File(path_xls));

		HSSFWorkbook book = new HSSFWorkbook(in);
		
		//export battle.fsm
		HSSFSheet sheet =book.getSheet(SHEET_NAME);// book. getSheetAt(0);
		
//		String sheetName = sheet.getSheetName();

		

		
		
        
		int num = sheet.getLastRowNum();		
		
		System.out.println("exporting ->"+SHEET_NAME);
		
		for(int i = 0;i<num+1;i++)
		{
			
				error_line=i;
				if(i==0||i==1){continue;};
				//----------------------------------------------------------
//				xapp.battle.Battle.Achievement.Builder builderR = Achievement.newBuilder();//.newBuilder();
//				xapp.battle.Battle.Achievement.Builder
				//----------------------------------------------------------
				boolean isError=false;

				//打印需要反射的类名称
//				xapp.battle.Battle.Achievement.Builder builderR2 = Achievement.newBuilder();//.newBuilder();
//		        Class stuClass2 = builderR2.getClass();//获取Class对象  
//		        System.out.println(stuClass2.getName());  
				String strClassName ="xapp.battle.Battle$"+SHEET_NAME+"$Builder";
//				Class<?> stuClass = Class.forName("xapp.battle.Battle$Achievement$Builder");  
				Class<?> stuClass = Class.forName(strClassName);
		        //打印所有构造方法
		        Constructor[] conArray = stuClass.getDeclaredConstructors();  
//		        for(Constructor c : conArray){  
//		            System.out.println(c);  
//		        }  
		        conArray[1].setAccessible(true);//暴力访问(忽略掉访问修饰符)  
		        Object obj2 = conArray[1].newInstance(); 
		        
		        
				HSSFRow row = sheet.getRow(i);
				if(row==null) continue;
				int colNumber = row.getLastCellNum();
				for(int j=0;j<colNumber;j++)//每一数列进行查询
				{
					if(i+1==7&&
							j+1==14)
					{
						int a=0;
						int b=0;
						a=b;
					}
					error_col=j;
					HSSFCell cellHeader = sheet.getRow(0).getCell(j);
					if(cellHeader==null)//if exsist the black cell 
					{
						
						continue;
					}
					String headValue = cellHeader.getStringCellValue();
					if(headValue.equals(""))
					{
						System.out.print("warning xls表没有定义表头<i行:"+(error_line+1)+""+"j列:"+(error_col+1)+"> 。 ");
						isError=true;
						break;
					}
					
					HSSFCell cell = row.getCell(j);
					
				if(cell!=null)
				{				
					if(cell.toString().equals(""))
					{
//						//如果title没有定义字段，直接跳出
//						if(j==0)
//						{
//							break;
//						}
						continue;
					}
					//----------------------------------------------------------
			    


			        
			        PbParseManager pm = PbParseManager.getInstance();
//			        String valueType =   pm.getType(SHEET_NAME, headValue);
			        
			    	String str =PbParseManager.getInstance().upperHeaderChar(headValue);
//				    xapp.battle.Battle.Talent.Builder build = null ;
//				    build.setTalentId(value);
			        String str2 ="set"+str;
			        boolean isWarning=false;
			        boolean isInt =true;
			        try{
			        	 stuClass.getMethod(str2, int.class);
			        }catch(Exception e){
			        	try{
			        	isInt=false;
			        	 stuClass.getMethod(str2, String.class);
			        	}catch(NoSuchMethodException e2){
			        		System.out.print("warning pb没有定义生成字段<"+headValue+">因此找不到方法"+str2+"。 ");
			        		isWarning=true;
			        	}
			        }
			        if(isWarning) 
			        {
			        	continue;
			        }

			    	int _valueInt ;
					String _valueString ;
					
			        Method m ;
			        if(isInt){//valueType.equals("0")
			           m= stuClass.getMethod(str2, int.class);  //			        Method m2 = stuClass.getMethod(str2, int.class);  
			         _valueInt = PoiUtils.getInt(cell);
				        m.invoke(obj2, _valueInt); 
			        }else{
				        m= stuClass.getMethod(str2, String.class);  //			        Method m2 = stuClass.getMethod(str2, int.class);  
			        	_valueString = PoiUtils.getString(cell);
					    m.invoke(obj2, _valueString); 
			        	
			        }
				
				}
				
				}
				//----------------------------------------------------------
				//----------------------------------------------------------
//				BattleResources.Builder builder0 = BattleResources.newBuilder();
//				xapp.battle.Battle.Achievement.Builder builderR = Achievement.newBuilder();//.newBuilder();
//				builder0.addAchievement(builderR);

				
//				xapp.battle.Battle$Talent$Builder
				String str3 ="add"+SHEET_NAME;
		        Method m3 = stuClass3.getMethod(str3, stuClass);  
			    m3.invoke(builder,obj2); //xapp.battle.Battle$Talent$Builder@1c72da34


//			    BattleResources.Builder builder4;
//			    xapp.battle.Battle.Achievement.Builder builderR2;// = Achievement.newBuilder();//.newBuilder();
//			    com.google.protobuf.GeneratedMessage m33;
//			    builder4.addAchievement(builderR2);
//			    builder4.addTalent(value)
		}
//		xapp.battle.Battle.Sound.Builder sound;
//		sound.set
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("xls表 错误error i行:"+(error_line+1)+"\t"+"j列:"+(error_col+1));

		System.out.println("error:"+e);	}
	}

}
