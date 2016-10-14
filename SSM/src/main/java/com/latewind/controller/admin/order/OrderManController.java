package com.latewind.controller.admin.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.latewind.common.constants.CommonConstants;
import com.latewind.pojo.order.OrderInfo;
import com.latewind.service.order.IOrderService;
import com.latewind.service.personal.IPersonalService;

@Controller
public class OrderManController {

@Resource
private IOrderService orderService;

@Resource
private IPersonalService personalService;

@RequestMapping("/admin/orders/viewOrders.html")
public String viewOrders(){
	
//	orderService
		
		return "admin/order/listOrders";
	}

@ResponseBody
@RequestMapping("/admin/ajax/orders/loadOrders")
public Map<String,List> loadOrders(){
	
	Integer totalCount = personalService.getOrderCountByUserId(1, CommonConstants.ALL_ORDERS);//
	List<OrderInfo>	orderList = personalService.getOrderByUserId(1, 0, totalCount,CommonConstants.ALL_ORDERS);
	
	Map<String,List> orders=new HashMap<>();
	
	orders.put("data", orderList);
	
	return orders;
}



@ResponseBody
@RequestMapping(value="/admin/order/ajax/delivery",method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
public String loadPackInfo(Integer orderId){
	
	orderService.updateOrderStatus(orderId, CommonConstants.HAVE_DELIVERY);
	
	return "<span>"+CommonConstants.HAVE_DELIVERY+"</span>";
}


}


