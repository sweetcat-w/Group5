<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <div class="content">
        <div class="header">
            <h1 class="page-title">修改退货登记</h1>
        </div>
		<div>
			<ul class="breadcrumb">
				<li><a href="GetRefundServlert">查看退货登记</a> <span class="divider">/</span></li>
				<li class="active">修改退货登记</li>
			</ul>
		</div>
        <div class="container-fluid">
 			<div class="row-fluid">     
 				<form id="refundTab" method="post" action="EditRefundServlert">
				<div class="btn-toolbar">
					<button type="submit" class="btn btn-primary"><i class="icon-save"></i> 确认修改</button>
					<a href="#" type="button" data-toggle="modal" class="btn" onclick="javascript:button_clear();" >全部清空</a>
				</div>
				<div class="well" style="height:400px;">
					<ul class="nav nav-tabs" style="width:1200px;">
						<li class="active" style="width:1200px;"><a href="#home" data-toggle="tab">退货登记</a></li>
					</ul>
					<div id="myTabContent">					
							<ul style="list-style: none; position: relative; left: -20px; height: 200px; width:180px;">
								<li style="width:180px;">
									<label style="width: 180px;">商品名称：</label>
									<input type="text"  name="g_name" id="g_name" value="${refund.g_name}" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="width:180px;">
									<label style="width: 180px;">商品条形码：</label>
									<input type="text" readonly="readonly" name="g_barCode" id="g_barCode" value="${refund.g_barCode}" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="width:180px;">
									<label style="width: 180px;">规格：</label>
									<input type="text" name="g_specifications" id="g_specifications" value="${refund.g_specifications}" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="width:180px;">
									<label style="width: 180px;">交易单号：</label>
									<input type="text" name="transactionNo" id="transactionNo" value="${refund.transactionNo}" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="width:180px;">
									<label style="width: 180px;">生产日期：</label>
									<input type="text" name="g_manufactureDate" id="g_manufactureDate" value="${refund.g_manufactureDate}" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="width:180px;">
									<label style="width: 180px;">退货数量：</label>
									<input type="text" name="r_num" id="r_num" value="${refund.r_num}" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="width:180px;">
									<label style="width: 180px;">单位：</label>
									<input type="text" name="g_unit" id="g_unit" value="${refund.g_unit}" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="width:180px;">
									<label style="width: 180px;">退货日期：</label>
									<input type="text" name="r_date" id="r_date" value="${refund.r_date}" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="position: relative; top: -210px; left:480px; width:680px;" >
									<img src="../manager/images/img_1.jpg" style="width: 680px; height: 330px; "/>
								</li>
							</ul>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
        function button_clear(){
        	document.getElementById("g_name").value = "";
			document.getElementById("g_barCode").value = "";
			document.getElementById("g_specifications").value = "";
			
			document.getElementById("transactionNo").value = "";
			document.getElementById("g_manufactureDate").value = "";
			document.getElementById("r_num").value = "";
			
			document.getElementById("g_unit").value = "";
			document.getElementById("r_date").value = "";
		}
    </script>
</body>
</html>


