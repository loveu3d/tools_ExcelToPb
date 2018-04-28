import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xapp.battle.Battle.BattleResources;
import xapp.battle.Battle.Bet;
import xapp.battle.Battle.Sound;
import xapp.battle.Battle.Story;
import xapp.battle.Battle.Talent.Builder;
import xapp.battle.Battle.Task;


public class BetR {
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
				xapp.battle.Battle.Bet.Builder builderR = Bet.newBuilder();//.newBuilder();
				//----------------------------------------------------------

				HSSFRow row = sheet.getRow(i);
				if(row==null)continue;
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
					if("bet_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setBetId(value);// TalentId(value);
					}else if("bet_name".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setBetName(value);// Page(value);
					}else if("item_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setItemId(value);// TalentId(value);
					}else if("success".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setSuccess(value);// TalentId(value);
					}else if("bet_pro".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setBetPro(value);// TalentId(value);
					}else if("bet_add".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setBetAdd(value);// TalentId(value);
					}else if("bet_change".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setBetChange(value);// TalentId(value);
					}else if("bet_ex".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setBetEx(value);// TalentId(value);
					}else if("event1".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setEvent1(value);// Page(value);
					}else if("des1".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setDes1(value);// Page(value);
					}else if("item_id1".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setItemId1(value);// Page(value);
					}else if("event2".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setEvent2(value);// Page(value);
					}else if("des2".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setDes2(value);// Page(value);
					}else if("item_id2".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setItemId2(value);// Page(value);
					}else if("res_precent".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setResPrecent(value);// TalentId(value);
					}
					//----------------------------------------------------------
					
				}
				
				}
				//----------------------------------------------------------
				builder.addBet(builderR);
				//----------------------------------------------------------

		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("error i:"+(error_line+1)+"\t"+"error j:"+(error_col+1));

		System.out.println("error:"+e);	}
	}
	
}
