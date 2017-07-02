<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>
</head>
<body>
	<!-- 显示错误信息 -->
	<c:if test="${allErrors!=null }">
		<c:forEach items="${allErrors }" var="error">
			${error.defaultMessage }<br/>
		</c:forEach>
	</c:if>

	<form id=""
		action="${pageContext.request.contextPath}/items/editItemsSubmit"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${itemsCustom.id}" /> 
		修改商品信息：
		<table width="100%" border="1">
			<tr>
				<td>名称</td>
				<td><input type="text" name="name" value="${itemsCustom.name}" /></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="text" name="price"
					value="${itemsCustom.price}" /></td>
			</tr>
			<tr>
				<td>细节</td>
				<td><input type="text" name="detail"
					value="${itemsCustom.detail}" /></td>
			</tr>
			<tr>
				<td>图片</td>
				<td>
					<c:if test="${itemsCustom.pic!=null }">
						<img src="/pic/${itemsCustom.pic }" width="100" height="100" />
					</c:if>
					<input type="file" name="items_pic"/>
				</td>
			</tr>
			
			<tr>
				<td>时间</td>
				<td><input type="text" name="createtime"
					value='<fmt:formatDate value="${itemsCustom.createtime}" 
					pattern="yyyy-MM-dd HH:mm:ss"/>' />
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>

</body>
</html>