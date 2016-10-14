package com.latewind.common.test;

public class TestDesignPattern {

	public static void main(String args[]){
	//简单工厂模式
	double result=OperatorFactory.getOperation("+").setNumberA((double) 1).setNumberB((double)2).getResult();
	
	
	System.out.println(result);
	//策略模式  区别：工厂模式重点是得到一个对象（拿出来），策略模式重点是实现实现执行策略（下指令，执行）
	StrategyContext sc=new StrategyContext(new OperationAddStrategy());
	System.out.println(sc.executeStragy(1.0, 2.0));
	
	
	
	}
		

}
