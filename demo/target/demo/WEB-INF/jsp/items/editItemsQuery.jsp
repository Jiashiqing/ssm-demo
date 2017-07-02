<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript">
	function editItemsAllSubmit() {
		//提交form
		document.itemsForm.action="${pageContext.request.contextPath}/items/editItemsAllSubmit.action";
		document.itemsForm.submit();
	}
	function queryItems() {
		//提交form
		document.itemsForm.action="${pageContext.request.contextPath}/items/queryItems.action";
		document.itemsForm.submit();
	}

</script>

</head>
<body>
	<h1>我的购物车</h1>
	<form  name="itemsForm" action="${pageContext.request.contextPath}/items/queryItems.action"
		method="post">
		查询条件：
		<table border="1" width="100%">
			<tr>
			<td>商品名称：<input type="text" name="itemsCustom.name"/></td>
			<td>
				<input type="submit" value="查询" onclick="queryItems()" />
				<input type="button" value="批量修改提交" onclick="editItemsAllSubmit()"/>
			</td>
			</tr>
		</table>
		<table border="1" width="100%">
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>描述</td>
				<td>日期</td>
			</tr>

			<c:forEach items="${itemsList}" var="item" varStatus="status">
				<tr>
					<th><input name="itemsList[${status.index}].name" value="${item.name }" /></th>
					<td><input name="itemsList[${status.index}].price" value="${item.price  }" /></td>
					<td><input name="itemsList[${status.index}].detail" value="${item.detail }" /></td>
					<td><input name="itemsList[${status.index}].createtime" 
							   value="<fmt:formatDate value="${item.createtime }" 
						       pattern="yy-MM-hh HH:mm:ss"/>" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>