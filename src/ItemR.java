import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xapp.battle.Battle.BattleResources;
import xapp.battle.Battle.Item;
import xapp.battle.Battle.Sound;
import xapp.battle.Battle.Story;
import xapp.battle.Battle.Talent.Builder;
import xapp.battle.Battle.Task;


public class ItemR {
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
				xapp.battle.Battle.Item.Builder builderR = Item.newBuilder();//.newBuilder();
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
					if("item_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setItemId(value);// TalentId(value);
					}else if("name".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setName(value);// Page(value);
					}else if("isnot".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setIsnot(value);// TalentId(value);
					}else if("grade".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setGrade(value);// TalentId(value);
					}else if("one".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setOne(value);// TalentId(value);
					}else if("equip".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setEquip(value);// TalentId(value);
					}else if("des".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setDes(value);// Page(value);
					}else if("where".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setWhere(value);// Page(value);
					}else if("type".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setType(value);// TalentId(value);
					}else if("num".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setNum(value);// TalentId(value);
					}else if("money".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setMoney(value);// TalentId(value);
					}else if("up_logic".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setUpLogic(value);// TalentId(value);
					}else if("make_appare".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setMakeAppare(value);// TalentId(value);
					}else if("tips".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setTips(value);// Page(value);
					}else if("cost_id1".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setCostId1(value);// TalentId(value);
					}else if("cost_num1".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setCostNum1(value);// TalentId(value);
					}else if("cost_id2".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setCostId2(value);// TalentId(value);
					}else if("cost_num2".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setCostNum2(value);// TalentId(value);
					}else if("cost_id3".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setCostId3(value);// TalentId(value);
					}else if("cost_num3".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setCostNum3(value);// TalentId(value);
					}else if("sell_num".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setSellNum(value);// TalentId(value);
					}else if("deduct_id1".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setDeductId1(value);// TalentId(value);
					}else if("deduct_num1".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setDeductNum1(value);// TalentId(value);
					}else if("deduct_id2".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setDeductId2(value);// TalentId(value);
					}else if("deduct_num2".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setDeductNum2(value);// TalentId(value);
					}else if("get_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setGetId(value);// TalentId(value);
					}else if("get_num".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setGetNum(value);// TalentId(value);
					}else if("pubitem".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setPubitem(value);// TalentId(value);
					}else if("material".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setMaterial(value);// TalentId(value);
					}else if("taskitem".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setTaskitem(value);// TalentId(value);
					}
					//----------------------------------------------------------
					
				}
				
				}
				//----------------------------------------------------------
				builder.addItem(builderR);
				//----------------------------------------------------------

		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("error i:"+(error_line+1)+"\t"+"error j:"+(error_col+1));

		System.out.println("error:"+e);	}
	}
	
}
