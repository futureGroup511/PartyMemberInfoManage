<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>时事新闻</title>
</head>
<body>
	<div class="content-two-one">	
			<div>
				<span>党建巡礼</span>
				<span>+</span>
				<span><a href="${rootPath }secretary/partySecretary_paperSection?paperTypeId=${}">查看更多</a></span>
			</div>
				<div>
					<ol>
						<c:forEach var="paper" items="${paperList }" begin="0" end="4">
							<li><span>${paper.releaseDate }</span>
							<span><a href="${rootPath }secretary/partySecretary_lookPaper?rp_Id=${paper.rp_Id}">${paper.title }</a></span></li>
						</c:forEach>
					</ol>
				</div>
		</div>
			<div class="content-two-one">	
			<div>
				<span>党建巡礼</span>
				<span>+</span>
				<span>查看更多</span>
			</div>
				<div>
					<ol>
						<c:forEach var="paper" items="${paperList }" begin="5" end="9">
							<li><span>${paper.releaseDate }</span><span>${paper.title }</span></li>
						</c:forEach>
					</ol>
				</div>
		</div>
			<div class="content-two-one">	
			<div>
				<span>党建巡礼</span>
				<span>+</span>
				<span>查看更多</span>
			</div>
				<div>
					<ol>
						<c:forEach var="paper" items="${paperList }" begin="10" end="14">
							<li><span>${paper.releaseDate }</span><span>${paper.title }</span></li>
						</c:forEach>
					</ol>
				</div>
		</div>
			<div class="content-two-one">	
			<div>
				<span>党建巡礼</span>
				<span>+</span>
				<span>查看更多</span>
			</div>
				<div>
					<ol>
						<c:forEach var="paper" items="${paperList }" begin="15" end="19">
							<li><span>${paper.releaseDate }</span><span>${paper.title }</span></li>
						</c:forEach>
					</ol>
				</div>
		</div>
			<div class="content-two-one">	
			<div>
				<span>党建巡礼</span>
				<span>+</span>
				<span>查看更多</span>
			</div>
				<div>
					<ol>
						<c:forEach var="paper" items="${paperList }" begin="20" end="24">
							<li><span>${paper.releaseDate }</span><span>${paper.title }</span></li>
						</c:forEach>
					</ol>
				</div>
		</div>
			<div class="content-two-one">	
			<div>
				<span>党建巡礼</span>
				<span>+</span>
				<span>查看更多</span>
			</div>
				<div>
					<ol>
						<c:forEach var="paper" items="${paperList }" begin="25" end="29">
							<li><span>${paper.releaseDate }</span><span>${paper.title }</span></li>
						</c:forEach>
					</ol>
				</div>
		</div>
</body>
</html>