package com.latewind.common.constants;

public enum PageEnum {
		INITPAGE(1),
		PAGESIZA(6);
	private int nCode;
	private PageEnum(int ncode){
		
		this.nCode=ncode;
	}
	
	@Override
	public String toString(){
		
		return String.valueOf(this.nCode);
	}
}
