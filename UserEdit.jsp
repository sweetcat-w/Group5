<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <div class="content">
        <div class="header">
            <h1 class="page-title">修改用户</h1>
        </div>
		<div>
			<ul class="breadcrumb">
				<li><a href="GetUserServlert">查看用户</a> <span class="divider">/</span></li>
				<li class="active">修改用户</li>
			</ul>
		</div>
        <div class="container-fluid">
 			<div class="row-fluid">     
 				<form id="userTab" method="post" action="EditUserServlert">
				<div class="btn-toolbar">
					<button type="submit" class="btn btn-primary"><i class="icon-save"></i> 确认修改</button>
					<a href="#" type="button" data-toggle="modal" class="btn" onclick="javascript:button_clear();" >全部清空</a>
				</div>
				<div class="well" style="height:400px;">
					<ul class="nav nav-tabs" style="width:1200px;">
						<li class="active" style="width:1200px;"><a href="#home" data-toggle="tab">用户</a></li>
					</ul>
					<div id="myTabContent">					
							<ul style="list-style: none; position: relative; left: -20px; height: 200px; width:180px;">
								<li style="width:180px;">
									<label style="width: 180px;">id：</label>
									<input type="text" readonly="readonly" name="id" id="id" value="${user.id}" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="width:180px;">
									<label style="width: 180px;">用户姓名：</label>
									<input type="text" name="userName" id="userName" value="${user.userName}" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="width:180px;">
									<label style="width: 180px;">用户电话：</label>
									<input type="text" name="phoneNum" id="phoneNum" value="${user.phoneNum}" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="width:180px;">
									<label style="width: 180px;">用户密码：</label>
									<input type="text" name="password" id="password" value="${user.password}" class="input-xlarge" style="width: 180px;">
								</li>
								
								<li style="width:180px;">
									<label style="width: 180px;">是否为管理员：</label>
									<input type="text" name="isAdmain" id="isAdmain" value="${user.isAdmain}" class="input-xlarge" style="width: 180px;">
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
        	document.getElementById("id").value = "";
			document.getElementById("userName").value = "";
			document.getElementById("phoneNum").value = "";
			
			document.getElementById("password").value = "";
			document.getElementById("isAdmain").value = "";
			
		}
    </script>
</body>
</html>


