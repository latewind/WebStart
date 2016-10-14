/**
 * 
 */
package com.latewind.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.latewind.tools.FileUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.star.setup.BaseAction;

/**
 * 
 * 文件上传action
 * @author Administrator
 *
 */
public class FileUploadAction extends ActionSupport {
	  private File  the_file;
	   private String the_fileContentType;//格式同上"fileName"+ContentType  
	   private String the_fileFileName;//格式同上"fileName"+FileName  
	   private String savePath;//文件上传后保存的路径
	   private Map<String, Object> dataMap = new HashMap<String, Object>();
	   
	   private String whichFile;
	   
	   
	   
	   private  File shareFile;
	   private String shareFileContentType;
	   private String shareFileName;
	   
	  public String execute() throws Exception{
	    
	    System.out.println("savePath"+getSavePath());
	    //设置存储路径 webcontent下面的upon
	    String path=ServletActionContext.getServletContext().getRealPath("/");    
	    System.out.println(path+"upload416464");   
	    ///
	    savePath=path+"upload";
	    
	    System.out.println(savePath);
	    System.out.println(whichFile+"Which File");
//	     File dir=new File(getSavePath());  
//	     System.out.println(dir.getAbsolutePath());     
//	     //判断是否存在路径
//	          if(!dir.exists()){  
//	              dir.mkdirs();  
//	          }  
	          //当前上传的文件
	          	File file=getThe_file();
	          	System.out.println(file.getName()+"test");
	          	//获得后缀
	          	String  ext =FileUtil.getExtensionName(getThe_fileFileName()); 
	          	//生成新的文件名：UUID
	          	String  newFileName = UUID.randomUUID()+ext;
	          	
	              FileOutputStream fos=new FileOutputStream(getSavePath()+"//"+newFileName);  
	              FileInputStream fis=new FileInputStream(getThe_file());  
	              byte []buffers=new byte[1024];  
	              int len=0;  
	              while((len=fis.read(buffers))!=-1){  
	                  fos.write(buffers,0,len);  
	              }   
	              fos.close();
	              fis.close();
	              Date d=new Date();
	              System.out.println(d.getTime());
	            //  String uploadFileName = getImg_fileFileName();
	              dataMap.put("filename",newFileName);
	              
	              //将文件名：UNID 保存在属性文件里
	    	    Properties properties=new Properties();
	    	    properties.load(new FileInputStream(new File(path+"upload\\"+"filelist.properties")));
	            properties.put(FileUtil.getNameExcpExt(getThe_fileFileName()),FileUtil.getNameExcpExt(newFileName));
	            System.out.println("properties.size="+properties.size());
	            properties.store(new FileOutputStream(new File(path+"upload\\"+"filelist.properties")), new Date().toLocaleString());
	 
	    return SUCCESS;
	  }

	public File getThe_file() {
		return the_file;
	}

	public void setThe_file(File the_file) {
		this.the_file = the_file;
	}

	public String getThe_fileContentType() {
		return the_fileContentType;
	}

	public void setThe_fileContentType(String the_fileContentType) {
		this.the_fileContentType = the_fileContentType;
	}

	public String getThe_fileFileName() {
		return the_fileFileName;
	}

	public void setThe_fileFileName(String the_fileFileName) {
		this.the_fileFileName = the_fileFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	/**
	 * @return the whichFile
	 */
	public String getWhichFile() {
		return whichFile;
	}

	/**
	 * @param whichFile the whichFile to set
	 */
	public void setWhichFile(String whichFile) {
		this.whichFile = whichFile;
	}

	/**
	 * @return the shareFile
	 */
	public File getShareFile() {
		return shareFile;
	}

	/**
	 * @param shareFile the shareFile to set
	 */
	public void setShareFile(File shareFile) {
		this.shareFile = shareFile;
	}

	/**
	 * @return the shareFileContentType
	 */
	public String getShareFileContentType() {
		return shareFileContentType;
	}

	/**
	 * @param shareFileContentType the shareFileContentType to set
	 */
	public void setShareFileContentType(String shareFileContentType) {
		this.shareFileContentType = shareFileContentType;
	}

	/**
	 * @return the shareFileName
	 */
	public String getShareFileName() {
		return shareFileName;
	}

	/**
	 * @param shareFileName the shareFileName to set
	 */
	public void setShareFileName(String shareFileName) {
		this.shareFileName = shareFileName;
	}
}