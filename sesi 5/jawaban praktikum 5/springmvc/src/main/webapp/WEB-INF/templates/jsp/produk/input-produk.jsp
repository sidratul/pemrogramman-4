<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Edit Produk</title>
    </head>
    <body>
        <h1>Input Produk</h1>
        <form action="proses" method="POST">
        <table>            
            <tbody>
                <tr>
                    <td>Kode</td>
                    <td>
                        <input type="text" name="kode"/>
                    </td>
                </tr>
                <tr>
                    <td>Nama</td>
                    <td>
                        <input type="text" name="nama"/>
                    </td>
                </tr>
                <tr>
                    <td>Harga</td>
                    <td>
                        <input type="text" name="harga"/>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>
                        <input type="submit" value="simpan"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
