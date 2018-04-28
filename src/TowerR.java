import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xapp.battle.Battle.BattleResources;
import xapp.battle.Battle.Sound;
import xapp.battle.Battle.Story;
import xapp.battle.Battle.Talent.Builder;
import xapp.battle.Battle.Task;
import xapp.battle.Battle.Tower;


public class TowerR {
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
				xapp.battle.Battle.Tower.Builder builderR = Tower.newBuilder();//.newBuilder();
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
					if("tower_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setTowerId(value);// TalentId(value);
					}else if("map_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setMapId(value);// TalentId(value);
					}else if("name".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setName(value);// Page(value);
					}else if("tile_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setTileId(value);// TalentId(value);
					}else if("area_tower".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setAreaTower(value);// Page(value);
					}else if("monster_res".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setMonsterRes(value);
					}else if("name2".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setName2(value);// Page(value);
					}else if("message2".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setMessage2(value);// Page(value);
					}else if("tower_flag".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setTowerFlag(value);// TalentId(value);
					}else if("task_item".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setTaskItem(value);// TalentId(value);
					}else if("task_count".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setTaskCount(value);// TalentId(value);
					}else if("supply_num".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setSupplyNum(value);// TalentId(value);
					}else if("build_res".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setBuildRes(value);// TalentId(value);
					}else if("build_time".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setBuildTime(value);// TalentId(value);
					}else if("build_num".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setBuildNum(value);// TalentId(value);
					}else if("mark_item_get".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setMarkItemGet(value);// TalentId(value);
					}else if("arm_res".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setArmRes(value);// TalentId(value);
					}else if("monster_drop".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setMonsterDrop(value);// TalentId(value);
					}else if("monster_drop_num".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setMonsterDropNum(value);// TalentId(value);
					}else if("message".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setMessage(value);// TalentId(value);
					}else if("message_end".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setMessageEnd(value);// TalentId(value);
					}
//					else if("monster_des".equals(headValue))
//					{
//						int value = PoiUtils.getInt(cell);
//						builderR.setMonsterDes(value);// TalentId(value);
//					}





					//----------------------------------------------------------
					
				}
				
				}
				//----------------------------------------------------------
				builder.addTower(builderR);
				//----------------------------------------------------------

		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("error i:"+(error_line+1)+"\t"+"error j:"+(error_col+1));

		System.out.println("error:"+e);	}
	}
	
}
