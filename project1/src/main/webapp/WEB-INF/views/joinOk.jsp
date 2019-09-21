<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title></title>
</head>
<body>
	<h1>Join Ok~~~~</h1>
	<p>
	id: ${member.id}<br>
	pw: ${member.pw}<br>
	name: ${member.name}<br>
	cash: ${member.cash}<br>
	</p>
	<a href="/test/">home</a>
</body>
</html>