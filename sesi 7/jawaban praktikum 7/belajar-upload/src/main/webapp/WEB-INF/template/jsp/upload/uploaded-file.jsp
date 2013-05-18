<%-- 
    Document   : uploaded-file
    Created on : May 17, 2013, 3:27:45 PM
    Author     : Muhammad Sidratul M
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Foto</title>
    </head>
    <body>
        <h1>Isi Folder</h1>
        <a href="<%= request.getContextPath() %>/aplikasi/upload/upload-gambar">Upload Foto</a>
        <c:choose>
            <c:when test="${empty listFile}">
                <h2>Folder Empty</h2>
            </c:when>
            <c:otherwise>
                <table border="1">
                    <thead>
                        <tr>    
                            <th><input type="checkbox" disabled></th>
                            <th>Nama File</th>
                            <th>Ukuran(KB)</th>
                            <th colspan="2">Aksi</th>
                        </tr>
                    </thead>
                    <form action="hapus-semua-file" method="POST" id="checkForm">
                    <tbody>
                        <c:forEach items="${listFile}" var="lf">
                        <tr>
                            <td><input type="checkbox" name="filePilihan" value="${lf.namaFile}"></td>
                            <td>${lf.namaFile}</td>
                            <td>${lf.ukuranFile}</td>
                            <td><a href="<%= request.getContextPath() %>/upload-folder/${lf.namaFile}">lihat</a></td>
                            <td><a href="hapus-file?namaFile=${lf.namaFile}">hapus</a></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                    </form>
                </table>
                <a href="hapus-semua-file">hapus semua</a> <a href="#" onclick="submitForm()">hapus terpilih</a>
            </c:otherwise>
        </c:choose>
        <script>
            function submitForm(){
                var a = document.getElementById("checkForm");
                a.submit();
            }
        </script>
    </body>
</html>
