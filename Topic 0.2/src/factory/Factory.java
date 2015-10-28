package factory;

import java.util.Hashtable;
import java.util.ResourceBundle;

public class Factory {
	
	private static String bundleName="factory";
	
	public static void setBundlename(String bn){
		bundleName=bn;
	}
	
	public static Object getBuilderInstance(){
		try{
			ResourceBundle rb=ResourceBundle.getBundle(bundleName);
			Object obj = null;
			String sClass = rb.getString("BUILDER"); 
			obj = Class.forName(sClass).newInstance();
			return obj;
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
