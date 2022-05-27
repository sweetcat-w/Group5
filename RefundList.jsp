<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content">
	<div class="header">
		<h1 class="page-title">查看退货登记</h1>
	</div>
	<div>
		<ul class="breadcrumb">
			<li><a href="GetRefundServlert">商品退货登记</a> <span class="divider">/</span></li>
			<li class="active">查看退货登记</li>
		</ul>
	</div>
    <div class="container-fluid">
		<div class="row-fluid">
			<div class="btn-toolbar">
				<a href="AddRefundServlert">
					<button  class="btn btn-primary"><i class="icon-plus"></i> 新增退货登记 </button>
				</a>
				<form method="get" action="FindRefundByBarCodeServlert" style="position:absolute; left:150px;top:110px;width:255px;height:30px;" >
					<input name="id" type="text" class="input" style="position:absolute; top:15px; width:120px;"/>
					<button type="submit" class="btn btn-primary" style="position:absolute; left:123px; top:10px;">按商品条码查询</button>
				</form>
				<form method="get" action="FindRefundByNameServlert" style="position:absolute; left:430px;top:110px;width:255px;height:30px;">
					<input name="name" type="text" class="input" style="position:absolute; top:15px; width:120px;"/>
					<button type="submit" class="btn btn-primary" style="position:absolute; left:123px; top:10px;">按商品名称查询</button>
				</form>
				<form method="get" action="FindRefundByNoServlert" style="position:absolute; left:730px;top:110px;width:255px;height:30px;">
					<input name="name" type="text" class="input" style="position:absolute; top:15px; width:120px;"/>
					<button type="submit" class="btn btn-primary" style="position:absolute; left:123px; top:10px;">按交易单号查询</button>
				</form>
			</div>
			<div class="well">
				<table class="table text-center">
					<thead>
						<tr>
							<th>商品名称</th>
							<th>商品条形码</th>
							<th>规格</th>
							
							<th>交易单号</th>
							<th>生产日期</th>
							
							<th>退货数量</th>
							<th>单位</th>
							
							<th>退货日期</th>
							<th style="width: 26px;">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="u" items="${list}">
							<tr>
								<td>${u.g_name}</td>
								<td>${u.g_barCode}</td>
								<td>${u.g_specifications}</td>
								
								<td>${u.transactionNo}</td>
								<td>${u.g_manufactureDate}</td>
								
								<td>${u.r_num}</td>
								<td>${u.g_unit}</td>
								
								<td>${u.r_date}</td>
								<td>
									<a href="EditRefundServlert?id=${u.transactionNo}"><i class="icon-pencil"></i></a>
									<a href="DelRefundServlert?id=${u.transactionNo}"><i class="icon-remove"></i></a>
								</td>	
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="pagination">
			    <ul>
			        <li><a href="GetRefundServlert?index=${currentIndex-1<=0?1:currentIndex-1}">上一页</a></li>
					<c:if test="${currentIndex-1>=0}">
						<li><a href="GetRefundServlert?index=${currentIndex-1>0?1:currentIndex}">${currentIndex-1>0?1:currentIndex}</a></li>
					</c:if>
					<c:if test="${allIndex-	currentIndex>0}">
						<li><a href="GetRefundServlert?index=${currentIndex+2>allIndex?allIndex:currentIndex+1}">${currentIndex+2>allIndex?allIndex:currentIndex+1}</a></li>
					</c:if>
					<li><a href="GetRefundServlert?index=${currentIndex+1>allIndex?allIndex:currentIndex+1}">下一页</a></li>
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


