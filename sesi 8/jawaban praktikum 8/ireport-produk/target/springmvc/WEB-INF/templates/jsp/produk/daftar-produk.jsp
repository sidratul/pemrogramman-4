<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>tampil produk</title>
    </head>
    <body>
        <a href="input-produk">input produk</a>
        <h1>Produk</h1>
        download <a href="../report/pdf">pdf</a> - <a href="../report/xls">xls</a> - <a href="../report/html">html</a> - <a href="../report/csv">Csv</a> 
        <c:choose>
            <c:when test="${empty daftarProduk}">
                <h2>Record Empty</h2>
            </c:when>
            <c:otherwise>
                <table border="1">
                    <thead>
                        <tr>
                            <td>#</td>
                            <td>Kode</td>
                            <td>Nama</td>
                            <td>Harga</td>
                            <td>Terakhir Update</td>
                            <td>&nbsp;</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${daftarProduk}" var="p" varStatus="i">
                        <tr>
                            <td>${i.count}</td>
                            <td>${p.kode}</td>
                            <td>${p.nama}</td>
                            <td>
                                <fmt:formatNumber value="${p.harga}" type="number"></fmt:formatNumber>
                            </td>
                            <td>
                                <fmt:formatDate value="${p.terakhirUpdate}" pattern="EEE, dd MMM yyyy"></fmt:formatDate>
                            </td>
                            <td>
                                <a href="input-produk?id=${p.id}">edit</a>
                                <a href="delete?id=${p.id}">hapus</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
    </body>
</html>
