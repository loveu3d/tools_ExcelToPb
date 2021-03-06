import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xapp.battle.Battle.Achievement;
import xapp.battle.Battle.BattleResources;
import xapp.battle.Battle.Sound;
import xapp.battle.Battle.Story;
import xapp.battle.Battle.Talent.Builder;
import xapp.battle.Battle.Task;

public class AchievementR {
	public static void bulid_resource(BattleResources.Builder builder,String pathR,String SHEET_NAME)
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
//					if(i+1==46&&j+1==13)
//					{
//						int a=0;
//						int b=0;
//						a=b;
//					}
					error_col=j;
					HSSFCell cellHeader = sheet.getRow(0).getCell(j);
					if(cellHeader==null)//if exsist the black cell 
					{
						continue;
					}
					String headValue = cellHeader.getStringCellValue();
					HSSFCell cell = row.getCell(j);
					
				if(cell!=null)
				{
					if(cell.toString().equals(""))
					{
						continue;
					}
					//----------------------------------------------------------
			    


			        
			        PbParseManager pm = PbParseManager.getInstance();
			        String valueType =   pm.getType(SHEET_NAME, headValue);
			        
			    	String str =PbParseManager.getInstance().upperHeaderChar(headValue);
//				    xapp.battle.Battle.Achievement.Builder build = null ;
//				    build.setId(0);
			        String str2 ="set"+str;
			        
			        boolean isInt =true;
			        try{
			        	 stuClass.getMethod(str2, int.class);
			        }catch(Exception e){
			        	isInt=false;
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
				
			       
//			        int aa =((xapp.battle.Battle.Achievement.Builder)obj2).getId();
//					System.out.println(""+"aa="+aa);
					
//					if("id".equals(headValue))
//					{
//						int value = PoiUtils.getInt(cell);
//						builderR.setId(value);// TalentId(value);
//					}else if("name".equals(headValue))
//					{
//						String value = PoiUtils.getString(cell);
//						builderR.setName(value);// Page(value);
//					}else if("mapid".equals(headValue))
//					{
//						int value = PoiUtils.getInt(cell);
//						builderR.setMapid(value);// TalentId(value);
//					}else if("level".equals(headValue))
//					{
//						int value = PoiUtils.getInt(cell);
//						builderR.setLevel(value);// TalentId(value);
//					}else if("point".equals(headValue))
//					{
//						int value = PoiUtils.getInt(cell);
//						builderR.setPoint(value);// TalentId(value);
//					}else if("des".equals(headValue))
//					{
//						String value = PoiUtils.getString(cell);
//						builderR.setDes(value);// Page(value);
//					}else if("head".equals(headValue))
//					{
//						int value = PoiUtils.getInt(cell);
//						builderR.setHead(value);// TalentId(value);
//					}else if("up".equals(headValue))
//					{
//						int value = PoiUtils.getInt(cell);
//						builderR.setUp(value);// TalentId(value);
//					}else if("type".equals(headValue))
//					{
//						int value = PoiUtils.getInt(cell);
//						builderR.setType(value);// TalentId(value);
//					}else if("num".equals(headValue))
//					{
//						int value = PoiUtils.getInt(cell);
//						builderR.setNum(value);// TalentId(value);
//					}
					//----------------------------------------------------------
					
				}
				
				}
				//----------------------------------------------------------
//				builder.addAchievement(builderR);
				//----------------------------------------------------------
			builder.addAchievement((xapp.battle.Battle.Achievement.Builder)obj2);
	
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("error i:"+(error_line+1)+"\t"+"error j:"+(error_col+1));

		System.out.println("error:"+e);	}
	}
	
}
