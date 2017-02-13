<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试结果</title>
<link rel="stylesheet" href="${rootPath }css/reset2.css" />
<link rel="stylesheet" href="${rootPath }css/toup2.css" />
<script src="${rootPath }js/fontSize.js"></script>	
</head>
<body>
    <div class="toup"  id="t1">
		<div class="swipers">
			<div class="jion">
			   <h2>前言</h2>
			   <p>考试结束，请查看你的成绩</p>
			   <h2>成绩单</h2>
			   <table border="1">
                  <tr>
                    <td>测试题数：${testNum } 题</td>
					<td>问卷满分：${testScore} 分</td>
					<td>您的得分：${totalScore} 分</td>
                  </tr>
              </table>
			</div>
		</div>
	</div>
    <form>
	<section class="toup" id="t2">
		<div class="swipers">
		<!-- 中间试题-->
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<div class="scores">
					    <h2>答案辨析：</h2>
					    <p class="title">单选题</p>
					    
	 		<c:forEach items="${questionList}" var="q" varStatus="status">				
					<h3>${status.index+1}.${q.questions_stems}&nbsp;&nbsp;&nbsp;(分值:${q.question_socre})　</h3>
						<div class="choose">
							<div class="input">
								<label>A.
										${q.a} </label>
							</div>
							<div class="input">
								<label>B.
										${q.b} </label>
							</div>
							<div class="input">
								<label>C.
										${q.c} </label>
							</div>
							<div class="input">
								<label>D.
										${q.d} </label>
							</div>
							<div class="answenr">
					<c:choose>
						<c:when test="${q.myAnswer!=null}">							
							<p>您的回答为：${q.myAnswer}. <img src="${rootPath}images/cross2.gif"></p>
							 <p class="true">正确答案为：${q.answer}. </p>
							 <p class="explain">解析：${q.analysis}</p>				
						</c:when>
						<c:otherwise>
							<p class="true">您的回答为：${q.answer}. <img src="${rootPath}images/true2.png">(得分：${q.question_socre})</p>
							<p class="explain">解析：${q.analysis}</p>													
						</c:otherwise>
					</c:choose>
							 
							</div>
						</div>
										
				
			</c:forEach>
								
					</div><!--scores-->
					</div>
		</div>
		<!-- 中间试题end -->
		</div><!--container-->
		</div>
	</section>
	</form>
</body>
</html>