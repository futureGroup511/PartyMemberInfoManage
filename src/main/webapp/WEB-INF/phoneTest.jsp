<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线测试</title>
<link rel="stylesheet" href="${rootPath }css/reset.css" />
<link rel="stylesheet" href="${rootPath }css/toup.css" />
<script src="${rootPath }js/fontSize.js"></script>
</head>
<body>
	<section class="toup" id="t1">
		<div class="swipers">
			<p class="jion" style="font-size:0.43rem">在线测试</p>
		</div>
	</section>
	<form action="${rootPath}phone_phoneExamDetails" method="post">
		<section class="toup" id="t2">
			<div class="swipers">
				<!-- 中间试题-->
				<div class="swiper-container">
					<div class="swiper-wrapper">
					<p class="testNum">共 ${testNum} 题，总分 ${testScore} 分。</p>
						<div class="swiper-slide">
							

							<div class="scores">
								<c:forEach items="${questionList}" var="q" varStatus="status">
									<h3>${status.index+1}.${q.questions_stems}<span> *
											</span>分值:${q.question_socre}
									</h3>
									<div class="choose">
										<div class="input">
											<label><input type="radio" name="answer${status.index}"
												required="required" value="A${q.qt_Id}" /> A.
												${q.a} </label>
										</div>
										<div class="input">
											<label><input type="radio" name="answer${status.index}"
												required="required" value="B${q.qt_Id}" /> B.
												${q.b} </label>
										</div>
										<div class="input">
											<label><input type="radio" name="answer${status.index}"
												required="required" value="C${q.qt_Id}" /> C.
												${q.c} </label>
										</div>
										<div class="input">
											<label><input type="radio" name="answer${status.index}"
												required="required" value="D${q.qt_Id}" /> D.
												${q.d} </label>
										</div>

									</div>
								</c:forEach>
								<div class="tijiao">
									<input type="submit" name="submit" value="提交试卷">
								</div>
							</div>
							<!--scores-->
						</div>
					</div>


				</div>
			</div>
		</section>
	</form>
</body>
</html>