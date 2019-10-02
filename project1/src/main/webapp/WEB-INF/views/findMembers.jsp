<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>Find Members</h2>
	<div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>id</th>
					<th>password</th>
					<th>이름</th>
					<th>cash</th>
				</tr>
			</thead>
			<tbody>
			<%
			if( request.getAttribute("IsMember") == "No")
				out.println("Ther is no member");
			else{
			%>
				<c:forEach items="${members}" var="m">
					<tr>
						<td>${m.id}</td>
						<td>${m.pw}</td>
						<td>${m.name}</td>
						<td>${m.cash}</td>
					</tr>
				</c:forEach>
			<%
				} 
			%>
			</tbody>
		</table>
	</div>
</body>
</html>