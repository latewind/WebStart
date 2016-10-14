/**
 * 
 */
package com.latewind.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Vector;

import javax.print.attribute.standard.Fidelity;

import com.latewind.service.OrdersService;
import com.latewind.tools.IdentifyCode;
import com.latewind.tools.TypeTransform;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.utility.Execute;

/**
 * @author jhon
 *
 */
public class ShowFigureAction extends ActionSupport{
	
//	private String fid;
//	private InputStream iStream;
//	private OrdersService ordersService;
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	
	 //Í¼Æ¬Á÷  
    private ByteArrayInputStream imageStream;  
    private String        fid;
    private OrdersService ordersService;
    public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public OrdersService getOrdersService() {
		return ordersService;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}

	//sessionÓò  
    private String randomCode ;  
    

	public String getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}
	
	@Override
	public String execute() throws Exception {
		
		
			
			System.out.println("show Figure");
		
			System.out.println(fid);
			fid=(String) ActionContext.getContext().getSession().get("fid");
			System.out.println(fid);
			int i=Integer.valueOf(fid);
			
			imageStream=(ByteArrayInputStream) TypeTransform.ByteToStream(
							ordersService.findOrders(i).getFigure());		
			////////////////
//			IdentifyCode ic=new IdentifyCode();	
//			Vector<Object> vector=ic.CreateImage("n");
//			String  random=(String) vector.get(0);
//			System.out.println(random);
//			randomCode=random;
//			ActionContext actionContext = ActionContext.getContext();
//	        Map session = actionContext.getSession();
//	        session.put("IdentifyCode",random);	
//			setImageStream((ByteArrayInputStream) vector.get(1));
//			System.out.println("IdentifyCode in action");
			
			
//			FileOutputStream fileOutputStream=new FileOutputStream(new File("D:/t3.jpg"));
//			byte[] buf=new byte[1024];
//			while(iStream.read(buf)!=-1){
//				fileOutputStream.write(buf);
//				
//			}
//			fileOutputStream.close();
//			iStream.close();
			
//			System.out.println(ordersService.findOrders(i).getAlloystate()+"12333");
//			TypeTransform.ByteToFile(ordersService.findOrders(i).getFigure(), "D:/568.jpg");

		// TODO Auto-generated method stub
		return SUCCESS;
	}

	/**
	 * @return the iStream
	 */
	
}
