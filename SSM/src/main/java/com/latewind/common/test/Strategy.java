package com.latewind.common.test;

public interface Strategy {
	
	public double doOperation(Double numA, Double numB) ;

}



class OperationAddStrategy implements Strategy{

	@Override
	public double doOperation(Double numA, Double numB) {
		//  Auto-generated method stub
		
		return numA+numB;
		
	}	
	
	
}


class StrategyContext{
	
	private Strategy strategy;
	
	public StrategyContext(Strategy strategy){
		this.strategy=strategy;
		
	}
	Double executeStragy(Double numA,double numB){
		
		
		return strategy.doOperation(numA, numB);
		
	}
	
	
}