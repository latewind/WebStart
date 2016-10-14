package com.latewind.common.test;

import java.util.HashMap;

import org.springframework.expression.spel.ast.Operator;
/**
 * 简单工厂模式
 * @author Administrator
 *
 */
public abstract class Operation {
	private Double numberA;
	private Double numberB;
	/**
	 * @return the numberB
	 */
	public Double getNumberB() {
		return numberB;
	}
	/**
	 * @param numberB the numberB to set
	 * @return 
	 */
	public  Operation setNumberB(Double numberB) {
		this.numberB = numberB;
		
		
		return this;
	}
	
	public abstract Double getResult();
	/**
	 * @return the numberA
	 */
	public Double getNumberA() {
		return numberA;
	}
	/**
	 * @param numberA the numberA to set
	 * @return 
	 */
	public Operation setNumberA(Double numberA) {
		this.numberA = numberA;
	
	return this;
	}
		
	

}

class OperationAdd extends Operation{

	@Override
	public Double getResult() {
		//  Auto-generated method stub
		return getNumberA()+getNumberB();
	}
	
}

 class OperatorFactory{
	
	 private static HashMap<String, Operation> opertMap=new HashMap<>();
	 
	 public static Operation getOperation(String operation){
		 
		 Operation o=null;
		 switch (operation) {
		case "+":
				o=opertMap.get("+")==null ? new OperationAdd():o;
			break;
		case "*": 
//			o=opertMap.get("+")==null ? new OperationMul():o;
			break;
		default:
			break;
		}
		 return o;
		 
		 
	 }
	 
	 
	
}
 
 class StrateContext{
	private  Operation operation;
	 
	 
	 
 }
 

