<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="${rootPath }css/toup.css" />
<link rel="stylesheet" href="${rootPath }css/swiper.min.css">
<script src="${rootPath }js/jquery-1.11.3.js"></script>
<script src="${rootPath }js/fontSize.js"></script>
	
</head>
<body>
 <form action="#" method="post">
    <section class="toup"  id="t1">
		<div class="swipers">
			<a href="#" class="jion">在线测试</a>
		</div>
	</section>
   
	<section class="toup" id="t2">
		<div class="swipers">
		<!-- 上下 -->
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<div class="scores">
						<h3>1、《党章》规定，党的建设的基本要求是　　</h3>
						<div class="choose">
							<div class="input"><input type="radio" name="score1" required="required" id="2"/><label for="2">社会主义国家的综合国力 </label></div>
							<div class="input"><input type="radio" name="score1" required="required" id="3"/><label for="3">社会主义国家的经济实力  </label></div>
							<div class="input"><input type="radio" name="score1" required="required" id="4"/><label for="4">社会主义国家的国家安全 </label></div>
						</div>
					</div>
				</div>
				<div class="swiper-slide">
					<div class="scores">
						<h3>1、《党章》规定，党的建设的基本要求是　　</h3>
						<div class="choose">
							<div class="input"><input type="radio" name="score2" required="required" id="2"/><label for="2">社会主义国家的综合国力 </label></div>
							<div class="input"><input type="radio" name="score2" required="required" id="3"/><label for="3">社会主义国家的经济实力  </label></div>
							<div class="input"><input type="radio" name="score2" required="required" id="4"/><label for="4">社会主义国家的国家安全 </label></div>
						</div>
					</div>
				</div>
				
			</div>
			<div class="preNexts">
				<div class="swiper-button-prev"><div class="pre"></div>上一题</div>
				<div class="swiper-button-next"><div class="next"></div>下一题</div>
			</div>
		</div>
		<!-- 上下end -->
		</div>
	</section>
	
	<section class="toup" id="t3">
		<div class="swipers">
			<div class="con con1">
				<div class="smile">
					<p>您已答完试题</p>
				</div>
			</div>
			<div class="tijiao">
			  <input type="submit"  value="提交试卷">
		    </div>
		</div>
	</section>
</form>
   	<script src="swiper/swiper.min.js"></script>
	<script>
		var mySwiper  = new Swiper('.swiper-container', {
        pagination: '.swiper-pagination',
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',
        slidesPerView:1,
        paginationClickable:true,
        spaceBetween:30,
        loop: true,
		onReachEnd: function(swiper){
			$("#t2").hide();
			$("#t3").show();
		}
    });
     	$("#t3").hide();
		$("a.jion").on("click",function(){
			$("#t1").show();
			$("#t2").show();
	});
	$(".swiper-container label,.swiper-container input").click(function(){
		var this_active = $(this).parents(".swiper-slide").index();
		setTimeout(function(){
			mySwiper.slideTo(this_active+1,1000)
		},500);
		
 });
	$('.swiper-button-next').click(function(){
		if(mySwiper .isEnd){
			$("#t1").show();
			$("#t2").hide();
			$("#t3").show();
		}
	})
	
	</script>
</body>
</html>