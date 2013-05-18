<%-- 
    Document   : index
    Created on : May 17, 2013, 2:09:47 PM
    Author     : Muhammad Sidratul M
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload File</title>
    </head>
    <body>
        <h1>Upload Foto</h1>
        <c:if test="${!empty pesan}">
            <h3><c:out value="${pesan}"/></h3> 
        </c:if>
            
        <a href="<%= request.getContextPath() %>/aplikasi/upload/uploaded-file">Daftar Foto</a>
        
        <form method="POST" enctype="multipart/form-data">
            <strong>Foto : </strong><input type="file" name="photofile" accept="image/*"/><br/>
            <input type="submit" value="Kirim"/>
        </form>
    </body>
</html>
