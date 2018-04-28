import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xapp.battle.Battle.BattleResources;
import xapp.battle.Battle.Monster;
import xapp.battle.Battle.Sound;
import xapp.battle.Battle.Story;
import xapp.battle.Battle.Talent.Builder;
import xapp.battle.Battle.Task;


public class MonsterR {
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
				xapp.battle.Battle.Monster.Builder builderR = Monster.newBuilder();//.newBuilder();
				//----------------------------------------------------------

				HSSFRow row = sheet.getRow(i);
				
				int colNumber = row.getLastCellNum();
				for(int j=0;j<colNumber;j++)//每一数列进行查询
				{
					if(i+1==46&&j+1==13)
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
					HSSFCell cell = row.getCell(j);
					
				if(cell!=null)
				{
					if(cell.toString().equals(""))
					{
						continue;
					}
					//----------------------------------------------------------
					if("monster_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setMonsterId(value);// TalentId(value);
					}else if("name".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setName(value);// Page(value);
					}else if("pic_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setPicId(value);// TalentId(value);
					}else if("des".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setDes(value);// Page(value);
					}else if("grade".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setGrade(value);// TalentId(value);
					}else if("attack".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setAttack(value);// TalentId(value);
					}else if("hp".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setHp(value);// TalentId(value);
					}else if("speed".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setSpeed(value);// TalentId(value);
					}else if("dodge".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setDodge(value);// TalentId(value);
					}else if("content".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setContent(value);// TalentId(value);
					}else if("good_vs".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setGoodVs(value);// TalentId(value);
					}else if("bad_vs".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setBadVs(value);// TalentId(value);
					}else if("drop1".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setDrop1(value);// Page(value);
					}else if("drop2".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setDrop2(value);// Page(value);
					}else if("drop3".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setDrop3(value);// Page(value);
					}else if("drop4".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setDrop4(value);// Page(value);
					}else if("drop5".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setDrop5(value);// Page(value);
					}else if("drop6".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setDrop6(value);// Page(value);
					}else if("skill_value1".equals(headValue))//dps should be string.............
					{
						int value = PoiUtils.getInt(cell);
						builderR.setSkillValue1(value);// TalentId(value);
					}else if("skill_value2".equals(headValue))//dps should be string.............
					{
						int value = PoiUtils.getInt(cell);
						builderR.setSkillValue2(value);// TalentId(value);
					}else if("skill_value3".equals(headValue))//dps should be string.............
					{
						String value = PoiUtils.getString(cell);
						builderR.setSkillValue3(value);// TalentId(value);
					}else if("skill_type".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setSkillType(value);// TalentId(value);
					}
					//----------------------------------------------------------
					
				}
				
				}
				//----------------------------------------------------------
				builder.addMonster(builderR);
				//----------------------------------------------------------

		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("error i:"+(error_line+1)+"\t"+"error j:"+(error_col+1));

		System.out.println("error:"+e);	}
	}
	
}
