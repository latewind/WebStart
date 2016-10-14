/**
 * order.jsp 页面
 */
	var initOrderPage=function(){
		//全选点击
		var $allSel = $("#allSelect");
		$allSel.click(function() {
			if ($allSel.prop("checked") == true) {
				$(".singleSelect").each(function() {
					$(this).prop("checked", true);
				});
				getTotalPrice();
			} else {
				$(".singleSelect").each(function() {
					$(this).prop("checked", false);
				});
				console.log("totalPrice:0");
			}
			getTotalPrice();
		});
		//单选点击
		$(".singleSelect").click(function() {
			getTotalPrice();
		});
		//确定选择点击
		var confirmStatus = false;
		$("#confirmChoose").click(function() {
			if (getTotalPrice() == 0) {
				alert("未选择商品");
				return;
			}
			if (confirmStatus == false) {
				$("#fieldset1").prop("disabled", true);
				$("#fieldset2").prop("disabled", false);
				$(this).text("重新选择");
			} else {

				$("#fieldset1").prop("disabled", !true);
				$("#fieldset2").prop("disabled", !false);
				$(this).text("确认选择");
			}
			confirmStatus = !confirmStatus;
		});
	console.log($(".price").text() + "");
		//将文本信息赋给弹出框
		$('#exampleModal').on('show.bs.modal', function(e) {
			console.log("show");
			$("#newName").val($("#name").text());
			$("#newContact").val($("#contact").text());
			$("#newAddress").val($("#address").text());
			// do something...
		})

		var showTip = function(e) {
			var $e = $(e);
			//弹出提示框
			$e.tooltip('show');
			//2s后销毁提示框
			setTimeout(function() {
				$e.tooltip('destroy');
				console.log("...........");
				//$("#newName").tooltip('destroy');
			}, 2000);
			console.log("不能为空");
		}
		
		//模态框保存，赋值给父页面
		$("#saveInfo").click(function() {
			var newName = $("#newName").val();
			var newContact = $("#newContact").val();
			var newAddress = $("#newAddress").val();
			//三个输入框都不能为空，为空弹出提示框
			if (newName == "") {
				showTip($("#newName"));
				return;
			}
			if (newContact == "") {
				showTip($("#newContact"));
				return;
			}
			if (newAddress == "") {
				showTip($("#newAddress"));
				return;
			}
			//都不为空，赋值，隐藏
			console.log("保存");
			$("#name").text(newName);
			$("#contact").text(newContact);
			$("#address").text(newAddress);
			$('#exampleModal').modal('hide');
		});
		
		//删除商品
		deleteOrderPrt();			
		
	}
//删除商品
var deleteOrderPrt = function() {
	$(".order-pack-delete").click(function() {
		var $this = $(this);
		var $rowDiv = $this.parents(".prt-pack:first");
		$rowDiv.remove();
		getTotalPrice();

	});
}
// 获取被选商品总价
var getTotalPrice = function() {
	console.log("fs");
	var totalPrice = 0;
	$(".singleSelect:checked").each(
			function() {
				totalPrice = parseFloat($(this)
						.attr("data-single-select-price"))
						+ totalPrice;
				console.log("you select me");
			});
	console.log("总价是：" + totalPrice);
	$("#totalPrice").text(totalPrice);
	return totalPrice;
}

// 获取所选商品
var getSelectPrtPack = function() {
	console.log("fs");
	var prtPacks = [];
	$(".singleSelect:checked").each(function() {
		var packId = $(this).attr("data-singel-select-packId");
		prtPacks.push(parseInt(packId));
		console.log("you select me");
	});

	return prtPacks;
}
//提交页面信息
var submitOrder = function(path) {
	var json = {};
	var sendData = {};

	sendData["packId"] = getSelectPrtPack();

	var name = $("#name").text();

	var contact = $("#contact").text();

	var address = $("#address").text();

	var payMethod = $("input:radio[name='payMethod']:checked").val();

	var delivery = $("input:radio[name='delivery']:checked").val();
	if(name==null||name==''||contact==null||contact==''||address==null||address==''||payMethod==null||payMethod==''||delivery!=null||delivery==''){
		
		alert("订单信息不全，请补充完整");
		return false;
	}
	alert(name.length()+name);
	sendData["name"] = name;
	sendData["address"] = address;
	sendData["payMethod"] = payMethod;
	sendData["delivery"] = delivery;
	sendData["contact"]=contact;

	for ( var index in sendData["packId"]) {

		console.log(index + "sendData" + sendData["packId"][index])
	}
	console.log(payMethod);
	console.log(delivery);
	setTimeout(function() {
//		window.location.href=path+"/index";
	}, 3000);
	json["sendData"] = sendData;
	$.ajax({
		url : path + "/front/order/orderConfirm",
		type : "POST",
		dataType : "html",
		contentType : "application/json",
		data : JSON.stringify(sendData),
		// data:{json:123},
		success:function(content) {	
			var $content=$(content);
			window.location.href=path+"/front/order/payfor?orderId="+$content.text();
			console.log($content.text());
		}
	});
	return true;
}