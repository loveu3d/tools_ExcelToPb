import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xapp.battle.Battle.BattleResources;
import xapp.battle.Battle.Talent;
import xapp.battle.Battle.Talent.Builder;


public class TalentR {
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
				Builder builderR = Talent.newBuilder();
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
					if("talent_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setTalentId(value);
					}else if("page".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setPage(value);
					}else if("map".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setMap(value);
					}else if("head".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setHead(value);
					}else if("up".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setUp(value);
					}
//                    else if("cost_id_2".equals(headValue))
//					{
//						int value = PoiUtils.getInt(cell);
//						builderR.setCostId2(value);
//					}else if("cost_num_2".equals(headValue))
//					{
//						int value = PoiUtils.getInt(cell);
//						builderR.setCostNum2(value);
//					}else if("cost_id_3".equals(headValue))
//					{
//						int value = PoiUtils.getInt(cell);
//						builderR.setCostId3(value);
//					}else if("cost_num_3".equals(headValue))
//					{
//						int value = PoiUtils.getInt(cell);
//						builderR.setCostNum3(value);
//					}
                    else if("name".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setName(value);
					}else if("ability".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setAbility(value);
					}else if("cost_id".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setCostId(value);
					}else if("cost_num".equals(headValue))
					{
						String value = PoiUtils.getString(cell);// (int)cell.getNumericCellValue();
						builderR.setCostNum(value);
					}else if("type".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setType(value);
					}else if("num".equals(headValue))
					{
						String value = PoiUtils.getString(cell);// (int)cell.getNumericCellValue();
						builderR.setNum(value);
					}else if("png".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setPng(value);
					}
					//----------------------------------------------------------
					
				}
				
				}
				//----------------------------------------------------------
				builder.addTalent(builderR);
				//----------------------------------------------------------

		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("error i:"+(error_line+1)+"\t"+"error j:"+(error_col+1));

		System.out.println("error:"+e);	}
	}
	
}
