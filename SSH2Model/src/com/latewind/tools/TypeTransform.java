package com.latewind.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tomcat.jni.Buffer;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.springframework.context.support.StaticApplicationContext;

/**
 * 
 * @author latewind
 * ����ת����
 *
 */

public class TypeTransform{

	/**
	 * ���������ֽ�ת��Ϊ ������
	 * @param b �������ֽ�
	 * @return ������
	 */
	public static InputStream ByteToStream(byte[] b){
		
		
		return new ByteArrayInputStream(b);
	}
	/**
	 * ��������ת��Ϊ�ļ�
	 * @param b �������ֽ�
	 * @param filePath Ŀ���ļ�
	 * 
	 */
	public static void ByteToFile(byte[] b,String filePath) {	
		ByteArrayInputStream ByteIput=(ByteArrayInputStream) ByteToStream(b);
		FileOutputStream fo=null;
		byte[] buf=new byte[1024];
		try {
			fo=new FileOutputStream(filePath);			
			while(ByteIput.read(buf)!=-1){
				fo.write(buf);			
				
			}			
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				ByteIput.close();
				fo.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}	
	}
	/**
	 * ���ļ�ת��Ϊbyte[]����
	 * 
	 * @param filePath �����ļ�
	 * @return b ����ֽ�
	 * 
	 */
	public static byte[] FileToByte(String filePath){
		ByteArrayOutputStream bo=new ByteArrayOutputStream(1024);
		FileInputStream fi = null;
		byte []  b=null;
		try {
			fi = new FileInputStream(filePath);
			byte [] buf = new byte[1024];
		
			while(fi.read(buf)!=-1){
			bo.write(buf);
			}
			
			b=bo.toByteArray();
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {

			try {
				fi.close();
				bo.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		}
	
	
				

		return b;
	}
	
	public static void main(String args[]){
		
	//ByteToFile(FileToByte("D:/YK2GXH.jpg"), "D:/t1.jpg");
		
	}
	
}
