(function($){
	
	
	
	var methods={
			
		init:function(options){
			
			return this.each(function(){
				
			var $this=$(this);
			 var defaults={
					initTdNum:5,
					onClickEvent:function(){},
					aJaxJson:function(){}
					 
			 }		 
			 var settings=$.extend({},defaults,options);
			 var $addBtn=$("<input type='button' value='增加行'>");
			 var $delBtn=$("<input type='button' value='删除行'>");
			 var $smtBtn=$("<input type='button' value='提交行'>");
			 $this.after($smtBtn);  $this.after($delBtn);$this.after($addBtn);
			 var $tbody=$this.find('tbody');
			 var textTd="<td><input type='text' required ></td>";// 文本框表格
			 var $checkTh=$("<th><input type='checkbox' ></th>");//复选框表格
			 var checkTd="<td><input type='checkbox' name='checkTd'></td>";//复选框表格
//			 $this.find("tbody").append("<tr><td><input type='text' ></td></tr>");
			 var thLength=$this.find('th').length;
			 console.log("the length of the <th>"+thLength);
			 //表头添加序号及选择框
			 $("th:first").before("<th nowrap>序号</th>");
			 $("th:first").before($checkTh);		 
			 //附加全选事件
			 $checkTh.isSel=false;
			 $checkTh.click(function(){//this.checked 不能正常使用
				
					 if(!this.isSel){
						 console.log("clicked111");
					 $("input[name='checkTd']").each(function(){this.checked=true;});
					 }else{
						 console.log("unclicked111");
					 $("input[name='checkTd']").each(function(){this.checked=false;});}
					 this.isSel=!this.isSel;
			 	});
			// 初始化TR
			 for(j=1;j<=settings.initTdNum;j++){
			 var $tr=$("<tr></tr>");
			 $tbody.append($tr);
			 $tr.append(checkTd);
			 $tr.append("<td>"+j+"</td>");;
			 for(var i=0;i<thLength;i++){
				$tr.append(textTd);
			}
			 }
			 //end			 
			 
			 /**
			  *添加行 
			  */
			 $addBtn.click(function(){
				 var $tr=$("<tr></tr>");
				 var index=$this.find('tr').length;
				 $tbody.append($tr);
				 $tr.append(checkTd);
				 $tr.append("<td>"+index+"</td>");;
				 for(var i=0;i<thLength;i++){
					$tr.append(textTd);
				}
			 });
			 
			 
			 /**
			  *删除行 
			  *
			  *
			  */
			 $delBtn.click(function(){
				$("input[name='checkTd']:checked").parentsUntil("tbody").remove();
			 console.log("123");
			 $tbody.find('tr').each(function(index){//序号重置			 
				 $(this).find('td:eq(1)').text(index+1);
			 });
			 });
			 
			 /**
			  *提交行 
			  */
			 $smtBtn.click(function(){
				//	$("input[name='checkTd']:checked").parentsUntil("tbody").remove();
				 console.log("123");
				 var sendData={};
				 
				 var $rows=$("input[name='checkTd']:checked").parent().parent();
				 
				 $rows.each(function(index){
					 var rowData={};
					$(this).find("input[type='text']").each(function(ii){
						
//						alert($(this).val());
						console.log($(this).val());
						rowData[ii]=$(this).val();
						
					});
					 sendData[index]=rowData;
				 });
			
				 
				alert(JSON.stringify(sendData));
				console.log(JSON.stringify(sendData));
				 settings.aJaxJson(sendData);
				
				//删除所选行
				$("input[name='checkTd']:checked").parentsUntil("tbody").remove();
				 $tbody.find('tr').each(function(index){//序号重置			 
					 $(this).find('td:eq(1)').text(index+1);
				 });
				 });
			 
			 
			 
			 
			});
			//			
		},
		test: function() {
			// 对选择器每个元素都执行方法
			return this.each(function() {
				alert("test");
				// 执行代码
			});
		}
						
	};
	
	$.fn.simpleTablelw= function() {
		var method = arguments[0];
 
		if(methods[method]) {
			method = methods[method];
			arguments = Array.prototype.slice.call(arguments, 1);
		} else if( typeof(method) == 'object' || !method ) {
			method = methods.init;
		} else {
			$.error( 'Method ' +  method + ' does not exist on jQuery.pluginName' );
			return this;
		}
 
		return method.apply(this, arguments);
 
	}
	
})(jQuery);