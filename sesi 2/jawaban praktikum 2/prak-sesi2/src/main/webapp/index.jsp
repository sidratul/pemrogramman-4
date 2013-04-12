<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<title>praktikum sesi 2</title>
	</head>
	<body>
		<time align="center">
			<h3>Tanggal dan waktu saat ini</h3>
			<c:set var="now" value="<%=new java.util.Date()%>"/>
			<div>Hari dan Tanggal saat ini : 
				<fmt:formatDate pattern="E,dd-MM-yyyy" value="${now}"/>
			</div>
			<div>waktu saat ini : <fmt:formatDate pattern="H:m:s" value="${now}"/></div>
		</time>
		<form method="post" action="verifikasi.jsp">
			<fieldset>
			<legend><h2>input data</h2></legend>
				<table>
					<tr>
						<td>nama</td>
						<td><input type="text" name="nama" placeholder="nama"></td>
					</tr>
					<tr>
						<td>email</td>
						<td><input type="email" name="email" placeholder="email"></td>
					</tr>
					<tr>
						<td>tanggal lahir</td>
						<td><input type="date" name="tl" placeholder="tanggal lahir"></td>
					</tr>
					<tr>
						<td>alamat</td>
						<td><textarea name="alamat" placeholder="alamat"></textarea></td>
					</tr>
					<tr>						
						<td colspan="2">
							<input type="submit" value="simpan"/>
							<input type="reset" value="batal"/>
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</body>
</html>