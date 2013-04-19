package com.p4.spring;

import java.math.BigDecimal;
import java.util.Date;

public class Produk {
    private Integer id;
    private String kode;
    private String nama;
    private BigDecimal harga;
    private Date terakhirUpdate;
    
    public void setId(Integer id){
        this.id=id;
    }
    
    public Integer getId(){
        return id;
    }
    
    public void setKode(String kode){
        this.id=id;
    }
    
    public String getKode(){
        return kode;
    }
    
    public void setNama(String nama){
        this.nama=nama;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setHarga(BigDecimal harga){
        this.harga=harga;
    }
    
    public BigDecimal getHarga(){
        return harga;
    }
    
    public void setLastUpdate(Date terakhirUpdate){
        this.terakhirUpdate=terakhirUpdate;
    }
    
    public Date getLastUpdate(){
        return terakhirUpdate;
    }
}
