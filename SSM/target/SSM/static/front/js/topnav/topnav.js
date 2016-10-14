/*从购物车删除商品*/
var deleteCartPrt = function(self, path) {
	// $(".cart-delete").click(function(){
	var $this = $(self);
	console.log("点击删除");
	// var $rowDiv=$this.parents(".prt-pack:first");
	// $rowDiv.remove();

	// });
	$this.parents(".row:first").remove();
	console.log("点击了这个元素");

	var prtPackId = $this.attr("prt-pack-id");

	console.log("产品包ID" + prtPackId);
	// 将产品ＩＤ上传
	$.ajax({
		url : path + "/front/ajax/cart/deletePrt",
		type : "POST",
		data : {
			prtPackId : prtPackId
		},
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		success : function(data) {
			var $content = $(data);
			console.log($content.text());
			if (data == LOGOUT) {
				showLoginDialog();
			} else {

			}

		}

	});
}

var searchPrt=function(path){
	
	var keyword=$("#searchInput").val();
	console.log(keyword+path);
	path+"/front/product/searchPrtAction?keyword="+keyword
	if(keyword==''||keyword==null){
		
		
	}
	else{
	
			
		
		window.location.href=path+"/front/product/searchPrtAction?keyword="+keyword;
			
		
		
	}
	
	
	
}

/* 加入购物车，出现提示消息 停留1000ms */
function showAlertMsg(elem, path) {
	console.log("加入购物车" + path);
	var prtId = elem.getAttribute("prt-id");
	$.ajax({
		url : path + "/front/ajax/cart/appendPrt",
		dataType : "html",
		type : "POST",
		data : {
			prtId : prtId
		},
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		success : function(data) {
			console.log(data);
			var $content = $(data);
			console.log($content.text());
			if (data == LOGOUT) {
				showLoginDialog();
			} else {
				$("#alertMsg").html(data);
				$("#cart-div").hide();
				$("#cart").attr("data-if-show", "false");
				$("#alertMsg").show(0, function() {
					$("#alertMsg").delay(500).hide(0);

				});
			}
		}

	});
	return true;
}

/* 打开购物车展示购物车商品 */
var viewCart = function(path) {
	var $cartDiv = $("#cart-div");
	var $cart = $("#cart");
	$cart.attr("data-if-show");
	$cart
			.click(function() {
				var $this = $(this);
				if ($cart.attr("data-if-show") == "false") {
					console.log($cart.attr("data-if-show"));
					$.ajax({
								url : path + "/front/ajax/cart/viewCart",
								dataType : "html",
								type:"POST",
								data : {},
								contentType : "application/x-www-form-urlencoded;charset=utf-8",
								success : function(data) {
									
									// console.log(data+"长一点才能看清楚-----------------------------------------------");
									// console.log(data);
//									var $content = $(data);
//									console.log($content.text());
									if (data == "<p>logout</p>") {
										showLoginDialog();
									} else {
										$("#cartContent").html(data);
										$cartDiv.show();
										$cart.attr("data-if-show", "true");
									}
								}

							});
				} else {
					$cartDiv.hide();
					$cart.attr("data-if-show", "false");

				}
				// true false 交替

			});

}

var showSignUpDialog=function(){
	
	$("#loginDialog").modal('show');
	$('#tabs-login-signup li:eq(1) a').tab('show') 
	
}

var showLoginDialog=function(){
	
	$("#loginDialog").modal('show');	
}

var submitLogin=function(e,path){
	var userName=$("#userName").val();
	var password=$("#password").val();
	//三个输入框都不能为空
	if(userName==""||!isEmail(userName)){
		showTip($("#userName"));
		return  false;
	}
	if(password==""){
		showTip($("#password"));
		return false;
	}	
	var autoLogin=$("#autoLogin").val();
	//都不为空
	$.ajax({
	url:path+"/front/user/loginAction",
	type:'POST',
	dataType:'html',
	contentType : "application/x-www-form-urlencoded;charset=utf-8",
	data:{
	userName:userName,
	password:password,
	autoLogin:autoLogin
	},
	success:function(data){
		if(data!='<p>success</p>'){
			console.log(data);
			$("#alertLoginMsg").html(data);
			setTimeout(function(){
				
				$("#alertLoginMsg").html("");		
			},2000);
		}
		else{
		location.reload();
		
		}
	}
	
	});
	console.log("提交");
	return true;


}

var submitSignUp=function(e,path){
	var userName=$("#signUpUserName").val();
	var oncePassword=$("#oncePassword").val();
	var twicePassword=$("#twicePassword").val();
	//三个输入框都不能为空
	if(userName==""||!isEmail(userName)){
		showTip($("#signUpUserName"));
		return  false;
	}
	if(oncePassword==""){
		showTip($("#oncePassword"));
		return false;
	}	
	
	
	//都不为空
	$.ajax({
	url:path+"/front/user/signUpAction",
	type:'POST',
	dataType:'html',
	contentType : "application/x-www-form-urlencoded;charset=utf-8",
	data:{
	userName:userName,
	oncePassword:oncePassword,
	twicePassword:twicePassword,
	},
	success:function(data){
		if(data!='<p>success</p>'){
			console.log(data);
			$("#alertLoginMsg").html(data);
			setTimeout(function(){
				
				$("#alertLoginMsg").html("");		
			},2000);
		}
		else{
		location.reload();	
		}
	}	
	});
	console.log("提交");
	return true;


}




var showTip=function(e){
	var $e=$(e);
		//弹出提示框
		$e.tooltip('show');
		//2s后销毁提示框
		setTimeout(function(){
		$e.tooltip('destroy');
		console.log("...........");
			//$("#newName").tooltip('destroy');
		},2000);
		console.log("不能为空");
}


function isEmail( str ){  
	var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/; 
	if(myReg.test(str)) return true; 
	return false; 
	}