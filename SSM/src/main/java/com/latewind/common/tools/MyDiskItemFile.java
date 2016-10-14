package com.latewind.common.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.management.loading.PrivateClassLoader;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemHeaders;

public class MyDiskItemFile implements FileItem {
	private String pathName;
	private File file;
	private String name;
	public MyDiskItemFile(String pathName) {
		
		this.pathName=pathName;
		// Auto-generated constructor stub
	}
	public  MyDiskItemFile(File file) {
		// Auto-generated constructor stub
		this.file=file;
		this.name=file.getName();
		this.pathName=file.getAbsolutePath();
	}
	@Override
	public FileItemHeaders getHeaders() {
		//  Auto-generated method stub
		return null;
	}

	@Override
	public void setHeaders(FileItemHeaders paramFileItemHeaders) {
		//  Auto-generated method stub

	}

	@Override
	public InputStream getInputStream() throws IOException {
		//  Auto-generated method stub
		FileInputStream fis=new FileInputStream(pathName);
		
		return fis;
	}

	@Override
	public String getContentType() {
		//  Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		//  Auto-generated method stub
		File file=new File(pathName);
		return file.getName();
	}

	@Override
	public boolean isInMemory() {
		
		//  Auto-generated method stub
		return true;
	}

	@Override
	public long getSize() {
		//  Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] get() {
		//  Auto-generated method stub
		return null;
	}

	@Override
	public String getString(String paramString) throws UnsupportedEncodingException {
		//  Auto-generated method stub
		return null;
	}

	@Override
	public String getString() {
		//  Auto-generated method stub
		return null;
	}

	@Override
	public void write(File paramFile) throws Exception {
		//  Auto-generated method stub

	}

	@Override
	public void delete() {
		//  Auto-generated method stub

	}

	@Override
	public String getFieldName() {
		//  Auto-generated method stub
		return pathName;
	}

	@Override
	public void setFieldName(String paramString) {
		//  Auto-generated method stub

	}

	@Override
	public boolean isFormField() {
		//  Auto-generated method stub
		return false;
	}

	@Override
	public void setFormField(boolean paramBoolean) {
		//  Auto-generated method stub

	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		//  Auto-generated method stub
		return null;
	}

}
