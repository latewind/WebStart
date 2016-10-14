
/* 设置导航栏 */
function cssNavigation() {
		//获取当前URL 当前的a添加active Class
		var url = window.document.location.pathname;
		console.log(url);
		var $a=$("a[href$='" + url + "']");
		$a.addClass("active");
		//让collapse div 在加载的时候 是保持展开的
		var $collapseDiv=$a.parent().parent();
		$collapseDiv.collapse('show');
		//获取展开collapse id 获取指向此 ID 的 a ，并获取a 的Text 添加到面包屑导航中
		var collapseId=$collapseDiv.attr("id");
		var $action=$("a[href$='#"+ collapseId+"']");
		console.log("a "+$a.text());
		console.log("action"+$action.text());
		
		//# 第一个a 设置为母菜单名，第二个 设置为子菜单名
		$("#bread a").first().text($action.text());
		$("#bread a").last().text($a.text());
		
	}

