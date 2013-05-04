<%-- 
    Document   : inputProduk
    Created on : Apr 26, 2013, 2:19:46 PM
    Author     : Muhammad Sidratul M
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="index.jsp">index</a>
        <form action="proses.jsp" method="POST">
            <fieldset>
                <legend><h2>Input Produk</h2></legend>
                <p>
                    <div><label name="kode">kode</label></div>
                    <input type="text" name="kode" required="required"/>
                </p>
                <p>
                    <div><label name="mama">nama</label></div>
                    <input type="text" name="nama" required="required"/>
                </p>
                <p>
                    <div><label name="harga">harga</label></div>
                    <input type="number" name="harga" required="required"/>
                </p>
                <p>
                    <input type="submit" value="tambah">
                </p>
            </fieldset>
        </form>          
    </body>
</html>
