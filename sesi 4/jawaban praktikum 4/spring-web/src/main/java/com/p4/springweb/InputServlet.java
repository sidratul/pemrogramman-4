/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.p4.springweb;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Muhammad Sidratul M
 */
public class InputServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res){
        try{
            String kode=req.getParameter("kode");
            String nama=req.getParameter("nama");            
            BigDecimal harga= new BigDecimal(req.getParameter("harga"));
            
            ApplicationContext actx = new ClassPathXmlApplicationContext("config-spring.xml");
            ProdukDao pd = actx.getBean(ProdukDao.class);
            
            Produk p = new Produk();
            p.setKode(kode);
            p.setNama(nama);
            p.setHarga(harga);
            p.setTerakhirUpdate(new Date());           
            pd.simpan(p);
            
            Integer hasil = pd.getHasil();
            String tampil;
            if(hasil==1){
                tampil = "menambahkan produk "+nama+" berhasil";
            }else{
                tampil = "menambahkan produk gagal";
            }
            
            tampil += "<br/><a href='inputProduk.jsp'>kembali input</a>";
            tampil += "<br/><a href='index.jsp'>kembali  ke index</a>";
            
            res.setContentType("text/html");            
            res.getWriter().print(tampil);
        }catch(IOException e){
            Logger.getLogger(InputServlet.class.getName()).log(Level.SEVERE,null,e);
        }catch (Exception ex) {
            Logger.getLogger(InputServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}