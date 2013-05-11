
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="id">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Edit Produk</title>
    </head>
    <body>
        <h1>Input Produk</h1>
        <sp:form action="proses" method="POST" modelAttribute="produk">
            <sp:hidden path="id"/>
        <table>            
            <tbody>
                <tr>
                    <td>Kode</td>
                    <td>
                        <sp:input path="kode" />
                    </td>
                    <td>
                        <sp:errors path="kode" />
                    </td>
                </tr>
                <tr>
                    <td>Nama</td>
                    <td>
                        <sp:input path="nama"/>
                    </td>
                    <td>
                        <sp:errors path="nama" />
                    </td>
                </tr>
                <tr>
                    <td>Harga</td>
                    <td>
                        <sp:input path="harga"/>
                    </td>
                    <td>
                        <sp:errors path="harga" />
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>                    
                    <td>
                        <input type="submit" value="simpan"/>
                    </td>
                    <td>&nbsp;</td>                    
                </tr>
            </tbody>
        </table>
        </sp:form>
    </body>
</html>
