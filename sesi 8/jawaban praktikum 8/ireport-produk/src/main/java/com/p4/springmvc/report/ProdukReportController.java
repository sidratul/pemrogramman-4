package com.p4.springmvc.report;

import com.p4.springmvc.produk.Produk;
import com.p4.springmvc.produk.ProdukDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/report/")
public class ProdukReportController {
    @Autowired private ProdukDao pd;
    
    @RequestMapping(method= RequestMethod.GET,value="pdf")
    public ModelAndView tampilPdf(ModelAndView mav){
        Map<String, Object> parameterMap = listToMap();
        mav = new ModelAndView("pdfReport", parameterMap);
        return mav;
    }
    
    @RequestMapping(method= RequestMethod.GET,value="xls")
    public ModelAndView tampilXls(ModelAndView mav){
        Map<String, Object> parameterMap = listToMap();
        mav = new ModelAndView("xlsReport", parameterMap);
        return mav;
    }
    
    @RequestMapping(method= RequestMethod.GET,value="html")
    public ModelAndView tampilHtml(ModelAndView mav){
        Map<String, Object> parameterMap = listToMap();
        mav = new ModelAndView("htmlReport", parameterMap);
        return mav;
    }
    
    @RequestMapping(method= RequestMethod.GET,value="csv")
    public ModelAndView tampilCsv(ModelAndView mav){
        Map<String, Object> parameterMap = listToMap();
        mav = new ModelAndView("csvReport", parameterMap);
        return mav;
    }

    private Map<String, Object> listToMap() {
        List<Produk> lp = new ArrayList<Produk>();
        try {
            lp= pd.tampilProduk();
        } catch (Exception ex) {
            Logger.getLogger(ProdukReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        JRDataSource JRDataSource = new JRBeanCollectionDataSource(lp);
        Map<String,Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("datasource", JRDataSource);
        return parameterMap;
    }
}
