package com.latewind.common.tools;

import java.io.Serializable;
import java.util.ArrayList;

import com.latewind.common.constants.CommonConstants;
import com.latewind.common.constants.PageEnum;

/**
 * 分页
 */
public class Page implements Serializable {

	private static final long serialVersionUID = -3198048449643774660L;

	private int pageNow = 1; // 当前页数

	private int pageSize = CommonConstants.PAGE_SIZE; // 每页显示记录的条数

	private int totalCount; // 总的记录条数

	private int totalPageCount; // 总的页数

	@SuppressWarnings("unused")
	private int startPos; // 开始位置，从0开始

	@SuppressWarnings("unused")
	private boolean hasFirst;// 是否是首页

	@SuppressWarnings("unused")
	private boolean hasPre;// 是否有前一页

	@SuppressWarnings("unused")
	private boolean hasNext;// 是否有下一页

	@SuppressWarnings("unused")
	private boolean hasLast;// 是否是最后一页
	
	@SuppressWarnings("unused")
	private ArrayList<Integer> pagination=new ArrayList<>();//分页
	
	/**
	 * 通过构造函数 传入  总记录数  和  当前页
	 * @param totalCount
	 * @param pageNow
	 */
	public Page(int totalCount, int pageNow) {
		this.totalCount = totalCount;
		this.pageNow = checkPageNow(pageNow);
	}
	//监测
	private int checkPageNow(int pageNow){
		
		if(pageNow<1){
			return 1;
		}
		if(pageNow>getTotalPageCount()){
			return getTotalPageCount();
		}
		return pageNow;
	}
	
	/**
	 * 取得总页数，总页数=总记录数/总页数
	 * @return
	 */
	public int getTotalPageCount() {
		totalPageCount = getTotalCount() / getPageSize();
		return (totalCount % pageSize == 0) ? totalPageCount
				: totalPageCount + 1;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * 取得选择记录的初始位置
	 * @return
	 */
	public int getStartPos() {
		return (pageNow - 1) * pageSize;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	/**
	 * 是否是第一页
	 * @return
	 */
	public boolean isHasFirst() {
		return (pageNow == 1) ? false : true;
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	/**
	 * 是否有首页
	 * @return
	 */
	public boolean isHasPre() {
		// 如果有首页就有前一页，因为有首页就不是第一页
		return isHasFirst() ? true : false;
	}

	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}
	/**
	 * 是否有下一页
	 * @return
	 */
	public boolean isHasNext() {
		// 如果有尾页就有下一页，因为有尾页表明不是最后一页
		return isHasLast() ? true : false;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	/**
	 * 是否有尾页
	 * @return
	 */
	public boolean isHasLast() {
		// 如果不是最后一页就有尾页
		return (pageNow < getTotalPageCount()) ? true : false;
	}

	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
	/**
	 * @return the pagination
	 */
	public ArrayList<Integer> getPagination() {
		return pagination(getPageNow(), getTotalPageCount());
	}

	/**
	 * @param pagination the pagination to set
	 */
	public void setPagination(ArrayList<Integer> pagination) {
		this.pagination = pagination;
	}
	
	public ArrayList<Integer> pagination ( Integer page, Integer pages ) {
		
		ArrayList<Integer>	numbers = new ArrayList<Integer>();
		Integer	buttons =7;
		Integer half = (int) Math.floor( buttons / 2 ),	i = 1;
	
		if ( pages <= buttons ) {
			numbers = range( 1		
			, pages );
		}
		else if ( page <= half ) {
			numbers = range( 1, buttons-2 );
			numbers.add( -1 );
			numbers.add( pages );
		}
		else if ( page >= pages - 1 - half ) {
			numbers = range( pages-(buttons-3), pages );
			numbers.add(0, -1);
//			numbers.splice( 0, 0, 'ellipsis' ); // no unshift in ie6
			numbers.add(0,1);
		}
		else {
			numbers = range( page-half+3, page+half-1 );
			numbers.add( -1);
			numbers.add( pages );
			numbers.add(0, -1);
			numbers.add(0,1);		}
		return numbers;
	}
	
	private ArrayList<Integer> range ( Integer len, Integer start )
	{
		ArrayList<Integer> out = new ArrayList<>();
		Integer end;
	
		if ( start == null ) {
			start = 0;
			end = len;
		}
		else {
			end = start;
			start = len;
		}
	
		for ( Integer i=start ; i<=end ; i++ ) {
			out.add(i);
		}
	
		return out;
	};
}
