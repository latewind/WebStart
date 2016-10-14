package com.latewind.common.tools;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MathOperation {
	
	/**
	 * 对list中数值，随机序列
	 * @param list
	 * @param listNum
	 * @return
	 */
	public static< E > Set<E> getRandomSequence(List<E> list,Integer listNum){
		
		Random random = new Random();
		Set<E> randomSet = new LinkedHashSet<E>();
		Integer length=list.size();
		if (listNum>length||listNum==null){
			listNum=length;
		}
		for (Integer i = 0; i < listNum; i++) {
			// logger.info(random.nextInt(57));
			Integer nextIndex=random.nextInt(length);
			if (!randomSet.add(list.get(nextIndex))) {
				i--;
			}
		}
		return randomSet;
	}

}
