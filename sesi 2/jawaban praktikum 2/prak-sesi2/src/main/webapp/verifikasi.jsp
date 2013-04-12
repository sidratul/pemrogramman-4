<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>verifikasi</h1>
<html lang="id">
	<head>
	</head>
	<body>
		<table>
			<tr>
				<td>nama</td>
				<td><%= request.getParameter("nama") %></td>
			</tr>
			<tr>
				<td>email</td>
				<td><%= request.getParameter("email") %></td>
			</tr>
			<tr>
				<td>tanggal lahir</td>
				<td><%= request.getParameter("tl") %></td>
			</tr>
			<tr>
				<td>alamat</td>
				<td><%= request.getParameter("alamat") %></td>
			</tr>
		</table>
	</body>
</html>