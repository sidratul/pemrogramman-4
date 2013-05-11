
package com.p4.springmvc;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class ProdukController {
    
    @Autowired private ProdukDao pd;
    
    @RequestMapping("/produk/daftar-produk")
    public ModelMap daftarProduk() throws Exception{
        List<Produk> hasil = pd.tampilProduk();
        ModelMap mm = new ModelMap();
        mm.addAttribute("daftarProduk", hasil);
        return mm;
    }
    
    @RequestMapping(value="/produk/input-produk",method = RequestMethod.GET)
    public ModelMap tampilkanForm(@RequestParam(required=false) Integer id)throws Exception{        
        Produk p = pd.cariById(id);
        if(p ==  null){
            p = new Produk();
        }
        
        ModelMap mm = new ModelMap();
        mm.addAttribute("produk",p);
        return mm;
    }
    
    @RequestMapping(value="/produk/proses", method= RequestMethod.POST)
    public String prosesForm(@ModelAttribute @Valid Produk p,
    BindingResult hasilValidasi,
    SessionStatus status) throws Exception{        
        p.setTerakhirUpdate(new Date());
        System.out.println("id :"+p.getId());
        if(hasilValidasi.hasErrors()){
            return "/produk/input-produk";
        }
        
        pd.simpan(p);
        status.setComplete();
        return "redirect:daftar-produk";
    }
    
    @RequestMapping("/produk/delete")
    public String hapusProduk(@RequestParam Integer id ){
        try {
            pd.hapus(id);
        } catch (Exception ex) {
            System.out.println("Gagal hapus : "+ex.getMessage());
        }
        return "redirect:daftar-produk";
    }
}