package com.p4.springmvc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProdukDao {
    @Autowired private DataSource dataSource;
    
    private String sqlInsert = "INSERT INTO `produk`(`kode`, `nama`, `harga`, `terakhir_update`) VALUES (?,?,?,?)";
    private String sqlUpdate = "UPDATE `produk` SET `kode`=?,`nama`=?,`harga`=?,`terakhir_update`=? WHERE id=?";
    private String sqlTampil = "SELECT * FROM produk";
    private String sqlCariById = "SELECT * FROM produk where id=?";
    private String sqlDelete = "DELETE FROM produk where id=?";
    
    public void simpan(Produk p)throws Exception{
        Connection c = dataSource.getConnection();
        if(p.getId()==null){
            PreparedStatement psInsert = c.prepareStatement(sqlInsert);
            psInsert.setString(1,p.getKode());
            psInsert.setString(2,p.getNama());
            psInsert.setBigDecimal(3,p.getHarga());
            psInsert.setDate(4,new java.sql.Date(p.getTerakhirUpdate().getTime()));

            psInsert.executeUpdate();   
        }else{
            PreparedStatement psUpdate = c.prepareStatement(sqlUpdate);
            
            psUpdate.setString(1,p.getKode());
            psUpdate.setString(2,p.getNama());
            psUpdate.setBigDecimal(3,p.getHarga());
            psUpdate.setDate(4,new java.sql.Date(p.getTerakhirUpdate().getTime()));
            psUpdate.setInt(5,p.getId());

            psUpdate.executeUpdate();
        }
        c.close();
    }       
    
    public List<Produk> tampilProduk() throws Exception{
        Connection c = dataSource.getConnection();
        PreparedStatement psTampil = c.prepareStatement(sqlTampil);
        
        List<Produk> hasil = new ArrayList<Produk>();
        ResultSet rs = psTampil.executeQuery();
        while(rs.next()){
            Produk p = konversiResultSetProduk(rs);
            hasil.add(p);
        }
        c.close();
        return hasil;
    }
    
    public Produk cariById(Integer id) throws Exception{
        if(id==null){
            return null;
        }
        Connection c = dataSource.getConnection();
        PreparedStatement psCariById = c.prepareStatement(sqlCariById);
        psCariById.setInt(1, id);
        ResultSet rs = psCariById.executeQuery();
        if(!rs.next()){
            return null;
        }
        Produk p =konversiResultSetProduk(rs);
        c.close();
        return p;
    }
    
    private Produk konversiResultSetProduk(ResultSet rs) throws SQLException {
        Produk p = new Produk();
        p.setId(rs.getInt("id"));
        p.setKode(rs.getString("kode"));
        p.setNama(rs.getString("nama"));
        p.setHarga(rs.getBigDecimal("harga"));
        p.setTerakhirUpdate(rs.getDate("terakhir_update"));
        return p;
    }
    
    public void hapus(Integer id)throws Exception{
        if(id==null){
            return;
        }
        Connection c = dataSource.getConnection();
        PreparedStatement psDelete = c.prepareStatement(sqlDelete);
        psDelete.setInt(1, id);
        psDelete.executeUpdate();
        c.close();
    }    
    
}