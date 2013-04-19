/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.p4.spring;

import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import com.p4.spring.Produk;
import java.math.BigDecimal;

public class ProdukMapper implements RowMapper<Produk> {
    public Produk mapRow(ResultSet rs,int rowNum) throws SQLException{
        Produk p = new Produk();
        p.setId(rs.getInt("id"));
        p.setKode(rs.getString("kode"));
        p.setNama(rs.getString("Nama"));
        p.setHarga(rs.getBigDecimal("harga"));
        p.setLastUpdate(rs.getDate("terakhir_update"));
        return p;
    }
}