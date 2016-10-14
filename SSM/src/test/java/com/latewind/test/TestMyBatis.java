package com.latewind.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.latewind.common.tools.ExcelOperator;
import com.latewind.common.tools.ExeCMD;
import com.latewind.common.tools.MyDiskItemFile;
import com.latewind.common.tools.Page;
import com.latewind.common.tools.PassKeyEncoder;
import com.latewind.pojo.Category;
import com.latewind.pojo.SubCategory;
import com.latewind.pojo.ThirdCategory;
import com.latewind.pojo.TopCategory;
import com.latewind.pojo.User;
import com.latewind.pojo.order.OrderInfo;
import com.latewind.pojo.product.ProductInfo;
import com.latewind.pojo.product.PrtComment;
import com.latewind.service.ICategoryService;
import com.latewind.service.IUserService;
import com.latewind.service.category.ICategoryManService;
import com.latewind.service.category.ISubCategoryService;
import com.latewind.service.category.IThirdCategoryService;
import com.latewind.service.category.ITopCategoryService;
import com.latewind.service.notice.INoticeService;
import com.latewind.service.order.IOrderService;
import com.latewind.service.personal.IPersonalService;
import com.latewind.service.product.IProductService;
import com.latewind.service.sysm.ISystemManService;
import com.latewind.service.user.IUserInfoService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

@RunWith(SpringJUnit4ClassRunner.class)		//��ʾ�̳���SpringJUnit4ClassRunner��
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})

public class TestMyBatis {
  private static Logger logger = Logger.getLogger(TestMyBatis.class);
//	private ApplicationContext ac = null;
  @Resource
  private IUserService userService ;
  
  @Resource
  private ICategoryService categoryService;
  
  @Resource
  private ITopCategoryService topCategoryService;
  
  @Resource
  private ISubCategoryService subCategoryService;
  @Resource
  private  IThirdCategoryService thirdCategoryService;
//  
  @Resource
  private IProductService productService;
  
  
  @Resource
  private ICategoryManService categoryManService;
  
  
  @Resource
  private IUserInfoService userInfoService;


  @Resource 
  private IOrderService orderService;
  
  @Resource
  private IPersonalService personalService;
  
  @Resource
  private INoticeService noticeService;
  
  @Resource 
  private ISystemManService systemManService;
  
  ////	@Before
//	public void before() {
//		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

  
//  @Test
  public void addProduct() throws IOException{
	  
	  
	 List<ProductInfo> list= ExcelOperator.readSheet2("D:/Svod/2014.xlsx",92,122, 7, 3, productService);
//	  DiskFileItemFactory sff=new DiskFileItemFactory(10240, new File("D:/WebDesign/"));
	  
	 File file=new File("D:/Svod/童衣_百度图片搜索");
	File[] files= file.listFiles(new FilenameFilter(){
		
		@Override
		public boolean accept(File dir, String name) {
			//  Auto-generated method stub
			if(name.endsWith(".jpg")){
				return true;
			}
			return false;
		}
		
	});
	System.out.println(files.length);
	CommonsMultipartFile[] picFiles=new CommonsMultipartFile[6];
	int start=0;
	for(ProductInfo p:list){
		
		int i=0;
		for(;i<6;i++,start++){
			
			picFiles[i]=new CommonsMultipartFile(new MyDiskItemFile(files[start]));
			
		}
		if(i==6){
//			productService.addProduct(p.getPrtName(), p.getPrice(), "童衣", p.getNum(), p.getDescrib(), p.getIntro(), "D:/qt/", picFiles);
			
		}else{
			
			break;
		}
		
		System.out.println(start);
	}
	
	  for(File f:files){
		  
		  
		  System.out.println(f.getName());
		  
	  }
//	FileItem fileItem= new MyDiskItemFile("D:/Svod/test/1.jpg");  
//	
//	InputStream is=fileItem.getInputStream();
//	byte[] buf =new byte[1024];
//	FileOutputStream fos=new FileOutputStream("D:/t.jpg");
			

//	while(is.read(buf)!=-1){
//		
//		fos.write(buf);
//	}
//	is.close();
//	fos.close();
	  
  }
  
  
  
