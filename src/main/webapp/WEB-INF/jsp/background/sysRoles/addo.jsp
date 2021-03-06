<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@include file="../../common/taglib.jsp" %>
    <%@include file="../../common/common-css.jsp" %>
  </head>
   
 <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.4.min.js"></script>
 <script type="text/javascript">
	  
	  function saveData(){
		 var name = $("#roleName").val();
    	 var roleKey = $("#roleKey").val();		  
    	 if(name=="" || name==null){
    	 	alert("请填入角色名称!");
    	 	return false;
    	 }
    	 if( roleKey=="" || roleKey==null ){
    	 	alert("请填入角色KEY!");
    	 	return false;
    	 }
    	 
    	 //提交.
    	  document.roleFrom.submit();
   	  	  return true;
	  }
	  
	  //查找是否已经存在.
	  $(function (){
	  		$("#roleName").change(function(){
				var name = $("#roleName").val();
				if(name != null && name != ''){
					$.ajax({
						url:'<%=request.getContextPath()%>/background/sysRoles/findByName.html',
						data:{"objName":name},
						type : "POST",
						success:function(msg){
							var obj = eval(msg);
							if (obj.msg == "Y"){
								alert(obj.content);
								$("#roleName").val("");
								return ;
							}
						}
					});
				}
	  		});
	  });
	  
  </script>
  <body>
<br/>
<br/>  
<form action="<%=request.getContextPath()%>/background/sysRoles/addOne.html" method="post" name="roleFrom" id="roleFrom" >
		<table class="ttab" height="100" width="50%" border="0" cellpadding="0" cellspacing="1"
			align="center">
			<tr>
				<td height="30"
					 colspan="2">
					<div align="center">
					<font color="blue" size="4" ><b>添加信息</b></font>
					</div>
				</td>
			</tr>
				<tr>	
					<td height="30" width="40%" >
						<div align="right" class="STYLE1" >
								角色名：
						</div>
					</td>
					<td >
						<div align="left" class="STYLE1"  style="padding-left:10px;">
							 <input style="height: 20px;width: 200px" name="roleName" id="roleName" type="text"/>
						</div>
					</td>
				</tr>
				<tr>	
					<td height="30" width="40%" >
						<div align="right" class="STYLE1" >
								角色roleKey：
						</div>
					</td>
					<td >
						<div align="left" class="STYLE1"  style="padding-left:10px;">
							 <input style="height: 20px;width: 200px" name="roleKey" id="roleKey" type="text"/>
						</div>
					</td>
				</tr>
				<tr>	
					<td height="30" width="40%" >
						<div align="right" class="STYLE1" >
								是否禁用：
						</div>
					</td>
					<td >
						<div align="left" class="STYLE1"  style="padding-left:10px;">
						<input name="roleStatus" type="radio" value="0"/>禁用　　
						<input name="roleStatus" type="radio" checked="checked" value="1"/>正常
						</div>
					</td>
				</tr>
					<tr>	
						<td height="30"width="20%" >
							<div align="right" class="STYLE1" >
									描述：
							</div>
						</td>
						<td >
							<div align="left" class="STYLE1"  style="padding-left:10px;">
								<input style="height: 20px;width: 200px" name="description" type="text"/>
							</div>
						</td>
					</tr>
					<tr>
					<td colspan="2" style="padding: 10px">
						<div align="center">
			 				 <sec:authorize ifAnyGranted="ROLE_sys_roles_addUI">
			 					<input type="button" value="　保　存　" class="input_btn_style1" onclick="return saveData()" />
			 				　</sec:authorize>　
			 				<input id="backBt" type="button" value="　返　回　" class="input_btn_style1" onclick="javascript:window.location.href='javascript:history.back()'"/>
		 				</div>
					</td>
				</tr>
		</table>
</form>
  </body>
</html>
