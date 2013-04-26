package com.p4.spring;

import com.p4.spring.Produk;
import com.p4.spring.ProdukDao;
import java.math.BigDecimal;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"config-spring.xml"});
        Produk p=context.getBean("p",com.p4.spring.Produk.class);
        ProdukDao pd=context.getBean("pd",com.p4.spring.ProdukDao.class); 
        
        pd.simpan(p);
        List<Produk> lp = pd.cariSemuaProduk();
       
    }
}
