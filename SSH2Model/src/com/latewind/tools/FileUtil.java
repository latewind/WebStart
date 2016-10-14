/**
 * 
 */
package com.latewind.tools;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.sun.star.presentation.ParagraphTarget;

/**
 * @author Administrator
 *
 */
public class FileUtil {
	/**
	 * 获取文件后缀名
	 * @param filename
	 * @return
	 */
	public static String getExtensionName(String filename){
		
		int pIndex=filename.lastIndexOf(".")+1;	
		String ext="."+filename.substring(pIndex);
		System.out.println("文件后缀名为"+ext);
		return ext;
	}
	
	public static String getNameExcpExt(String filename){
		int pIndex=filename.lastIndexOf(".");	
		String name=filename.substring(0, pIndex);
		System.out.println("文件名去后缀名为"+name);
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
		
		
	}

}
