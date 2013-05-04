package com.p4.springmvc;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class ProdukDao {
    private DataSource dataSource;
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psTampil;    
    
    public void setDataSource(DataSource dataSource) throws Exception {
        this.dataSource = dataSource;
        
        String sqlInsert = "INSERT INTO `produk`(`kode`, `nama`, `harga`, `terakhir_update`) VALUES (?,?,?,?)";
        String sqlUpdate = "UPDATE `produk` SET `id`=?,`kode`=?,`nama`=?,`harga`=?,`terakhir_update`=[value-5] WHERE id=?";
        String sqlTampil = "SELECT * FROM produk";
        
        psInsert = dataSource.getConnection().prepareStatement(sqlInsert);
        psUpdate = dataSource.getConnection().prepareStatement(sqlUpdate);
        psTampil = dataSource.getConnection().prepareStatement(sqlTampil);        
    }
    
    public void simpan(Produk p)throws Exception{
        psInsert.setString(1,p.getKode());
        psInsert.setString(2,p.getNama());
        psInsert.setBigDecimal(3,p.getHarga());
        psInsert.setDate(4,new java.sql.Date(p.getTerakhirUpdate().getTime()));
        
        psInsert.executeUpdate();   
    }       
    
    public List<Produk> tampilProduk() throws Exception{
        List<Produk> hasil = new ArrayList<Produk>();
        
        ResultSet rs = psTampil.executeQuery();
        while(rs.next()){
            Produk p = new Produk();
            p.setId(rs.getInt("id"));
            p.setKode(rs.getString("kode"));
            p.setNama(rs.getString("nama"));
            p.setHarga(rs.getBigDecimal("harga"));
            p.setTerakhirUpdate(rs.getDate("terakhir_update"));
            hasil.add(p);
        }
        return hasil;
    }
}
