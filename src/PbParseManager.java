import java.util.Map;
import java.util.Vector;

//解析定义格式的pb，用来提取定义的字段名称对应的int32或string类型
public class PbParseManager {
	
	static PbParseManager pm=null;
	Vector<Data> m_vector;
	public class Data{
		
		String message_name;
		//1:name ,2:type (0:int32 1:string)
		public Map< String,String> message_body;

	}
	public static PbParseManager getInstance()
	{
		if(pm==null)
		{
			pm = new PbParseManager();
		}
			return pm;
	}
	//将首个字母变成大写
	public String upperHeaderChar(String str)
	{
		String str__=strUpp(str);
		return str__;
	}
	
	public static String strUpp(String s){  
		String[] str = s.split("_");  
		StringBuffer sb = new StringBuffer();  
		for(int i = 0;i < str.length;i++){  
		sb.append(Character.toUpperCase(str[i].charAt(0))).append(str[i].substring(1));  
//		sb.append(" ");
		} 
		return sb.toString();  

	}
		
	public void parse(String path)
	{
		
	}
	
	
	//string=0:int32 string=1:string
	public String getType(String message_name,String key)
	{
		if(true)
		return "0";

		for(int i=0;i<m_vector.size();i++)
		{
			Data data =	m_vector.get(i);

			if(message_name.equals(data.message_name)==true)
			{
			String value =	data.message_body.get(key);
			return value;
			}			
			
		}
		return "0";
	}
	
}
