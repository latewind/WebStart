package com.latewind.common.tools;

import java.io.File;

import org.apache.log4j.Logger;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Startable;

public class ImagesSplit6Team {
static Logger logger = Logger.getLogger(ImagesSplit6Team.class);
	
	public static void split(Integer startDirsNum){
		
		
		   File file=new File("D:/Svod/test");
		    File file2=new File("D:/Svod/productImages");
		    String file2Path="D:/Svod/productImages/";
		    File [] oFiles=file.listFiles();
		    Integer i=0;
		    Integer n=0;
		    Integer m=0;
		    for(File f:oFiles){	
		    	if(i%6==0){
		    		n=i/6+startDirsNum;
		        	File temDirs=new File(file2Path+n);
		    		if(!temDirs.exists()){
//		    			temFile.createNewFile();
		    			temDirs.mkdirs();   		
		    		}  	    		
		    	}
		    	       m=i%6+1;
		    		String path=n+"/"+m+".jpg";
		    		File temFile=new File(file2Path+path);
//		    		if(!temFile.exists()){
//		    			temFile.createNewFile();
//		    		}
//		    		File tem2=new File(file2Path+path);
		    		f.renameTo(temFile);
		    		logger.info(path);
		    		logger.info(f.getName());	
		    i++;	   	
		    }		    
	}
	
}
