<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html lang="id">
	<head></head>
	<body>
		<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/p4" user="root"  password=""/>		
		
		<sql:query dataSource="${db}" var="hasil">SELECT * from produk;</sql:query>
		 
		<table border="1" width="100%">
			<tr>
			   <th>kode</th>
			   <th>nama</th>
			   <th>harga</th>
			   <th>terakhir update</th>
			</tr>
			<c:forEach var="data" items="${hasil.rows}">
				<tr>
				   <td><c:out value="${data.kode}"/></td>
				   <td><c:out value="${data.nama}"/></td>
				   <td><c:out value="${data.harga}"/></td>
				   <td><c:out value="${data.terakhir_update}"/></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>