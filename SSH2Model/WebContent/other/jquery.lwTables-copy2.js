/*!
 LateWind  Tables 1.0.1
 @lsqwell@sina.com
 未完项目
 1、Data 类型转换
 2、搜索优化 屏蔽无用键
 3、数据Ajax传输
*/
(function($){	 
	 $.fn.lwtables=function(options){
		 var settings = $.extend({}, {open: 1 ,thType:"char,int,double,date,boolean",editable:true},options);//接受函数参数，将结果赋给settings
		 var setType=settings.thType.split(",");
		 var canedit=settings.editable;
//		 console.log(canedit)
//		 if(!canedit){alert("false") }
			 	
		 return this.each(function(){			 
			 var $table=$(this);//预缓存 table tbody th
			 var $tbody=$table.find('tbody');
			 var $th=$table.find('th');	
			 var thnum=$th.length;
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
				var key=$("#searchInput").val(); //获取输入框值
				var temKey=key.replace(/(^\s*)|(\s*$)/g,"");//去掉头尾空格
				var multKey=temKey.split(/\s{1,}/);//分开关键字
				var result; 			
				currentData.length=0;//初始
				var rult;
				var j=0;
				$.each(rows,function(index,row){//遍历原始数组
					 	 
					 result=$(row).find("td").text();//
				
					for(var i=0;i<multKey.length;i++){
					rult=result.search(multKey[i]);
					if(rult<0) break;//没找到中断
					if(i==multKey.length-1){//找到了 将当前数据推入
						//currentData[j]=row;
					//	j=j+1;
						currentData.push(row);
						}
					}						
					 
				 });//数组遍历查询结束			
				 startTr=0;//设置输出行起点
				changePageQuick(currentData);//设置底部分页
				 viewTb(currentData);//输出数据			
				//console.log("数据总数"+currentData.length);
				 
			 }
			 
			 function initTb(){	
				 selectAndSearch();	//初始化
				 createPage();
				 viewTb(rows);
				 changePageQuick(rows);
				 dbClickOnTd(); 
				 $("#span1").trigger("click");
				 
			 }
			//td 双击 增添 输入框
			 function dbClickOnTd(){
				 $("td").each(function(index){//遍历每一个格子
					 $(this).dblclick(function(){//双击事件
						 
					if(canedit){
					 var $td=$(this);
					 var str=$td.text();//预先存储原来的数据
					 var trbef=$td.parent().text();
					 var input=$("<input type='text' id='temp'>");
					 input.val(str);//输入框赋值
					 $td.text("");//表格清空
					 $(this).append(input);//添加输入框
					 $("#temp").focus();//输入框获取焦点
					 $("#temp").text(str);
					 $("#temp").blur(function(){//输入框失去焦点
						 var newstr=$("#temp").val();//新数据
					      $("#temp").remove();//消除输入框  		
					      $td.text(newstr);
					      //alert(index);
					      if(newstr!=str){//前后数据不一样
						      console.log(thnum+"the num of th");
						      console.log($td.prevAll().length+"本行前有几个");//前面有几个
						      console.log($td.prevAll().last().text()+"第一个是");//第一个 ID是多少
						      console.log($td.text()+"新数值");
						     console.log($td.parent().text());
						     var d=$td.parent().text();
						    aJax(d);
			
						     $.each( rows,function(index,row){//遍历rows
						    	//  console.log($(row).text());
						      });
					    	  
					      }//end if

					      /////////////////////////////////////////////
					      ////////////////////////////////////////////
					     // rows=$tbody.find('tr').get();//更新用其他方法替代
					 });
					}//end if
				 });
					 });
			 }
			//列表选择框初始化及搜索框初始化，事件设置
			 function aJax(d){
				 
					$.ajax({
						
						type: "post",
						url: "json/TestAjaxAction",
						data:{
							dpost:d
						}
						,
						dataType:'json',
						success:function(data,textstatus){
							
						//	$(this).text(d.result);
						//	var t=data.result[2];
						//	$("#p1").text(t);
							alert("success in AjaxAction");
							
						},
					    complete: function(XMLHttpRequest, textStatus){
					            //HideLoading();
					        },
						error:function(){
							alert("error");
						}				
					});
					
				 
				 
			 }
			 
			 function selectAndSearch(){
				 var headDiv=$("<div id='headDiv'></div>");
				 var selectList=$("<label>显示<select id='selectList'><option>10</option><option>30</option><option>50</option><option>100</option></select>页</label>");
				 var searchInput=$("<label>&nbsp搜索:<input id='searchInput' type='text'></label>");
				 headDiv.prepend(selectList);//添加列表
				 headDiv.append(searchInput);
				 $table.before(headDiv);//添加选择框和搜索框
				 
				 $("#selectList").change(function(){//列表发生变化
					 selectNum=$(this).val();//获取列表值
					 changePageQuick(currentData);
					 viewTb(currentData);
				 });
				 
				$("#searchInput").keyup(function(event){//搜素框发生变化//////////////
					// var p=new RegExp("/0|8|32|[5-8]\\d|48|49|90");
					 var k=event.which;
					 if(k>9&&k<35&&k!=32&&k!=13){
						
						 }else{
							 searchKey(rows);
						 }				
				 });

				 
			 }
	
			//分页栏初始化及事件
			 function createPage(){
	
				var showNum=$("#selectList").val();//每页显示数 
				var dataNum=rows.length; //数据总数
			
				var pageNum=dataNum/showNum;
				if(showNum%dataNum!=0)//最后一页求模
					pageNum=pageNum+1;
									
				var footDiv=$("<div id='footDiv'></div>");
				var id="span";
				for(var i=1;i<8;i++)
				{	
					var everyPage=$("<span id="+id+i+"></span>");//id=span0-span8
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
						 changePageQuick(currentData);
						 viewTb(currentData);
					 });
					 
				
			 });
			 }
			 
			 function viewTb(data){//输出数据
				 
				 endTr=startTr+selectNum*1;//设置输出结束点
				 $tbody.empty();//清空
				// alert("currentP"+currentP+"startTr"+startTr+"endTr"+endTr+"selectNum"+selectNum);//
				 for(var i=startTr;i<endTr;i++){//添加到表格
					 $tbody.append(data[i]);
				 }	

				 
				 dbClickOnTd();//可优化，减少范围，yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy
				/////////控制分页显示/////////	
				 
			 }	 
////////////////////////////////////快速设置page////////////////////////////////////////////			 
			 function changePageQuick(data){//布置分页栏--快捷
					var pageNum=Math.ceil(data.length/selectNum);
					var currentPage=Math.ceil(startTr/selectNum)+1;
					console.log(pageNum+" ..."+currentPage);
					if(currentPage==0) currentPage=1;
					//alert(pageNum+"strat "+startTr+" current "+currentPage );
					$spans=$("#span0").nextUntil("#span8");//1-7span
					if(pageNum<8){//总数少于等于7 一次排
						$spans.each(function(index){
							if(index<pageNum)	
							$(this).text(index+1);
							else{//展不开 剩余部分空格
								$(this).text("");
							}
						});						
					}//end pageNum
					
					
					if(pageNum>8){
						if(currentPage<5){
							$spans.each(function(index){
								$(this).text(index+1);
								});	
							
							$("#span7").text(pageNum);
							console.log(pageNum);
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
					///设置。class 鼠标hover时 颜色变化
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
			var pageNum=Math.ceil(currentData.length/selectNum);
				
		if($span.text()!=""){
				//第一栏点击	
				if($span.is($("#span1"))){		
					startTr=0;	
					console.log(startTr);
					}//
				//第二栏点击	且text不为“。。。”
				if($span.is($("#span2"))&&$span.text()!="..."){		
					startTr=0+selectNum*1;
					console.log(startTr);				
					}//	
				//第三栏点击	
				if($span.is($("#span3"))){
					
						if($("#span3").text()=="3"){						
							startTr=0+selectNum*2;
							console.log(startTr);
						}else{
							
							var n=parseInt($("#span3").text())-1;
							startTr=0+selectNum*n;
							console.log(startTr);
						}				
					}//
				//第四栏点击
				if($span.is($("#span4"))){				
					var n=parseInt($("#span4").text())-1;
					startTr=0+selectNum*n;
					console.log(startTr);
					
				}
				//第五栏点击	
				if($span.is($("#span5"))){					
					if($("#span5").text()=="5"&&$("#span6").text()!="..."){						
						startTr=0+selectNum*4;
						console.log(startTr);
					}else{
						
						var n=parseInt($("#span5").text())-1;
						startTr=0+selectNum*n;
						console.log(startTr);
					}				
				}//				
				if($span.is($("#span6"))&&$span.text()!="..."){		
					var n=parseInt($("#span6").text())-1;
					startTr=0+selectNum*n;
					console.log(startTr);				
					}//	
				if($span.is($("#span7"))){		
					var n=pageNum-1;
					startTr=0+selectNum*n;
					console.log(startTr);				
					}//					
		}					
			}

			
///////////////////////////////////////////////////////////			
			
			
	function sortTb(data,col){//表格排序方法
				 	
					$.each(data,function(index,row){//遍历数组
					 	row.sortkey=setSortKey($(row).find('td').eq(col),col);//给每一行增添一个比较值
					 	});	
				 	data.sort(function(a,b){//数组排序
					 	if(a.sortkey<b.sortkey) return transort;
					 	if(a.sortkey>b.sortkey) return -transort;
					 	return 0;
					 	 });
				 	 if(transort>0){transort=-1;}//反置 实现正逆排序
				 	 else{transort=1;}

				 	 viewTb(data);//输出表格
				 	 
					function setSortKey($cell,col){//类型转换，返回比较值
						
						if(setType[col]==null) setType[col]="char";
						console.log(setType[col]+"此列类型");
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
			 	$(this).click(function(){//表头点击事件触发
			 		var d1=new Date();
			 	sortTb(currentData,col);//排序
			 	var d2=new Date();
			 	//alert(d2.getTime()-d1.getTime());

			 	});//end clilk th

			 });//end th each
			 

			 });
	 }
	 
	 	 
 })(jQuery);