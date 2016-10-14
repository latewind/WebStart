/*!
 LateWind  Tables 1.0.1
 ©2016-2020 SpryMedia Ltd - datatables.net/license
*/
(function($){	 
	 $.fn.lwtables=function(options){
		 var settings = $.extend({}, {open: 1 ,thType:"char,int,double,date,boolean"},options);//接受函数参数，将结果赋给settings
		 var setType=settings.thType.split(",");
		 
		 return this.each(function(){			 
			 var $table=$(this);//预缓存 table tbody th
			 var $tbody=$table.find('tbody');
			 var $th=$table.find('th');		
			 var rows=$tbody.find('tr').get();//将每一行转换为数组//单击 rows.length=0 用来释放内存
			 var oriData=$tbody.find('tr').get();//存放原始数据
			 var  transort=1;//实现正逆排序
			 var selectNum=10;//列表显示数量
			 var startTr=0//初始行
			 var endTr=10;
			 var currentData=$tbody.find('tr').get();;
			 //dbClickOnTd();
			 initTb();
			 /////////////////////////////
			 function searchKey(rows){
				 
				var key=$("#searchInput").val(); 
				var temKey=key.replace(/(^\s*)|(\s*$)/g,"");//去掉头尾空格
				var multKey=temKey.split(/\s{1,}/);//分开关键字
				var result; 
				
				//console.log(key);
				//console.log(multKey.length);
			//	console.log(multKey[0]);
			//	console.log(multKey[1]);

			//	indexOf()
				 console.log("数据总数"+oriData.length);
				currentData.length=0;//初始
				var rult;
				var j=0;
				 $.each(rows,function(index,row){
				result=$(row).find("td").text();
				
					for(var i=0;i<multKey.length;i++){
					rult=result.search(multKey[i]);
					if(rult<0) break;//没找到中断
					if(i==multKey.length-1){//找到了 输出
						//console.log(index);	
						//$(oriData).append(row);
						//currentData[j]=row;
					//	j=j+1;
						currentData.push(row);
						}
					}
					
	
					 
				 });//数组遍历查询结束
				// viewTb(currentData);
				console.log("数据总数"+currentData.length);
				 
			 }
			 
			 function initTb(){	
				 selectAndSearch();	//初始化
				 createPage();
				 viewTb(rows);
				 dbClickOnTd(); 
				 $("#span1").trigger("click");
				 
			 }
	 
			 function dbClickOnTd(){//td 双击事件
				 $("td").each(function(){//遍历每一个格子
					 $(this).dblclick(function(){//双击事件
					 var $td=$(this);
					 var str=$td.text();//预先存储原来的数据
					 var input=$("<input type='text' id='temp'>");
					 input.val(str);//输入框赋值
					 $td.text("");//表格清空
					 $(this).append(input);//添加输入框
					 
					 $("#temp").focus();//输入框获取焦点
					 $("#temp").text(str);
					 $("#temp").blur(function(){//输入框失去焦点
						 str=$("#temp").val();
					      $("#temp").remove();//消除输入框  		
					      $td.text(str);
					     // rows=$tbody.find('tr').get();//更新用其他方法替代
					 });
					 //alert("double click "+str);
				
				 });
					 });
			 }
			 function selectAndSearch(){//列表和选择
				 var headDiv=$("<div id='headDiv'></div>");
				 var selectList=$("<label>显示<select id='selectList'><option>10</option><option>30</option><option>50</option><option>100</option></select>页</label>");
				 var searchInput=$("<label>&nbsp搜索:<input id='searchInput' type='text'></label>");
				 headDiv.prepend(selectList);//添加列表
				 headDiv.append(searchInput);
				 $table.before(headDiv);//添加选择框和搜索框
				 
				 $("#selectList").change(function(){//列表发生变化
					 selectNum=$(this).val();
					 changePageQuick();
					 viewTb(rows);
				 });
				 
				 var preKey=" ";
				 var newKey=" ";
				 $("#searchInput").keyup(function(){//搜素框发生变化//////////////待完善
				
					 searchKey(rows);
					 /*	newKey=$(this).val();
					//alert(newKey+" new key");
					 if(preKey!=newKey){//相等
						 alert($(this).val()+"search");
						 preKey=newKey;
					 }else{
						
					 }
				*/	
					// alert(preKey);
				 });
				 
			 }
	
			 
			 function createPage(){//分页
	
				var showNum=$("#selectList").val();//每页显示数 
				var dataNum=rows.length; //数据总数
			
				var pageNum=dataNum/showNum;
				if(showNum%dataNum!=0)//最后一页求模
					pageNum=pageNum+1;
					
		
				
				var footDiv=$("<div id='footDiv'></div>");
				var id="span";
				for(var i=1;i<8;i++)
				{	
					var everyPage=$("<span id="+id+i+">"+"&nbsp"+i+"&nbsp"+"</span>");//id=span0-span8
					everyPage.addClass("pageSpan");
					footDiv.append(everyPage);	
					}
				var prePage=$("<span id='span0'>"+"&nbsp"+"第"+"&nbsp"+"</span>");
				var nextPage=$("<span id='span8'>"+"&nbsp"+"页"+"&nbsp"+"</span>");
				footDiv.prepend(prePage);
				footDiv.append(nextPage);
				$table.after(footDiv);
				var currentPage=$("#span1");//定义一个当前页
				currentPage.addClass("pageCurrent");//初始化当前页
				/*   end   init     */
				 var $page=footDiv.find(".pageSpan");
				 $page.each(function(){//点击分页			
					 $(this).click(function(){
						 changePageClick($(this));
//////////////////	 	
						 viewTb(rows);
					 });
					 
				
			 });
			 }
			 
			 function viewTb(data){//输出数据
				 var currentP= parseInt($("#footDiv").find(".pageCurrent").text());	
				 startTr=(currentP-1)*selectNum;
				 endTr=startTr+selectNum*1;
				 $tbody.empty();//清空
				// alert("currentP"+currentP+"startTr"+startTr+"endTr"+endTr+"selectNum"+selectNum);
				 //////////
				 for(var i=startTr;i<endTr;i++){//添加到表格
					 $tbody.append(data[i]);
				 }	
			//	 console.log($(currentData[0]).find("td").text()+"currentData ");
				 console.log($(oriData[0]).find("td").text()+"oriData ");
				 
				 dbClickOnTd();
				/////////控制分页显示/////////	
				 
			 }	 
////////////////////////////////////快速设置page////////////////////////////////////////////			 
			 function changePageQuick(){//布置分页栏--快捷
					var pageNum=Math.ceil(rows.length/selectNum);
					var currentPage=Math.ceil(startTr/selectNum);
					if(currentPage==0) currentPage=1;
					//alert(pageNum+"strat "+startTr+" current "+currentPage );
					$spans=$("#span0").nextUntil("#span8");//1-7span
					if(pageNum<8){//总数少于等于7 一次排
						$spans.each(function(index){
							if(index<pageNum)
							$(this).text(index+1);
						});						
					}//end pageNum
					if(pageNum>8){
						if(currentPage<5){
							$spans.each(function(index){
								$(this).text(index+1);
								});	
							$("#span7").text(pageNum);
							$("#span6").text("...");							
							}//end <5
						else if(pageNum-currentPage<4){
							$spans.each(function(index){
								$(this).text(index-6+pageNum);
								});	
							$("#span1").text(1);
							$("#span2").text("...");	
						}
						else{
							$("#span2").text("...");	
							$("#span3").text(currentPage-1);
							$("#span4").text(currentPage);
							$("#span5").text(currentPage+1);
							$("#span6").text("...");	
						}
						
						
					}
					///设置。class
					$spans.removeClass("pageCurrent");
					$spans.addClass("pageSpan");
					$spans.each(function(index){

						if($(this).text()==currentPage){
						//	alert(currentPage+" "+index);
							$(this).addClass("pageCurrent");
						}
						if($(this).text()=="..."){
							//	alert(currentPage+" "+index);
								$(this).removeClass("pageSpan");
							}

					});
				 
			 }
///////////////////////////////点击逐步增加分页///////////////////////////////////			 
			function changePageClick($span){
				var pageNum=Math.ceil(rows.length/selectNum);
				
				
				if($span.is($("#span1"))){
			
					$span.siblings().removeClass("pageCurrent");
					$span.addClass("pageCurrent");	
					var $spans=$span.nextAll();
					var i=1;
						if(pageNum<8){//页面不用压缩
							$spans.each(function(index){
								if(i<pageNum){$(this).text(index+2);}
								else if(index!=6){$(this).hide();}//其他的隐藏最后一个除外
								i=i+1;
							});
							
						}
						else{$("#span2").text(2).addClass("pageSpan");$("#span3").text(3);$("#span4").text(4);$("#span5").text(5);$("#span6").text("...").removeClass("pageSpan");$("#span7").text(pageNum);}
						
				
					}//
				if($span.is($("#span2"))||$span.is($("#span4"))||$span.is($("#span6"))){
					
					if($span.text()!="..."){
					$span.siblings().removeClass("pageCurrent");
					$span.addClass("pageCurrent");
					}
				}
					
					if($span.is($("#span3"))){
						$span.siblings().removeClass("pageCurrent");
						var t=parseInt($span.text());
						if(t<4||pageNum<8){
						
							$span.addClass("pageCurrent");		
						}else{
							$("#span3").text(t-1);
							$("#span4").text(t);
							$("#span4").addClass("pageCurrent");
							$("#span5").text(t+1);
							if(pageNum-t==4) {$("#span6").text("...").removeClass("pageSpan")};
							if(t==4){$("#span2").text(2);$("#span2").addClass("pageSpan");}
						}
						
					}
					
					
					if($span.is($("#span5"))){
						var t=parseInt($span.text());
						$span.siblings().removeClass("pageCurrent");
			
						if(pageNum-t<3||pageNum<8){
							$span.addClass("pageCurrent");		
						}else{
							$("#span5").text(t+1);
							$("#span4").text(t);
							$("#span4").addClass("pageCurrent");
							$("#span3").text(t-1);
							if(t==5) {$("#span2").text("...").removeClass("pageSpan")};
							if(pageNum-t==3){$("#span6").text(pageNum-1);$("#span6").addClass("pageSpan");}
						}
						
					}
					
					if($span.is($("#span7"))){
				
						$span.siblings().removeClass("pageCurrent");
						$span.addClass("pageCurrent");	
						var pageNum=Math.ceil(rows.length/selectNum);
						var $spans=$span.prevAll();
						var i=1;
							if(pageNum<8){//页面不用压缩
							}
							else{$("#span6").text(pageNum-1).addClass("pageSpan");$("#span5").text(pageNum-2);$("#span4").text(pageNum-3);$("#span3").text(pageNum-4);$("#span2").text("...").removeClass("pageSpan");}
						
						}//	
					
				 }
			
///////////////////////////////////////////////////////////			
			
			
	function sortTb(data,col){//表格排序方法
				 	
					$.each(data,function(index,row){//遍历数组
					 	row.sortkey=setSortKey($(row).find('td').eq(col),col);
					 	});	
				 	data.sort(function(a,b){//数组排序
					 	if(a.sortkey<b.sortkey) return transort;
					 	if(a.sortkey>b.sortkey) return -transort;
					 	return 0;
					 	 });
				 	 if(transort>0){transort=-1;}//反置 实现正逆排序
				 	 else{transort=1;}

				 	 viewTb(data);//输出表格
				 	 
					function setSortKey($cell,col){
						
						if(setType[col]==null) setType[col]="char";
						switch(setType[col])
					 	{
					 	case "char":
					 		  return $cell.text().toUpperCase();
					 		break;
					 		
					 	case "double":							
					 	case "int":
							var key = parseFloat($cell.text().replace(/^[^\d.]*/, ''));
								return isNaN(key) ? 0 : key;
					 		break;
					 		
					 	case "date":

							return Date.parse('1 ' + $cell.text());
							break;
					 	case "boolean":
					 	default:  
					 		return $cell.text();
					 	}
					}
					
					
				}//end sortTb()
			
					
			 /////////////////////////////
 $th.each(function(col){//遍历表头		 			
			 	$(this).click(function(){//点击事件触发
			 		var d1=new Date();
			 	sortTb(rows,col);//排序
			 	var d2=new Date();
			 	//alert(d2.getTime()-d1.getTime());

			 	});//end clilk th

			 });//end th each
			 

			 });
	 }
	 
	 
 })(jQuery);