/**
 * 
 */
package com.latewind.common.tools;

/**
 * @author Administrator
 *
 */
public class FileUtil {
	/**
	 * 
	 * @param filename
	 * @return
	 */
	public static String getFileSuffix(String filename){
		int pIndex = 0;
//		try{
			pIndex=filename.lastIndexOf(".")+1;	
			
//		}catch(Exception e){
//			return ".jpg";
//		}
		String ext="."+filename.substring(pIndex);
		System.out.println(""+ext);
		return ext;
	}
	
	public static String getNameExcpExt(String filename){
		int pIndex=filename.lastIndexOf(".");	
		String name=filename.substring(0, pIndex);
		System.out.println(""+name);
		return name;
		
	}
	/**
	 * 
	 * 
	 */
	public static String getWEBINFPath(){
		String path=FileUtil.class.getResource("/").getPath();
		 String path2=Thread.currentThread().getContextClassLoader().getResource("").toString(); 
		System.out.println(path);
		path=path.replace("/classes", "");
		System.out.println(path);
		return path;
	}
	public static void  main(String agrs[]) {
		
		getNameExcpExt("1234.test");
		getWEBINFPath();
		getFileSuffix("23232.1212");
		
		
	}

}
