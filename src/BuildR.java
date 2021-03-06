import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xapp.battle.Battle.BattleResources;
import xapp.battle.Battle.Build;
import xapp.battle.Battle.Sound;
import xapp.battle.Battle.Story;
import xapp.battle.Battle.Talent.Builder;
import xapp.battle.Battle.Task;


public class BuildR {
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
				xapp.battle.Battle.Build.Builder builderR = Build.newBuilder();//.newBuilder();
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
					if("build_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setBuildId(value);// TalentId(value);
					}else if("name".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setName(value);// Page(value);
					}else if("des".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setDes(value);// Page(value);
					}else if("grade".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setGrade(value);// TalentId(value);
					}else if("up".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setUp(value);// TalentId(value);
					}else if("tips".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setTips(value);// Page(value);
					}else if("cost_w1".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setCostW1(value);// Page(value);
					}else if("cost_value1".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setCostValue1(value);// Page(value);
					}else if("cost_w2".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setCostW2(value);// Page(value);
					}else if("cost_value2".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setCostValue2(value);// Page(value);
					}else if("cost_w3".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setCostW3(value);// Page(value);
					}else if("cost_value3".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setCostValue3(value);// Page(value);
					}
					//----------------------------------------------------------
					
				}
				
				}
				//----------------------------------------------------------
				builder.addBuild(builderR);
				//----------------------------------------------------------

		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("error i:"+(error_line+1)+"\t"+"error j:"+(error_col+1));

		System.out.println("error:"+e);	}
	}
	
}
