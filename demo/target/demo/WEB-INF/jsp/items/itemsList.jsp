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
	function deleteItems() {
		//提交form
		document.itemsForm.action="${pageContext.request.contextPath}/items/deleteItems.action";
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
	当前用户：${username }
	<c:if test="${username!=null }">
		<a href="${pageContext.request.contextPath }/logout.action">退出</a>
	</c:if>
	<h1>我的购物车</h1>
	<form  name="itemsForm" action="${pageContext.request.contextPath}/items/queryItems.action"
		method="post">
		查询条件：
		<table border="1" width="100%">
			<tr>
			<td>商品名称：<input type="text" name="itemsCustom.name"/>
				商品类型：
				<select name="itemtype">
					<c:forEach items="${itemtypes }" var="itemtype">
						<option value="${itemtype.key }">${itemtype.value }</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<input type="submit" value="查询" onclick="queryItems()" />
				<input type="button" value="批量删除" onclick="deleteItems()" />
			</td>
			</tr>
		</table>
		<table border="1" width="100%">
			<tr>
				<td>选择</td>
				<td>名称</td>
				<td>价格</td>
				<td>日期</td>
				<td>描述</td>
				<td>操作</td>
			</tr>

			<c:forEach items="${itemsList}" var="item">
				<tr>
					<th><input type="checkbox" name="items_id" value="${item.id}"/></th>
					<th><c:out value="${item.name }"></c:out></th>
					<td><c:out value="${item.price }"></c:out></td>
					<td><fmt:formatDate value="${item.createtime }" pattern="yy-MM-hh HH:mm:ss"/></td>
					<td><c:out value="${item.detail }"></c:out></td>

					<td><a
						href="${pageContext.request.contextPath}/items/editItems?id=${item.id} ">修改</a>
					</td>

				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>