package com.p4.spring;


import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

//import org.springframework.jdbc.core.JdbcTemplate;

public class ProdukDao {    
    private DataSource ds;    
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    private PreparedStatement psTampil;
    
        
    public void simpan(Produk p){        
        
    }

    public List<Produk> cariSemuaProduk(){        
        List <Produk> produk = new ArrayList<Produk>();
        return produk;
    }
}
