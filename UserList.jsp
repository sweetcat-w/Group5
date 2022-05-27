<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content">
	<div class="header">
		<h1 class="page-title">查看用户</h1>
	</div>
	<div>
		<ul class="breadcrumb">
			<li><a href="GetUserServlert">用户</a> <span class="divider">/</span></li>
			<li class="active">查看用户</li>
		</ul>
	</div>
    <div class="container-fluid">
		<div class="row-fluid">
			<div class="btn-toolbar">
				<a href="AddUserServlert">
					<button  class="btn btn-primary"><i class="icon-plus"></i> 新增用户 </button>
				</a>
				<form method="get" action="FindUserByNameServlert" style="position:absolute; left:150px;top:110px;width:255px;height:30px;" >
					<input name="id" type="text" class="input" style="position:absolute; top:15px; width:120px;"/>
					<button type="submit" class="btn btn-primary" style="position:absolute; left:123px; top:10px;">按用户名称查询用户信息</button>
				</form>
				<form method="get" action="FindUserByIdServlert" style="position:absolute; left:430px;top:110px;width:255px;height:30px;">
					<input name="name" type="text" class="input" style="position:absolute; top:15px; width:120px;"/>
					<button type="submit" class="btn btn-primary" style="position:absolute; left:123px; top:10px;">按id查询用户信息</button>
				</form>
				
			</div>
			<div class="well">
				<table class="table text-center">
					<thead>
						<tr>
							<th>用户id</th>
							<th>用户姓名</th>
							<th>用户电话</th>
							
							<th>用户密码</th>
							<th>是否为管理员</th>
							
							<th style="width: 26px;">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="u" items="${list}">
							<tr>
								<td>${u.id}</td>
								<td>${u.userName}</td>
								<td>${u.phoneNum}</td>
								
								<td>${u.password}</td>
								<td>${u.isAdmain}</td>
								
								<td>
									<a href="EditUserServlert?id=${u.id}"><i class="icon-pencil"></i></a>
									<a href="DelUserServlert?id=${u.id}"><i class="icon-remove"></i></a>
								</td>	
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="pagination">
			    <ul>
			        <li><a href="GetUserServlert?index=${currentIndex-1<=0?1:currentIndex-1}">上一页</a></li>
					<c:if test="${currentIndex-1>=0}">
						<li><a href="GetUserServlert?index=${currentIndex-1>0?1:currentIndex}">${currentIndex-1>0?1:currentIndex}</a></li>
					</c:if>
					<c:if test="${allIndex-	currentIndex>0}">
						<li><a href="GetUserServlert?index=${currentIndex+2>allIndex?allIndex:currentIndex+1}">${currentIndex+2>allIndex?allIndex:currentIndex+1}</a></li>
					</c:if>
					<li><a href="GetUserServlert?index=${currentIndex+1>allIndex?allIndex:currentIndex+1}">下一页</a></li>
			    </ul>
			</div>
		</div>
	</div>
</div>

<script src="lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	$("[rel=tooltip]").tooltip();
	$(function() {
		$('.demo-cancel-click').click(function(){return false;});
	});
</script>
    
</body>
</html>


