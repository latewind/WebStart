$(document).ready(
		function() {

			/* 中央幻灯片的尺寸 */
			var imgWidth = $(".carousel-inner").width();
			var imgHeight = $(".carousel-inner").height();
			/* 鼠标移动到左边边分类导航时 */
			$("#rightNav").find("li").hover(
					function() {

						var subId = $(this).attr("subId");
						console.log("subId  li" + subId)
						$(this).addClass("nav-li-cur");
						var $nextDiv = $(this).next("div");
						$nextDiv.css("width", imgWidth + "px").css("height",
								imgHeight + 10 + "px").show();/*
																 * 设置隐藏/显示导航div
																 * 长宽与中央幻灯片大体相等
																 */

					}, function() {

						$(this).removeClass("nav-li-cur");
						var $nextDiv = $(this).next("div");
						$nextDiv.hover(function() {
							$(this).show();
						}, function() {
							$(this).hide();
						});
						$(this).next("div").hide();
					});

			/* 初始化隐藏 */
			$("a[href$='#carousel-668027']").hide();
			/* 鼠标移动到中央幻灯片 左右控制取消设置 */
			$("#carousel-668027").hover(function() {

				$("a[href$='#carousel-668027']").show();

			}, function() {
				$("a[href$='#carousel-668027']").hide();

			});

			$("#alertMsg").hide();

			$(".nav-a-left").hover(function() {

				$(this).css("background-color", "transparent");

			}, function() {

			});

		});
/* 新闻公告 面板切换*/
function tabPanelShow(element) {
	var $this = $(element);

	$this.tab('show');
	
	
	

}