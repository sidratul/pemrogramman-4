package com.p4.spring;

import com.p4.spring.Produk;
import com.p4.spring.ProdukMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProdukDao {    
    private DataSource ds;
    private JdbcTemplate jt;
        
    public void simpan(Produk p){        
        String SQL = "insert into Student (id,kode,nama,harga,terakhir_update) values (?,?,?,?)";
        jt.update( SQL,p.getKode(),p.getNama(),p.getHarga(),p.getLastUpdate());
        System.out.println("Created Record");       
    }

    public List<Produk> cariSemuaProduk(){
        String SQL = "select * from produk";
        List <Produk> produk = jt.query(SQL,new ProdukMapper());      
        return produk;
    }
}
