import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xapp.battle.Battle.BattleResources;
import xapp.battle.Battle.Help;
import xapp.battle.Battle.Sound;
import xapp.battle.Battle.Story;
import xapp.battle.Battle.Talent.Builder;
import xapp.battle.Battle.Task;


public class HelpR {
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
				xapp.battle.Battle.Help.Builder builderR = Help.newBuilder();//.newBuilder();
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
					if("help_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setHelpId(value);// TalentId(value);
					}else if("map_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setMapId(value);// TalentId(value);
					}else if("equipment_id".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setEquipmentId(value);// TalentId(value);
					}else if("build".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setBuild(value);// TalentId(value);
					}else if("base_id".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setBaseId(value);// TalentId(value);
					}else if("exchange_id".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setExchangeId(value);// TalentId(value);
					}else if("towerRes_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setTowerResId(value);// TalentId(value);
					}else if("buy".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setBuy(value);// TalentId(value);
					}else if("drop".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setDropId(value);// TalentId(value);
					}else if("page1".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setPage1(value);// TalentId(value);
					}else if("page2".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setPage2(value);// TalentId(value);
					}else if("page_barracks".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setPageBarracks(value);// TalentId(value);
					}else if("iconMain".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setIconMain(value);// TalentId(value);
					}else if("village_id".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setVillageId(value);// TalentId(value);
					}else if("point_id".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setPointId(value);// TalentId(value);
					}
					//----------------------------------------------------------
					
				}
				
				}
				//----------------------------------------------------------
				builder.addHelp(builderR);
				//----------------------------------------------------------

		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("error i:"+(error_line+1)+"\t"+"error j:"+(error_col+1));

		System.out.println("error:"+e);	}
	}
	
}
