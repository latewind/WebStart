/**
 * 
 */
package com.latewind.common.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Administrator
 *
 */
public class ExeCMD {

	/**
	 * ִ��ϵͳ����
	 * @param cmd
	 */
	public static void exe(String cmd){
		
		Runtime runtime=Runtime.getRuntime();
		Process p = null;
		BufferedReader br = null;
		try {
			p = runtime.exec(cmd);
			
			 br= new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String inline;
	        while ((inline = br.readLine()) != null) {
	            System.out.println(inline);
	            
	        }
	       
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			 try {
				br.close();
				p.destroy();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			 //		ExeCMD.exe("ping");
	
	}

}
