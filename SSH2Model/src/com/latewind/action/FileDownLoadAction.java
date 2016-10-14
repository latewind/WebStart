/**
 * 
 */
package com.latewind.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class FileDownLoadAction extends ActionSupport {
	
	private InputStream fileInputStream;
	private String fileName;
	private List<String> fileNames=new ArrayList<String>();
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String download() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(fileName);
		String path=ServletActionContext.getServletContext().getRealPath("/");
		String filePath=path+"WEB-INF/download/"+fileName;
		System.out.println(path+"WEB-INF/download/test.txt");
		File file=new File(filePath);
		
		fileName=file.getName();
		fileInputStream=new FileInputStream(file);
		return SUCCESS;
	}
	public String listFiles(){
		String path=ServletActionContext.getServletContext().getRealPath("/");
		String filePath=path+"WEB-INF/download";
		
	File webFile=new File(filePath);
		File[] files=webFile.listFiles();
		for(File f:files){
			fileNames.add(f.getName());
			System.out.println(f.getName());
	
			
		}
		
		return SUCCESS;
	}
	/**
	 * @return the fileInputStream
	 */
	public InputStream getFileInputStream() {
		return fileInputStream;
	}
	/**
	 * @param fileInputStream the fileInputStream to set
	 */
	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the fileNames
	 */
	public List<String> getFileNames() {
		return fileNames;
	}
	/**
	 * @param fileNames the fileNames to set
	 */
	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	}
	
	
}
