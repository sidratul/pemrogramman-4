package com.p4.springmvc.produk;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class Produk {
    private Integer id;
    
    @NotNull
    @NotEmpty
    @Size(min=1,max=5)
    private String kode;
    
    @NotNull
    @NotEmpty
    private String nama;
    
    @Min(100)
    private BigDecimal harga;
    private Date terakhirUpdate;

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTerakhirUpdate() {
        return terakhirUpdate;
    }

    public void setTerakhirUpdate(Date terakhirUpdate) {
        this.terakhirUpdate = terakhirUpdate;
    }
}
