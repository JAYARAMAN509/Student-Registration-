<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/employe" user="roor" password="Jay17@00"/>
<sql:query dataSource="${db}" var="rs">
select * from studenttable
</sql:query>
<table border=1 width=100%>
<tr><th>name <th>mobile <th>email <th>Fathername <th>Address <th>gender</th></tr>
<h1>Welcome ${param.t3 }</h1>
<c:forEach items="${rs.rows}" var="table">
<tr>


<td><c:out value="${table.name}"></c:out></td>
<th><c:out value="${table.mobile}"></c:out></th>
<th><c:out value="${table.email}"></c:out></th>
<th><c:out value="${table.Fathername}"></c:out></th>
<th><c:out value="${table.Address}"></c:out></th>
<th><c:out value="${table.gender}"></c:out></th>
</tr>
</c:forEach>
</table>
</body>
</html>
