
/* 设置当前导航栏 */
function cssNavigation() {
		var url = window.document.location.pathname;
		console.log(url);
		$("a[href$='" + url + "']").parent().addClass("cur");
	}

