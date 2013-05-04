
package com.p4.springmvc;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProdukController {
    
    @Autowired private ProdukDao pd;
    
    @RequestMapping("produk/daftar-produk")
    public ModelMap daftarProduk() throws Exception{
        List<Produk> hasil = pd.tampilProduk();
        ModelMap mm = new ModelMap();
        mm.addAttribute("daftarProduk", hasil);
        return mm;
    }
    
    @RequestMapping("produk/input-produk")
    public void tampilkanForm(){
        
    }
    
    @RequestMapping(value="produk/proses", method= RequestMethod.POST)
    public String prosesForm(@ModelAttribute Produk p) throws Exception{        
        p.setTerakhirUpdate(new Date());
        
        pd.simpan(p);
        return "redirect:input-produk";
    }
    
}
