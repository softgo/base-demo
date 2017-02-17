<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<%@include file="../../common/taglib.jsp" %>
	<%@include file="../../common/common-css.jsp" %>
	<%@include file="../../common/common-js.jsp" %>
<!-- 写需要的 js 文件 -->
<script type="text/javascript">
	
</script>
	
</head>
<body>
<form id="fenye" name="fenye" action="<%=request.getContextPath()%>/background/testStudent/find.html" method="post">
<div style="overflow-y:scroll;overflow-x:scroll; height:75%;">
<table width="100%" cellpadding="0" cellspacing="0" >
  <!-- 搜索页面展示 -->
  <tr>
     <td align="left" >
       <div id="search_bar" class="mt10">
       <div class="box">
          <div class="box_border">
          	<!-- 表头显示 -->
            <div class="box_top">
                <b>&nbsp;&nbsp;系统管理——> XXX管理 </b>
            </div>
            <div class="box_center pt10 pb10">
              <!-- 查询条件添加 -->
              <table cellpadding="0" cellspacing="0">
                <tr>
                  <td>&nbsp;&nbsp;查询条件1</td>
                  <td><input type="text" name="propsName1" value="" class="input-text lh25"/></td>
                  <td>&nbsp;&nbsp;查询条件2</td>
                  <td><input type="text" name="propsName2" value="" class="input-text lh25"/></td>
                    <td>
	                    <div class="box_bottom pb5 pt5 pr10" style="border-top:0px solid #dadada;">
			              <div class="search_bar_btn" style="text-align:right;">
			                 <input type="submit" name="button" class="btn btn82 btn_search" value="查询">   
	                         <sec:authorize ifAnyGranted="ROLE_test_student_add">
	                            <input type="button" name="button" class="btn btn82 btn_add" value="新增" onclick="GOTO('<%=request.getContextPath()%>/background/testStudent/addUI.html')">
	                         </sec:authorize>
	                         <sec:authorize ifAnyGranted="ROLE_test_student_delete">
	                            <input type="button" name="button" class="btn btn82 btn_del" value="删除" onclick="return deleteAll()">
	                         </sec:authorize>
	                         <input type="button" name="button" class="btn btn82 btn_res" value="重置" onclick="clearText()">
			              </div>
			            </div>
                    </td>
                </tr>
              </table>
            </div>
          </div>
        </div>
        </div>
     </td>
  </tr>
  <!-- 主页面展示 -->
  <tr>
    <td>
        <div id="table" class="mt10">
            <div class="box span10 oh">
              <table class="list_table" width="100%" cellspacing="1" onmouseover="changeto()"  onmouseout="changeback()">
			          <tr>
			            <th >
			              <input id="chose" type="checkbox" name="checkbox" onclick="selectAllCheckBox()" />
			            </th>
			            <!-- 显示的列 -->
              									<th>学生的名字</th>
							<th>联系方式</th>
							<th>1男,0女</th>
							<th>年龄</th>
	
              			<th >基本操作</th>
			          </tr>
			          <c:forEach var="key" items="pageView.data" >
			              <tr class="tr">
							<!-- 显示的内容 -->
           										<td align="center" >
						<input type="checkbox" name="check" value="${key.id}" />
						</td>
						<td align="center" ><a href="<%=request.getContextPath()%>/background/testStudent/findById.html?objId=${key.id}&type=0">${key.id}</a></td>
						<td align="center" >${key.name}</td>
						<td align="center" >${key.mobile}</td>
						<td align="center" >${key.gender}</td>
						<td align="center" >${key.age}</td>
						<td align="center" >
						
						<sec:authorize ifAnyGranted="ROLE_test_student_info">
							<img src="<%=request.getContextPath()%>/images/admin.gif" width="10" height="10" />
							<a href="<%=request.getContextPath()%>/background/testStudent/findById.html?objId=${key.id}&type=0">
							详细信息</a>
						</sec:authorize>
						<sec:authorize ifAnyGranted="ROLE_test_student_edit">
							<img src="<%=request.getContextPath()%>/images/edt.gif" width="12" height="12" />
							<a href="<%=request.getContextPath()%>/background/testStudent/findById.html?objId=${key.id}&type=1">编辑</a>
						</sec:authorize>
						<sec:authorize ifAnyGranted="ROLE_test_student_delete">
							<img src="<%=request.getContextPath()%>/images/del.gif" width="16" height="16" />
							<a href="javascript:void(0);" onclick="deleteId('<%=request.getContextPath()%>/background/testStudent/deleteById.html','${key.id}')">删除</a>
						</sec:authorize>
						
						</td>	
			              </tr>
			          </c:forEach>
              </table>
        </div>
      </div>
    </td>
  </tr>
   <!-- 分页 -->
   <tr>
    <td>
        <div id="table" class="mt10">
            <div class="box span10 oh">
              <%@include file="../../common/webfenye.jsp" %>
            </div>
      </div>
    </td>
  </tr>
  
</table>
</div>
</form>
</body>
</html>
