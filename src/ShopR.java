import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import xapp.battle.Battle.BattleResources;
import xapp.battle.Battle.Shop;
import xapp.battle.Battle.Sound;
import xapp.battle.Battle.Talent.Builder;


public class ShopR {
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
				xapp.battle.Battle.Shop.Builder builderR = Shop.newBuilder();//.newBuilder();
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
					if("shop_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setShopId(value);// TalentId(value);
					}else if("pic".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setPic(value);// Page(value);
					}else if("name".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setName(value);// Page(value);
					}else if("item_id".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setItemId(value);//(value);// TalentId(value);
					}else if("number".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setNumber(value);// TalentId(value);
					}else if("type".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setType(value);// TalentId(value);
					}else if("priority".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setPriority(value);// TalentId(value);
					}else if("money_id".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setMoneyId(value);// Page(value);
					}else if("money".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setMoney(value);// Page(value);
					}else if("logic".equals(headValue))
					{
						int value = PoiUtils.getInt(cell);
						builderR.setLogic(value);// Page(value);
					}else if("type_progress".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setTypeProgress(value);// Page(value);
					}else if("des".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setDes(value);// Page(value);
					}else if("des2".equals(headValue))
					{
						String value = PoiUtils.getString(cell);
						builderR.setDes2(value);// Page(value);
					}
					//----------------------------------------------------------
					
				}
				
				}
				//----------------------------------------------------------
				builder.addShop(builderR);
				//----------------------------------------------------------

		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("error i:"+(error_line+1)+"\t"+"error j:"+(error_col+1));

		System.out.println("error:"+e);	}
	}
	
}