  @Test
  public void testController(){
	    MockHttpServletRequest request = new MockHttpServletRequest();
	    MockHttpServletResponse response = new MockHttpServletResponse();
		  
	  
	  
	  
  }
//  @Test
  public void testDate(){
	  
	  String testString="服装 女装 ";
	String[] querys=  testString.split("\\s+");
	Set<String> keywordSet=new HashSet<>();
	
	for(String s:querys){
		keywordSet.add(s);
		System.out.println(s+querys.length);
	}
	
System.out.println(productService.listPrtByKeyWord(keywordSet).toString());

System.out.println(productService.randomListProduct(productService.listPrtByKeyWord(keywordSet), 20));

  }
  
//  @Test
  public void testSalt(){
	  
	 System.out.println( PassKeyEncoder.generateSalt());
	 
	  String salt="bc50c6c027c32043f246e96f5ba3337a";
	  
	 System.out.println(PassKeyEncoder.encodePassword(salt, "123456", "MD5"));
  }
  
  
//  @Test
  public void testSort(){
	  
	  Integer [] arrayInt=new Integer []{49,38,65,97,76,13,27,31};
	  sort(arrayInt, 0, 7);
	  
  for(int show:arrayInt){
		  
		  System.out.println("-------"+show);
	  }
	  
	  
  }
  // 快速排序
  public void sort(Integer[] arrayInt,Integer start,Integer end){
	  Integer i=start,j=end;
	  Integer tem;
	  if(start+1>end){
		  return;
	  }
	  while(i<j){
		  
		  for(;i<j;j--){
			  
			  if(arrayInt[i]>arrayInt[j]){
				  tem=arrayInt[j];
				  arrayInt[j]=arrayInt[i];
				  arrayInt[i]=tem;
				  break;
			  }
			  
		  }
		  
		 for(;i<j;i++){
			 
			  if(arrayInt[j]<arrayInt[i]){
				  tem=arrayInt[i];
				  arrayInt[i]=arrayInt[j];
				  arrayInt[j]=tem;
				  break;
			  }
			 
		 }		  		  		  
	  }
	  System.out.println("start:" +start);
	  System.out.println("i:"+i);
	  System.out.println("end:" +end);
	  sort(arrayInt, start, i-1);
	  sort(arrayInt, j+1, end);
  }
  
  
//  @Test
  public void test5() throws CloneNotSupportedException{
//	 Integer.toString(1, 8); 
	 
	  Integer [] arrayInt=new Integer []{49,38,65,97,76,13,27,31};
	  int len=arrayInt.length;
	  System.out.println(len);
	  int i=0,j=len-1;
	  int start=arrayInt[0];
	  int tem;
	  //once sort
	  
	  while(i!=j){
		  
		  for(;i<j;j--){
			  
			  if(arrayInt[i]>arrayInt[j]){
				  tem=arrayInt[j];
				  arrayInt[j]=arrayInt[i];
				  arrayInt[i]=tem;
				  break;
			  }
			  
		  }
		  
		 for(;i<j;i++){
			 
			  if(arrayInt[j]<arrayInt[i]){
				  tem=arrayInt[i];
				  arrayInt[i]=arrayInt[j];
				  arrayInt[j]=tem;
				  break;
			  }
			 
		 }
	  }
	  for(int show:arrayInt){
		  
		  System.out.println("-------"+show);
	  }
	  
	  System.out.println(arrayInt[i]);
//	 Arrays
	  
//	Headline h=  noticeService.getHeadLine();
//	Headline newh=(Headline) h.clone();  
//	
//	System.out.println(h.hashCode()+"--"+newh.hashCode());
//	newh.setShowStatus(123);
//	System.out.println(h.getShowStatus());
////	newh.setDisplayTime(new Date());
//	System.out.println(h.getDisplayTime().hashCode()+" "+h.getDisplayTime());
//	System.out.println(newh.getDisplayTime().hashCode()+" " + newh.getDisplayTime());
//	
//	System.out.println(systemManService.listFunctionByRole(null, "商品管理员").size());
//	List<SysmFunction> funcList =	systemManService.listAllFunction();
//	
//	List<Integer> list=new LinkedList<>();
//	list.add(2);
//	
//	list.add(3);
	
//	systemManService.addRoleFunction(list, 1);
	
  }

  
//  @Test
  public void test4(){
	List<PrtComment> pc= productService.listPrtCommentByPrtId(1, 0, 2);
	  
	System.out.println(pc.size());
	  
	List<ProductInfo> recmmPrts=productService.randomListProduct(1, 4);
	
	System.out.println(recmmPrts.get(0));
	
	System.out.println(productService.listProductByThirdId(1, null, null).size());
	
  }
  
//  @Test
  public void test3(){
//	List< OrderInfo> olist= orderService.getOrdersByUserIdBase(1);
//	  OrderInfo orderInfo= olist.get(6);
//	  Date d =orderInfo.getCreateTime();
//	  System.out.println(d.getHours());
	  
	 int i= personalService.getOrderByUserId(1, 0, 5,null).size();
  System.out.println(i+"chaojj");
  Page page=new Page(100, 20);
  Integer[] arrays={1,2,3,4,5,6,7,8,45,46,47,48,49,50};
  for(Integer iii:arrays){
 ArrayList<Integer> arrayList= page.pagination(iii, 50);
 
 System.out.println(iii);
 for(Integer ii:arrayList){
	 System.out.print(ii+" ");
 }
 System.out.println(" ");

  }
  
  System.out.println(noticeService.getAnnouncement().size());
  
  System.out.println(categoryManService.getThirdByTop(1).size());
  }
  
//  @Test
  public void testCmd(){
	  
	  ExeCMD.exe("java -jar D:\\Important\\mybatis-generator-core-1.3.2\\lib\\mybatis-generator-core-1.3.2.jar -configfile D:\\Important\\mybatis-generator-core-1.3.2\\lib\\generatorConfig.xml -overwrite ");
	  
  }
  
//  @Test
  public void test2(){
    orderService.getCartByUserId(1);
	  System.out.println("test2");
	 List<ProductInfo> testList= productService.randomListProduct(20);
	 for(ProductInfo i:testList){
		 
		 System.out.println(i.getPrtId());
	 }
	testList=productService.getTopTenByClick(); 
	for(ProductInfo i:testList){
		 
		 System.out.println(i.getPrtId());
	 } 
	
	
//	 productService.test();
	 
	 List<OrderInfo> list= orderService.getOrdersByUserIdBase(1);
	 System.out.println(list);
	
  }
  
//  @Test
  public void test1() throws IOException {
	  

    User user = userService.getUserById(1);
     logger.info("ֵ��"+user.getUserName());
    List<User> list=userService.getAllUser();
    System.out.println(list.size());
    
    Category category=categoryService.getCategoryById(1);
    logger.info(category.getName());
    
    //一级分类Test
    TopCategory topCategory=topCategoryService.geTopCategoryById(1);
    logger.info(topCategory.getName()+topCategory.getSubCategories().size());
    List<SubCategory> subList=topCategory.getSubCategories();
    for(SubCategory sCategory:subList){
    	
    	logger.info("-------------"+sCategory.getName()+"----------");
    	
    }
    List<TopCategory> topCategories=topCategoryService.getAllTop();
    
    logger.info(topCategories.size()+"topCategories");
    
    logger.info(topCategoryService.getAllTopMap().toString());
    
   List<TopCategory> tops= topCategoryService.getAllTop();
    
   for(TopCategory top:tops){
	   
	   List<SubCategory> subs=top.getSubCategories();
	   logger.info("*************"+top.getName());
	   for(SubCategory sub:subs){
		   
		   List<ThirdCategory> thirds=sub.getThirdCategories();
		   logger.info("*********"+sub.getName());
		   	for(ThirdCategory third:thirds){
		   		
		   		logger.info("****************"+third.getName());
		   	}
	   }
	   
   }
   
    
    // 二级分类Test
    SubCategory subCategory=subCategoryService.getSubCategoryById(1);
    logger.info(subCategory.getName()+subCategory.getTopCategory().getName()+subCategory.getThirdCategories().size());
    List<ThirdCategory> thirdList=subCategory.getThirdCategories();
    for(ThirdCategory tCategory:thirdList){
    	
    	logger.info("-------------"+tCategory.getName()+"----------");
    	
    }
    
    List<SubCategory> subCategories=subCategoryService.getAllSub();
    for(SubCategory sub:subCategories){
    	//输出一级分类
    	logger.info(sub.getTopCategory().getName());
    	//输出二级分类
    	logger.info("-----"+sub.getName()+"------topId=" +sub.getTopId());
    	//输出三级分类	
        List<ThirdCategory> thList=sub.getThirdCategories();
        for(ThirdCategory tCategory:thList){
        	
        	logger.info("-------------"+tCategory.getName()+"----------");
        	
        }
    }
    
    // 三级分类Test
    ThirdCategory thirdCategory=thirdCategoryService.geThirdCategoryById(3);
    logger.info(thirdCategory.getName()+thirdCategory.getSubCategory().getName());
    List<ThirdCategory> thirdCategories=thirdCategoryService.getAllThird();
    logger.info(thirdCategories.size());
    logger.info(JSON.toJSONString(user));
//    
    ProductInfo productInfo=productService.getProductInfoById(1);
//    logger.info(""+productInfo.getPrimImage().getImageName());
    logger.info(productInfo.getIntro());
    
    List<ProductInfo> productInfos=productService.randomListProduct(null);
    logger.info(productInfos.size());
    
    Map<String,String> listMap=categoryManService.getProduct123Category(1);
    
    for(Map.Entry<String, String> m:listMap.entrySet()){
    	
    	logger.info(m.getKey()+m.getValue());
    }
    
    
    productInfos=productService.listProductByThirdId(1, null, null);
    logger.info(productInfos);
    
//    logger.info(productInfo.getImages().size());
     
//    ProductImages productImage=new ProductImages();
//    for(Integer i=3;i<100;i++){
//    	for(Integer j=1;j<7;j++){
//    		String path=i+"/"+j+".jpg";
//    		logger.info(path+"----"+i);
//    	    productImage.setImageName(path);
//    	    productImage.setPrtId(i);
//    	    productService.addProductImges(productImage);
////    		logger.info(i);
//    		
//    	}
//    
//    }
  
    //分割图片

    
String stings="Http://localhost:8080/SSM/index/45454/132.jsp";

String [] results=stings.split("/SSM");
stings.indexOf("/SSM");
String ssdfsdf=stings.substring(stings.indexOf("/SSM")+"/SSM".length());
for(String s:results){
	
	System.out.println(s);
}
System.out.println(ssdfsdf);

userInfoService.verifyUserName("lsqwell@sina.com", "123456");

//    ExcelOperator.readSheet2("");
//ProductInfo pInfo=new ProductInfo();
//pInfo.setPrtName("test");
//productService.addProduct(productInfo);  

//ExcelOperator.readSheet2(null, 61, 62, 11, 3, productService);

  }//end test
  @Test
  public void testEhcacheSelData(){
	  ProductInfo productInfo=productService.getProductAllInfoById(1);
	  try {
	
		
		CacheManager cacheManager =CacheManager.create();
		Cache cache=cacheManager.getCache("myCache");
		

		
		Thread.sleep(3000);
	
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  ProductInfo productInfo2=productService.getProductAllInfoById(1);
  }
  
}