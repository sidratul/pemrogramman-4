<%-- 
    Document   : inputProduk
    Created on : Apr 26, 2013, 2:19:46 PM
    Author     : Muhammad Sidratul M
--%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="inputProduk.jsp">Input Produk</a>
        <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/p4" user="root" password=""/>
        <sql:query dataSource="${db}" var="hasil">SELECT * FROM produk;</sql:query>        
        <table border="1">
            <tr>    
                <th>Kode</th>
                <th>Nama</th>
                <th>Harga</th>
                <th>Terakhir update</th>
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
