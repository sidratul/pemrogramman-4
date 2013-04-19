package com.p4.spring;

import com.p4.spring.Produk;
import com.p4.spring.ProdukDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import java.math.BigDecimal;

public class Main {
    public static void main(){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"config-spring.xml"});
        Produk p=context.getBean("p",com.p4.spring.Produk.class);
        ProdukDao pd=context.getBean("pd",com.p4.spring.ProdukDao.class);
        
        
        
    }
}
