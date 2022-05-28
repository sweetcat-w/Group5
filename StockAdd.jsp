<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
    <div class="content">
        <div class="header">
            <h1 class="page-title">新增库存</h1>
        </div>
		<div>
			<ul class="breadcrumb">
				<li><a href="GetStockServlert">查看库存</a> <span class="divider">/</span></li>
				<li class="active">新增库存</li>
			</ul>
		</div>
        <div class="container-fluid">
 			<div class="row-fluid">     
 			<form id="stockTab" method="post" action="AddStockServlert" >
				<div class="btn-toolbar">
					<button type="submit" class="btn btn-primary"><i class="icon-save"></i> 确认添加</button>
					<a href="#" type="button" data-toggle="modal" class="btn" onclick="javascript:button_clear();" >全部清空</a>
				</div>
				<div class="well" style="height:400px;">
					<ul class="nav nav-tabs" style="width:1200px;">
						<li class="active" style="width:1200px;"><a href="#home" data-toggle="tab">班级信息</a></li>
					</ul>
					<div id="myTabContent">					
							<ul style="list-style: none; position: relative; left: -20px; height: 200px; width:180px;">
							
								<li style="width:180px;">
									<label style="width: 180px;">商品名称：</label>
									<input type="text" name="g_name" id="g_name" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="width:180px;">
									<label style="width: 180px;">商品条形码：</label>
									<input type="text" name="g_barCode" id="g_barCode" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="width:180px;">
									<label style="width: 180px;">保质期：</label>
									<input type="text" name="g_shelfLife" id="g_shelfLife"  class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="position: relative; top:-163px; left:240px; width:180px;">
									<label style="width: 180px;">商品类型：</label>
									<input type="text" name="g_type" id="g_type" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="position: relative; top:-163px; left:240px; width:180px;">
									<label style="width: 180px;">库存数量：</label>
									<input type="text" name="s_num" id="s_num" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="position: relative; top:-163px; left:240px; width:180px;">
									<label style="width: 180px;">单位：</label>
									<input type="text" name=g_nuit id="g_nuit" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="position: relative; top:-163px; left:240px; width:180px;">
									<label style="width: 180px;">是否过期：</label>
									<input type="text" name="g_lsexpired" id="g_lsexpired" class="input-xlarge" style="width: 180px;">
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
			document.getElementById("g_shelfLife").value = "";
			
			document.getElementById("g_type").value = "";
			document.getElementById("s_num").value = "";
			document.getElementById("g_nuit").value = "";
			
			document.getElementById("g_lsexpired").value = "";
			
		}
    </script>
</body>
</html>





