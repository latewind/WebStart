/**
 * 
 */
package com.latewind.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;

import org.apache.struts2.ServletActionContext;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.springframework.context.support.StaticApplicationContext;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.latewind.common.ConstantValue;

/**
 * @author Administrator
 *
 */
public class OfficeConvert {
//	private static String  OPENOFFICE_HOME="E:\\Program Files (x86)\\OpenOffice 4";//openOffice路径
//	private static String SWFTOOL_HOME="E:\\Program Files (x86)\\SWFTools";//SWFTools路径
	private File sourceFile; //转换源文件
	private File pdfFile; //PDF目标文件
	private File swfFile;  //SWF目标文件
	private Runtime r;
	

    /** 
         * 将Office文档转换为PDF. 运行该函数需要用到OpenOffice, OpenOffice下载地址为 
         * http://www.openoffice.org/ 
         *  
         * <pre> 
         * 方法示例: 
         * String sourcePath = "F:\\office\\source.doc"; 
         * String destFile = "F:\\pdf\\dest.pdf"; 
         * Converter.office2PDF(sourcePath, destFile); 
         * </pre> 
         *  
         * @param sourceFile 
         *            源文件, 绝对路径. 可以是Office2003-2007全部格式的文档, Office2010的没测试. 包括.doc, 
         *            .docx, .xls, .xlsx, .ppt, .pptx等. 示例: F:\\office\\source.doc 
         * @param destFile 
         *            目标文件. 绝对路径. 示例: F:\\pdf\\dest.pdf 
         * @return 操作成功与否的提示信息. 如果返回 -1, 表示找不到源文件, 或url.properties配置错误; 如果返回 0, 
         *         则表示操作成功; 返回1, 则表示转换失败 
         */  
        public static int office2PDF(String sourceFile, String destFile) {  
            try {  
                File inputFile = new File(sourceFile);  
                if (!inputFile.exists()) {  
                    return -1;// 找不到源文件, 则返回-1  
                }  
                // 如果目标路径不存在, 则新建该路径  
                File outputFile = new File(destFile);  
                if (!outputFile.getParentFile().exists()) {  
                    outputFile.getParentFile().mkdirs();  
                }  
      
                String OpenOffice_HOME =ConstantValue.OPENOFFICE_HOME;//这里是OpenOffice的安装目录, 在我的项目中,为了便于拓展接口,没有直接写成这个样子,但是这样是绝对没问题的  
                // 如果从文件中读取的URL地址最后一个字符不是 '\'，则添加'\'  
                if (OpenOffice_HOME.charAt(OpenOffice_HOME.length() - 1) != '\\') {  
                    OpenOffice_HOME += "\\";  
                }  
                // 启动OpenOffice的服务  
                String command = OpenOffice_HOME  
                        + "program\\soffice.exe -headless -accept=\"socket,host=127.0.0.1,port=8100;urp;\"";  
                Process pro = Runtime.getRuntime().exec(command);  
                // connect to an OpenOffice.org instance running on port 8100  
                OpenOfficeConnection connection = new SocketOpenOfficeConnection(  
                        "127.0.0.1", 8100);  
                connection.connect();  
      
                // convert  
                DocumentConverter converter = new OpenOfficeDocumentConverter(  
                        connection);  
                converter.convert(inputFile, outputFile);  
      
                // close the connection  
                connection.disconnect();  
                // 关闭OpenOffice服务的进程  
                pro.destroy();  
      
                return 0;  
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
                return -1;  
            } catch (ConnectException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
      
            return 1;  
        }  
	/**
	 * 
	 * @param src
	 * @param des
	 */
	public static void pdf2swf(String src,String des){
		String command=ConstantValue.SWFTOOLS_HOME+"\\"+"pdf2swf.exe "+src+" -o "+des+" -T 9";//	
//		Process p=Runtime.getRuntime().exec(command); 
		ExeCMD.exe(command);	
	}
	/**
	 * 将文件从临时文件夹中取走，放入swf文件中
	 */
	
	public static int office2Swf(String srcPath){
		File file=new File(srcPath);
		String fileName=file.getName();
		String parentPath=file.getParent();
		String fileNameNoExt=FileUtil.getNameExcpExt(fileName);
		
		System.out.println(fileName+","+parentPath);
		String docPath=srcPath;
		String pdfPath=parentPath+"\\"+fileNameNoExt+".pdf";
		String swfPath=parentPath+"\\"+fileNameNoExt+".swf";
		System.out.println(docPath);
		System.out.println(pdfPath);
		System.out.println(swfPath);
		//
		office2PDF(docPath, pdfPath);
		pdf2swf(pdfPath, swfPath);
		
		
		return 1;
	}
	
	public static void pdf2swf2(){
		
		
		
		//String path=this.getClass().getClassLoader().getResource("/").getPath();
		//System.out.println(path.toString());
		System.out.println(System.getProperty("user.dir")); 
	
		String path2=ServletActionContext.getServletContext().getRealPath("/");
		String path3=path2+"swf\\";
		System.out.println(path3);
		
		File f=new File(ConstantValue.SWF_TEMP_PATH);
		f.mkdirs();
		OfficeConvert.pdf2swf("E:\\1.pdf",ConstantValue.SWF_TEMP_PATH+"\\1.swf");
		File file=new File(ConstantValue.SWF_TEMP_PATH+"\\1.swf");
		if (file.exists()){
//			file.renameTo(new File(file.getName()));
			file.renameTo(new File(path3+file.getName()));
		}	
		
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OfficeConvert wConvert=new OfficeConvert();
//		wConvert.office2PDF("D:\\1.doc", "D:\\1.pdf");
//		OfficeConvert.office2PDF("E:\\2.doc", "E:\\2.pdf");
//		OfficeConvert.pdf2swf("E:\\2.pdf","E:\\2.swf");
//		OfficeConvert.pdf2swf2();
		
		System.out.println("end");
	}

}
